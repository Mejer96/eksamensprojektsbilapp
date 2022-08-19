package com.example.eksamensprojektsbilapp.Service;

import com.example.eksamensprojektsbilapp.Model.Customer;
import com.example.eksamensprojektsbilapp.Repository.CustomerRepository;

import java.sql.SQLException;

public class CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();

    public Customer createCustomerObject(String firstname, String lastname, String email, int phoneNumber) {
        return new Customer(firstname, lastname, phoneNumber, email);
    }

    public void insertCustomerObjectDB(Customer customer) throws SQLException {
        customerRepository.insertCustomerDB(customer);
    }

    public int selectCustomerID(String firstname, String lastname, String email) throws SQLException {
        return customerRepository.getCustomerID(firstname, lastname, email);
    }

}
