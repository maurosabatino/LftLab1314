/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.maurosabatino.lftlab1314.es1.lexer;

/**
 *
 * @author Mauro
 */
public class RunLexer {

    public static void main(String[] args) {
        Lexer lex = new Lexer();
        Token tok;
        do {
            tok = lex.scan();
            System.out.println("Scan: " + tok);
        } while (tok.tag != Tag.EOF);
    }
}
