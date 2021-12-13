package org.iesfm.bank.repositories;

import org.iesfm.bank.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
