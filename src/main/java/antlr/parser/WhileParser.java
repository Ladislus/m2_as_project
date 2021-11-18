// Generated from C:/Users/Darky/Desktop/m2_as_project/src/main/java/antlr\While.g4 by ANTLR 4.9.2
package antlr.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WhileParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Program=1, Proc=2, Begin=3, End=4, Res=5, Call=6, Minus=7, Plus=8, Multiplication=9, 
		Division=10, GreaterThan=11, GreaterOrEqual=12, Equal=13, LesserThan=14, 
		LesserOrEqual=15, Different=16, Negation=17, OpenedParenthesis=18, ClosedParenthesis=19, 
		Semicolon=20, Comma=21, Colon=22, Underscore=23, Assign=24, Type=25, IntegerType=26, 
		BooleanType=27, BooleanValue=28, True=29, False=30, If=31, While=32, Do=33, 
		Else=34, Then=35, Skip=36, Identifier=37, IntegerValue=38, Digit=39, Characters=40, 
		WS=41;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_identifierDeclarationList = 2, 
		RULE_variablesDeclarationList = 3, RULE_variablesDeclaration = 4, RULE_identifierList = 5, 
		RULE_type = 6, RULE_block = 7, RULE_statements = 8, RULE_statement = 9, 
		RULE_arithmeticExpressionList = 10, RULE_arithmeticExpression = 11, RULE_booleanExpression = 12, 
		RULE_constant = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "identifierDeclarationList", "variablesDeclarationList", 
			"variablesDeclaration", "identifierList", "type", "block", "statements", 
			"statement", "arithmeticExpressionList", "arithmeticExpression", "booleanExpression", 
			"constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'proc'", "'begin'", "'end'", "'res'", "'call'", "'-'", 
			"'+'", "'*'", "'/'", "'>'", "'>='", "'='", "'<'", "'<='", "'<>'", "'not'", 
			"'('", "')'", "';'", "','", "':'", "'_'", null, null, "'int'", "'boolean'", 
			null, "'true'", "'false'", "'if'", "'while'", "'do'", "'else'", "'then'", 
			"'skip'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Program", "Proc", "Begin", "End", "Res", "Call", "Minus", "Plus", 
			"Multiplication", "Division", "GreaterThan", "GreaterOrEqual", "Equal", 
			"LesserThan", "LesserOrEqual", "Different", "Negation", "OpenedParenthesis", 
			"ClosedParenthesis", "Semicolon", "Comma", "Colon", "Underscore", "Assign", 
			"Type", "IntegerType", "BooleanType", "BooleanValue", "True", "False", 
			"If", "While", "Do", "Else", "Then", "Skip", "Identifier", "IntegerValue", 
			"Digit", "Characters", "WS"
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
	public String getGrammarFileName() { return "While.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WhileParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode Program() { return getToken(WhileParser.Program, 0); }
		public TerminalNode Begin() { return getToken(WhileParser.Begin, 0); }
		public VariablesDeclarationListContext variablesDeclarationList() {
			return getRuleContext(VariablesDeclarationListContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode End() { return getToken(WhileParser.End, 0); }
		public TerminalNode EOF() { return getToken(WhileParser.EOF, 0); }
		public TerminalNode Identifier() { return getToken(WhileParser.Identifier, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(Program);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(29);
				match(Identifier);
				}
			}

			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Proc) {
				{
				{
				setState(32);
				declaration();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(Begin);
			setState(39);
			variablesDeclarationList();
			setState(40);
			statements();
			setState(41);
			match(End);
			setState(42);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode Proc() { return getToken(WhileParser.Proc, 0); }
		public List<TerminalNode> Identifier() { return getTokens(WhileParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(WhileParser.Identifier, i);
		}
		public TerminalNode OpenedParenthesis() { return getToken(WhileParser.OpenedParenthesis, 0); }
		public IdentifierDeclarationListContext identifierDeclarationList() {
			return getRuleContext(IdentifierDeclarationListContext.class,0);
		}
		public TerminalNode ClosedParenthesis() { return getToken(WhileParser.ClosedParenthesis, 0); }
		public TerminalNode Begin() { return getToken(WhileParser.Begin, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode End() { return getToken(WhileParser.End, 0); }
		public TerminalNode Comma() { return getToken(WhileParser.Comma, 0); }
		public TerminalNode Res() { return getToken(WhileParser.Res, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(Proc);
			setState(45);
			match(Identifier);
			setState(46);
			match(OpenedParenthesis);
			setState(47);
			identifierDeclarationList();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(48);
				match(Comma);
				setState(49);
				match(Res);
				setState(50);
				type();
				setState(51);
				match(Identifier);
				}
			}

			setState(55);
			match(ClosedParenthesis);
			setState(56);
			match(Begin);
			setState(57);
			statements();
			setState(58);
			match(End);
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

	public static class IdentifierDeclarationListContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(WhileParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(WhileParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(WhileParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(WhileParser.Comma, i);
		}
		public IdentifierDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierDeclarationList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitIdentifierDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierDeclarationListContext identifierDeclarationList() throws RecognitionException {
		IdentifierDeclarationListContext _localctx = new IdentifierDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_identifierDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			type();
			setState(61);
			match(Identifier);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					match(Comma);
					setState(63);
					type();
					setState(64);
					match(Identifier);
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class VariablesDeclarationListContext extends ParserRuleContext {
		public VariablesDeclarationContext variablesDeclaration() {
			return getRuleContext(VariablesDeclarationContext.class,0);
		}
		public List<VariablesDeclarationListContext> variablesDeclarationList() {
			return getRuleContexts(VariablesDeclarationListContext.class);
		}
		public VariablesDeclarationListContext variablesDeclarationList(int i) {
			return getRuleContext(VariablesDeclarationListContext.class,i);
		}
		public VariablesDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesDeclarationList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitVariablesDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesDeclarationListContext variablesDeclarationList() throws RecognitionException {
		VariablesDeclarationListContext _localctx = new VariablesDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variablesDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			variablesDeclaration();
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(72);
					variablesDeclarationList();
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class VariablesDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(WhileParser.Semicolon, 0); }
		public VariablesDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitVariablesDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesDeclarationContext variablesDeclaration() throws RecognitionException {
		VariablesDeclarationContext _localctx = new VariablesDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variablesDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			type();
			setState(79);
			identifierList();
			setState(80);
			match(Semicolon);
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

	public static class IdentifierListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(WhileParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(WhileParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(WhileParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(WhileParser.Comma, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(Identifier);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(83);
				match(Comma);
				setState(84);
				match(Identifier);
				}
				}
				setState(89);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(WhileParser.Type, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(Type);
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
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenthesizedStatementContext extends BlockContext {
		public TerminalNode OpenedParenthesis() { return getToken(WhileParser.OpenedParenthesis, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode ClosedParenthesis() { return getToken(WhileParser.ClosedParenthesis, 0); }
		public ParenthesizedStatementContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitParenthesizedStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleStatementContext extends BlockContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SimpleStatementContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitSimpleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Call:
			case If:
			case While:
			case Skip:
			case Identifier:
				_localctx = new SimpleStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				statement();
				}
				break;
			case OpenedParenthesis:
				_localctx = new ParenthesizedStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(OpenedParenthesis);
				setState(94);
				statements();
				setState(95);
				match(ClosedParenthesis);
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<TerminalNode> Semicolon() { return getTokens(WhileParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(WhileParser.Semicolon, i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			statement();
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(100);
					match(Semicolon);
					setState(101);
					statements();
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public TerminalNode If() { return getToken(WhileParser.If, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode Then() { return getToken(WhileParser.Then, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(WhileParser.Else, 0); }
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipStatementContext extends StatementContext {
		public TerminalNode Skip() { return getToken(WhileParser.Skip, 0); }
		public SkipStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitSkipStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStatementContext extends StatementContext {
		public TerminalNode Identifier() { return getToken(WhileParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(WhileParser.Assign, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public AssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatementContext extends StatementContext {
		public TerminalNode While() { return getToken(WhileParser.While, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(WhileParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallStatementContext extends StatementContext {
		public TerminalNode Call() { return getToken(WhileParser.Call, 0); }
		public TerminalNode Identifier() { return getToken(WhileParser.Identifier, 0); }
		public TerminalNode OpenedParenthesis() { return getToken(WhileParser.OpenedParenthesis, 0); }
		public ArithmeticExpressionListContext arithmeticExpressionList() {
			return getRuleContext(ArithmeticExpressionListContext.class,0);
		}
		public TerminalNode ClosedParenthesis() { return getToken(WhileParser.ClosedParenthesis, 0); }
		public CallStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Skip:
				_localctx = new SkipStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(Skip);
				}
				break;
			case If:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(If);
				setState(109);
				booleanExpression();
				setState(110);
				match(Then);
				setState(111);
				block();
				setState(114);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(112);
					match(Else);
					setState(113);
					block();
					}
					break;
				}
				}
				break;
			case While:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(While);
				setState(117);
				booleanExpression();
				setState(118);
				match(Do);
				setState(119);
				block();
				}
				break;
			case Call:
				_localctx = new CallStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				match(Call);
				setState(122);
				match(Identifier);
				setState(123);
				match(OpenedParenthesis);
				setState(124);
				arithmeticExpressionList();
				setState(125);
				match(ClosedParenthesis);
				}
				break;
			case Identifier:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				match(Identifier);
				setState(128);
				match(Assign);
				setState(129);
				arithmeticExpression(0);
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

	public static class ArithmeticExpressionListContext extends ParserRuleContext {
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(WhileParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(WhileParser.Comma, i);
		}
		public ArithmeticExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitArithmeticExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionListContext arithmeticExpressionList() throws RecognitionException {
		ArithmeticExpressionListContext _localctx = new ArithmeticExpressionListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arithmeticExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			arithmeticExpression(0);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(133);
				match(Comma);
				setState(134);
				arithmeticExpression(0);
				}
				}
				setState(139);
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

	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
	 
		public ArithmeticExpressionContext() { }
		public void copyFrom(ArithmeticExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenthesizedArithmeticExpressionContext extends ArithmeticExpressionContext {
		public TerminalNode OpenedParenthesis() { return getToken(WhileParser.OpenedParenthesis, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode ClosedParenthesis() { return getToken(WhileParser.ClosedParenthesis, 0); }
		public ParenthesizedArithmeticExpressionContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitParenthesizedArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivArithmeticExpressionContext extends ArithmeticExpressionContext {
		public Token op;
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode Multiplication() { return getToken(WhileParser.Multiplication, 0); }
		public TerminalNode Division() { return getToken(WhileParser.Division, 0); }
		public MulDivArithmeticExpressionContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitMulDivArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantArithmeticExpressionContext extends ArithmeticExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantArithmeticExpressionContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitConstantArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierArithmeticExpressionContext extends ArithmeticExpressionContext {
		public TerminalNode Identifier() { return getToken(WhileParser.Identifier, 0); }
		public IdentifierArithmeticExpressionContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitIdentifierArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubArithmeticExpressionContext extends ArithmeticExpressionContext {
		public Token op;
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode Plus() { return getToken(WhileParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(WhileParser.Minus, 0); }
		public AddSubArithmeticExpressionContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitAddSubArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationArithmeticExpressionContext extends ArithmeticExpressionContext {
		public TerminalNode Minus() { return getToken(WhileParser.Minus, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public NegationArithmeticExpressionContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitNegationArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		return arithmeticExpression(0);
	}

	private ArithmeticExpressionContext arithmeticExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, _parentState);
		ArithmeticExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_arithmeticExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				_localctx = new IdentifierArithmeticExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(141);
				match(Identifier);
				}
				break;
			case IntegerValue:
				{
				_localctx = new ConstantArithmeticExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				constant();
				}
				break;
			case Minus:
				{
				_localctx = new NegationArithmeticExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(Minus);
				setState(144);
				arithmeticExpression(2);
				}
				break;
			case OpenedParenthesis:
				{
				_localctx = new ParenthesizedArithmeticExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(OpenedParenthesis);
				setState(146);
				arithmeticExpression(0);
				setState(147);
				match(ClosedParenthesis);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivArithmeticExpressionContext(new ArithmeticExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(151);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(152);
						((MulDivArithmeticExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Multiplication || _la==Division) ) {
							((MulDivArithmeticExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						arithmeticExpression(5);
						}
						break;
					case 2:
						{
						_localctx = new AddSubArithmeticExpressionContext(new ArithmeticExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(154);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(155);
						((AddSubArithmeticExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Minus || _la==Plus) ) {
							((AddSubArithmeticExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(156);
						arithmeticExpression(4);
						}
						break;
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
	 
		public BooleanExpressionContext() { }
		public void copyFrom(BooleanExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BooleanValueBooleanExpressionContext extends BooleanExpressionContext {
		public TerminalNode BooleanValue() { return getToken(WhileParser.BooleanValue, 0); }
		public BooleanValueBooleanExpressionContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitBooleanValueBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonBooleanExpressionContext extends BooleanExpressionContext {
		public Token op;
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode GreaterThan() { return getToken(WhileParser.GreaterThan, 0); }
		public TerminalNode GreaterOrEqual() { return getToken(WhileParser.GreaterOrEqual, 0); }
		public TerminalNode Equal() { return getToken(WhileParser.Equal, 0); }
		public TerminalNode LesserThan() { return getToken(WhileParser.LesserThan, 0); }
		public TerminalNode LesserOrEqual() { return getToken(WhileParser.LesserOrEqual, 0); }
		public TerminalNode Different() { return getToken(WhileParser.Different, 0); }
		public ComparisonBooleanExpressionContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitComparisonBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationBooleanExpressionContext extends BooleanExpressionContext {
		public TerminalNode Negation() { return getToken(WhileParser.Negation, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public NegationBooleanExpressionContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitNegationBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedBooleanExpressionContext extends BooleanExpressionContext {
		public TerminalNode OpenedParenthesis() { return getToken(WhileParser.OpenedParenthesis, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode ClosedParenthesis() { return getToken(WhileParser.ClosedParenthesis, 0); }
		public ParenthesizedBooleanExpressionContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitParenthesizedBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_booleanExpression);
		int _la;
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new BooleanValueBooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(BooleanValue);
				}
				break;
			case 2:
				_localctx = new ComparisonBooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				arithmeticExpression(0);
				setState(164);
				((ComparisonBooleanExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GreaterThan) | (1L << GreaterOrEqual) | (1L << Equal) | (1L << LesserThan) | (1L << LesserOrEqual) | (1L << Different))) != 0)) ) {
					((ComparisonBooleanExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(165);
				arithmeticExpression(0);
				}
				break;
			case 3:
				_localctx = new NegationBooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				match(Negation);
				setState(168);
				booleanExpression();
				}
				break;
			case 4:
				_localctx = new ParenthesizedBooleanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				match(OpenedParenthesis);
				setState(170);
				booleanExpression();
				setState(171);
				match(ClosedParenthesis);
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode IntegerValue() { return getToken(WhileParser.IntegerValue, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(IntegerValue);
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
		case 11:
			return arithmeticExpression_sempred((ArithmeticExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmeticExpression_sempred(ArithmeticExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00b4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\5\2!\n\2\3\2\7\2$\n\2"+
		"\f\2\16\2\'\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\38\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4E\n\4\f"+
		"\4\16\4H\13\4\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\7\7X\n\7\f\7\16\7[\13\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\td\n\t\3\n"+
		"\3\n\3\n\7\ni\n\n\f\n\16\nl\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13u\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0085\n\13\3\f\3\f\3\f\7\f\u008a\n\f\f\f\16\f\u008d\13"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0098\n\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\7\r\u00a0\n\r\f\r\16\r\u00a3\13\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u00b0\n\16\3\17\3\17\3\17\2\3\30\20\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\2\5\3\2\13\f\3\2\t\n\3\2\r\22\2\u00bb"+
		"\2\36\3\2\2\2\4.\3\2\2\2\6>\3\2\2\2\bI\3\2\2\2\nP\3\2\2\2\fT\3\2\2\2\16"+
		"\\\3\2\2\2\20c\3\2\2\2\22e\3\2\2\2\24\u0084\3\2\2\2\26\u0086\3\2\2\2\30"+
		"\u0097\3\2\2\2\32\u00af\3\2\2\2\34\u00b1\3\2\2\2\36 \7\3\2\2\37!\7\'\2"+
		"\2 \37\3\2\2\2 !\3\2\2\2!%\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#"+
		"\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2()\7\5\2\2)*\5\b\5\2*+\5\22\n\2"+
		"+,\7\6\2\2,-\7\2\2\3-\3\3\2\2\2./\7\4\2\2/\60\7\'\2\2\60\61\7\24\2\2\61"+
		"\67\5\6\4\2\62\63\7\27\2\2\63\64\7\7\2\2\64\65\5\16\b\2\65\66\7\'\2\2"+
		"\668\3\2\2\2\67\62\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\25\2\2:;\7\5\2\2"+
		";<\5\22\n\2<=\7\6\2\2=\5\3\2\2\2>?\5\16\b\2?F\7\'\2\2@A\7\27\2\2AB\5\16"+
		"\b\2BC\7\'\2\2CE\3\2\2\2D@\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\7\3"+
		"\2\2\2HF\3\2\2\2IM\5\n\6\2JL\5\b\5\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3"+
		"\2\2\2N\t\3\2\2\2OM\3\2\2\2PQ\5\16\b\2QR\5\f\7\2RS\7\26\2\2S\13\3\2\2"+
		"\2TY\7\'\2\2UV\7\27\2\2VX\7\'\2\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2"+
		"\2\2Z\r\3\2\2\2[Y\3\2\2\2\\]\7\33\2\2]\17\3\2\2\2^d\5\24\13\2_`\7\24\2"+
		"\2`a\5\22\n\2ab\7\25\2\2bd\3\2\2\2c^\3\2\2\2c_\3\2\2\2d\21\3\2\2\2ej\5"+
		"\24\13\2fg\7\26\2\2gi\5\22\n\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"k\23\3\2\2\2lj\3\2\2\2m\u0085\7&\2\2no\7!\2\2op\5\32\16\2pq\7%\2\2qt\5"+
		"\20\t\2rs\7$\2\2su\5\20\t\2tr\3\2\2\2tu\3\2\2\2u\u0085\3\2\2\2vw\7\"\2"+
		"\2wx\5\32\16\2xy\7#\2\2yz\5\20\t\2z\u0085\3\2\2\2{|\7\b\2\2|}\7\'\2\2"+
		"}~\7\24\2\2~\177\5\26\f\2\177\u0080\7\25\2\2\u0080\u0085\3\2\2\2\u0081"+
		"\u0082\7\'\2\2\u0082\u0083\7\32\2\2\u0083\u0085\5\30\r\2\u0084m\3\2\2"+
		"\2\u0084n\3\2\2\2\u0084v\3\2\2\2\u0084{\3\2\2\2\u0084\u0081\3\2\2\2\u0085"+
		"\25\3\2\2\2\u0086\u008b\5\30\r\2\u0087\u0088\7\27\2\2\u0088\u008a\5\30"+
		"\r\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\27\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\b\r\1"+
		"\2\u008f\u0098\7\'\2\2\u0090\u0098\5\34\17\2\u0091\u0092\7\t\2\2\u0092"+
		"\u0098\5\30\r\4\u0093\u0094\7\24\2\2\u0094\u0095\5\30\r\2\u0095\u0096"+
		"\7\25\2\2\u0096\u0098\3\2\2\2\u0097\u008e\3\2\2\2\u0097\u0090\3\2\2\2"+
		"\u0097\u0091\3\2\2\2\u0097\u0093\3\2\2\2\u0098\u00a1\3\2\2\2\u0099\u009a"+
		"\f\6\2\2\u009a\u009b\t\2\2\2\u009b\u00a0\5\30\r\7\u009c\u009d\f\5\2\2"+
		"\u009d\u009e\t\3\2\2\u009e\u00a0\5\30\r\6\u009f\u0099\3\2\2\2\u009f\u009c"+
		"\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\31\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00b0\7\36\2\2\u00a5\u00a6\5\30"+
		"\r\2\u00a6\u00a7\t\4\2\2\u00a7\u00a8\5\30\r\2\u00a8\u00b0\3\2\2\2\u00a9"+
		"\u00aa\7\23\2\2\u00aa\u00b0\5\32\16\2\u00ab\u00ac\7\24\2\2\u00ac\u00ad"+
		"\5\32\16\2\u00ad\u00ae\7\25\2\2\u00ae\u00b0\3\2\2\2\u00af\u00a4\3\2\2"+
		"\2\u00af\u00a5\3\2\2\2\u00af\u00a9\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0\33"+
		"\3\2\2\2\u00b1\u00b2\7(\2\2\u00b2\35\3\2\2\2\21 %\67FMYcjt\u0084\u008b"+
		"\u0097\u009f\u00a1\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}