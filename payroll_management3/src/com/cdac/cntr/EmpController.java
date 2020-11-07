package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Employee;
import com.cdac.dto.Hr;
import com.cdac.service.EmployeeService;
import com.cdac.valid.EmployeeValidator;

@Controller
public class EmpController {
	
	@Autowired
	private EmployeeService empService;
	@Autowired
	private EmployeeValidator empValidator;
	
	@RequestMapping(value = "/reg_form.htm",method = RequestMethod.GET)
	public String prepRegForm(ModelMap map) {
		map.put("emp", new Employee());
		return "reg_form";
	}
	@RequestMapping(value = "/emp_login.htm",method = RequestMethod.GET)
	public String prepLoginForm(ModelMap map) {
		map.put("emp", new Employee());
		System.out.println("in emp controller ===========================");
		return "emp_login";
	}
	@RequestMapping(value = "/select_emp.htm",method = RequestMethod.GET)
	public String select(ModelMap map) {
		map.put("emp", new Employee());
		return "emp_sel";
	}
	
	@RequestMapping(value = "/search.htm",method = RequestMethod.POST)
	public String selEmp(@RequestParam int employeeID,ModelMap map) {
		
		Employee exp = empService.selectEmp(employeeID);
		map.put("empSel", exp);
		return "home2";
	}

	
	@RequestMapping(value = "/emp_logged_in.htm",method = RequestMethod.POST)
	public String login( @ModelAttribute("emp")Employee emp,BindingResult result,ModelMap map,HttpSession session,Model m) {
		empValidator.validate(emp, result);
		System.out.println(" ");
		System.out.println(" ");
		//System.out.println(empValidator.supports(getClass()));
		if(result.hasErrors()) {
			return "login_form";
		}
		
		boolean b = empService.findEmp(emp);
		if(b) {
			session.setAttribute("emp",emp);
			if(0<emp.getEmployeeID() && emp.getEmployeeID()<20000) {
				System.out.println("in upper if");
			return "update_form2";
			}
			else if(emp.getEmployeeID()>20000) {
				return "home2";
			}
			else {
				System.out.println("in else");
				return "index";
			}
		}else {
			map.put("emp", new Employee());
			return "emp_login";
		}
	}
	
	
	@RequestMapping(value = "/employeelist.htm",method = RequestMethod.GET)
	public String employeeList(ModelMap map) {
		List<Employee> li=empService.selectAllEmp();
		map.put("empList", li);
		return "employeelist";
	}
	
	@RequestMapping(value = "/emp_delete.htm",method = RequestMethod.GET)
	public String delEmp(ModelMap map) {
		map.put("emp", new Employee());
		return "emp_del";
	}
	
	@RequestMapping(value = "/delete.htm",method = RequestMethod.GET)
	public String delete(@RequestParam int employeeID,ModelMap map,HttpSession session) {
		empService.removeEmp(employeeID);
		List<Employee> li=empService.selectAllEmp();
		map.put("empList", li);
		return "employeelist";
	}
	
	
	@RequestMapping(value = "/employee_update.htm",method = RequestMethod.GET)
	public String upEmp(@RequestParam int employeeID,ModelMap map,HttpSession session) {
		Employee li=empService.selectEmp(employeeID);
		map.put("emp", li);
		System.out.println(li);
		return "employee_update_form";
	}

	
	@RequestMapping(value = "/emp_update.htm",method = RequestMethod.POST)
	public String employeeUpdateForm(Employee emp,ModelMap map,HttpSession session) {
		System.out.println("came here in emp_update ");
		empService.ChangeEmployee(emp);
		List<Employee> li=empService.selectAllEmp();
		map.put("empList", li);
		
		return "employeelist";
	}
	@RequestMapping(value = "/em_update.htm",method = RequestMethod.GET)
	public String updEmp(@RequestParam int employeeID,ModelMap map,HttpSession session) {
		Employee li=empService.selectEmp(employeeID);
		map.put("emp", li);
		System.out.println(li);
		return "update_form";
	}
	@RequestMapping(value = "/emp_update2.htm",method = RequestMethod.POST)
	public String employeeUpdateForm2(@RequestParam int employeeID,Employee emp,ModelMap map,HttpSession session) {
		System.out.println("came here in emp_update ");
		empService.ChangeEmployee(emp);
		Employee li=empService.selectEmp(employeeID);
		map.put("empList", li);
		
		return "update_form2";
	}
	
	@RequestMapping(value="/emp_logout.htm",method=RequestMethod.GET)
	public String logout(Employee emp,ModelMap map,HttpSession session) {
		
		return "emp_logout";
		
	}

	
}
