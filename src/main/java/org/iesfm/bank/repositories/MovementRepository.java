package org.iesfm.bank.repositories;

import org.iesfm.bank.pojos.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement,Integer> {
}
