package oopsConcepts;

import java.util.Arrays;

class Contractor implements Comparable<Contractor> {

	private String name;
	private int hourlySalary;

	public Contractor(String name, int hourlySalary) {

		this.name = name;
		this.hourlySalary = hourlySalary;
	}

	public String getName() {

		return this.name;
	}

	public int getHourlySalary() {

		return this.hourlySalary;
	}

	public String getDetails() {

		return this.name + ", " + this.hourlySalary;
	}

	@Override
	public int compareTo(Contractor otherEmployee) {
		System.out.println("In superclass: " + this.getDetails() + " : "
				+ otherEmployee.getDetails());
		return this.hourlySalary - otherEmployee.hourlySalary;
	}
}

class HeadContractor extends Contractor {

	private int bonus;

	public HeadContractor(String name, int hourlySalary) {

		super(name, hourlySalary);
	}

	public void setBonus(int bonus) {

		this.bonus = bonus;
	}

	public int getTotalSalary() {

		return (this.getHourlySalary() + this.bonus);
	}

	@Override
	public String getDetails() {

		return this.getName() + ", " + (this.getTotalSalary());
	}

	// Do not implement this. The 'transitivity contract' will break. May give
	// wrong results. Refer to
	// http://stackoverflow.com/questions/11928656/sorting-a-subclass-in-java

	@Override
	public int compareTo(Contractor otherEmployee) {

		if (this instanceof HeadContractor
				&& otherEmployee instanceof HeadContractor) {
			System.out.println("In subclass: " + this.getDetails() + " : "
					+ otherEmployee.getDetails());
			HeadContractor c = (HeadContractor) otherEmployee;
			return (this.getTotalSalary() - c.getTotalSalary());
		}
		return super.compareTo(otherEmployee);
	}

}

public class InterfaceComparableExample {

	public static void main(String[] args) {

		Contractor[] contractor = new Contractor[5];

		contractor[0] = new Contractor("Contractor1", 15000);
		contractor[1] = new Contractor("Contractor2", 5000);
		contractor[2] = new HeadContractor("HeadContractor1", 6000);
		contractor[3] = new HeadContractor("HeadContractor2", 8000);
		contractor[4] = new Contractor("Contractor4", 7000);

		HeadContractor hc = (HeadContractor) contractor[2];
		hc.setBonus(10000);
		hc = (HeadContractor) contractor[3];
		hc.setBonus(5000);

		Arrays.sort(contractor);

		for (Contractor c : contractor) {
			System.out.println(c.getDetails());
		}

	}

}
