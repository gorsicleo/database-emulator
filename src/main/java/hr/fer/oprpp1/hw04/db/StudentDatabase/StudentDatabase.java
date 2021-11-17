package hr.fer.oprpp1.hw04.db.StudentDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import hr.fer.oprpp1.hw04.db.IFilter.IFilter;
import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

/**Models simple database of student records, it has one index for JMBAG used for getting values of direct queries in O(1)
 * @author gorsicleo
 *
 */
public class StudentDatabase {

	private static final String GRADE_ERROR = "Grade for student %s must be between 1 and 5 but is: %d \n";
	private static final String DUPLICATE_JMBAG_ERROR = "Duplicate jmbag for: %s";
	
	/**List used for storing all student records*/
	private ArrayList<StudentRecord> students = new ArrayList<>();
	
	/**Map for getting values in O(1), used for direct queries*/
	private HashMap<String, StudentRecord> indexes = new HashMap<>();

	
	/**Creates new database and fills it up with raw unparsed query string
	 * @param studentRecords raw string input from user
	 */
	public StudentDatabase(List<String> studentRecords) {
		for (String record : studentRecords) {
			addNewRecord(record);
		}
	}

	/**Adds new record in database, <b>checks for duplicate keys and grades that are greater than 5 or smaller than 1</b>
	 * @param record to be parsed and added
	 * @throws IllegalArgumentException if jmbag is duplicate or grade is out of range
	 */
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
	
	/**Used for fast retrieval of Student record in constant time using index.
	 * @param jmbag
	 * @return {@link StudentRecord}
	 */
	public StudentRecord forJMBAG(String jmbag) {
		return indexes.get(jmbag);
	}
	
	/**Filters database using given filtering strategy
	 * @param filter strategy for applying
	 * @return list of filtered student records
	 */
	public List<StudentRecord> filter(IFilter filter){
		 return students.stream().filter(filter::accepts).collect(Collectors.toList());
	}
	
	
	
	
}
