package week07.jocelynwijaya.tutorial;

public class CountingEmployeeAddedListener implements EmployeeAddedListener {
//	@Override
	private static int employeesAddedCount = 0;
	public void onEmployeeAdded (Employee employee) {
		employeesAddedCount++;
		
		System.out.println("Total karyawan: " + employeesAddedCount);
	}
	
}
