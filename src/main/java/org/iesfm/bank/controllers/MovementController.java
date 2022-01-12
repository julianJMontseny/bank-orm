package org.iesfm.bank.controllers;

import org.iesfm.bank.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovementController {

    @Autowired
    private MovementRepository movementRepository;


}
