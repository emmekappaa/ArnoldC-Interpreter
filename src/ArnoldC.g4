grammar ArnoldC;

prog : (method)* main (method)* EOF ;

main : BEGIN_MAIN (com)* END_MAIN;

com : IF exp (com)* (ELSE (com2)*)? END_IF  # if
    | A_INIT ID DECLARE exp                 # declare
    | TAKE ID SET exp END_SET               # init
    | WHILE exp (com)* END_WHILE            # while
    | SOUT (ID | STRING)                    # sout
    | CALL ID (exp)*                        # callMethod
    | ASSIGN_CALL ID CALL ID (exp)*         # assignVarFromMethod
    ;

com2 : com;

exp : INT                                 # int
    | BOOL                                # bool
    | exp op=(DIV | MUL | MOD) exp        # divMulMod
    | exp op=(PLUS | MINUS) exp           # plusMinus
    | exp GT exp                          # cmpExp
    | exp EQQ exp                         # eqExp
    | exp op=(AND | OR) exp               # logicExp
    | ID                                  # id
    | ZERO                                # zero
    | ONE                                 # one
    ;

method : DEFINE_METHOD ID (GET_ARG ID)* (NON_VOID)? (com)* (RETURN (id2))? END_METHOD;

id2 : ID;

INT : NAT | '-' POS ;
fragment NAT : '0' | POS ;
fragment POS : [1-9][0-9]* ;

BOOL : 'NO PROBLEMO' | 'I LIED' ;

STRING : '"' STRCHR* '"' ;
fragment STRCHR : ~["\\] | ESC ;
fragment ESC : '\\' [btnfr"'\\] ;

BEGIN_MAIN : 'IT\'S SHOWTIME';
END_MAIN : 'YOU HAVE BEEN TERMINATED';

SOUT : 'TALK TO THE HAND';

A_INIT : 'HEY CHRISTMAS TREE';
DECLARE: 'YOU SET US UP' ;

TAKE: 'GET TO THE CHOPPER';
SET : 'HERE IS MY INVITATION';
END_SET : 'ENOUGH TALK';

PLUS  : 'GET UP' ;
MINUS : 'GET DOWN';
MUL   : 'YOU\'RE FIRED';
DIV   : 'HE HAD TO SPLIT';
MOD   : 'I LET HIM GO';


AND : 'KNOCK KNOCK' ;
OR  : 'CONSIDER THAT A DIVORCE' ;
EQQ : 'YOU ARE NOT YOU YOU ARE ME' ;
GT  : 'LET OFF SOME STEAM BENNET' ;

IF     : 'BECAUSE I\'M GOING TO SAY PLEASE' ;
ELSE   : 'BULLSHIT' ;
END_IF : 'YOU HAVE NO RESPECT FOR LOGIC';

WHILE      : 'STICK AROUND' ;
END_WHILE  : 'CHILL' ;

ZERO    : '@I LIED';
ONE     : '@NO PROBLEMO';

DEFINE_METHOD : 'LISTEN TO ME VERY CAREFULLY';
GET_ARG       : 'I NEED YOUR CLOTHES YOUR BOOTS AND YOUR MOTORCYCLE';
NON_VOID      : 'GIVE THESE PEOPLE AIR';
RETURN        : 'I\'LL BE BACK';
END_METHOD    : 'HASTA LA VISTA, BABY';

CALL : 'DO IT NOW';
ASSIGN_CALL : 'GET YOUR ASS TO MARS';

ID : [a-zA-Z0-9]+ ;

WS : [ \t\r\n]+ -> skip ;