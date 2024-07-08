package online_web_app.service;

import online_web_app.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomerById(Integer id);
}
