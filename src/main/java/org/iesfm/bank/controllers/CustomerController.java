package org.iesfm.bank.controllers;

import org.iesfm.bank.pojos.Customer;
import org.iesfm.bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET,name = "/customers")
    public List<Customer> list(){
        return customerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,name = "/customers")
    public void postCustomer(Customer customer){
        if(customerRepository.existsById(customer.getId())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Customer already exists");
        } else {
            customerRepository.save(customer);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,name = "/customers/{id}")
    public void deleteCustomer(@PathVariable("id") int id){
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found");
        }
    }

    @RequestMapping(method = RequestMethod.GET,name = "/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable("id") int id){
        return customerRepository.findById(id);
    }



}
