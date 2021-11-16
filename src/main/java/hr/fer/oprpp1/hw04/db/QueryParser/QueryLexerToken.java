package hr.fer.oprpp1.hw04.db.QueryParser;


public class QueryLexerToken {

	/**Token type (IDENTIFIER;STRING;OPERATOR;EOF)*/
	private QueryLexerTokenType tokenType;
	
	/**Value that token is holding*/
	private Object tokenValue;
	
	/**Constructor.
	 * @param type type of token
	 * @param value that token is holding
	 */
	public QueryLexerToken(QueryLexerTokenType type, Object value) {
		tokenType = type;
		tokenValue = value;
	}
	
	/**Returns value that token is holding.
	 * @return value that token is holding
	 */
	public Object getValue() {
		return tokenValue;
	}
	
	/**Returns token type.
	 * @return type of this token.
	 */
	public QueryLexerTokenType getType() {
		return tokenType;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof QueryLexerToken)) {
			return false;
		}
		
		QueryLexerToken token =  (QueryLexerToken) other;
		
		return (tokenType.equals(token.getType()) && tokenValue.toString().equals(token.getValue().toString()));
	}
}
