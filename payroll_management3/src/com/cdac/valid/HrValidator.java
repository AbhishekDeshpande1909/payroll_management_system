package com.cdac.valid;


import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.cdac.dto.Employee;
import com.cdac.dto.Hr;

@Service
public class HrValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Hr.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hrId","unmKey", "hr Id required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hrPass", "passKey","password required");
		
//		Employee emp = (Employee)target;
//		if(emp.getEmployeePass()!=null) {
//			if(emp.getEmployeePass().length()<3) { 
//				errors.rejectValue("employeePass", "passKey", "password should contain more 2 chars");
//			}
//		}
	}
}
		