package hr.fer.oprpp1.hw04.db.IFilter;

import hr.fer.oprpp1.hw04.db.StudentRecord.StudentRecord;

public interface IFilter {
	public boolean accepts(StudentRecord record);
}
