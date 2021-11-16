package hr.fer.oprpp1.hw04.db.QueryParser;


public class QueryLexer {
	
	/**Data where is text stored for analysis*/
	private char[] data;
	
	/**Current index count that is pointing to char[] data of last analysed character*/
	private int currentIndex;
	
	/**Last created token*/
	private QueryLexerToken currentToken;
	
	private static final String ILLEGAL_CALL_EOF = "Illegal call. Cannot generate next token when EOF is reached.";
	private static final String MISPLACED_TOKEN_ERROR = "Misplaced token.";
	
	
	/**
	 * Constructor. Creates new QueryLexer object that will generate tokens
	 * for given String <code>text</code>.
	 * 
	 * @param text that will be used to generate tokens.
	 * 
	 */
	public QueryLexer(String text) {
		currentIndex = 0;
		currentToken = null;
		
		data = text.toCharArray();
	}
	
	
	/**
	 * Generates next token.
	 * 
	 * @return {@link QueryLexerToken} next generated token.
	 */
	public QueryLexerToken nextToken() {
		generateNextToken();
		return currentToken;
	}
	
	/**
	 * Returns last generated token.
	 * 
	 * @return {@link QueryLexerToken} last generated token.
	 */
	public QueryLexerToken getToken() {
		return currentToken;
	}
	
	private void generateNextToken() {
		checkForEOF();
		removeBlanks();
		
		if (isEndReached() || isOperator() || isIdentifier()  || isString()) {
			return;
		}
		
		throw new IllegalStateException(MISPLACED_TOKEN_ERROR);
	}
	
	/**
	 * Method increases index counter when it encounters ' ' or '\n' or '\t' or '\t'
	 */
	private void removeBlanks() {
		while (currentIndex < data.length) {
			char currentCharacter = data[currentIndex];
			if (currentCharacter == ' ' || currentCharacter == '\n' || currentCharacter == '\t'
					|| currentCharacter == '\r') {
				currentIndex++;
			} else {
				break;
			}
		}

	}
	
	private boolean isString() {
		if (data[currentIndex]=='"') {
			currentIndex++;
			int startOfStringIndex = currentIndex;
			
			
			while (data[currentIndex] != '"') {
				currentIndex++;
			}
			if (currentIndex - startOfStringIndex != 0) {
				String identifierName = new String(data, startOfStringIndex, currentIndex - startOfStringIndex);
				currentToken = new QueryLexerToken(QueryLexerTokenType.STRING, identifierName);
				currentIndex++;
				return true;
			}
		}
		return false;
	}


	private boolean isIdentifier() {
		if (Character.isLetter(data[currentIndex])) {
			int startOfIdentifierIndex = currentIndex;
			currentIndex++;
			while (Character.isLetter(data[currentIndex])) {
				currentIndex++;
			}
			if (currentIndex - startOfIdentifierIndex != 0) {
				String identifierName = new String(data, startOfIdentifierIndex, currentIndex - startOfIdentifierIndex);
				currentToken = new QueryLexerToken(QueryLexerTokenType.IDENTIFIER, identifierName);
				return true;
			}
		}
		return false;
	}


	/**
	 * Method checks if following characters can be grouped as operator.
	 * 
	 * @return true if following characters are +, -, *, /, ^
	 */
	private boolean isOperator() {
		if (currentIndex < data.length-4) {
			String operator = new String(data,currentIndex,4);
			if (operator.equalsIgnoreCase("LIKE")) {
				currentToken = new QueryLexerToken(QueryLexerTokenType.OPERATOR, operator);
				currentIndex += 4;
				return true;
			}
			operator = new String(data,currentIndex,3);
			if (operator.equalsIgnoreCase("AND")) {
				currentToken = new QueryLexerToken(QueryLexerTokenType.OPERATOR, operator);
				currentIndex += 3;
				return true;
			}
			operator = new String(data,currentIndex,2);
			if (operator.equalsIgnoreCase("<=") || operator.equalsIgnoreCase(">=")) {
				currentToken = new QueryLexerToken(QueryLexerTokenType.OPERATOR, operator);
				currentIndex += 2;
				return true;
			}
			
			
		}
		if (data[currentIndex] == '=' || data[currentIndex] == '<' || data[currentIndex] == '>') {
			currentToken = new QueryLexerToken(QueryLexerTokenType.OPERATOR, data[currentIndex]);
			currentIndex++;
			return true;
		}
		
		return false;
	}
	
	/**
	 * In case when index count reaches length of string that needs to be tokenized
	 * EOF token is going to be generated.
	 * 
	 * @return true if EOF token is generated
	 */
	private boolean isEndReached() {
		if (currentIndex >= data.length) {
			currentToken = new QueryLexerToken(QueryLexerTokenType.EOF, null);
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * When EOF token is generated further calls are not legal! Method raises
	 * exception when user tries to get next token after EOF token is generated.
	 * 
	 * @throws SmartScriptLexerException if user tries to get next token after EOF is
	 *                        generated.
	 * 
	 */
	private void checkForEOF() {
		if (currentToken != null) {
			if (currentToken.getType() == QueryLexerTokenType.EOF) {
				throw new IllegalStateException(ILLEGAL_CALL_EOF);
			}
		}
	}
	
}
