package hr.fer.oprpp1.hw04.db.QueryFilter;

import java.util.List;

import hr.fer.oprpp1.hw04.db.ConditionalExpression.ConditionalExpression;
import hr.fer.oprpp1.hw04.db.FieldValueGetters.FieldValueGetters;
import hr.fer.oprpp1.hw04.db.IFilter.IFilter;
import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

public class QueryFilter implements IFilter {
	private List<ConditionalExpression> conditions;

	public QueryFilter(List<ConditionalExpression> conditionalExpressions) {
		conditions = conditionalExpressions;
	}

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
