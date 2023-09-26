package week07.jocelynwijaya.tutorial;

import java.util.*;

public class Office {
	private List<Employee> employees = new ArrayList<>();
	private List<EmployeeAddedListener> listeners = new ArrayList<>();
	
	public void addEmployee (Employee employee) {
		this.employees.add(employee);
		this.notifyEmployeeAddedListeners(employee);
	}
	
	public void registerEmployeeAddedListener (EmployeeAddedListener listener) {
		this.listeners.add(listener);
	}
	
	public void unregisterEmployeeAddedListener (EmployeeAddedListener listener) {
		this.listeners.remove(listener);
	}
	
	protected void notifyEmployeeAddedListeners (Employee employee) {
		this.listeners.forEach(listener -> listener.onEmployeeAdded(employee));
	}
}
