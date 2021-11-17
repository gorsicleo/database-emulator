package hr.fer.oprpp1.hw04.db.IFieldValueGetter;

import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

/**Models strategy for retrieving values form StudentRecord class
 * @author gorsicleo
 *
 */
public interface IFieldValueGetter {
	
	/**Returns value from StudentRecord
	 * @param record to extract values from
	 * @return String representation of that attribute value.
	 */
	String get(StudentRecord record);

}
