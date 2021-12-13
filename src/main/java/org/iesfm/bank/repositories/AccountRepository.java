package org.iesfm.bank.repositories;

import org.iesfm.bank.pojos.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,String> {

    Optional<Account> findByIban(String iban);

}
