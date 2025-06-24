// Generated from grammar\MOC.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MOCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INT_TYPE=2, DOUBLE_TYPE=3, VOID_TYPE=4, IF=5, ELSE=6, WHILE=7, 
		FOR=8, RETURN=9, READ=10, READC=11, READS=12, WRITE=13, WRITEC=14, WRITEV=15, 
		WRITES=16, OP_LT=17, OP_LE=18, OP_GT=19, OP_GE=20, OP_EQ=21, OP_NE=22, 
		AND=23, OR=24, NOT=25, LPAREN=26, RPAREN=27, LBRACE=28, RBRACE=29, LBRACK=30, 
		RBRACK=31, SEMI=32, COMMA=33, ASSIGN=34, PLUS=35, MINUS=36, MULT=37, DIV=38, 
		MOD=39, QUOTE=40, DOUBLE_LITERAL=41, INT_LITERAL=42, STRING_LITERAL=43, 
		ID=44, WS=45, LINE_COMMENT=46, BLOCK_COMMENT=47;
	public static final int
		RULE_start = 0, RULE_prototype = 1, RULE_functionDecl = 2, RULE_paramList = 3, 
		RULE_param = 4, RULE_mainFunction = 5, RULE_block = 6, RULE_statement = 7, 
		RULE_varDecl = 8, RULE_simpleDeclList = 9, RULE_simpleDecl = 10, RULE_arrayDeclList = 11, 
		RULE_arrayDecl = 12, RULE_arraySuffix = 13, RULE_initValue = 14, RULE_exprList = 15, 
		RULE_inputFunction = 16, RULE_assignment = 17, RULE_expr = 18, RULE_functionCall = 19, 
		RULE_casting = 20, RULE_condition = 21, RULE_ifStatement = 22, RULE_whileStatement = 23, 
		RULE_forStatement = 24, RULE_returnStatement = 25, RULE_writeFunction = 26, 
		RULE_type = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "prototype", "functionDecl", "paramList", "param", "mainFunction", 
			"block", "statement", "varDecl", "simpleDeclList", "simpleDecl", "arrayDeclList", 
			"arrayDecl", "arraySuffix", "initValue", "exprList", "inputFunction", 
			"assignment", "expr", "functionCall", "casting", "condition", "ifStatement", 
			"whileStatement", "forStatement", "returnStatement", "writeFunction", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'int'", "'double'", "'void'", "'if'", "'else'", "'while'", 
			"'for'", "'return'", "'read'", "'readc'", "'reads'", "'write'", "'writec'", 
			"'writev'", "'writes'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", 
			"'&&'", "'||'", "'!'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", 
			"','", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "INT_TYPE", "DOUBLE_TYPE", "VOID_TYPE", "IF", "ELSE", "WHILE", 
			"FOR", "RETURN", "READ", "READC", "READS", "WRITE", "WRITEC", "WRITEV", 
			"WRITES", "OP_LT", "OP_LE", "OP_GT", "OP_GE", "OP_EQ", "OP_NE", "AND", 
			"OR", "NOT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
			"SEMI", "COMMA", "ASSIGN", "PLUS", "MINUS", "MULT", "DIV", "MOD", "QUOTE", 
			"DOUBLE_LITERAL", "INT_LITERAL", "STRING_LITERAL", "ID", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
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
	public String getGrammarFileName() { return "MOC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MOCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public MainFunctionContext mainFunction() {
			return getRuleContext(MainFunctionContext.class,0);
		}
		public List<PrototypeContext> prototype() {
			return getRuleContexts(PrototypeContext.class);
		}
		public PrototypeContext prototype(int i) {
			return getRuleContext(PrototypeContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(59);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(56);
						prototype();
						}
						break;
					case 2:
						{
						setState(57);
						functionDecl();
						}
						break;
					case 3:
						{
						setState(58);
						varDecl();
						}
						break;
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(64);
			mainFunction();
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

	public static class PrototypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MOCParser.SEMI, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public List<TerminalNode> VOID_TYPE() { return getTokens(MOCParser.VOID_TYPE); }
		public TerminalNode VOID_TYPE(int i) {
			return getToken(MOCParser.VOID_TYPE, i);
		}
		public PrototypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prototype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterPrototype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitPrototype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitPrototype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrototypeContext prototype() throws RecognitionException {
		PrototypeContext _localctx = new PrototypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prototype);
		int _la;
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				type();
				setState(67);
				match(ID);
				setState(68);
				match(LPAREN);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << VOID_TYPE))) != 0)) {
					{
					setState(69);
					paramList();
					}
				}

				setState(72);
				match(RPAREN);
				setState(73);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(VOID_TYPE);
				setState(76);
				match(T__0);
				setState(77);
				match(LPAREN);
				setState(78);
				match(VOID_TYPE);
				setState(79);
				match(RPAREN);
				setState(80);
				match(SEMI);
				}
				break;
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

	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			type();
			setState(84);
			match(ID);
			setState(85);
			match(LPAREN);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << VOID_TYPE))) != 0)) {
				{
				setState(86);
				paramList();
				}
			}

			setState(89);
			match(RPAREN);
			setState(90);
			block();
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

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MOCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MOCParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			param();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(93);
				match(COMMA);
				setState(94);
				param();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(MOCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MOCParser.RBRACK, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			type();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(101);
				match(ID);
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(104);
				match(LBRACK);
				setState(105);
				match(RBRACK);
				}
			}

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

	public static class MainFunctionContext extends ParserRuleContext {
		public List<TerminalNode> VOID_TYPE() { return getTokens(MOCParser.VOID_TYPE); }
		public TerminalNode VOID_TYPE(int i) {
			return getToken(MOCParser.VOID_TYPE, i);
		}
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterMainFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitMainFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitMainFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainFunctionContext mainFunction() throws RecognitionException {
		MainFunctionContext _localctx = new MainFunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mainFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(VOID_TYPE);
			setState(109);
			match(T__0);
			setState(110);
			match(LPAREN);
			setState(111);
			match(VOID_TYPE);
			setState(112);
			match(RPAREN);
			setState(113);
			block();
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MOCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MOCParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(LBRACE);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << VOID_TYPE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << WRITE) | (1L << WRITEC) | (1L << WRITEV) | (1L << WRITES) | (1L << ID))) != 0)) {
				{
				{
				setState(116);
				statement();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(RBRACE);
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

	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WriteFunctionContext writeFunction() {
			return getRuleContext(WriteFunctionContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MOCParser.SEMI, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				writeFunction();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				returnStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(130);
				functionCall();
				setState(131);
				match(SEMI);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(133);
				assignment();
				setState(134);
				match(SEMI);
				}
				break;
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

	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SimpleDeclListContext simpleDeclList() {
			return getRuleContext(SimpleDeclListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MOCParser.SEMI, 0); }
		public ArrayDeclListContext arrayDeclList() {
			return getRuleContext(ArrayDeclListContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDecl);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				type();
				setState(139);
				simpleDeclList();
				setState(140);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				type();
				setState(143);
				arrayDeclList();
				setState(144);
				match(SEMI);
				}
				break;
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

	public static class SimpleDeclListContext extends ParserRuleContext {
		public List<SimpleDeclContext> simpleDecl() {
			return getRuleContexts(SimpleDeclContext.class);
		}
		public SimpleDeclContext simpleDecl(int i) {
			return getRuleContext(SimpleDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MOCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MOCParser.COMMA, i);
		}
		public SimpleDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDeclList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterSimpleDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitSimpleDeclList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitSimpleDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleDeclListContext simpleDeclList() throws RecognitionException {
		SimpleDeclListContext _localctx = new SimpleDeclListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_simpleDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			simpleDecl();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(149);
				match(COMMA);
				setState(150);
				simpleDecl();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class SimpleDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MOCParser.ASSIGN, 0); }
		public InitValueContext initValue() {
			return getRuleContext(InitValueContext.class,0);
		}
		public SimpleDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterSimpleDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitSimpleDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitSimpleDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleDeclContext simpleDecl() throws RecognitionException {
		SimpleDeclContext _localctx = new SimpleDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_simpleDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ID);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(157);
				match(ASSIGN);
				setState(158);
				initValue();
				}
			}

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

	public static class ArrayDeclListContext extends ParserRuleContext {
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MOCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MOCParser.COMMA, i);
		}
		public ArrayDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterArrayDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitArrayDeclList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitArrayDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclListContext arrayDeclList() throws RecognitionException {
		ArrayDeclListContext _localctx = new ArrayDeclListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			arrayDecl();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(162);
				match(COMMA);
				setState(163);
				arrayDecl();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public ArraySuffixContext arraySuffix() {
			return getRuleContext(ArraySuffixContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MOCParser.ASSIGN, 0); }
		public InitValueContext initValue() {
			return getRuleContext(InitValueContext.class,0);
		}
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(ID);
			setState(170);
			arraySuffix();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(171);
				match(ASSIGN);
				setState(172);
				initValue();
				}
			}

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

	public static class ArraySuffixContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(MOCParser.LBRACK, 0); }
		public TerminalNode INT_LITERAL() { return getToken(MOCParser.INT_LITERAL, 0); }
		public TerminalNode RBRACK() { return getToken(MOCParser.RBRACK, 0); }
		public ArraySuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterArraySuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitArraySuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitArraySuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySuffixContext arraySuffix() throws RecognitionException {
		ArraySuffixContext _localctx = new ArraySuffixContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arraySuffix);
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(LBRACK);
				setState(176);
				match(INT_LITERAL);
				setState(177);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(LBRACK);
				setState(179);
				match(RBRACK);
				}
				break;
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

	public static class InitValueContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InputFunctionContext inputFunction() {
			return getRuleContext(InputFunctionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(MOCParser.LBRACE, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MOCParser.RBRACE, 0); }
		public InitValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterInitValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitInitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitInitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitValueContext initValue() throws RecognitionException {
		InitValueContext _localctx = new InitValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_initValue);
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				inputFunction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(LBRACE);
				setState(185);
				exprList();
				setState(186);
				match(RBRACE);
				}
				break;
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

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MOCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MOCParser.COMMA, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			expr(0);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(191);
				match(COMMA);
				setState(192);
				expr(0);
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class InputFunctionContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MOCParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public TerminalNode READC() { return getToken(MOCParser.READC, 0); }
		public TerminalNode READS() { return getToken(MOCParser.READS, 0); }
		public InputFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterInputFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitInputFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitInputFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputFunctionContext inputFunction() throws RecognitionException {
		InputFunctionContext _localctx = new InputFunctionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_inputFunction);
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READ:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(READ);
				setState(199);
				match(LPAREN);
				setState(200);
				match(RPAREN);
				}
				break;
			case READC:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(READC);
				setState(202);
				match(LPAREN);
				setState(203);
				match(RPAREN);
				}
				break;
			case READS:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				match(READS);
				setState(205);
				match(LPAREN);
				setState(206);
				match(RPAREN);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MOCParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(MOCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MOCParser.RBRACK, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assignment);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(ID);
				setState(210);
				match(ASSIGN);
				setState(211);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(ID);
				setState(213);
				match(LBRACK);
				setState(214);
				expr(0);
				setState(215);
				match(RBRACK);
				setState(216);
				match(ASSIGN);
				setState(217);
				expr(0);
				}
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CastingContext casting() {
			return getRuleContext(CastingContext.class,0);
		}
		public InputFunctionContext inputFunction() {
			return getRuleContext(InputFunctionContext.class,0);
		}
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(MOCParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MOCParser.RBRACK, 0); }
		public TerminalNode INT_LITERAL() { return getToken(MOCParser.INT_LITERAL, 0); }
		public TerminalNode DOUBLE_LITERAL() { return getToken(MOCParser.DOUBLE_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MOCParser.STRING_LITERAL, 0); }
		public TerminalNode PLUS() { return getToken(MOCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MOCParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(MOCParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MOCParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MOCParser.MOD, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(222);
				match(LPAREN);
				setState(223);
				expr(0);
				setState(224);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(226);
				functionCall();
				}
				break;
			case 3:
				{
				setState(227);
				casting();
				}
				break;
			case 4:
				{
				setState(228);
				inputFunction();
				}
				break;
			case 5:
				{
				setState(229);
				match(ID);
				setState(230);
				match(LBRACK);
				setState(231);
				expr(0);
				setState(232);
				match(RBRACK);
				}
				break;
			case 6:
				{
				setState(234);
				match(ID);
				}
				break;
			case 7:
				{
				setState(235);
				match(INT_LITERAL);
				}
				break;
			case 8:
				{
				setState(236);
				match(DOUBLE_LITERAL);
				}
				break;
			case 9:
				{
				setState(237);
				match(STRING_LITERAL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(241);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(242);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(244);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MOCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MOCParser.COMMA, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(ID);
			setState(252);
			match(LPAREN);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << READ) | (1L << READC) | (1L << READS) | (1L << LPAREN) | (1L << DOUBLE_LITERAL) | (1L << INT_LITERAL) | (1L << STRING_LITERAL) | (1L << ID))) != 0)) {
				{
				setState(253);
				expr(0);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(254);
					match(COMMA);
					setState(255);
					expr(0);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(263);
			match(RPAREN);
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

	public static class CastingContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CastingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_casting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterCasting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitCasting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitCasting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastingContext casting() throws RecognitionException {
		CastingContext _localctx = new CastingContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_casting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(LPAREN);
			setState(266);
			type();
			setState(267);
			match(RPAREN);
			setState(268);
			expr(0);
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_LT() { return getToken(MOCParser.OP_LT, 0); }
		public TerminalNode OP_LE() { return getToken(MOCParser.OP_LE, 0); }
		public TerminalNode OP_GT() { return getToken(MOCParser.OP_GT, 0); }
		public TerminalNode OP_GE() { return getToken(MOCParser.OP_GE, 0); }
		public TerminalNode OP_EQ() { return getToken(MOCParser.OP_EQ, 0); }
		public TerminalNode OP_NE() { return getToken(MOCParser.OP_NE, 0); }
		public TerminalNode AND() { return getToken(MOCParser.AND, 0); }
		public TerminalNode OR() { return getToken(MOCParser.OR, 0); }
		public TerminalNode NOT() { return getToken(MOCParser.NOT, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_condition);
		int _la;
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READ:
			case READC:
			case READS:
			case LPAREN:
			case DOUBLE_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				expr(0);
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_LT) | (1L << OP_LE) | (1L << OP_GT) | (1L << OP_GE) | (1L << OP_EQ) | (1L << OP_NE) | (1L << AND) | (1L << OR))) != 0)) {
					{
					setState(271);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_LT) | (1L << OP_LE) | (1L << OP_GT) | (1L << OP_GE) | (1L << OP_EQ) | (1L << OP_NE) | (1L << AND) | (1L << OR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(272);
					expr(0);
					}
				}

				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				match(NOT);
				setState(276);
				expr(0);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MOCParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MOCParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(IF);
			setState(280);
			match(LPAREN);
			setState(281);
			condition();
			setState(282);
			match(RPAREN);
			setState(283);
			block();
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(284);
				match(ELSE);
				setState(285);
				block();
				}
			}

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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MOCParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(WHILE);
			setState(289);
			match(LPAREN);
			setState(290);
			condition();
			setState(291);
			match(RPAREN);
			setState(292);
			block();
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

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MOCParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MOCParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MOCParser.SEMI, i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(FOR);
			setState(295);
			match(LPAREN);
			setState(296);
			assignment();
			setState(297);
			match(SEMI);
			setState(298);
			condition();
			setState(299);
			match(SEMI);
			setState(300);
			assignment();
			setState(301);
			match(RPAREN);
			setState(302);
			block();
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MOCParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MOCParser.SEMI, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(RETURN);
			setState(305);
			expr(0);
			setState(306);
			match(SEMI);
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

	public static class WriteFunctionContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(MOCParser.WRITE, 0); }
		public TerminalNode LPAREN() { return getToken(MOCParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MOCParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MOCParser.SEMI, 0); }
		public TerminalNode WRITEC() { return getToken(MOCParser.WRITEC, 0); }
		public TerminalNode WRITEV() { return getToken(MOCParser.WRITEV, 0); }
		public TerminalNode ID() { return getToken(MOCParser.ID, 0); }
		public TerminalNode WRITES() { return getToken(MOCParser.WRITES, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MOCParser.STRING_LITERAL, 0); }
		public WriteFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterWriteFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitWriteFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitWriteFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteFunctionContext writeFunction() throws RecognitionException {
		WriteFunctionContext _localctx = new WriteFunctionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_writeFunction);
		int _la;
		try {
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WRITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(WRITE);
				setState(309);
				match(LPAREN);
				setState(310);
				expr(0);
				setState(311);
				match(RPAREN);
				setState(312);
				match(SEMI);
				}
				break;
			case WRITEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(WRITEC);
				setState(315);
				match(LPAREN);
				setState(316);
				expr(0);
				setState(317);
				match(RPAREN);
				setState(318);
				match(SEMI);
				}
				break;
			case WRITEV:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				match(WRITEV);
				setState(321);
				match(LPAREN);
				setState(322);
				match(ID);
				setState(323);
				match(RPAREN);
				setState(324);
				match(SEMI);
				}
				break;
			case WRITES:
				enterOuterAlt(_localctx, 4);
				{
				setState(325);
				match(WRITES);
				setState(326);
				match(LPAREN);
				setState(327);
				_la = _input.LA(1);
				if ( !(_la==STRING_LITERAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(328);
				match(RPAREN);
				setState(329);
				match(SEMI);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(MOCParser.INT_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(MOCParser.DOUBLE_TYPE, 0); }
		public TerminalNode VOID_TYPE() { return getToken(MOCParser.VOID_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << DOUBLE_TYPE) | (1L << VOID_TYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		case 18:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0151\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\7\2>\n\2\f\2\16\2"+
		"A\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3I\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3T\n\3\3\4\3\4\3\4\3\4\5\4Z\n\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5b"+
		"\n\5\f\5\16\5e\13\5\3\6\3\6\5\6i\n\6\3\6\3\6\5\6m\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\7\bx\n\b\f\b\16\b{\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u0095\n\n\3\13\3\13\3\13\7\13\u009a\n\13\f\13\16\13\u009d\13"+
		"\13\3\f\3\f\3\f\5\f\u00a2\n\f\3\r\3\r\3\r\7\r\u00a7\n\r\f\r\16\r\u00aa"+
		"\13\r\3\16\3\16\3\16\3\16\5\16\u00b0\n\16\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00b7\n\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00bf\n\20\3\21\3\21\3"+
		"\21\7\21\u00c4\n\21\f\21\16\21\u00c7\13\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u00d2\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u00de\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f1\n\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\7\24\u00f9\n\24\f\24\16\24\u00fc\13\24\3\25\3\25"+
		"\3\25\3\25\3\25\7\25\u0103\n\25\f\25\16\25\u0106\13\25\5\25\u0108\n\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u0114\n\27\3\27"+
		"\3\27\5\27\u0118\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0121\n"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\5\34\u014d\n\34\3\35\3\35\3\35\2\3&\36\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668\2\7\3\2%&\3\2\')\3\2\23\32\3\2-.\3"+
		"\2\4\6\2\u0163\2?\3\2\2\2\4S\3\2\2\2\6U\3\2\2\2\b^\3\2\2\2\nf\3\2\2\2"+
		"\fn\3\2\2\2\16u\3\2\2\2\20\u008a\3\2\2\2\22\u0094\3\2\2\2\24\u0096\3\2"+
		"\2\2\26\u009e\3\2\2\2\30\u00a3\3\2\2\2\32\u00ab\3\2\2\2\34\u00b6\3\2\2"+
		"\2\36\u00be\3\2\2\2 \u00c0\3\2\2\2\"\u00d1\3\2\2\2$\u00dd\3\2\2\2&\u00f0"+
		"\3\2\2\2(\u00fd\3\2\2\2*\u010b\3\2\2\2,\u0117\3\2\2\2.\u0119\3\2\2\2\60"+
		"\u0122\3\2\2\2\62\u0128\3\2\2\2\64\u0132\3\2\2\2\66\u014c\3\2\2\28\u014e"+
		"\3\2\2\2:>\5\4\3\2;>\5\6\4\2<>\5\22\n\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2"+
		">A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\5\f\7\2C\3\3\2\2"+
		"\2DE\58\35\2EF\7.\2\2FH\7\34\2\2GI\5\b\5\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2"+
		"\2JK\7\35\2\2KL\7\"\2\2LT\3\2\2\2MN\7\6\2\2NO\7\3\2\2OP\7\34\2\2PQ\7\6"+
		"\2\2QR\7\35\2\2RT\7\"\2\2SD\3\2\2\2SM\3\2\2\2T\5\3\2\2\2UV\58\35\2VW\7"+
		".\2\2WY\7\34\2\2XZ\5\b\5\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7\35\2\2\\"+
		"]\5\16\b\2]\7\3\2\2\2^c\5\n\6\2_`\7#\2\2`b\5\n\6\2a_\3\2\2\2be\3\2\2\2"+
		"ca\3\2\2\2cd\3\2\2\2d\t\3\2\2\2ec\3\2\2\2fh\58\35\2gi\7.\2\2hg\3\2\2\2"+
		"hi\3\2\2\2il\3\2\2\2jk\7 \2\2km\7!\2\2lj\3\2\2\2lm\3\2\2\2m\13\3\2\2\2"+
		"no\7\6\2\2op\7\3\2\2pq\7\34\2\2qr\7\6\2\2rs\7\35\2\2st\5\16\b\2t\r\3\2"+
		"\2\2uy\7\36\2\2vx\5\20\t\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3"+
		"\2\2\2{y\3\2\2\2|}\7\37\2\2}\17\3\2\2\2~\u008b\5\22\n\2\177\u008b\5.\30"+
		"\2\u0080\u008b\5\60\31\2\u0081\u008b\5\62\32\2\u0082\u008b\5\66\34\2\u0083"+
		"\u008b\5\64\33\2\u0084\u0085\5(\25\2\u0085\u0086\7\"\2\2\u0086\u008b\3"+
		"\2\2\2\u0087\u0088\5$\23\2\u0088\u0089\7\"\2\2\u0089\u008b\3\2\2\2\u008a"+
		"~\3\2\2\2\u008a\177\3\2\2\2\u008a\u0080\3\2\2\2\u008a\u0081\3\2\2\2\u008a"+
		"\u0082\3\2\2\2\u008a\u0083\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0087\3\2"+
		"\2\2\u008b\21\3\2\2\2\u008c\u008d\58\35\2\u008d\u008e\5\24\13\2\u008e"+
		"\u008f\7\"\2\2\u008f\u0095\3\2\2\2\u0090\u0091\58\35\2\u0091\u0092\5\30"+
		"\r\2\u0092\u0093\7\"\2\2\u0093\u0095\3\2\2\2\u0094\u008c\3\2\2\2\u0094"+
		"\u0090\3\2\2\2\u0095\23\3\2\2\2\u0096\u009b\5\26\f\2\u0097\u0098\7#\2"+
		"\2\u0098\u009a\5\26\f\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\25\3\2\2\2\u009d\u009b\3\2\2"+
		"\2\u009e\u00a1\7.\2\2\u009f\u00a0\7$\2\2\u00a0\u00a2\5\36\20\2\u00a1\u009f"+
		"\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\27\3\2\2\2\u00a3\u00a8\5\32\16\2\u00a4"+
		"\u00a5\7#\2\2\u00a5\u00a7\5\32\16\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\31\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ac\7.\2\2\u00ac\u00af\5\34\17\2\u00ad\u00ae\7"+
		"$\2\2\u00ae\u00b0\5\36\20\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\33\3\2\2\2\u00b1\u00b2\7 \2\2\u00b2\u00b3\7,\2\2\u00b3\u00b7\7!\2\2\u00b4"+
		"\u00b5\7 \2\2\u00b5\u00b7\7!\2\2\u00b6\u00b1\3\2\2\2\u00b6\u00b4\3\2\2"+
		"\2\u00b7\35\3\2\2\2\u00b8\u00bf\5&\24\2\u00b9\u00bf\5\"\22\2\u00ba\u00bb"+
		"\7\36\2\2\u00bb\u00bc\5 \21\2\u00bc\u00bd\7\37\2\2\u00bd\u00bf\3\2\2\2"+
		"\u00be\u00b8\3\2\2\2\u00be\u00b9\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf\37"+
		"\3\2\2\2\u00c0\u00c5\5&\24\2\u00c1\u00c2\7#\2\2\u00c2\u00c4\5&\24\2\u00c3"+
		"\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6!\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\7\f\2\2\u00c9\u00ca"+
		"\7\34\2\2\u00ca\u00d2\7\35\2\2\u00cb\u00cc\7\r\2\2\u00cc\u00cd\7\34\2"+
		"\2\u00cd\u00d2\7\35\2\2\u00ce\u00cf\7\16\2\2\u00cf\u00d0\7\34\2\2\u00d0"+
		"\u00d2\7\35\2\2\u00d1\u00c8\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00ce\3"+
		"\2\2\2\u00d2#\3\2\2\2\u00d3\u00d4\7.\2\2\u00d4\u00d5\7$\2\2\u00d5\u00de"+
		"\5&\24\2\u00d6\u00d7\7.\2\2\u00d7\u00d8\7 \2\2\u00d8\u00d9\5&\24\2\u00d9"+
		"\u00da\7!\2\2\u00da\u00db\7$\2\2\u00db\u00dc\5&\24\2\u00dc\u00de\3\2\2"+
		"\2\u00dd\u00d3\3\2\2\2\u00dd\u00d6\3\2\2\2\u00de%\3\2\2\2\u00df\u00e0"+
		"\b\24\1\2\u00e0\u00e1\7\34\2\2\u00e1\u00e2\5&\24\2\u00e2\u00e3\7\35\2"+
		"\2\u00e3\u00f1\3\2\2\2\u00e4\u00f1\5(\25\2\u00e5\u00f1\5*\26\2\u00e6\u00f1"+
		"\5\"\22\2\u00e7\u00e8\7.\2\2\u00e8\u00e9\7 \2\2\u00e9\u00ea\5&\24\2\u00ea"+
		"\u00eb\7!\2\2\u00eb\u00f1\3\2\2\2\u00ec\u00f1\7.\2\2\u00ed\u00f1\7,\2"+
		"\2\u00ee\u00f1\7+\2\2\u00ef\u00f1\7-\2\2\u00f0\u00df\3\2\2\2\u00f0\u00e4"+
		"\3\2\2\2\u00f0\u00e5\3\2\2\2\u00f0\u00e6\3\2\2\2\u00f0\u00e7\3\2\2\2\u00f0"+
		"\u00ec\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2"+
		"\2\2\u00f1\u00fa\3\2\2\2\u00f2\u00f3\f\r\2\2\u00f3\u00f4\t\2\2\2\u00f4"+
		"\u00f9\5&\24\16\u00f5\u00f6\f\f\2\2\u00f6\u00f7\t\3\2\2\u00f7\u00f9\5"+
		"&\24\r\u00f8\u00f2\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\'\3\2\2\2\u00fc\u00fa\3\2\2\2"+
		"\u00fd\u00fe\7.\2\2\u00fe\u0107\7\34\2\2\u00ff\u0104\5&\24\2\u0100\u0101"+
		"\7#\2\2\u0101\u0103\5&\24\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0107\u00ff\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\7\35\2\2\u010a)\3\2\2\2\u010b\u010c\7\34\2\2\u010c\u010d\58\35"+
		"\2\u010d\u010e\7\35\2\2\u010e\u010f\5&\24\2\u010f+\3\2\2\2\u0110\u0113"+
		"\5&\24\2\u0111\u0112\t\4\2\2\u0112\u0114\5&\24\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0118\3\2\2\2\u0115\u0116\7\33\2\2\u0116\u0118\5"+
		"&\24\2\u0117\u0110\3\2\2\2\u0117\u0115\3\2\2\2\u0118-\3\2\2\2\u0119\u011a"+
		"\7\7\2\2\u011a\u011b\7\34\2\2\u011b\u011c\5,\27\2\u011c\u011d\7\35\2\2"+
		"\u011d\u0120\5\16\b\2\u011e\u011f\7\b\2\2\u011f\u0121\5\16\b\2\u0120\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121/\3\2\2\2\u0122\u0123\7\t\2\2\u0123"+
		"\u0124\7\34\2\2\u0124\u0125\5,\27\2\u0125\u0126\7\35\2\2\u0126\u0127\5"+
		"\16\b\2\u0127\61\3\2\2\2\u0128\u0129\7\n\2\2\u0129\u012a\7\34\2\2\u012a"+
		"\u012b\5$\23\2\u012b\u012c\7\"\2\2\u012c\u012d\5,\27\2\u012d\u012e\7\""+
		"\2\2\u012e\u012f\5$\23\2\u012f\u0130\7\35\2\2\u0130\u0131\5\16\b\2\u0131"+
		"\63\3\2\2\2\u0132\u0133\7\13\2\2\u0133\u0134\5&\24\2\u0134\u0135\7\"\2"+
		"\2\u0135\65\3\2\2\2\u0136\u0137\7\17\2\2\u0137\u0138\7\34\2\2\u0138\u0139"+
		"\5&\24\2\u0139\u013a\7\35\2\2\u013a\u013b\7\"\2\2\u013b\u014d\3\2\2\2"+
		"\u013c\u013d\7\20\2\2\u013d\u013e\7\34\2\2\u013e\u013f\5&\24\2\u013f\u0140"+
		"\7\35\2\2\u0140\u0141\7\"\2\2\u0141\u014d\3\2\2\2\u0142\u0143\7\21\2\2"+
		"\u0143\u0144\7\34\2\2\u0144\u0145\7.\2\2\u0145\u0146\7\35\2\2\u0146\u014d"+
		"\7\"\2\2\u0147\u0148\7\22\2\2\u0148\u0149\7\34\2\2\u0149\u014a\t\5\2\2"+
		"\u014a\u014b\7\35\2\2\u014b\u014d\7\"\2\2\u014c\u0136\3\2\2\2\u014c\u013c"+
		"\3\2\2\2\u014c\u0142\3\2\2\2\u014c\u0147\3\2\2\2\u014d\67\3\2\2\2\u014e"+
		"\u014f\t\6\2\2\u014f9\3\2\2\2\37=?HSYchly\u008a\u0094\u009b\u00a1\u00a8"+
		"\u00af\u00b6\u00be\u00c5\u00d1\u00dd\u00f0\u00f8\u00fa\u0104\u0107\u0113"+
		"\u0117\u0120\u014c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}