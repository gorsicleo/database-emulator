package hr.fer.oprpp1.hw04.db.QueryFilter;

import java.util.List;

import hr.fer.oprpp1.hw04.db.ConditionalExpression.ConditionalExpression;
import hr.fer.oprpp1.hw04.db.FieldValueGetters.FieldValueGetters;
import hr.fer.oprpp1.hw04.db.IFilter.IFilter;
import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

/**Filters student record from criteria of list of conditionalExpressions.
 * @author gorsicleo
 *
 */
public class QueryFilter implements IFilter {
	/**List of conditions used for filtering*/
	private List<ConditionalExpression> conditions;

	/**Creates new QueryFilter.
	 * @param conditionalExpressions used for filtering
	 */
	public QueryFilter(List<ConditionalExpression> conditionalExpressions) {
		conditions = conditionalExpressions;
	}

	/**Accepts student record if student record satisfies all conditionalExpressions that this QueryFilter class has.
	 * @param record that needs to be analysed
	 * @return true if student record satisfies all conditionalExpressions, false otherwise
	 */
	@Override
	public boolean accepts(StudentRecord record) {

		for (ConditionalExpression condition : conditions) {

			if (!condition.getComparisonOperator().satisfied(condition.getValueGetter().get(record),
					condition.getStringLiteral())) {
				return false;

			}
		}
		return true;
	}

}
