import org.antlr.v4.runtime.tree.ParseTree;
import value.*;

import java.io.InputStream;

public class IntArnoldC extends  ArnoldCBaseVisitor<Value>{

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
    public  ComValue visitIf(ArnoldCParser.IfContext ctx) {
        if(visitBoolExp(ctx.exp())){
            return visitCom(ctx.com(0));
        }else if(ctx.com(1) != null){
            return visitCom(ctx.com(1));
        }

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitDeclare(ArnoldCParser.DeclareContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());

        if(conf.contains(id)){
            System.err.println("Variable already declared");
            System.exit(1);
        }
        conf.update(id,v);

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitInit(ArnoldCParser.InitContext ctx) {

        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());

        if(!conf.contains(id)){
            System.err.println("You must declare the variable in order to do an assignment");
            System.exit(1);
        }

        conf.update(id,v);

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
        if(ctx.ID() != null){
            text = (conf.get(ctx.ID().getText())).toJavaValue().toString();
        }
        else{
            text = ctx.STRING().getText();
        }
        System.out.println(text);
        return ComValue.INSTANCE;
    }

    @Override
    public Value visitInt(ArnoldCParser.IntContext ctx) {
        return new NatValue(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public BoolValue visitBool(ArnoldCParser.BoolContext ctx) {
        return new BoolValue(Boolean.parseBoolean(ctx.BOOL().getText()));
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
    public BoolValue visitCmpExp(ArnoldCParser.CmpExpContext ctx) {
        int left = visitNatExp(ctx.exp(0));
        int right = visitNatExp(ctx.exp(1));
        return new BoolValue(left > right);
    }

    @Override
    public BoolValue visitEqExp(ArnoldCParser.EqExpContext ctx) {
        ExpValue<?> left = visitExp(ctx.exp(0));
        ExpValue<?> right = visitExp(ctx.exp(1));
        return new BoolValue(left.equals(right));
    }

    @Override
    public BoolValue visitLogicExp(ArnoldCParser.LogicExpContext ctx) {
        boolean left = visitBoolExp(ctx.exp(0));
        boolean right = visitBoolExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ArnoldCParser.AND -> new BoolValue(left && right);
            case ArnoldCParser.OR -> new BoolValue(left || right);
            default -> null;
        };
    }

    @Override
    public Value visitId(ArnoldCParser.IdContext ctx) {

        if(conf.contains(ctx.ID().getText())){
            return conf.get(ctx.ID().getText());
        }
        else{
            return new NatValue(0);
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
        conf.updateTree(ctx.ID(0).getText(),tree);
        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitCallMethod(ArnoldCParser.CallMethodContext ctx) {
        ParseTree tree = conf.getTree(ctx.ID().getText());
        visit(tree.getChild(2));
        return ComValue.INSTANCE;
    }
}

