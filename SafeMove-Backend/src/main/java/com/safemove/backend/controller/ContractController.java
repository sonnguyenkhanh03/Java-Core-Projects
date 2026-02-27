package com.safemove.backend.controller;

import com.safemove.backend.entity.Contract;
import com.safemove.backend.repository.ContractRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
    private final ContractRepository contractRepository;

    public ContractController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    @PostMapping
    public Contract create(@RequestBody Contract contract) {
        return contractRepository.save(contract);
    }
}
