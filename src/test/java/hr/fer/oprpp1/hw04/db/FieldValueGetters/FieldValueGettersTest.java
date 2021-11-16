package hr.fer.oprpp1.hw04.db.FieldValueGetters;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

public class FieldValueGettersTest {
	StudentRecord record = new StudentRecord("001", "Prezimenović", "Imenko", 4);
	
	@Test
	public void getFirstNameTest() {
		assertEquals("Imenko", FieldValueGetters.FIRST_NAME.get(record));
	}
	
	@Test
	public void getLastNameTest() {
		assertEquals("Prezimenović", FieldValueGetters.LAST_NAME.get(record));
	}
	
	@Test
	public void getJMBAGTest() {
		assertEquals("001", FieldValueGetters.JMBAG.get(record));
	}
	

}
