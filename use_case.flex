
%%

%package use_case_diagram 
%class Lexer
%public
%line
%column
%cup

%%

[ \t\f]					{ }
\r\n|\r|\n				{ }
"//".*					{ }
"/*" ~ "*/"				{ }

"{"						{ return getSymbolFactory().newSymbol ("O_BRACE", Sym.O_BRACE, yyline, yycolumn); }
"}"						{ return getSymbolFactory().newSymbol ("C_BRACE", Sym.C_BRACE, yyline, yycolumn); }

model					{ return getSymbolFactory().newSymbol("T_MODEL",Sym.T_MODEL, yyline, yycolumn);}
actor					{ return getSymbolFactory().newSymbol("T_ACTOR",Sym.T_ACTOR, yyline, yycolumn);}
useCase					{ return getSymbolFactory().newSymbol("T_USECASE",Sym.T_USECASE, yyline, yycolumn); }
association				{ return getSymbolFactory().newSymbol("T_ASSOCIATION",Sym.T_ASSOCIATION, yyline, yycolumn); }
include 				{ return getSymbolFactory().newSymbol("T_INCLUDE",Sym.T_INCLUDE, yyline, yycolumn); }
extend					{ return getSymbolFactory().newSymbol("T_EXTEND",Sym.T_EXTEND, yyline, yycolumn); }

[a-zA-Z][a-zA-Z0-9]*	{ return getSymbolFactory().newSymbol ("NAME", Sym.NAME, yyline, yycolumn, yytext()); }