// Generated from C:/Users/miche/Desktop/LAB_LING/ArnoldC/src/ArnoldC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArnoldCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArnoldCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArnoldCParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ArnoldCParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArnoldCParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ArnoldCParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link ArnoldCParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(ArnoldCParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declare}
	 * labeled alternative in {@link ArnoldCParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(ArnoldCParser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code init}
	 * labeled alternative in {@link ArnoldCParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(ArnoldCParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link ArnoldCParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(ArnoldCParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sout}
	 * labeled alternative in {@link ArnoldCParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSout(ArnoldCParser.SoutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callMethod}
	 * labeled alternative in {@link ArnoldCParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethod(ArnoldCParser.CallMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignVarFromMethod}
	 * labeled alternative in {@link ArnoldCParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVarFromMethod(ArnoldCParser.AssignVarFromMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nat}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNat(ArnoldCParser.NatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code zero}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZero(ArnoldCParser.ZeroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divMulMod}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivMulMod(ArnoldCParser.DivMulModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusMinus}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinus(ArnoldCParser.PlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(ArnoldCParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ArnoldCParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExp}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExp(ArnoldCParser.CmpExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExp}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExp(ArnoldCParser.LogicExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code one}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOne(ArnoldCParser.OneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ArnoldCParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ArnoldCParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArnoldCParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(ArnoldCParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nonVoid}
	 * labeled alternative in {@link ArnoldCParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonVoid(ArnoldCParser.NonVoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code void}
	 * labeled alternative in {@link ArnoldCParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid(ArnoldCParser.VoidContext ctx);
}