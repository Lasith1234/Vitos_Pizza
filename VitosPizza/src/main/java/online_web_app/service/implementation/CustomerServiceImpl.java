package online_web_app.service.implementation;

import online_web_app.model.Customer;
import online_web_app.model.dtos.CustomerDTO;
import online_web_app.repository.CustomerRepo;
import online_web_app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) {

        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setCreatedAt(LocalDateTime.now());
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
