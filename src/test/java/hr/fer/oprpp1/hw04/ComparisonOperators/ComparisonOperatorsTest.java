package hr.fer.oprpp1.hw04.ComparisonOperators;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hr.fer.oprpp1.hw04.db.ComparisonOperators.ComparisonOperators;
import hr.fer.oprpp1.hw04.db.IComparisonOperator.IComparisonOperator;

public class ComparisonOperatorsTest {
	
	@Test
	public void testLessOperator() {
		IComparisonOperator oper = ComparisonOperators.LESS;
		assertEquals(false, oper.satisfied("Ana", "Ana"));
		assertEquals(true, oper.satisfied("Ana", "Jasna"));
		assertEquals(true, oper.satisfied("Ana", "Ankica"));
		assertEquals(false, oper.satisfied("Petar", "Jasna"));
	}
	
	@Test
	public void testLessOrEqualsOperator() {
		IComparisonOperator oper = ComparisonOperators.LESS_OR_EQUALS;
		assertEquals(true, oper.satisfied("Ana", "Ana"));
		assertEquals(true, oper.satisfied("Ana", "ana"));
		assertEquals(true, oper.satisfied("Ana", "Ankica"));
		assertEquals(false, oper.satisfied("Petar", "Jasna"));
	}
	
	@Test
	public void testGreaterOperator() {
		IComparisonOperator oper = ComparisonOperators.GREATER;
		assertEquals(false, oper.satisfied("Ana", "Ana"));
		assertEquals(false, oper.satisfied("Ana", "ana"));
		assertEquals(false, oper.satisfied("Ana", "Ankica"));
		assertEquals(true, oper.satisfied("Petar", "Jasna"));
	}
	
	@Test
	public void testGreaterOrEqualsOperator() {
		IComparisonOperator oper = ComparisonOperators.GREATER_OR_EQUALS;
		assertEquals(true, oper.satisfied("Ana", "Ana"));
		assertEquals(true, oper.satisfied("Ana", "ana"));
		assertEquals(false, oper.satisfied("Ana", "Ankica"));
		assertEquals(true, oper.satisfied("Petar", "Jasna"));
		assertEquals(true, oper.satisfied("Haramlija", "Haramlija"));
	}
	
	@Test
	public void testEqualsOperator() {
		IComparisonOperator oper = ComparisonOperators.EQUALS;
		assertEquals(true, oper.satisfied("Ana", "Ana"));
		assertEquals(true, oper.satisfied("Ana", "ana"));
		assertEquals(false, oper.satisfied("Ana", "Ankica"));
		assertEquals(false, oper.satisfied("Petar", "Jasna"));
		assertEquals(true, oper.satisfied("Haramlija", "Haramlija"));
	}
	
	@Test
	public void testNotEqualsOperator() {
		IComparisonOperator oper = ComparisonOperators.NOT_EQUALS;
		assertEquals(false, oper.satisfied("Ana", "Ana"));
		assertEquals(false, oper.satisfied("Ana", "ana"));
		assertEquals(true, oper.satisfied("Ana", "Ankica"));
		assertEquals(true, oper.satisfied("Petar", "Jasna"));
		assertEquals(false, oper.satisfied("Haramlija", "Haramlija"));
	}
	
	@Test
	public void testLikeOperator() {
		IComparisonOperator oper = ComparisonOperators.LIKE;
		assertEquals(false, oper.satisfied("Zagreb", "Aba*"));
		assertEquals(false, oper.satisfied("AAA", "AA*AA"));
		assertEquals(true, oper.satisfied("AAAA", "AA*AA"));
		assertEquals(true,oper.satisfied("ABBBBBA", "A*A"));
		assertEquals(true,oper.satisfied("ABABABA", "ABA*ABA"));
		assertEquals(true,oper.satisfied("AB*AB", "AB*AB"));
		assertEquals(false,oper.satisfied("A", "A*A"));
		assertEquals(false,oper.satisfied("ABBA", "AB*AB"));
	}
	
	
	
	
	
	
	
	
}
