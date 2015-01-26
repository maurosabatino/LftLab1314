package eu.maurosabatino.lftlab1314.es1.lexer;

import java.io.*;

public class Lexer {

    public static int line = 1;
    private char peek = ' ';

    private void readch() {
        try {
            peek = (char) System.in.read();
        } catch (IOException exc) {
            peek = (char) -1; // ERROR = EOF
        }
    }

    public Token scan() {
        while (peek == ' ' || peek == '\t' || peek == '\n') {
            if (peek == '\n') {
                line++;
            }
            readch();
        }

        switch (peek) {
            case '(':
                peek = ' '; //la testina ora è vuota
                return new Token(Tag.LPAR, "(");
            case ')':
                peek = ' ';
                return new Token(Tag.RPAR, ")");
            case '+':
                peek = ' ';
                return new Token(Tag.PLUS, "+");
            case '-':
                peek = ' ';
                return new Token(Tag.MINUS, "-");
            case '*':
                peek = ' ';
                return new Token(Tag.TIMES, "*");
            case '/':
                peek = ' ';
            case '\004':
                peek = ' ';
                return new Token(Tag.EOF, " ");

            default:
                if (Character.isDigit(peek)) {
                    String s = "";
                    do {
                        s += peek;
                        readch();
                    } while (Character.isDigit(peek));
                    return new Token(Tag.NUM, s);
                } else if (Character.isLetter(peek)) {
                    String s = "";
                    do {
                        s += peek;
                        readch();
                    } while (Character.isLetter(peek));
                    return new Token(Tag.ID, s);
                } else {
                    System.out.println("Carattere non riconosciuto:");
                    return new Token(Tag.EOF, peek + "");
                }
        }
    }

}
