package org.iesfm.bank.controllers;

import org.hibernate.hql.internal.ast.ParameterTranslationsImpl;
import org.iesfm.bank.pojos.Account;
import org.iesfm.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/accounts")
    public List<Account> list() {
        return accountRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/accounts/{iban}")
    public Optional<Account> listByIban(@PathVariable("iban") String iban) {
        return accountRepository.findByIban(iban);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/accounts/{iban}")
    public void deleteByIban(@PathVariable("iban") String iban) {
        if (accountRepository.existsById(iban)) {
            accountRepository.deleteById(iban);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
    }


}
