package online_web_app.service;

import online_web_app.model.Customer;
import online_web_app.model.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(CustomerDTO customerDTO);

    List<Customer> getCustomers();

    Customer getCustomerById(String id);
}
