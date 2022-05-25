package com.am.cabbooking.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.am.cabbooking.entities.Admin;
import com.am.cabbooking.entities.Customer;
import com.am.cabbooking.entities.Driver;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Object validateCredintials(Object obj) {
		
		if (obj instanceof Customer) {
			
			Customer c = (Customer) obj;
			
			TypedQuery<Customer> q = em.createQuery(
					"select c from Customer c where c.username=:uname and c.password=:pass", Customer.class);
			
			q.setParameter("uname", c.getUsername());
			q.setParameter("pass", c.getPassword());
			
			Customer cust = new Customer();
			try {
				cust = q.getSingleResult();
			}catch (Exception e) {
				return null;
			}
			
			return cust;
			
		} 
		
		else if (obj instanceof Driver) {
			Driver d = (Driver) obj;
			
			TypedQuery<Driver> q = em.createQuery("select d from Driver d where d.username=:uname and d.password=:pass",
					Driver.class);
			
			q.setParameter("uname", d.getUsername());
			q.setParameter("pass", d.getPassword());

			Driver driver = new Driver();
			try {
				driver = q.getSingleResult();
			}catch (Exception e) {
				return null;
			}
			
			return driver;
		}
		
		else if (obj instanceof Admin) {
			Admin d = (Admin) obj;
			
			TypedQuery<Admin> q = em.createQuery("select a from Admin a where a.username=:uname and a.password=:pass",
					Admin.class);
			
			q.setParameter("uname", d.getUsername());
			q.setParameter("pass", d.getPassword());
			
			Admin admin = new Admin();
			
			try {
				admin = q.getSingleResult();
			}catch (Exception e) {
				return null;
			}
			return admin;
		}
		return null;
	}

}
