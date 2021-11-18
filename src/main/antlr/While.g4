grammar While;

// ########### GRAMMAR ###########

program: Program identifier declaration* Begin variablesDeclarationList statements End EOF;
declaration: Proc identifier OpenedParenthesis identifierDeclarationList (Comma Res type identifier)? ClosedParenthesis Begin statements End;
identifierDeclarationList: type identifier (Comma type identifier)*;
variablesDeclarationList: variablesDeclaration variablesDeclarationList*;
variablesDeclaration: type identifierList Semicolon;
identifierList: identifier (Comma identifier)*;
type: Type;
block: statement
        | OpenedParenthesis statements ClosedParenthesis
        ;
statements: statement (Semicolon statements)*;
statement: Skip
        | identifier Assign arithmeticExpression
        | If booleanExpression Then block (Else block)?
        | While booleanExpression Do block
        | Call identifier OpenedParenthesis arithmeticExpressionList ClosedParenthesis
        ;
arithmeticExpressionList: arithmeticExpression (Comma arithmeticExpression)*;
arithmeticExpression: identifier
        | constant
        | arithmeticExpression op=(Multiplication | Division) arithmeticExpression
        | arithmeticExpression op=(Plus | Minus) arithmeticExpression
        | Minus arithmeticExpression
        | OpenedParenthesis arithmeticExpression ClosedParenthesis
        ;
booleanExpression: BooleanValue
        | arithmeticExpression op=(GreaterThan | GreaterOrEqual | Equal | LesserThan | LesserOrEqual | Different) arithmeticExpression
        | Negation booleanExpression
        | OpenedParenthesis booleanExpression ClosedParenthesis
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