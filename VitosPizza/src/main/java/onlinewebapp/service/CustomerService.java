package onlinewebapp.service;

import onlinewebapp.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomerById(Integer id);
}
