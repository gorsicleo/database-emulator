package hr.fer.oprpp1.hw04.db.QueryParser;

import java.util.List;

import hr.fer.oprpp1.hw04.db.ConditionalExpression.ConditionalExpression;

public class QueryParser {
	
	private String input;
	
	public QueryParser(String input) {
		this.input = input;
	}

	public boolean isDirectQuery() {
		return false;
	}
	
	public String getQueriedJMBAG() {
		return null;
	}
	
	public List<ConditionalExpression> getQuery(){
		return null;
	}
}
