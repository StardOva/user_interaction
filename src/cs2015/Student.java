package cs2015;

public class Student {

	String lastName;
	String firstName;
	String dayOfBirth;
	String skills;

	public void initialise() {
		this.lastName = "Mustermann";
		this.firstName = "Max";
		this.dayOfBirth = "2000-01-01";
		this.skills = "empty";
	}
	
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

}
