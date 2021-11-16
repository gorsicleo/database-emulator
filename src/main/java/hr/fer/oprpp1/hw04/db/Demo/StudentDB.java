package hr.fer.oprpp1.hw04.db.Demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import hr.fer.oprpp1.hw04.db.StudentDatabase.StudentDatabase;

public class StudentDB {
	
	

	public static void main(String[] args) {
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get("./src/main/resources/database.txt"),StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Unable to load database.");
			return;
		}
		
		StudentDatabase db = new StudentDatabase(lines);
		System.out.println(db.toString());
		//System.out.println(db.forJMBAG("0000000016"));
		
		
	}
	
}
