package com.example.demo.controller;

import com.example.demo.Model.BankCustomer;
import com.example.demo.service.BankAccountService;
import org.hibernate.internal.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private  BankAccountService bankAccountServiceobj;

    public BankController(BankAccountService bankAccountServiceobj) {
        this.bankAccountServiceobj = bankAccountServiceobj;
    }


    // Create Account
    @PostMapping
    public ResponseEntity<BankCustomer> createAccount( @RequestBody BankCustomer customer) {

        BankCustomer saved = bankAccountServiceobj.createAccount(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get All Accounts
    @GetMapping
    public List<BankCustomer> getAllAccounts() {
        return bankAccountServiceobj.getAllAccounts();
    }

    // Find Account by Account Number
    @GetMapping("/{accountNumber}")
    public ResponseEntity<BankCustomer> findByID(
            @PathVariable Long accountNumber) {

        return bankAccountServiceobj.findByID(accountNumber).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update Account Details
    @PutMapping
    public String updateAccount(@RequestBody BankCustomer customer) {
        return bankAccountServiceobj.updateAccount(customer);
    }


    // Delete Account
    @DeleteMapping("/{accountNumber}")
    public String deleteAccount(@PathVariable Long accountNumber) {
        return bankAccountServiceobj.deleteAccount(accountNumber);
    }

    // check balance using account nmbr
    @GetMapping("/{accountNumber}/bankBalance")
    public double getBalance(@PathVariable long accountNumber) {
        return bankAccountServiceobj.getBalance(accountNumber);
    }

}