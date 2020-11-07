package com.cdac.service;

import java.util.List;

import com.cdac.dto.Employee;

public interface EmployeeService {
	void addEmp(Employee emp);
	void removeEmp(int employeeID);
	Employee selectEmp(int employeeID);
	List<Employee> selectAllEmp();
	boolean findEmp(Employee emp);
	void ChangeEmployee(Employee emp);
}
