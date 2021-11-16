package hr.fer.oprpp1.hw04.db.QueryParser;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QueryLexerTest {

	@Test
	public void test1() {
		QueryLexer lexer = new QueryLexer("jmbag=\"0000000003\"");
		
		QueryLexerToken currentToken = lexer.nextToken();
		
		assertEquals(new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, "jmbag"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "="), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.STRING, "0000000003"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(QueryLexerTokenType.EOF, currentToken.getType());
		
		
	}
	
	@Test
	public void test2() {
		QueryLexer lexer = new QueryLexer(" lastName = \"Blažić\"");
		
		QueryLexerToken currentToken = lexer.nextToken();
		
		assertEquals(new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, "lastName"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "="), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.STRING, "Blažić"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(QueryLexerTokenType.EOF, currentToken.getType());
		
		
	}
	
	@Test
	public void test3() {
		QueryLexer lexer = new QueryLexer("firstName>\"A\" and lastName LIKE \"B*ć\"");
		
		QueryLexerToken currentToken = lexer.nextToken();
		
		assertEquals(new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, "firstName"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, ">"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.STRING, "A"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "and"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, "lastName"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "LIKE"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.STRING, "B*ć"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(QueryLexerTokenType.EOF, currentToken.getType());
		
		
	}
	
	@Test
	public void test4() {
		QueryLexer lexer = new QueryLexer(
			"firstName>\"A\" and firstName<\"C\" and lastName LIKE \"B*ć\" and jmbag>\"0000000002\"");
		
		QueryLexerToken currentToken = lexer.nextToken();
		
		assertEquals(new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, "firstName"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, ">"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.STRING, "A"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "and"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, "firstName"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "<"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.STRING, "C"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "and"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, "lastName"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "LIKE"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.STRING, "B*ć"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, "and"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, "jmbag"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.OPERATOR, ">"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(new QueryLexerToken(QueryLexerTokenType.STRING, "0000000002"), currentToken);
		currentToken = lexer.nextToken();
		assertEquals(QueryLexerTokenType.EOF, currentToken.getType());
		
		
	}
}
