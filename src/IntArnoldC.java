import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import value.*;

import java.io.InputStream;
import java.util.*;

public class IntArnoldC extends  ArnoldCBaseVisitor<Value>{

    String current_method = "";
    String current_method_stack = "main";
    Boolean in_main = true;
    private final Conf conf;

    public IntArnoldC(Conf conf) {
        this.conf = conf;
    }

    private ComValue visitCom(ArnoldCParser.ComContext ctx) {
        return (ComValue) visit(ctx);
    }

    private ExpValue<?> visitExp(ArnoldCParser.ExpContext ctx) {
        return (ExpValue<?>) visit(ctx);
    }

    private int visitNatExp(ArnoldCParser.ExpContext ctx) {
        try {
            return ((NatValue) visitExp(ctx)).toJavaValue();
        } catch (ClassCastException e) {
            System.err.println("Type mismatch exception!");
            System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());
            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            System.err.println(ctx.getText());
            System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<");
            System.err.println("> Natural expression expected.");
            System.exit(1);
        }

        return 0; // unreachable code
    }

    private boolean visitBoolExp(ArnoldCParser.ExpContext ctx) {
        try {
            return ((BoolValue) visitExp(ctx)).toJavaValue();
        } catch (ClassCastException e) {
            System.err.println("Type mismatch exception!");
            System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());
            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            System.err.println(ctx.getText());
            System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<");
            System.err.println("> Boolean expression expected.");
            System.exit(1);
        }

        return false; // unreachable code
    }

    @Override
    public NatValue visitProg(ArnoldCParser.ProgContext ctx) {

        for(int i = 0; i < ctx.method().size(); i++){
            visitMethod(ctx.method(i));
        }

        return visitMain(ctx.main());
    }

    @Override
    public NatValue visitMain(ArnoldCParser.MainContext ctx) {
        if(!ctx.com().isEmpty()){
            for(int i = 0; i < ctx.com().size(); i++){
                visit(ctx.com(i));
            }
        }
        return new NatValue(0);
    }


    @Override
    public ComValue visitIf(ArnoldCParser.IfContext ctx) {

        if(visitNatExp(ctx.exp()) > 0){

            for(int i = 0; i < ctx.com().size(); i++){
                visitCom(ctx.com(i));
            }
        }
        else if(ctx.com2(0) != null)
        {
            for(int i = 0; i < ctx.com2().size(); i++){
                visit(ctx.com2(i));
            }
        }

        return ComValue.INSTANCE;
    }


    @Override
    public ComValue visitDeclare(ArnoldCParser.DeclareContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());
        if(in_main)
        {
            if(conf.contains(id)){
                System.err.println("Variable already declared");
                System.exit(1);
            }
            conf.update(id,v);
        }
        else
        {
            Map<String, ExpValue<?>> Temp_map = conf.getMVar(current_method);
            if(Temp_map != null){
                if(Temp_map.containsKey(id)){
                    System.err.println("Variable already declared");
                    System.exit(1);
                }
                else{
                    Temp_map.put(id,v);
                }
            }
            else{
                Temp_map = new HashMap<>();
                Temp_map.put(id,v);
            }

            conf.updateMVar(current_method,Temp_map);
        }
        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitInit(ArnoldCParser.InitContext ctx) {

        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());
        if(in_main)
        {
            if(!conf.contains(id)){
                System.err.println("You must declare the variable in order to do an assignment");
                System.exit(1);
            }

            conf.update(id,v);
        }
        else
        {
            Map<String, ExpValue<?>> Temp_map = conf.getMVar(current_method);
            if(!Temp_map.containsKey(id)){
                System.err.println("You must declare the variable in order to do an assignment");
                System.exit(1);
            }
            else{
                Temp_map.put(id,v);
            }
            conf.updateMVar(current_method,Temp_map);
        }

        return ComValue.INSTANCE;

    }

    @Override
    public ComValue visitWhile(ArnoldCParser.WhileContext ctx) {

        while (visitNatExp(ctx.exp()) > 0) {
            for(int i = 0; i < ctx.com().size(); i++){
                visitCom(ctx.com(i));
            }
        }
        return ComValue.INSTANCE;

    }

    @Override
    public ComValue visitSout(ArnoldCParser.SoutContext ctx) {

       String text = "";
        if(in_main){
            if(ctx.ID() != null){
                text = (conf.get(ctx.ID().getText())).toJavaValue().toString();
            }
            else{
                text = ctx.STRING().getText();
            }
            System.out.println(text.replace("\"", ""));
        }
        else{
            if(ctx.ID() != null){
                Map<String, ExpValue<?>> Temp_map = conf.getMVar(current_method);
                text = Temp_map.get(ctx.ID().getText()).toJavaValue().toString();
            }
            else{
                text = ctx.STRING().getText();
            }
            System.out.println(text.replace("\"", ""));
        }

        return ComValue.INSTANCE;
    }

    @Override
    public Value visitInt(ArnoldCParser.IntContext ctx) {
        return new NatValue(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public BoolValue visitBool(ArnoldCParser.BoolContext ctx) {
        String tmp = "";
        if(ctx.BOOL().getText().equals("NO PROBLEMO")){
            tmp = "true";
        }
        else if (ctx.BOOL().getText().equals("I LIED")){
            tmp = "false";
        }
        return new BoolValue(Boolean.parseBoolean(tmp));
    }

    @Override
    public NatValue visitDivMulMod(ArnoldCParser.DivMulModContext ctx) {
        int left = visitNatExp(ctx.exp(0));
        int right = visitNatExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ArnoldCParser.DIV -> new NatValue(left / right);
            case ArnoldCParser.MUL -> new NatValue(left * right);
            case ArnoldCParser.MOD -> new NatValue(left % right);
            default -> null;
        };
    }

    @Override
    public NatValue visitPlusMinus(ArnoldCParser.PlusMinusContext ctx) {
        int left = visitNatExp(ctx.exp(0));
        int right = visitNatExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ArnoldCParser.PLUS -> new NatValue(left + right);
            case ArnoldCParser.MINUS -> new NatValue(Math.max(left - right, 0));
            default -> null;
        };
    }

    @Override
    public NatValue visitCmpExp(ArnoldCParser.CmpExpContext ctx) {
        int left = visitNatExp(ctx.exp(0));
        int right = visitNatExp(ctx.exp(1));
        if(left > right){
            return new NatValue(1);
        }
        else{
            return new NatValue(0);
        }
    }

    @Override
    public NatValue visitEqExp(ArnoldCParser.EqExpContext ctx) {
        ExpValue<?> left = visitExp(ctx.exp(0));
        ExpValue<?> right = visitExp(ctx.exp(1));
        if(left.equals(right)){
            return new NatValue(1);
        }
        return new NatValue(0);
    }

    @Override
    public NatValue visitLogicExp(ArnoldCParser.LogicExpContext ctx) {
        int left = visitNatExp(ctx.exp(0));
        int right = visitNatExp(ctx.exp(1));

        if(ctx.op.getType() == ArnoldCParser.AND)
        {
            if(left == 1 && right == 1){
                return new NatValue(1);
            }
            return new NatValue(0);
        }
        else if(ctx.op.getType() == ArnoldCParser.OR)
        {
            if(left == 1 || right == 1){
                return new NatValue(1);
            }
            return new NatValue(0);
        }
        return new NatValue(0);
    }

    @Override
    public Value visitId(ArnoldCParser.IdContext ctx) {
        if(in_main){
            if(conf.contains(ctx.ID().getText())){
                return conf.get(ctx.ID().getText());
            }
            else{
                return new NatValue(0);
            }
        }
        else
        {
            Map<String, ExpValue<?>> Temp_map = conf.getMVar(current_method);
            if(Temp_map.containsKey(ctx.ID().getText())){
                return Temp_map.get(ctx.ID().getText());
            }
            else{
                return new NatValue(0);
            }
        }
    }

    @Override
    public Value visitZero(ArnoldCParser.ZeroContext ctx) {
        return new NatValue(0);
    }

    @Override
    public Value visitOne(ArnoldCParser.OneContext ctx) {
        return new NatValue(1);
    }

    @Override
    public ComValue visitMethod(ArnoldCParser.MethodContext ctx) {
        ParseTree tree = ctx;
        Map<String, ExpValue<?>> Temp_map = new HashMap<>();
        Map<String, ExpValue<?>> Temp_map_copy = new HashMap<>();

        if(ctx.GET_ARG() != null){
            // metodi con mappa di parametri vuoti ora
            for(int i=1; i<ctx.ID().size(); i++)
            {
                Temp_map.put(i-1+"-"+ctx.ID(i).getText(),null);
            }
        }
        if(ctx.RETURN() != null){
            Temp_map.put("Return"+ctx.id2().getText(),null);
        }

        for (Map.Entry<String, ExpValue<?>> entry : Temp_map.entrySet()) {
            Temp_map_copy.put(entry.getKey(), null);
        }

        conf.updateMVarcopy(ctx.ID(0).getText(),Temp_map_copy);
        conf.updateMVar(ctx.ID(0).getText(),Temp_map);
        conf.updateTree(ctx.ID(0).getText(),tree);
        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitCallMethod(ArnoldCParser.CallMethodContext ctx) {

        if(!conf.containsTree(ctx.ID().getText())){
            System.err.println("Error, no method " + ctx.ID().getText() + " found");
            System.exit(1);

        }

        ParseTree tree = conf.getTree(ctx.ID().getText());

        if(tree.getText().contains("BOOTS")){
            Map<String, ExpValue<?>> Temp_map = conf.getMVar(ctx.ID().getText());
            Set<String> cpy = new HashSet<>(Temp_map.keySet());
            for(Integer i=0; i< ctx.exp().size(); i++){

                for(String s: cpy)
                {
                    if(s.contains(i.toString())){
                        Temp_map.remove(s);
                        Temp_map.put(s.replaceAll("\\d", ""), (ExpValue<?>) visit(ctx.exp(i)));
                    }
                }
                //Temp_map.put(ctx.exp(i).getText(),conf.get((ctx.exp(i).getText())));
            }

            conf.updateMVar(ctx.ID().getText(),Temp_map);
        }
        in_main = false;
        current_method = ctx.ID().getText();
        current_method_stack += "_-_" + ctx.ID().getText();
        for(int i=0; i< tree.getChildCount();i++){
            if(!(tree.getChild(i) instanceof TerminalNodeImpl)){
                visit(tree.getChild(i));
            }
        }
        dealloc_map();
        //conf.updateMVar(current_method,null);
        current_method = precCurrentMethod(ctx.ID().getText());
        current_method_stack = updateCurrentMethod(ctx.ID().getText());
        if(current_method_stack.equals("main")){
            in_main = true;
        }
        return ComValue.INSTANCE;
    }

    public void dealloc_map(){
        Map<String, ExpValue<?>> Temp_map_copy = new HashMap<>();
        Map<String, ExpValue<?>> Temp_map = conf.getMVarCopy(current_method);
        if(Temp_map != null){
            for (Map.Entry<String, ExpValue<?>> entry : Temp_map.entrySet()) {
                Temp_map_copy.put(entry.getKey(), null);
            }
            conf.updateMVar(current_method,Temp_map_copy);
        }

    }



    public String precCurrentMethod(String ctx)
    {
        // Dividi la stringa principale in segmenti
        String[] segments = current_method_stack.split("_-_");

        // Cerca l'indice del segmento target
        for (int i = 1; i < segments.length; i++) {
            if (segments[i].equals(ctx)) {
                // Se il target viene trovato, ritorna il segmento precedente
                return segments[i - 1];
            }
        }
        return "";
    }
    public String updateCurrentMethod(String ctx){
        int lastIndex = current_method_stack.lastIndexOf("_-_"+ctx);
        String result = "";
        if (lastIndex != -1) {
            result = current_method_stack.substring(0, lastIndex) + current_method_stack.substring(lastIndex + ctx.length()+"_-_".length());
        } else {
            System.err.println("Stack Error");
            System.exit(1);
        }
        return result;
    }
    @Override
    public ComValue visitAssignVarFromMethod(ArnoldCParser.AssignVarFromMethodContext ctx) {


        ParseTree tree = conf.getTree(ctx.ID(1).getText());

        if(tree.getText().contains("BOOTS")) {
            Map<String, ExpValue<?>> Temp_map = conf.getMVar(ctx.ID(1).getText());
            Set<String> cpy = new HashSet<>(Temp_map.keySet());
            for (Integer i = 0; i < ctx.exp().size(); i++) {

                for (String s : cpy) {
                    if (s.contains(i.toString())) {
                        Temp_map.remove(s);
                        Temp_map.put(s.replaceAll("[\\d-]", ""), (ExpValue<?>) visit(ctx.exp(i)));
                    }
                }

            }
            conf.updateMVar(ctx.ID(1).getText(),Temp_map);
        }

        if(in_main)
        {
            if(conf.get(ctx.ID(0).getText()) != null){
                conf.update(ctx.ID(0).getText(), returnMethodResults(ctx.ID(1).getText()));
                dealloc_map();
                current_method = precCurrentMethod(ctx.ID(1).getText());
                current_method_stack = updateCurrentMethod(ctx.ID(1).getText());
                if(current_method_stack.equals("main")){
                    in_main = true;
                }
            }
            else{
                System.err.println("You must declare the variable in order to do an assignment");
                System.exit(1);
            }
        }
        else
        {
            Map<String, ExpValue<?>> Temp_map = conf.getMVar(current_method);
            if(Temp_map.get(ctx.ID(0).getText()) != null){
                Temp_map.put(ctx.ID(0).getText(),returnMethodResults(ctx.ID(1).getText()));
                conf.updateMVar(ctx.ID(1).getText(),Temp_map);
                dealloc_map();
                current_method = precCurrentMethod(ctx.ID(1).getText());
                current_method_stack = updateCurrentMethod(ctx.ID(1).getText());
                if(current_method_stack.equals("main")){
                    in_main = true;
                }
            }
            else{
                System.err.println("You must declare the variable in order to do an assignment");
                System.exit(1);
            }
        }

        return ComValue.INSTANCE;
    }


    public ExpValue<?> returnMethodResults(String tree){

        // valore da prendere come return
        //ParseTree t = conf.getTree(tree).getChild(2);
        String returntmp = "";
        Map<String, ExpValue<?>> Temp_map = conf.getMVar(tree);
        for(String s : Temp_map.keySet()){
            if (s.startsWith("Return")) {
                returntmp = s.substring("Return".length());
            }
        }
        in_main = false;
        current_method = tree;
        current_method_stack += "_-_" + tree;
        for(int i=0; i< conf.getTree(tree).getChildCount();i++){
            if(!(conf.getTree(tree).getChild(i) instanceof TerminalNodeImpl)){
                visit(conf.getTree(tree).getChild(i));
            }
        }
        Map<String, ExpValue<?>> Temp_map2 = conf.getMVar(tree);
        return Temp_map2.get(returntmp);

    }

}
