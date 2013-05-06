package main;

public enum Keyword {
	ABSTRACT("abstract"),
	CONTINUE("continue"),
	FOR("for"),
	NEW("new"),
	SWITCH("switch"),
	ASSERT("assert"),
	DEFAULT("default"),
	IF("if"),
	PACKAGE("package"),
	SYNCHRONIZED("synchronized"),
    BOOLEAN("boolean"),
    DO("do"),          
    GOTO("goto"),
    PRIVATE("private"),
    THIS("this"),
    BREAK("break"),
    DOUBLE("double"),
    IMPLEMENTS("implements"),  
    PROTECTED("protected"),    
    THROW("throw"),
    BYTE("byte"),
    ELSE("else"),        
    IMPORT("import"),        	
    PUBLIC("public"),       
    THROWS("throws"),
    CASE("case"), 
    ENUM("enum"),        
    INSTANCEOF("instanceof"),    
    RETURN("return"),       
    TRANSIENT("transient"),
    CATCH("catch"), 
    EXTENDS("extends"),     
    INT("int"),           
    SHORT("short"),        
    TRY("try"),
    CHAR("char"), 
    FINAL("final"),       
    INTEFACE("interface"),     
    STATIC("static"), 
    VOID("void"),
    CLASS("class"),
    FINALLY("finally"),    
    LONG("long"),          
    STRICTFP("strictfp"),
	VOLATILE("volatile"),
    CONST("const"), 
    FLOAT("float"),   
    NATIVE("native"),   
    SUPER("super"),
    WHILE("while");

	private String name;
	
	private Keyword(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return name;
	}
}
