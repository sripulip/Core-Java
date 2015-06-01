package testPackage;

abstract class Person {

	private String name = null;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	abstract public String getDescription();
}

class Student extends Person {

	private String major;
	private final String role;

	public Student(String name) {
		super(name);
		major = "N/A";
		this.role = "Student";
	}

	public String getMajor() {
		return this.major;
	}

	public String getRole() {
		return this.role;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String getDescription() {
		return this.getName() + ", " + this.getRole() + ", " + this.getMajor();
	}

}

class Professor extends Person {

	private String specialization;
	private final String role;

	public Professor(String name) {
		super(name);
		specialization = "N/A";
		this.role = "Professor";
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public String getRole() {
		return this.role;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String getDescription() {
		return this.getName() + ", " + this.getRole() + ", "
				+ this.getSpecialization();
	}
}

public class AbstractClassExample {

	public static void main(String[] args) {

		try {
			Person[] person = new Person[3];
			person[0] = new Student("SRK");
			person[1] = new Student("Shahrukh");
			person[2] = new Professor("Hrithik");

			for (Person p : person) {

				System.out.println(p.getDescription());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
