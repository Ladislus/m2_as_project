grammar While;

// ########### GRAMMAR ###########

program: Program programName=Identifier? procedureDeclaration* Begin variablesDeclaration* statementList End EOF;
procedureDeclaration: Proc procedureName=Identifier OpenedParenthesis identifierDeclarationList (Comma Res returnType=type returnIdentifier=Identifier)? ClosedParenthesis Begin statementList End;

identifierDeclarationList: identifierDeclaration (Comma identifierDeclaration)*;
identifierDeclaration: type Identifier;

variablesDeclaration: type identifierList Semicolon;
identifierList: Identifier (Comma Identifier)*;
type: Type;

block: statement                                                                                                                                                # SimpleStatement
        | OpenedParenthesis statementList ClosedParenthesis                                                                                                     # ParenthesizedStatement
        ;
statementList: statement (Semicolon statement)*;
statement: Skip                                                                                                                                                 # SkipStatement
        | If booleanExpression Then thenBlock=block (Else elseBlock=block)                                                                                      # IfStatement
        | While booleanExpression Do block                                                                                                                      # WhileStatement
        | Call Identifier OpenedParenthesis arithmeticExpressionList ClosedParenthesis                                                                          # CallStatement
        | Identifier Assign arithmeticExpression                                                                                                                # AssignmentStatement
        ;

arithmeticExpressionList: arithmeticExpression (Comma arithmeticExpression)*;
arithmeticExpression: Identifier                                                                                                                                # IdentifierArithmeticExpression
        | constant                                                                                                                                              # ConstantArithmeticExpression
        | leftSide=arithmeticExpression op=(Multiplication | Division) rightSide=arithmeticExpression                                                           # MulDivArithmeticExpression
        | leftSide=arithmeticExpression op=(Plus | Minus) rightSide=arithmeticExpression                                                                        # AddSubArithmeticExpression
        | Minus arithmeticExpression                                                                                                                            # NegationArithmeticExpression
        | OpenedParenthesis arithmeticExpression ClosedParenthesis                                                                                              # ParenthesizedArithmeticExpression
        ;

booleanExpression: BooleanValue                                                                                                                                 # BooleanValueBooleanExpression
        | leftSide=arithmeticExpression op=(GreaterThan | GreaterOrEqual | Equal | LesserThan | LesserOrEqual | Different) rightSide=arithmeticExpression       # ComparisonBooleanExpression
        | Negation booleanExpression                                                                                                                            # NegationBooleanExpression
        | OpenedParenthesis booleanExpression ClosedParenthesis                                                                                                 # ParenthesizedBooleanExpression
        ;

constant: Minus? IntegerValue;

// ########### CONSTANTS ###########

// Main
Program: 'program';

// Procedures
Proc: 'proc';
Begin: 'begin';
End: 'end';
Res: 'res';
Call: 'call';

// Arithmetic Operations
Minus: '-';
Plus: '+';
Multiplication: '*';
Division: '/';

// Boolean Operations
GreaterThan: '>';
GreaterOrEqual: '>=';
Equal: '=';
LesserThan: '<';
LesserOrEqual: '<=';
Different: '<>';
Negation: 'not';

// Characters
OpenedParenthesis: '(';
ClosedParenthesis: ')';
Semicolon: ';';
Comma: ',';
Colon:':';
Underscore : '_';
Assign: Colon Equal;

// Types
Type: IntegerType | BooleanType;
IntegerType: 'int';
BooleanType: 'boolean';

BooleanValue: True | False;
True: 'true';
False: 'false';

// Control
If : 'if';
While : 'while';
Do : 'do';
Else : 'else';
Then: 'then';
Skip: 'skip';

// Identifiers & Constants
Identifier: Characters (Characters | Underscore | Digit)*;
IntegerValue: Digit+;
Digit:  [0-9];
Characters: [a-z];

WS: [ \t\r\n]+ -> skip;