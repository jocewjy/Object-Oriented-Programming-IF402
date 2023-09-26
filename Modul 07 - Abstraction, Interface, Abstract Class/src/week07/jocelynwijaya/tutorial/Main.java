package week07.jocelynwijaya.tutorial;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Office office = new Office();
		
		office.registerEmployeeAddedListener(new PrintNameEmployeeAddedListener());
		office.registerEmployeeAddedListener(new CountingEmployeeAddedListener());
				
		office.addEmployee(new Employee("Andre", "IT Manager"));
		office.addEmployee(new Employee("Vincent", "Senior programmer"));
		office.addEmployee(new Employee("Jonathan", "internship Programmer"));
	}

}
