package hr.fer.oprpp1.hw04.db.QueryParser;

/**Available types of tokens for query input
 * @author gorsicleo
 *
 */
public enum QueryLexerTokenType {

	/**identifier token*/
	IDENTIFIER,
	
	/**operator token*/
	OPERATOR,
	
	/**string token*/
	STRING,
	
	/**end-of-file token*/
	EOF,
	
}
