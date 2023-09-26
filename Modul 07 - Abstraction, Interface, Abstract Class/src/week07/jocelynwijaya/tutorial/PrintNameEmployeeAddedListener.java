package week07.jocelynwijaya.tutorial;

public class PrintNameEmployeeAddedListener implements EmployeeAddedListener{
	@Override
	
	public void onEmployeeAdded(Employee employee) {
		System.out.println("Ditambahkan karyawan baru dengan posisi '" + employee.getPosition() +
				"' bernama '"+employee.getName()+"'");
	}
}
