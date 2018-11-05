package com.project.dao;

import com.project.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public CustomerDAOImpl() {
    }

    @Override
    public List<Customer> getCustomers() {

        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        // execute the query and get result list
        List<Customer> customers = query.getResultList();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer to the database
        currentSession.save(customer);
    }
}
