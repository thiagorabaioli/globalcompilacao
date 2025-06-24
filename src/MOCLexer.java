// Generated from MOC.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MOCLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "INT_TYPE", "DOUBLE_TYPE", "VOID_TYPE", "IF", "ELSE", "WHILE", 
			"FOR", "RETURN", "READ", "READC", "READS", "WRITE", "WRITEC", "WRITEV", 
			"WRITES", "OP_LT", "OP_LE", "OP_GT", "OP_GE", "OP_EQ", "OP_NE", "AND", 
			"OR", "NOT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
			"SEMI", "COMMA", "ASSIGN", "PLUS", "MINUS", "MULT", "DIV", "MOD", "QUOTE", 
			"DOUBLE_LITERAL", "INT_LITERAL", "STRING_LITERAL", "ID", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
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


	public MOCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MOC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0131\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\6*\u00f3\n*\r*\16*\u00f4\3*\3*"+
		"\6*\u00f9\n*\r*\16*\u00fa\3+\6+\u00fe\n+\r+\16+\u00ff\3,\3,\7,\u0104\n"+
		",\f,\16,\u0107\13,\3,\3,\3-\3-\7-\u010d\n-\f-\16-\u0110\13-\3.\6.\u0113"+
		"\n.\r.\16.\u0114\3.\3.\3/\3/\3/\3/\7/\u011d\n/\f/\16/\u0120\13/\3/\3/"+
		"\3\60\3\60\3\60\3\60\7\60\u0128\n\60\f\60\16\60\u012b\13\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\u0129\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"\3\2\b\3\2\62;\5\2\f\f\17\17$$\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\2\u0138\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5f\3\2\2\2\7j\3\2\2\2\tq\3\2\2\2\13v\3"+
		"\2\2\2\ry\3\2\2\2\17~\3\2\2\2\21\u0084\3\2\2\2\23\u0088\3\2\2\2\25\u008f"+
		"\3\2\2\2\27\u0094\3\2\2\2\31\u009a\3\2\2\2\33\u00a0\3\2\2\2\35\u00a6\3"+
		"\2\2\2\37\u00ad\3\2\2\2!\u00b4\3\2\2\2#\u00bb\3\2\2\2%\u00bd\3\2\2\2\'"+
		"\u00c0\3\2\2\2)\u00c2\3\2\2\2+\u00c5\3\2\2\2-\u00c8\3\2\2\2/\u00cb\3\2"+
		"\2\2\61\u00ce\3\2\2\2\63\u00d1\3\2\2\2\65\u00d3\3\2\2\2\67\u00d5\3\2\2"+
		"\29\u00d7\3\2\2\2;\u00d9\3\2\2\2=\u00db\3\2\2\2?\u00dd\3\2\2\2A\u00df"+
		"\3\2\2\2C\u00e1\3\2\2\2E\u00e3\3\2\2\2G\u00e5\3\2\2\2I\u00e7\3\2\2\2K"+
		"\u00e9\3\2\2\2M\u00eb\3\2\2\2O\u00ed\3\2\2\2Q\u00ef\3\2\2\2S\u00f2\3\2"+
		"\2\2U\u00fd\3\2\2\2W\u0101\3\2\2\2Y\u010a\3\2\2\2[\u0112\3\2\2\2]\u0118"+
		"\3\2\2\2_\u0123\3\2\2\2ab\7o\2\2bc\7c\2\2cd\7k\2\2de\7p\2\2e\4\3\2\2\2"+
		"fg\7k\2\2gh\7p\2\2hi\7v\2\2i\6\3\2\2\2jk\7f\2\2kl\7q\2\2lm\7w\2\2mn\7"+
		"d\2\2no\7n\2\2op\7g\2\2p\b\3\2\2\2qr\7x\2\2rs\7q\2\2st\7k\2\2tu\7f\2\2"+
		"u\n\3\2\2\2vw\7k\2\2wx\7h\2\2x\f\3\2\2\2yz\7g\2\2z{\7n\2\2{|\7u\2\2|}"+
		"\7g\2\2}\16\3\2\2\2~\177\7y\2\2\177\u0080\7j\2\2\u0080\u0081\7k\2\2\u0081"+
		"\u0082\7n\2\2\u0082\u0083\7g\2\2\u0083\20\3\2\2\2\u0084\u0085\7h\2\2\u0085"+
		"\u0086\7q\2\2\u0086\u0087\7t\2\2\u0087\22\3\2\2\2\u0088\u0089\7t\2\2\u0089"+
		"\u008a\7g\2\2\u008a\u008b\7v\2\2\u008b\u008c\7w\2\2\u008c\u008d\7t\2\2"+
		"\u008d\u008e\7p\2\2\u008e\24\3\2\2\2\u008f\u0090\7t\2\2\u0090\u0091\7"+
		"g\2\2\u0091\u0092\7c\2\2\u0092\u0093\7f\2\2\u0093\26\3\2\2\2\u0094\u0095"+
		"\7t\2\2\u0095\u0096\7g\2\2\u0096\u0097\7c\2\2\u0097\u0098\7f\2\2\u0098"+
		"\u0099\7e\2\2\u0099\30\3\2\2\2\u009a\u009b\7t\2\2\u009b\u009c\7g\2\2\u009c"+
		"\u009d\7c\2\2\u009d\u009e\7f\2\2\u009e\u009f\7u\2\2\u009f\32\3\2\2\2\u00a0"+
		"\u00a1\7y\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7v\2\2"+
		"\u00a4\u00a5\7g\2\2\u00a5\34\3\2\2\2\u00a6\u00a7\7y\2\2\u00a7\u00a8\7"+
		"t\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac"+
		"\7e\2\2\u00ac\36\3\2\2\2\u00ad\u00ae\7y\2\2\u00ae\u00af\7t\2\2\u00af\u00b0"+
		"\7k\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7x\2\2\u00b3"+
		" \3\2\2\2\u00b4\u00b5\7y\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7k\2\2\u00b7"+
		"\u00b8\7v\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7u\2\2\u00ba\"\3\2\2\2\u00bb"+
		"\u00bc\7>\2\2\u00bc$\3\2\2\2\u00bd\u00be\7>\2\2\u00be\u00bf\7?\2\2\u00bf"+
		"&\3\2\2\2\u00c0\u00c1\7@\2\2\u00c1(\3\2\2\2\u00c2\u00c3\7@\2\2\u00c3\u00c4"+
		"\7?\2\2\u00c4*\3\2\2\2\u00c5\u00c6\7?\2\2\u00c6\u00c7\7?\2\2\u00c7,\3"+
		"\2\2\2\u00c8\u00c9\7#\2\2\u00c9\u00ca\7?\2\2\u00ca.\3\2\2\2\u00cb\u00cc"+
		"\7(\2\2\u00cc\u00cd\7(\2\2\u00cd\60\3\2\2\2\u00ce\u00cf\7~\2\2\u00cf\u00d0"+
		"\7~\2\2\u00d0\62\3\2\2\2\u00d1\u00d2\7#\2\2\u00d2\64\3\2\2\2\u00d3\u00d4"+
		"\7*\2\2\u00d4\66\3\2\2\2\u00d5\u00d6\7+\2\2\u00d68\3\2\2\2\u00d7\u00d8"+
		"\7}\2\2\u00d8:\3\2\2\2\u00d9\u00da\7\177\2\2\u00da<\3\2\2\2\u00db\u00dc"+
		"\7]\2\2\u00dc>\3\2\2\2\u00dd\u00de\7_\2\2\u00de@\3\2\2\2\u00df\u00e0\7"+
		"=\2\2\u00e0B\3\2\2\2\u00e1\u00e2\7.\2\2\u00e2D\3\2\2\2\u00e3\u00e4\7?"+
		"\2\2\u00e4F\3\2\2\2\u00e5\u00e6\7-\2\2\u00e6H\3\2\2\2\u00e7\u00e8\7/\2"+
		"\2\u00e8J\3\2\2\2\u00e9\u00ea\7,\2\2\u00eaL\3\2\2\2\u00eb\u00ec\7\61\2"+
		"\2\u00ecN\3\2\2\2\u00ed\u00ee\7\'\2\2\u00eeP\3\2\2\2\u00ef\u00f0\7$\2"+
		"\2\u00f0R\3\2\2\2\u00f1\u00f3\t\2\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f8\7\60\2\2\u00f7\u00f9\t\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3"+
		"\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fbT\3\2\2\2\u00fc\u00fe"+
		"\t\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100V\3\2\2\2\u0101\u0105\7$\2\2\u0102\u0104\n\3\2\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7$\2\2\u0109"+
		"X\3\2\2\2\u010a\u010e\t\4\2\2\u010b\u010d\t\5\2\2\u010c\u010b\3\2\2\2"+
		"\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010fZ\3"+
		"\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\t\6\2\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0117\b.\2\2\u0117\\\3\2\2\2\u0118\u0119\7\61\2\2\u0119\u011a"+
		"\7\61\2\2\u011a\u011e\3\2\2\2\u011b\u011d\n\7\2\2\u011c\u011b\3\2\2\2"+
		"\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\b/\2\2\u0122^\3\2\2\2\u0123\u0124"+
		"\7\61\2\2\u0124\u0125\7,\2\2\u0125\u0129\3\2\2\2\u0126\u0128\13\2\2\2"+
		"\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u012a\3\2\2\2\u0129\u0127"+
		"\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7,\2\2\u012d"+
		"\u012e\7\61\2\2\u012e\u012f\3\2\2\2\u012f\u0130\b\60\2\2\u0130`\3\2\2"+
		"\2\13\2\u00f4\u00fa\u00ff\u0105\u010e\u0114\u011e\u0129\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}