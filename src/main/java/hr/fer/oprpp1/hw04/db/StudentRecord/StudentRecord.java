package hr.fer.oprpp1.hw04.db.StudentRecord;

/**Models simple student record consisting od identifier jmbag which is unique, first name, last name, and grade
 * @author gorsicleo
 *
 */
public class StudentRecord {
	
	private String jmbag;
	private String lastName;
	private String firstName;
	private int finalGrade;
	
	
	/**Creates new student record, without validation of arguments
	 * @param jmbag
	 * @param lastName
	 * @param firstName
	 * @param finalGrade
	 */
	public StudentRecord(String jmbag, String lastName, String firstName, int finalGrade) {
		this.jmbag = jmbag;
		this.lastName = lastName;
		this.firstName = firstName;
		this.finalGrade = finalGrade;
	}


	public String getJmbag() {
		return jmbag;
	}


	public void setJmbag(String jmbag) {
		this.jmbag = jmbag;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public int getFinalGrade() {
		return finalGrade;
	}


	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jmbag == null) ? 0 : jmbag.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "StudentRecord: "+jmbag+" "+firstName+" "+lastName+" "+finalGrade;
	}


	/**Two records are considered equal if their jmbag property is equal
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentRecord other = (StudentRecord) obj;
		if (jmbag == null) {
			if (other.jmbag != null)
				return false;
		} else if (!jmbag.equals(other.jmbag))
			return false;
		return true;
	}


	


	
	
	
	

}
