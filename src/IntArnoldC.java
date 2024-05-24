import value.*;

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

        if(!ctx.method(0).isEmpty()){
            visitMethod(ctx.method(0));
        }

        if(!ctx.method(1).isEmpty()){
            visitMethod(ctx.method(1));
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
        return visitBoolExp(ctx.exp())
                ? visitCom(ctx.com(0))
                : visitCom(ctx.com(1));
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
        while (visitBoolExp(ctx.exp())) {
            visitCom(ctx.com());
        }
        return ComValue.INSTANCE;

    }

    @Override
    public ComValue visitSout(ArnoldCParser.SoutContext ctx) {

        String text = "";
        if(!ctx.exp().isEmpty()){
            text = visitExp(ctx.exp()).toJavaValue().toString();
        }
        else if(ctx.ID() != null){
            text = (conf.get(ctx.ID().getText())).toJavaValue().toString();
        }
        else{
            text = ctx.STRING().getText();
        }
        System.out.println(text);
        return ComValue.INSTANCE;
    }


}

