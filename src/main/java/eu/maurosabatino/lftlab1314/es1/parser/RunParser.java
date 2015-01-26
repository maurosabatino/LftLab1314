/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.maurosabatino.lftlab1314.es1.parser;

import eu.maurosabatino.lftlab1314.es1.lexer.*;

/**
 *
 * @author Mauro
 */
public class RunParser {
    public static void main(String[] args) {
		Lexer lex = new Lexer();
		Parser parser = new Parser(lex);
		try{
			System.out.println(parser.start());
		}catch(Error e){ System.out.println(e.getMessage());}
	}
}
