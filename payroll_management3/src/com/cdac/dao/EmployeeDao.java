package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Employee;

public interface EmployeeDao {
	void insertEmp(Employee emp);
	
	void deleteEmp(int employeeID);
	
	Employee selectEmp(int employeeID);
	
	List<Employee> selectAllEmp();
	
	void UpdateEmp(Employee emp);
	
	boolean checkEmp(Employee emp);
}
