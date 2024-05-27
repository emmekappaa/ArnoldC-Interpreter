// Generated from C:/Users/miche/Desktop/LAB_LING/ArnoldC/src/ArnoldC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ArnoldCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOL=2, STRING=3, BEGIN_MAIN=4, END_MAIN=5, SOUT=6, A_INIT=7, DECLARE=8, 
		TAKE=9, SET=10, END_SET=11, PLUS=12, MINUS=13, MUL=14, DIV=15, MOD=16, 
		AND=17, OR=18, EQQ=19, GT=20, IF=21, ELSE=22, END_IF=23, WHILE=24, END_WHILE=25, 
		ZERO=26, ONE=27, DEFINE_METHOD=28, GET_ARG=29, NON_VOID=30, RETURN=31, 
		END_METHOD=32, CALL=33, ASSIGN_CALL=34, ID=35, WS=36;
	public static final int
		RULE_prog = 0, RULE_main = 1, RULE_com = 2, RULE_exp = 3, RULE_method = 4, 
		RULE_method_type = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "main", "com", "exp", "method", "method_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'IT'S SHOWTIME'", "'YOU HAVE BEEN TERMINATED'", 
			"'TALK TO THE HAND'", "'HEY CHRISTMAS TREE'", "'YOU SET US UP'", "'GET TO THE CHOPPER'", 
			"'HERE IS MY INVITATION'", "'ENOUGH TALK'", "'GET UP'", "'GET DOWN'", 
			"'YOU'RE FIRED'", "'HE HAD TO SPLIT'", "'I LET HIM GO'", "'KNOCK KNOCK'", 
			"'CONSIDER THAT A DIVORCE'", "'YOU ARE NOT YOU YOU ARE ME'", "'LET OFF SOME STEAM BENNET'", 
			"'BECAUSE I'M GOING TO SAY PLEASE'", "'BULLSHIT'", "'YOU HAVE NO RESPECT FOR LOGIC'", 
			"'STICK AROUND'", "'CHILL'", "'@I LIED'", "'@NO PROBLEMO'", "'LISTEN TO ME VERY CAREFULLY'", 
			"'I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE'", "'GIVE THESE PEOPLE AIR'", 
			"'I'LL BE BACK'", "'HASTA LA VISTA, BABY'", "'DO IT NOW'", "'GET YOUR ASS TO MARS'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOL", "STRING", "BEGIN_MAIN", "END_MAIN", "SOUT", "A_INIT", 
			"DECLARE", "TAKE", "SET", "END_SET", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
			"AND", "OR", "EQQ", "GT", "IF", "ELSE", "END_IF", "WHILE", "END_WHILE", 
			"ZERO", "ONE", "DEFINE_METHOD", "GET_ARG", "NON_VOID", "RETURN", "END_METHOD", 
			"CALL", "ASSIGN_CALL", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ArnoldC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArnoldCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ArnoldCParser.EOF, 0); }
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE_METHOD) {
				{
				{
				setState(12);
				method();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			main();
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE_METHOD) {
				{
				{
				setState(19);
				method();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public TerminalNode BEGIN_MAIN() { return getToken(ArnoldCParser.BEGIN_MAIN, 0); }
		public TerminalNode END_MAIN() { return getToken(ArnoldCParser.END_MAIN, 0); }
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(BEGIN_MAIN);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25788678848L) != 0)) {
				{
				{
				setState(28);
				com();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(END_MAIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComContext extends ParserRuleContext {
		public ComContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com; }
	 
		public ComContext() { }
		public void copyFrom(ComContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallMethodContext extends ComContext {
		public TerminalNode CALL() { return getToken(ArnoldCParser.CALL, 0); }
		public TerminalNode ID() { return getToken(ArnoldCParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CallMethodContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitCallMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InitContext extends ComContext {
		public TerminalNode TAKE() { return getToken(ArnoldCParser.TAKE, 0); }
		public TerminalNode ID() { return getToken(ArnoldCParser.ID, 0); }
		public TerminalNode SET() { return getToken(ArnoldCParser.SET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode END_SET() { return getToken(ArnoldCParser.END_SET, 0); }
		public InitContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclareContext extends ComContext {
		public TerminalNode A_INIT() { return getToken(ArnoldCParser.A_INIT, 0); }
		public TerminalNode ID() { return getToken(ArnoldCParser.ID, 0); }
		public TerminalNode DECLARE() { return getToken(ArnoldCParser.DECLARE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DeclareContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ComContext {
		public TerminalNode WHILE() { return getToken(ArnoldCParser.WHILE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode END_WHILE() { return getToken(ArnoldCParser.END_WHILE, 0); }
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public WhileContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ComContext {
		public TerminalNode IF() { return getToken(ArnoldCParser.IF, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public TerminalNode END_IF() { return getToken(ArnoldCParser.END_IF, 0); }
		public TerminalNode ELSE() { return getToken(ArnoldCParser.ELSE, 0); }
		public IfContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SoutContext extends ComContext {
		public TerminalNode SOUT() { return getToken(ArnoldCParser.SOUT, 0); }
		public TerminalNode ID() { return getToken(ArnoldCParser.ID, 0); }
		public TerminalNode STRING() { return getToken(ArnoldCParser.STRING, 0); }
		public SoutContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitSout(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignVarFromMethodContext extends ComContext {
		public TerminalNode ASSIGN_CALL() { return getToken(ArnoldCParser.ASSIGN_CALL, 0); }
		public List<TerminalNode> ID() { return getTokens(ArnoldCParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ArnoldCParser.ID, i);
		}
		public TerminalNode CALL() { return getToken(ArnoldCParser.CALL, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public AssignVarFromMethodContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitAssignVarFromMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComContext com() throws RecognitionException {
		ComContext _localctx = new ComContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_com);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(IF);
				setState(37);
				exp(0);
				setState(38);
				com();
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(39);
					match(ELSE);
					setState(40);
					com();
					}
				}

				setState(43);
				match(END_IF);
				}
				break;
			case A_INIT:
				_localctx = new DeclareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(A_INIT);
				setState(46);
				match(ID);
				setState(47);
				match(DECLARE);
				setState(48);
				exp(0);
				}
				break;
			case TAKE:
				_localctx = new InitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				match(TAKE);
				setState(50);
				match(ID);
				setState(51);
				match(SET);
				setState(52);
				exp(0);
				setState(53);
				match(END_SET);
				}
				break;
			case WHILE:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(WHILE);
				setState(56);
				exp(0);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25788678848L) != 0)) {
					{
					{
					setState(57);
					com();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(END_WHILE);
				}
				break;
			case SOUT:
				_localctx = new SoutContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
				match(SOUT);
				setState(66);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case CALL:
				_localctx = new CallMethodContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(67);
				match(CALL);
				setState(68);
				match(ID);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34561064966L) != 0)) {
					{
					{
					setState(69);
					exp(0);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ASSIGN_CALL:
				_localctx = new AssignVarFromMethodContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(75);
				match(ASSIGN_CALL);
				setState(76);
				match(ID);
				setState(77);
				match(CALL);
				setState(78);
				match(ID);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34561064966L) != 0)) {
					{
					{
					setState(79);
					exp(0);
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ZeroContext extends ExpContext {
		public TerminalNode ZERO() { return getToken(ArnoldCParser.ZERO, 0); }
		public ZeroContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitZero(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivMulModContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode DIV() { return getToken(ArnoldCParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(ArnoldCParser.MUL, 0); }
		public TerminalNode MOD() { return getToken(ArnoldCParser.MOD, 0); }
		public DivMulModContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitDivMulMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusMinusContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ArnoldCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ArnoldCParser.MINUS, 0); }
		public PlusMinusContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode EQQ() { return getToken(ArnoldCParser.EQQ, 0); }
		public EqExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(ArnoldCParser.BOOL, 0); }
		public BoolContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CmpExpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode GT() { return getToken(ArnoldCParser.GT, 0); }
		public CmpExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitCmpExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicExpContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AND() { return getToken(ArnoldCParser.AND, 0); }
		public TerminalNode OR() { return getToken(ArnoldCParser.OR, 0); }
		public LogicExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitLogicExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OneContext extends ExpContext {
		public TerminalNode ONE() { return getToken(ArnoldCParser.ONE, 0); }
		public OneContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitOne(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExpContext {
		public TerminalNode ID() { return getToken(ArnoldCParser.ID, 0); }
		public IdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExpContext {
		public TerminalNode INT() { return getToken(ArnoldCParser.INT, 0); }
		public IntContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(88);
				match(INT);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(BOOL);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(ID);
				}
				break;
			case ZERO:
				{
				_localctx = new ZeroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(ZERO);
				}
				break;
			case ONE:
				{
				_localctx = new OneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(ONE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(110);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new DivMulModContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(95);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(96);
						((DivMulModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
							((DivMulModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(97);
						exp(9);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(98);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(99);
						((PlusMinusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((PlusMinusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						exp(8);
						}
						break;
					case 3:
						{
						_localctx = new CmpExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(101);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(102);
						match(GT);
						setState(103);
						exp(7);
						}
						break;
					case 4:
						{
						_localctx = new EqExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(104);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(105);
						match(EQQ);
						setState(106);
						exp(6);
						}
						break;
					case 5:
						{
						_localctx = new LogicExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(107);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(108);
						((LogicExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public TerminalNode DEFINE_METHOD() { return getToken(ArnoldCParser.DEFINE_METHOD, 0); }
		public List<TerminalNode> ID() { return getTokens(ArnoldCParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ArnoldCParser.ID, i);
		}
		public Method_typeContext method_type() {
			return getRuleContext(Method_typeContext.class,0);
		}
		public List<TerminalNode> GET_ARG() { return getTokens(ArnoldCParser.GET_ARG); }
		public TerminalNode GET_ARG(int i) {
			return getToken(ArnoldCParser.GET_ARG, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(DEFINE_METHOD);
			setState(116);
			match(ID);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GET_ARG) {
				{
				{
				setState(117);
				match(GET_ARG);
				setState(118);
				match(ID);
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			method_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_typeContext extends ParserRuleContext {
		public Method_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_type; }
	 
		public Method_typeContext() { }
		public void copyFrom(Method_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidContext extends Method_typeContext {
		public TerminalNode END_METHOD() { return getToken(ArnoldCParser.END_METHOD, 0); }
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public VoidContext(Method_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NonVoidContext extends Method_typeContext {
		public TerminalNode NON_VOID() { return getToken(ArnoldCParser.NON_VOID, 0); }
		public TerminalNode RETURN() { return getToken(ArnoldCParser.RETURN, 0); }
		public TerminalNode END_METHOD() { return getToken(ArnoldCParser.END_METHOD, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public NonVoidContext(Method_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArnoldCVisitor ) return ((ArnoldCVisitor<? extends T>)visitor).visitNonVoid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_typeContext method_type() throws RecognitionException {
		Method_typeContext _localctx = new Method_typeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method_type);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_VOID:
				_localctx = new NonVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(NON_VOID);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25788678848L) != 0)) {
					{
					{
					setState(127);
					com();
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				match(RETURN);
				{
				setState(134);
				exp(0);
				}
				setState(135);
				match(END_METHOD);
				}
				break;
			case SOUT:
			case A_INIT:
			case TAKE:
			case IF:
			case WHILE:
			case END_METHOD:
			case CALL:
			case ASSIGN_CALL:
				_localctx = new VoidContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25788678848L) != 0)) {
					{
					{
					setState(137);
					com();
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143);
				match(END_METHOD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u0093\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0015\b\u0000\n\u0000"+
		"\f\u0000\u0018\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0005\u0001\u001e\b\u0001\n\u0001\f\u0001!\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002*\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002;\b"+
		"\u0002\n\u0002\f\u0002>\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002G\b\u0002\n\u0002"+
		"\f\u0002J\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002Q\b\u0002\n\u0002\f\u0002T\t\u0002\u0003\u0002V\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003^\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"o\b\u0003\n\u0003\f\u0003r\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004x\b\u0004\n\u0004\f\u0004{\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005\u0081\b\u0005\n\u0005"+
		"\f\u0005\u0084\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u008b\b\u0005\n\u0005\f\u0005\u008e\t\u0005\u0001"+
		"\u0005\u0003\u0005\u0091\b\u0005\u0001\u0005\u0000\u0001\u0006\u0006\u0000"+
		"\u0002\u0004\u0006\b\n\u0000\u0004\u0002\u0000\u0003\u0003##\u0001\u0000"+
		"\u000e\u0010\u0001\u0000\f\r\u0001\u0000\u0011\u0012\u00a6\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u0004U\u0001"+
		"\u0000\u0000\u0000\u0006]\u0001\u0000\u0000\u0000\bs\u0001\u0000\u0000"+
		"\u0000\n\u0090\u0001\u0000\u0000\u0000\f\u000e\u0003\b\u0004\u0000\r\f"+
		"\u0001\u0000\u0000\u0000\u000e\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001"+
		"\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0012\u0001"+
		"\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0012\u0016\u0003"+
		"\u0002\u0001\u0000\u0013\u0015\u0003\b\u0004\u0000\u0014\u0013\u0001\u0000"+
		"\u0000\u0000\u0015\u0018\u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000"+
		"\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0019\u0001\u0000"+
		"\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0019\u001a\u0005\u0000"+
		"\u0000\u0001\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001f\u0005\u0004"+
		"\u0000\u0000\u001c\u001e\u0003\u0004\u0002\u0000\u001d\u001c\u0001\u0000"+
		"\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000"+
		"\u0000\u001f \u0001\u0000\u0000\u0000 \"\u0001\u0000\u0000\u0000!\u001f"+
		"\u0001\u0000\u0000\u0000\"#\u0005\u0005\u0000\u0000#\u0003\u0001\u0000"+
		"\u0000\u0000$%\u0005\u0015\u0000\u0000%&\u0003\u0006\u0003\u0000&)\u0003"+
		"\u0004\u0002\u0000\'(\u0005\u0016\u0000\u0000(*\u0003\u0004\u0002\u0000"+
		")\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+,\u0005\u0017\u0000\u0000,V\u0001\u0000\u0000\u0000-.\u0005\u0007"+
		"\u0000\u0000./\u0005#\u0000\u0000/0\u0005\b\u0000\u00000V\u0003\u0006"+
		"\u0003\u000012\u0005\t\u0000\u000023\u0005#\u0000\u000034\u0005\n\u0000"+
		"\u000045\u0003\u0006\u0003\u000056\u0005\u000b\u0000\u00006V\u0001\u0000"+
		"\u0000\u000078\u0005\u0018\u0000\u00008<\u0003\u0006\u0003\u00009;\u0003"+
		"\u0004\u0002\u0000:9\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000"+
		"\u0000><\u0001\u0000\u0000\u0000?@\u0005\u0019\u0000\u0000@V\u0001\u0000"+
		"\u0000\u0000AB\u0005\u0006\u0000\u0000BV\u0007\u0000\u0000\u0000CD\u0005"+
		"!\u0000\u0000DH\u0005#\u0000\u0000EG\u0003\u0006\u0003\u0000FE\u0001\u0000"+
		"\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001"+
		"\u0000\u0000\u0000IV\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000"+
		"KL\u0005\"\u0000\u0000LM\u0005#\u0000\u0000MN\u0005!\u0000\u0000NR\u0005"+
		"#\u0000\u0000OQ\u0003\u0006\u0003\u0000PO\u0001\u0000\u0000\u0000QT\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000U$\u0001\u0000\u0000"+
		"\u0000U-\u0001\u0000\u0000\u0000U1\u0001\u0000\u0000\u0000U7\u0001\u0000"+
		"\u0000\u0000UA\u0001\u0000\u0000\u0000UC\u0001\u0000\u0000\u0000UK\u0001"+
		"\u0000\u0000\u0000V\u0005\u0001\u0000\u0000\u0000WX\u0006\u0003\uffff"+
		"\uffff\u0000X^\u0005\u0001\u0000\u0000Y^\u0005\u0002\u0000\u0000Z^\u0005"+
		"#\u0000\u0000[^\u0005\u001a\u0000\u0000\\^\u0005\u001b\u0000\u0000]W\u0001"+
		"\u0000\u0000\u0000]Y\u0001\u0000\u0000\u0000]Z\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000^p\u0001\u0000\u0000"+
		"\u0000_`\n\b\u0000\u0000`a\u0007\u0001\u0000\u0000ao\u0003\u0006\u0003"+
		"\tbc\n\u0007\u0000\u0000cd\u0007\u0002\u0000\u0000do\u0003\u0006\u0003"+
		"\bef\n\u0006\u0000\u0000fg\u0005\u0014\u0000\u0000go\u0003\u0006\u0003"+
		"\u0007hi\n\u0005\u0000\u0000ij\u0005\u0013\u0000\u0000jo\u0003\u0006\u0003"+
		"\u0006kl\n\u0004\u0000\u0000lm\u0007\u0003\u0000\u0000mo\u0003\u0006\u0003"+
		"\u0005n_\u0001\u0000\u0000\u0000nb\u0001\u0000\u0000\u0000ne\u0001\u0000"+
		"\u0000\u0000nh\u0001\u0000\u0000\u0000nk\u0001\u0000\u0000\u0000or\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"q\u0007\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000st\u0005\u001c"+
		"\u0000\u0000ty\u0005#\u0000\u0000uv\u0005\u001d\u0000\u0000vx\u0005#\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|}\u0003\n\u0005\u0000}\t\u0001\u0000\u0000\u0000~\u0082"+
		"\u0005\u001e\u0000\u0000\u007f\u0081\u0003\u0004\u0002\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0005\u001f\u0000\u0000\u0086\u0087\u0003\u0006\u0003\u0000\u0087\u0088"+
		"\u0005 \u0000\u0000\u0088\u0091\u0001\u0000\u0000\u0000\u0089\u008b\u0003"+
		"\u0004\u0002\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e\u0001"+
		"\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008f\u0091\u0005 \u0000\u0000\u0090~\u0001\u0000\u0000"+
		"\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0091\u000b\u0001\u0000\u0000"+
		"\u0000\u000f\u000f\u0016\u001f)<HRU]npy\u0082\u008c\u0090";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}