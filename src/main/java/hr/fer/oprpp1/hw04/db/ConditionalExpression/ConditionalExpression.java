package hr.fer.oprpp1.hw04.db.ConditionalExpression;

import hr.fer.oprpp1.hw04.db.IComparisonOperator.IComparisonOperator;
import hr.fer.oprpp1.hw04.db.IFieldValueGetter.IFieldValueGetter;

/**
 * Models complete conditional expression that consists of valueGetter strategy,
 * reference to string literal and comparisonOperator strategy.
 * 
 * @author gorsicleo
 */
public class ConditionalExpression {

	/**Strategy for getting values (for example: firstName, lastName ...)*/
	private IFieldValueGetter valueGetter;
	
	/**Used for LIKE operator*/
	private String stringLiteral;
	
	/**Strategy for comparing values (for example: greater, less_or_equals ...)*/
	private IComparisonOperator comparisonOperator;

	/**Creates new ConditionalExpression.
	 * @param valueGetter strategy for getting values from record
	 * @param stringLiteral 
	 * @param comparisonOperator strategy for comparing records
	 */
	public ConditionalExpression(IFieldValueGetter valueGetter, String stringLiteral,
			IComparisonOperator comparisonOperator) {

		this.valueGetter = valueGetter;
		this.stringLiteral = stringLiteral;
		this.comparisonOperator = comparisonOperator;
	}

	/**Returns strategy for getting values from record*/
	public IFieldValueGetter getValueGetter() {
		return valueGetter;
	}

	/**Returns string used as template for LIKE operator*/
	public String getStringLiteral() {
		return stringLiteral;
	}

	/**Strategy for comparing values (for example: greater,less,...)*/
	public IComparisonOperator getComparisonOperator() {
		return comparisonOperator;
	}

}
