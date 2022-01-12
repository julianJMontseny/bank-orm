package org.iesfm.bank.repositories;

import org.iesfm.bank.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByNif(String nif);

    //Devuelve las filas afectadas por el Delete
    int deleteByNif(String nif);

    Optional<Customer> findByNif(String nif);
}
