package org.iesfm.bank.controllers;

import org.iesfm.bank.pojos.Customer;
import org.iesfm.bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET,path = "/customers")
    public List<Customer> list(){
            return customerRepository.findAll();

    }

    @RequestMapping(method = RequestMethod.GET,path = "/customers/{nif}")
    public Customer getCustomer(@PathVariable("nif") String nif){
        Optional<Customer> customerOptional = customerRepository.findByNif(nif);
        return customerOptional.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found"));
    }

    @RequestMapping(method = RequestMethod.POST,path = "/customers")
    public void postCustomer(@RequestBody Customer customer){
        if(customerRepository.existsByNif(customer.getNif())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Customer already exists");
        } else {
            customerRepository.save(customer);
        }
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE,path = "/customers/{nif}")
    public void deleteCustomer(@PathVariable("nif") String nif){
        //Si las filas que borra son 0 -> saca el error. (porque no se ha borrado nada), si no, pues borra igualmente.
        if(customerRepository.deleteByNif(nif) == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found");
        }
    }





}
