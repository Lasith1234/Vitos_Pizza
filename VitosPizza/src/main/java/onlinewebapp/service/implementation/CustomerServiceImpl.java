package onlinewebapp.service.implementation;

import onlinewebapp.model.Customer;
import onlinewebapp.repository.CustomerRepo;
import onlinewebapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
        log.info("Customer added successfully");
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepo.findById(id).get();
    }
}
