grammar Expr;
start
: expr EOF
;
expr returns [int val]
: term e=exprP[$term.val] {$val = $e.val;}
;
exprP[int i] returns [int val]
:   {$val = $i;}
| '+' term e=exprP[$i + $term.val] {$val = $e.val;}
| '-' term e=exprP[$i - $term.val] {$val = $e.val;}
;
term returns [int val]
: fact t=termP[$fact.val] {$val = $t.val;}
;
termP [int i] returns [int val]
:   {$val = $i;}
| '*' fact t=termP[$i * $fact.val] {$val = $t.val;}
| '/' fact t=termP[$i / $fact.val] {$val = $t.val;}
;
fact returns [int val]
: '(' expr ')' {$val = $expr.val;}
| NUM {$val = Integer.parseInt($NUM.text);}
;
ID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
NUM : '0'..'9'+ ;
WS : (' ' | '\t' | '\r' | '\n')+ { skip(); } ;