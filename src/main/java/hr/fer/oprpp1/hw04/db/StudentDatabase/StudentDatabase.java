package hr.fer.oprpp1.hw04.db.StudentDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

public class StudentDatabase {

	private static final String GRADE_ERROR = "Grade for student %s must be between 1 and 5 but is: %d \n";
	private static final String DUPLICATE_JMBAG_ERROR = "Duplicate jmbag for: %s";
	private ArrayList<StudentRecord> students = new ArrayList<>();
	private HashMap<String, StudentRecord> indexes = new HashMap<>();

	public StudentDatabase(List<String> studentRecords) {
		for (String record : studentRecords) {
			addNewRecord(record);
		}
	}

	private void addNewRecord(String record) {
		String[] values = record.split("\\t");
		int grade = Integer.valueOf(values[3]);
		if (grade > 5 || grade < 1) {
			throw new IllegalArgumentException(String.format(GRADE_ERROR, values[0],grade));
		}
		StudentRecord newStudentRecord = new StudentRecord(values[0], values[1], values[2], grade);
		students.add(newStudentRecord);
		if (indexes.put(values[0],newStudentRecord) != null ){
			throw new IllegalArgumentException(String.format(DUPLICATE_JMBAG_ERROR, values[0]));
		}
	}
	
	
}
