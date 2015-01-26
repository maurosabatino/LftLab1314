package eu.maurosabatino.lftlab1314.es1.lexer;

public class Token {
	
	public int tag;
	public String text;
	
	public Token (int tag, String text){
		this.tag = tag;
		this.text = text;
	}
	
	public String toString(){
		return "<"+Tag.getTag(tag)+", \""+text+"\">";
	}
}
