package hr.fer.oprpp1.hw04.db.Demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import hr.fer.oprpp1.hw04.db.QueryFilter.QueryFilter;
import hr.fer.oprpp1.hw04.db.QueryParser.QueryParser;
import hr.fer.oprpp1.hw04.db.StudentDatabase.StudentDatabase;
import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

/**Class that communicates with the user and queries the database. 
 * @author gorsicleo
 *
 */
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
				try {
					executeQuery(db,input);
				} catch (Exception e) {
					System.out.println("Opps error happend with following message: "+e.getMessage());
					System.out.println("Hint: Make sure to use only legal attribute names and \n "
							+ "make sure put all non-operator arguments in quotation marks.");
				}
				
			}
			System.out.print("> ");
			input = scanner.nextLine();
			
		}
		
		System.out.println("Goodbye!");

	}

	/**Executes query and sends result to print method.
	 * @param db StudentDatabase
	 * @param input query String
	 */
	private static void executeQuery(StudentDatabase db,String input) {
		QueryParser parser = new QueryParser(input);
		if (parser.isDirectQuery()) {
			System.out.println("Using index for record retrieval.");
			printRecords(Arrays.asList(db.forJMBAG(parser.getQueriedJMBAG())));
		} else {
			printRecords(db.filter(new QueryFilter(parser.getQuery())));
			}
		}
	
	/**Method prints query results in table-like format.
	 * @param records List that needs to be printed
	 */
	private static void printRecords(List<StudentRecord> records) {
		long size = records.stream().filter(Objects::nonNull).count();
		System.out.println("Records selected: "+size);
		if (size==0) {
			return;
		}
		
		int maxFirstNameLength = records.stream().mapToInt( (record) -> record.getFirstName().length()).max().getAsInt();
		int maxLastNameLength = records.stream().mapToInt( (record) -> record.getLastName().length()).max().getAsInt();
		
		System.out.println("+" + "=".repeat(12) + "+" + "=".repeat(maxLastNameLength + 2) + "+"
				+ "=".repeat(maxFirstNameLength + 2) + "+===+");
		
		records.stream().forEach( (record) -> System.out.println("| " + record.getJmbag() + " | " + record.getLastName()
				+ " ".repeat(maxLastNameLength - record.getLastName().length()) + " | " + record.getFirstName()
				+ " ".repeat(maxFirstNameLength - record.getFirstName().length()) + " | " + record.getFinalGrade() + " |"));
		
		System.out.println("+" + "=".repeat(12) + "+" + "=".repeat(maxLastNameLength + 2) + "+"
				+ "=".repeat(maxFirstNameLength + 2) + "+===+");
	}
	
	
	}

