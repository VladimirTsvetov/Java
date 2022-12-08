package org.gb.intefaces;

import org.gb.entity.Customer;

import java.util.List;

public interface ICustomerDao {
    public Customer findByID(int id);
    public Customer findByFirstname(String firstName);
    public Customer findByLastname(String lastName);
    public List<Customer> findAll();
}
