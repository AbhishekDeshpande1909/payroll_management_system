package com.cdac.valid;


import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.cdac.dto.Employee;

@Service
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeID","unmKey", "employee ID required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeePass", "passKey","password required");
		
//		Employee emp = (Employee)target;
//		if(emp.getEmployeePass()!=null) {
//			if(emp.getEmployeePass().length()<3) { 
//				errors.rejectValue("employeePass", "passKey", "password should contain more 2 chars");
//			}
//		}
	}
}
		