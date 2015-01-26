package eu.maurosabatino.lftlab1314.es1.lexer;

public class Tag {
	
	public final static int NUM = 0;
	public final static int ID = 1;
	public final static int PLUS = 2;
	public final static int MINUS = 3;
	public final static int LPAR = 6;
	public final static int RPAR = 7;
	public final static int TIMES = 4;
	public final static int DIV = 5;
	public final static int EOF = -1;
	
	public static String getTag(int t){
		String tag;
		
		switch(t){
		
		case 0: tag = "NUM";
				break;
		case 1: tag = "ID";
				break;
		case 2: tag = "PLUS";
				break;
		case 3: tag = "MINUS";
				break;
		case 4: tag = "TIMES";
				break;
		case 5: tag = "DIV";
				break;
		case 6: tag = "LPAR";
				break;
		case 7: tag = "RPAR";
				break;
		default: tag = "EOF";
				break;
				
		}
		
		return tag;
	}
	
}
