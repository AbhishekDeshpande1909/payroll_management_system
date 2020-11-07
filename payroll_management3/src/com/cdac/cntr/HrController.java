package com.cdac.cntr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Employee;
import com.cdac.dto.Hr;
import com.cdac.service.EmployeeService;
import com.cdac.service.HrService;
import com.cdac.valid.EmployeeValidator;
import com.cdac.valid.HrValidator;

@Controller
public class HrController {
	
	@Autowired
	private HrService hrService;
	
	@Autowired
	private EmployeeService empService;

	@Autowired
	private HrValidator hrValidator;
	
	@RequestMapping(value = "/hr_login.htm",method = RequestMethod.GET)
	public String prepLoginForm(ModelMap map) {
		map.put("hr", new Hr());
		System.out.println("in hr controller ===========================");
		return "hr_login";
	}
	@RequestMapping(value = "/login.htm",method = RequestMethod.POST)
	public String login(@ModelAttribute("hr")Hr hr,BindingResult result,ModelMap map,HttpSession session,Model m) {
		
		hrValidator.validate(hr, result);

		System.out.println(" ");
		System.out.println(" ");
		//System.out.println(empValidator.supports(getClass()));
		if(result.hasErrors()) {
			return "hr_login";
		}
		
		boolean b = hrService.findHr(hr);
		if(b) {
			session.setAttribute("hr",hr);
			if(hr.getHrName() != null) {
				System.out.println("in first if");
			return "home";
			}/*
			else if(hr.getHrId()>20000) {
				return "home2";
			}*/
			else {
				System.out.println("in else");
				return "index";
			}
		}else {
			map.put("hr", new Hr());
			return "hr_login";
		}
	}
	
	@RequestMapping(value = "/hr_reg.htm",method = RequestMethod.GET)
	public String prepRegForm(ModelMap map) {
		map.put("hr", new Hr());
		return "hr_reg";
	}
	
	@RequestMapping(value = "/reg.htm",method = RequestMethod.POST)
	public String register(Hr hr,ModelMap map) {
	hrService.addHr(hr);
		return "hr_login";
	}
	

	
	@RequestMapping(value = "/add_emp.htm",method = RequestMethod.GET)
	public String addEmp(Employee emp,ModelMap map) {
		map.put("emp", new Employee());
		return "emp_add";

	}
	
	@RequestMapping(value = "/emp_reg.htm",method = RequestMethod.POST)
	public String register(Employee emp,ModelMap map) {
		empService.addEmp(emp);
		return "home";
	}
	
	
	@RequestMapping(value="/logout.htm",method=RequestMethod.GET)
	public String logout(Employee emp,ModelMap map,HttpSession session) {
		
		return "logout";
		
	}
	
	
}
