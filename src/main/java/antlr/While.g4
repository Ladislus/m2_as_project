grammar While;

// ########### GRAMMAR ###########

program: Program identifier declaration* Begin variablesDeclarationList statements End EOF;
declaration: Proc identifier OpenedParenthesis identifierDeclarationList (Comma Res type identifier)? ClosedParenthesis Begin statements End;
identifierDeclarationList: type identifier (Comma type identifier)*;
variablesDeclarationList: variablesDeclaration variablesDeclarationList*;
variablesDeclaration: type identifierList Semicolon;
identifierList: identifier (Comma identifier)*;
type: Type;
block: statement                                                                                                                                # SimpleStatement
        | OpenedParenthesis statements ClosedParenthesis                                                                                        # ParenthesizedStatement
        ;
statements: statement (Semicolon statements)*;
statement: Skip                                                                                                                                 # SkipStatement
        | identifier Assign arithmeticExpression                                                                                                # AssignmentStatement
        | If booleanExpression Then block (Else block)?                                                                                         # IfStatement
        | While booleanExpression Do block                                                                                                      # WhileStatement
        | Call identifier OpenedParenthesis arithmeticExpressionList ClosedParenthesis                                                          # CallStatement
        ;
arithmeticExpressionList: arithmeticExpression (Comma arithmeticExpression)*;
arithmeticExpression: identifier                                                                                                                # IdentifierArithmeticExpression
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
identifier: Characters (Characters | Underscore)*;
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

IntegerValue: Digit+;
Digit:  [0-9];
Characters: [a-z];


// Control
If : 'if';
While : 'while';
Do : 'do';
Else : 'else';
Then: 'then';
Skip: 'skip';

WS: [ \t\r\n]+ -> skip;