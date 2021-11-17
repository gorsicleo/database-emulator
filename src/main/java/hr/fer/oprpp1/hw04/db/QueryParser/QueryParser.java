package hr.fer.oprpp1.hw04.db.QueryParser;

import java.util.ArrayList;
import java.util.List;

import hr.fer.oprpp1.hw04.db.ComparisonOperators.ComparisonOperators;
import hr.fer.oprpp1.hw04.db.ConditionalExpression.ConditionalExpression;
import hr.fer.oprpp1.hw04.db.FieldValueGetters.FieldValueGetters;
import hr.fer.oprpp1.hw04.db.IComparisonOperator.IComparisonOperator;
import hr.fer.oprpp1.hw04.db.IFieldValueGetter.IFieldValueGetter;

public class QueryParser {

	private static final String INVALID_IDENTIFIER = "Identifier %s is not allowed.";
	private static final String INDIRECT_QUERY_ERROR = "Query must be direct to perform this request.";
	private static final String INVALID_OPERATOR = "Operator %s is not allowed.";
	private QueryLexer lexer;
	private List<QueryLexerToken> tokens = new ArrayList<>();

	public QueryParser(String input) {
		lexer = new QueryLexer(input);
		getAllTokens();
	}

	private void getAllTokens() {
		tokens.add(lexer.nextToken());
		while (lexer.nextToken().getType() != QueryLexerTokenType.EOF) {
			tokens.add(lexer.getToken());
		}

	}

	public boolean isDirectQuery() {
		return (tokens.size() == 3 && tokens.get(0).getValue().equals("jmbag") && tokens.get(1).getValue().equals('=')
				&& tokens.get(2).getType().equals(QueryLexerTokenType.STRING));
	}

	public String getQueriedJMBAG() {
		if (!isDirectQuery()) {
			throw new IllegalStateException(INDIRECT_QUERY_ERROR);
		}
		return tokens.get(2).getValue().toString();
	}

	public List<ConditionalExpression> getQuery() {
		List<ConditionalExpression> list = new ArrayList<>();
		int currentIndex = 0;
		while (currentIndex < tokens.size()) {
			if (tokens.get(currentIndex).getValue().toString().equalsIgnoreCase("and")) {
				currentIndex++;
				continue;
			}
			list.add(createConditionalExpression(currentIndex));
			currentIndex += 3;
		}
		
		return list;
	}

	private ConditionalExpression createConditionalExpression(int index) {
		IFieldValueGetter getter;
		IComparisonOperator operator;
		switch (tokens.get(index).getValue().toString()) {
		case "firstName":
			getter = FieldValueGetters.FIRST_NAME;
			break;

		case "lastName":
			getter = FieldValueGetters.LAST_NAME;
			break;

		case "jmbag":
			getter = FieldValueGetters.JMBAG;
			break;

		default:
			throw new IllegalStateException(String.format(INVALID_IDENTIFIER, tokens.get(index).getValue().toString()));
		}
		
		switch (tokens.get(index+1).getValue().toString().toUpperCase()) {
		case "=":
			operator = ComparisonOperators.EQUALS;
			break;
			
		case "<=":
			operator = ComparisonOperators.LESS_OR_EQUALS;
			break;
			
		case "<":
			operator = ComparisonOperators.LESS;
			break;
		
		case ">":
			operator = ComparisonOperators.GREATER;
			break;
			
		case ">=":
			operator = ComparisonOperators.GREATER_OR_EQUALS;
			break;
			
		case "LIKE":
			operator = ComparisonOperators.LIKE;
			break;
			
		case "!=":
			operator = ComparisonOperators.NOT_EQUALS;

		default:
			throw new IllegalStateException(String.format(INVALID_OPERATOR, tokens.get(index+1).getValue().toString()));
		}
		
		return new ConditionalExpression(getter, tokens.get(index+2).getValue().toString(), operator);
		
		

	}
}
