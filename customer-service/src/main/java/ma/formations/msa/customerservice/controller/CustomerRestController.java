package ma.formations.msa.customerservice.controller;

import ma.formations.msa.customerservice.entites.Customer;
import org.springframework.web.bind.annotation.*;
import ma.formations.msa.customerservice.repository.CustomerRepository;

import java.util.List;

/**
 * @author marwane
 **/
@RestController
public class CustomerRestController {

    private final CustomerRepository customerRepository;
    public CustomerRestController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public List<Customer> listCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        customer.setId(id);
        return customerRepository.save(customer);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
    }


}
