grammar While;

// ########### GRAMMAR ###########

program: Program Identifier? declaration* Begin variablesDeclarationList statements End EOF;
declaration: Proc Identifier OpenedParenthesis identifierDeclarationList (Comma Res type Identifier)? ClosedParenthesis Begin statements End;
identifierDeclarationList: type Identifier (Comma type Identifier)*;
variablesDeclarationList: variablesDeclaration variablesDeclarationList*;
variablesDeclaration: type identifierList Semicolon;
identifierList: Identifier (Comma Identifier)*;
type: Type;
block: statement                                                                                                                                # SimpleStatement
        | OpenedParenthesis statements ClosedParenthesis                                                                                        # ParenthesizedStatement
        ;
statements: statement (Semicolon statements)*;
statement: Skip                                                                                                                                 # SkipStatement
        | If booleanExpression Then block (Else block)?                                                                                         # IfStatement
        | While booleanExpression Do block                                                                                                      # WhileStatement
        | Call Identifier OpenedParenthesis arithmeticExpressionList ClosedParenthesis                                                          # CallStatement
        | Identifier Assign arithmeticExpression                                                                                                # AssignmentStatement
        ;
arithmeticExpressionList: arithmeticExpression (Comma arithmeticExpression)*;
arithmeticExpression: Identifier                                                                                                                # IdentifierArithmeticExpression
        | constant                                                                                                                              # ConstantArithmeticExpression
        | arithmeticExpression op=(Multiplication | Division) arithmeticExpression                                                              # MulDivArithmeticExpression
        | arithmeticExpression op=(Plus | Minus) arithmeticExpression                                                                           # AddSubArithmeticExpression
        | Minus arithmeticExpression                                                                                                            # NegationArithmeticExpression
        | OpenedParenthesis arithmeticExpression ClosedParenthesis                                                                              # ParenthesizedArithmeticExpression
        ;
booleanExpression: BooleanValue                                                                                                                 # BooleanValueBooleanExpression
        | arithmeticExpression op=(GreaterThan | GreaterOrEqual | Equal | LesserThan | LesserOrEqual | Different) arithmeticExpression          # ComparitionBooleanExpression
        | Negation booleanExpression                                                                                                            # NegationBooleanExpression
        | OpenedParenthesis booleanExpression ClosedParenthesis                                                                                 # ParenthesizedBooleanExpression
        ;
constant: IntegerValue;

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