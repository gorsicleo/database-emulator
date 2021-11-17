package hr.fer.oprpp1.hw04.db.IFilter;

import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

/**Filters student record with given strategy.
 * @author gorsicleo
 *
 */
public interface IFilter {
	/**
	 * @param record to be filtered
	 * @return true if record is accepted, false otherwise.
	 */
	public boolean accepts(StudentRecord record);
}
