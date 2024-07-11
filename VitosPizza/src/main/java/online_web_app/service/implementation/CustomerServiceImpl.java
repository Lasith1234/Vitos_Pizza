package online_web_app.service.implementation;

import online_web_app.model.Customer;
import online_web_app.model.dtos.CustomerDTO;
import online_web_app.repository.CustomerRepo;
import online_web_app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) {

        Customer customer = Customer.builder().email(customerDTO.getEmail()).firstName(customerDTO.getFirstName()).lastName(customerDTO.getLastName()).mobileNo(customerDTO.getMobileNo()).password(customerDTO.getPassword()).createdAt(LocalDateTime.now()).build();
        customerRepo.save(customer);
        log.info("Customer added successfully");
        return customer;

    }

    @Override
    public List<Customer> getCustomers() {
        log.info("finding all...");
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found for id: " + id));
    }
}
