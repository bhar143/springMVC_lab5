package com.gl.springMVC.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gl.springMVC.entity.Customer;

public class CustomerImpl implements CustomerService{
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
@Autowired
public CustomerImpl( SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
	try {
		session = sessionFactory.getCurrentSession();
	} catch(HibernateException ex) {
		session = sessionFactory.openSession();
	}
}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		List<Customer> customer = session.createQuery("from Customer").list();
		tx.commit();
		return customer;
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		return null;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
		
	}

	@Override
	@Transactional
	public void deletedById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		
	}

}
