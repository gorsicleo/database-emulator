package hr.fer.oprpp1.hw04.db.QueryParser;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QueryParserTest {

	@Test
	public void queryParserTest1() {
		QueryParser qp1 = new QueryParser(" jmbag =\"0123456789\" ");
		assertEquals(true, qp1.isDirectQuery());
		assertEquals("0123456789", qp1.getQueriedJMBAG());
		assertEquals(1, qp1.getQuery().size());
		//System.out.println("isDirectQuery(): " + qp1.isDirectQuery()); // true
		//System.out.println("jmbag was: " + qp1.getQueriedJMBAG()); // 0123456789
		//System.out.println("size: " + qp1.getQuery().size()); // 1
	}
	
	@Test
	public void queryParserTest2() {
		QueryParser qp2 = new QueryParser("jmbag=\"0123456789\" and lastName>=\"J\"");
		assertEquals(false, qp2.isDirectQuery());
		assertThrows(IllegalStateException.class, () -> qp2.getQueriedJMBAG()); 
		assertEquals(2, qp2.getQuery().size());
		//System.out.println("isDirectQuery(): " + qp2.isDirectQuery()); // false
		// System.out.println(qp2.getQueriedJMBAG()); // would throw!
		//System.out.println("size: " + qp2.getQuery().size()); // 2
	}
}
