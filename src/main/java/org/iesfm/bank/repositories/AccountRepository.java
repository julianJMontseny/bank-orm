package org.iesfm.bank.repositories;

import org.iesfm.bank.pojos.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

    Optional<Account> findByIban(String iban);

    //Ponemos nativeQuery para señalar que es una consulta de MySQl y no de JPA.
    //La "?" Es porque es un parámetro.
    @Query(value= "SELECT a.* FROM Account a " +
            "INNER JOIN Customer c " +
            "ON c.id=a.owner_id " +
            "WHERE nif=?",
            nativeQuery= true)
    List<Account>  findByNif(String customerNif);

}
