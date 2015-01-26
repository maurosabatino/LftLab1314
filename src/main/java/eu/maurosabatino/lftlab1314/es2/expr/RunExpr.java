/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.eu.maurosabatino.lftlab1314.es2.expr;

import main.java.eu.maurosabatino.lftlab1314.es2.expr.antlr4.imports.ExprLexer;
import main.java.eu.maurosabatino.lftlab1314.es2.expr.antlr4.imports.ExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author Mauro
 */
public class RunExpr {

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        parser.start();
    }
}
