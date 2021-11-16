package hr.fer.oprpp1.hw04.db.StudentDatabase;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;


public class StudentDatabaseTest {

	public List<String> readFile() {
		try {
			return Files.readAllLines(Paths.get("./src/main/resources/database.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.err.println("readFile method error: unable to read file");
		}
		return null;
	}
	
	@Test
	public void testInvalidGrade() {
		assertThrows(IllegalArgumentException.class, ()-> new StudentDatabase(
				List.of("0000000007	Čima	Sanjin	4", "0000000008	Ćurić	Marko	6")));
	}
	
	@Test
	public void testDuplicateJMBAG() {
		assertThrows(IllegalArgumentException.class, ()-> new StudentDatabase(
				List.of("0000000007	Čima	Sanjin	4", "0000000007	Ćurić	Marko	1")));
	}
	
	@Test
	public void testFilter() {
		StudentDatabase db = new StudentDatabase(readFile());
		assertEquals(15, db.filter(record -> record.getFinalGrade() == 5 ).size());
	}

	@Test
	public void testForJMBAG() {
		StudentDatabase db = new StudentDatabase(readFile());
		assertEquals("0000000012", db.forJMBAG("0000000012").getJmbag());
		assertEquals("Gužvinec", db.forJMBAG("0000000018").getLastName());
	}

	
	
	

}
