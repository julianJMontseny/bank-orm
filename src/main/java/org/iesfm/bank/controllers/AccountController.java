package org.iesfm.bank.controllers;


import org.iesfm.bank.pojos.Account;
import org.iesfm.bank.repositories.AccountRepository;
import org.iesfm.bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/accounts")
    public List<Account> list() {
        return accountRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/accounts/{iban}")
    public Account listByIban(@PathVariable("iban") String iban) {
        Optional<Account> account = accountRepository.findByIban(iban);
        return account.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, path = "/accounts/{iban}")
    public void deleteByIban(@PathVariable("iban") String iban) {
        if (accountRepository.existsById(iban)) {
            accountRepository.deleteById(iban);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customers/{nif}/accounts")
    public void insertAccount(@PathVariable("nif") String nif, @RequestBody Account account){
        if(customerRepository.existsByNif(nif)){
            accountRepository.save(account);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/{nif}/accounts")
    public List<Account> listAccountsByNif(@PathVariable("nif") String nif){

        return null;
    }



}
