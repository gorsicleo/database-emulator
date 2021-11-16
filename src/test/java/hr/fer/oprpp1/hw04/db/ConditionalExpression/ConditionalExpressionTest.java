package hr.fer.oprpp1.hw04.db.ConditionalExpression;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hr.fer.oprpp1.hw04.db.ComparisonOperators.ComparisonOperators;
import hr.fer.oprpp1.hw04.db.FieldValueGetters.FieldValueGetters;
import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

public class ConditionalExpressionTest {

	@Test
	public void testConditionalExpression() {
		ConditionalExpression expr = new ConditionalExpression(FieldValueGetters.LAST_NAME, "Bos*",
				ComparisonOperators.LIKE);
		StudentRecord record = new StudentRecord("001", "Prezimenović", "Imenko", 4);
		
		boolean recordSatisfies = expr.getComparisonOperator().satisfied(
				expr.getValueGetter().get(record),
				expr.getStringLiteral());
		
		assertEquals(false, recordSatisfies);
		
		expr = new ConditionalExpression(FieldValueGetters.LAST_NAME, "Prez*vić",
				ComparisonOperators.LIKE);
		
		recordSatisfies = expr.getComparisonOperator().satisfied(
				expr.getValueGetter().get(record),
				expr.getStringLiteral());
		
		assertEquals(true, recordSatisfies);
	}
}
