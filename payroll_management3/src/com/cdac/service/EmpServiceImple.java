package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.EmployeeDao;
import com.cdac.dto.Employee;
@Service
public class EmpServiceImple implements EmployeeService {
	
	
	
	@Autowired
	private EmployeeDao empDao;
	@Override
	public void addEmp(Employee emp) {
		empDao.insertEmp(emp);	
	}
	
	
	@Override
	public boolean findEmp(Employee emp) {

		return empDao.checkEmp(emp);
	}
	
	
	@Override
	public void removeEmp(int employeeID) {
		empDao.deleteEmp( employeeID);
		
	}
	@Override
	public Employee selectEmp(int employeeID) {
		
		return empDao.selectEmp(employeeID);
	}
	@Override
	public List<Employee> selectAllEmp() {
		// TODO Auto-generated method stub
		return empDao.selectAllEmp();
	}



	@Override
	public void ChangeEmployee(Employee emp) {
		// TODO Auto-generated method stub
		 empDao.UpdateEmp(emp);
	}



}
