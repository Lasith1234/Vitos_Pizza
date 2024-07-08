package online_web_app.controller;

import online_web_app.model.Customer;
import online_web_app.service.implementation.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Valid
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@Valid @RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }
}
