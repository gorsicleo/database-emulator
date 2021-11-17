package hr.fer.oprpp1.hw04.db.Demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import hr.fer.oprpp1.hw04.db.QueryFilter.QueryFilter;
import hr.fer.oprpp1.hw04.db.QueryParser.QueryParser;
import hr.fer.oprpp1.hw04.db.StudentDatabase.StudentDatabase;
import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

public class StudentDB {

	public static void main(String[] args) {
		List<String> lines;
		try {
			System.out.println("Loading database...");
			lines = Files.readAllLines(Paths.get("./src/main/resources/database.txt"), StandardCharsets.UTF_8);
			System.out.println("Database loaded... happy querying :)");
		} catch (IOException e) {
			System.out.println("Unable to load database.");
			return;
		}
		
		StudentDatabase db = new StudentDatabase(lines);
		Scanner scanner = new Scanner(System.in);
		System.out.print("> ");
		String input = scanner.nextLine();
		while (!input.equals("exit") && !input.isBlank()) {
			if (input.startsWith("query")) {
				input = input.substring("query".length());
				executeQuery(db,input);
			}
			System.out.print("> ");
			input = scanner.nextLine();
			
		}

	}

	private static void executeQuery(StudentDatabase db,String input) {
		QueryParser parser = new QueryParser(input);
		if (parser.isDirectQuery()) {
			printRecords(Arrays.asList(db.forJMBAG(parser.getQueriedJMBAG())));
		} else {
			printRecords(db.filter(new QueryFilter(parser.getQuery())));
			}
		}
	
	private static void printRecords(List<StudentRecord> records) {
		
	}
	
	
	}

