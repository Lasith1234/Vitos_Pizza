package online_web_app.controller;

import online_web_app.model.Customer;
import online_web_app.model.dtos.CustomerDTO;
import online_web_app.service.CustomerService;
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

    private final CustomerService customerService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {

        return customerService.addCustomer(customerDTO);
    }

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }
}
