package testPackage;

class Employee {

	private String name = null;
	private int id = 999;
	private int salary = 999;

	public Employee(String name, int id, int salary) {

		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getSalary() {
		return salary;
	}

	public String employeeDetails() {

		return name + ", " + id + ", " + salary;
	}
}

class Manager extends Employee {

	private int bonus = 0;

	public Manager(String name, int id, int salary) {

		super(name, id, salary);
		this.bonus = 0;
	}

	public void setBonus(int bonus) {

		this.bonus = bonus;
	}

	public String employeeDetails() {

		String mngrName = super.getName();
		int mngrId = super.getId();
		int mngrSalary = super.getSalary();

		int mngrTotalSalary = mngrSalary + bonus;

		return mngrName + ", " + mngrId + ", " + mngrTotalSalary;
	}

}

public class InheritanceExample {

	public static void main(String[] args) {

		try {

			Employee[] employees = new Employee[3];

			employees[0] = new Manager("Manager1", 1, 15000);
			employees[1] = new Employee("Employee1", 2, 5000);
			employees[2] = new Employee("Employee2", 3, 7000);

			((Manager) employees[0]).setBonus(10000);

			for (Employee e : employees) {

				System.out.println(e.employeeDetails());
			}
		} catch (Exception e) {

			System.out.println("Exception: " + e);
			System.out.println("Casue: " + e.getCause());
		}

	}
}
