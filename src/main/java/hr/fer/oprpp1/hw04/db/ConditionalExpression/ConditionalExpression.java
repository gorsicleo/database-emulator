package hr.fer.oprpp1.hw04.db.ConditionalExpression;

import hr.fer.oprpp1.hw04.db.IComparisonOperator.IComparisonOperator;
import hr.fer.oprpp1.hw04.db.IFieldValueGetter.IFieldValueGetter;

public class ConditionalExpression {

	private IFieldValueGetter valueGetter;
	private String stringLiteral;
	private IComparisonOperator comparisonOperator;
	
	
	public ConditionalExpression(IFieldValueGetter valueGetter, String stringLiteral,
			IComparisonOperator comparisonOperator) {
		
		this.valueGetter = valueGetter;
		this.stringLiteral = stringLiteral;
		this.comparisonOperator = comparisonOperator;
	}


	public IFieldValueGetter getValueGetter() {
		return valueGetter;
	}


	public String getStringLiteral() {
		return stringLiteral;
	}


	public IComparisonOperator getComparisonOperator() {
		return comparisonOperator;
	}
	
}
