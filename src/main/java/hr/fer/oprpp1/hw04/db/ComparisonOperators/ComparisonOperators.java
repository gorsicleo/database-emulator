package hr.fer.oprpp1.hw04.db.ComparisonOperators;


import hr.fer.oprpp1.hw04.db.IComparisonOperator.IComparisonOperator;

/** Class offers public static final variables (i.e. constants) of
 *  type IComparisonOperator
 * @author gorsicleo
 *
 */
public class ComparisonOperators {

	public static final IComparisonOperator LESS;
	public static final IComparisonOperator LESS_OR_EQUALS;
	public static final IComparisonOperator GREATER;
	public static final IComparisonOperator GREATER_OR_EQUALS;
	public static final IComparisonOperator EQUALS;
	public static final IComparisonOperator NOT_EQUALS;
	public static final IComparisonOperator LIKE;

	static {
		LESS = (first, second) ->  first.compareToIgnoreCase(second) < 0;
		
		LESS_OR_EQUALS = (first, second) -> first.compareToIgnoreCase(second) <= 0;
		
		GREATER = (first, second) -> first.compareToIgnoreCase(second) > 0;
		
		GREATER_OR_EQUALS = (first, second) -> first.compareToIgnoreCase(second) >= 0;
		
		EQUALS = (first,second) -> first.compareToIgnoreCase(second) == 0;
		
		NOT_EQUALS = (first, second) -> first.compareToIgnoreCase(second) != 0;
		
		LIKE = (statement, pattern) -> {
			int starIndex = pattern.indexOf('*');
			String endRequirement = pattern.substring(starIndex+1);
			String startRequirement = pattern.substring(0, starIndex);
			
			if (endRequirement.isEmpty()) {
				return statement.startsWith(startRequirement);
			}
			
			if (startRequirement.isEmpty()) {
				return statement.endsWith(endRequirement);
			}
			
			return (statement.endsWith(endRequirement) && statement.startsWith(startRequirement)
					&& startRequirement.length()+endRequirement.length()<=statement.length());
		};
	}
}
