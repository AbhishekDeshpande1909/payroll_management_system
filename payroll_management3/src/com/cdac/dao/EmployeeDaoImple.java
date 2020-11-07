package com.cdac.dao;


import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.cdac.dto.Employee;


@Repository
public class EmployeeDaoImple implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	@Override
	public void insertEmp(Employee emp) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(emp);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}


	@Override
	public boolean checkEmp(Employee emp) {

		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Employee where empID = ? and empPassword = ?");
				q.setInteger(0, emp.getEmployeeID());
				q.setString(1, emp.getEmployeePass());
				List<Employee> li = q.list();		
				boolean flag = !li.isEmpty();
				if(flag==false) {
					
				}
				else {
					emp.setEmployeeID(li.get(0).getEmployeeID());
					emp.setEmployeeName(li.get(0).getEmployeeName());
					emp.setEmployeePass(li.get(0).getEmployeePass());
					emp.setEmployeeSalary(li.get(0).getEmployeeSalary());
					emp.setEmployeecontactno(li.get(0).getEmployeecontactno());
					emp.setEmployeemail(li.get(0).getEmployeemail());
					
				}
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
			
		});
		return b;
	}


	@Override
	public void deleteEmp(int employeeID) {

		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Employee(employeeID));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}


	@Override
	public Employee selectEmp(int employeeID) {

		Employee emp = hibernateTemplate.execute(new HibernateCallback<Employee>() {

			@Override
			public Employee doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Employee ex = (Employee)session.get(Employee.class, employeeID);
				tr.commit();
				session.flush();
				session.close();
				return ex;
			}
			
		});
		return emp;
		
	}


	@Override
	public List<Employee> selectAllEmp() {
		List<Employee> empList = hibernateTemplate.execute(new HibernateCallback<List<Employee>>() {

			@Override
			public List<Employee> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Employee");
			
				List<Employee> li = q.list();
				System.out.println(li); 
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		return empList;
	}


	@Override
	public void UpdateEmp(Employee emp) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				System.out.println("in update");
				session.update(emp);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

}
