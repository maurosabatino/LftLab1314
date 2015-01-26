package eu.maurosabatino.lftlab1314.es1.parser;

import eu.maurosabatino.lftlab1314.es1.lexer.*;

public class Parser {
	private Lexer lex;
	private Token look;

	public Parser(Lexer l) {
		lex = l;
		move();
	}
	
	void move() {
		look = lex.scan();
		System.err.println("token = " + look);
	}

	void error(String s) {
		throw new Error("near line " + lex.line + ": " + s);
	}
	
	void match(int t) {
		if (look.tag == t) {
			if (look.tag != Tag.EOF) move();
		} else error("syntax error");
	}
	
	public int start() {
		int expr_val;
                System.out.println("inizia il parser");
		expr_val = expr();
                System.out.println("fie del parser");
		match(Tag.EOF);
		return expr_val;
	}

	private int expr() {
		int term_val, exprp_val;
		term_val = term();
		exprp_val = exprp(term_val);
		return exprp_val;
	}

	private int exprp(int exprp_i) {
		int term_val, exprp_val;
		
		switch (look.tag) {
		case Tag.PLUS:
			match(Tag.PLUS);
			term_val = term();
			exprp_val = exprp(exprp_i + term_val);
			break;
		case Tag.MINUS:
			match(Tag.MINUS);
			term_val = term();
			exprp_val = exprp(exprp_i - term_val);
			break;
		default: 
			exprp_val = exprp_i;
		}
		
		return exprp_val;
	}

	private int term() {
		int fact_val, term_val;
		
		fact_val = fact();
		term_val = termp(fact_val);
		return term_val;
	}

	private int termp(int termp_i) {
		int fact_val, termp_val;
		
		switch (look.tag) {
		case Tag.TIMES:
			match(Tag.TIMES);
			fact_val = fact();
			termp_val = termp(termp_i*fact_val);
			break;
		case Tag.DIV:
			match(Tag.DIV);
			fact_val = fact();
			if(fact_val == 0) error("divided by zero");
			termp_val = termp(termp_i/fact_val);
			break;
		default: 
			termp_val = termp_i;
		}
		return termp_val;
	}

		private int fact() {
			int fact_val;
			
			switch (look.tag) {
			case Tag.LPAR:
				match(Tag.LPAR);
				fact_val = expr();
				match(Tag.RPAR);
				break;
			case Tag.NUM:
				fact_val = Integer.parseInt(look.text);
				match(Tag.NUM);
				break;
			default:
				error("syntax error");
				return 0;
			}
			return fact_val;
		}
}
