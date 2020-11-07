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

import com.cdac.dto.Hr;

@Repository
public class HrDaoImple implements HrDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void insertHr(Hr hr) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(hr);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});

	}

	@Override
	public boolean checkHr(Hr hr) {		
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

		@Override
		public Boolean doInHibernate(Session session) throws HibernateException {
			Transaction tr = session.beginTransaction();
			Query q = session.createQuery("from Hr where hr_name = ? and hr_pass = ?");
			q.setString(0, hr.getHrName());
			q.setString(1, hr.getHrPass());
			List<Hr> li = q.list();
			boolean flag = !li.isEmpty();
			tr.commit();
			session.flush();
			session.close();
			return flag;
		}
		
	});
	return b;
	}

}
