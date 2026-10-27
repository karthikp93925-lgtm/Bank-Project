package com.example.demo.service;

import com.example.demo.Model.BankCustomer;
import com.example.demo.repository.BankDBRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    BankDBRepository bankDBRepository;

    public BankAccountService(BankDBRepository bankDBRepository){
        this.bankDBRepository =bankDBRepository;
    }


    //  Account creationn
    public BankCustomer createAccount(BankCustomer customer) {

        if (bankDBRepository.existsById(customer.getAccountNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account already exists");
        }

        return bankDBRepository.save(customer);
    }

    //Get aLl Account
    public List<BankCustomer> getAllAccounts(){
        return bankDBRepository.findAll();
    }


    //Find account by account numbers

    public Optional<BankCustomer> findByID(Long accountNumber){
        return bankDBRepository.findById(accountNumber);
    }


    //update account detials
    public String updateAccount(BankCustomer newCustomer){
        Optional<BankCustomer> obj=findByID(newCustomer.getAccountNumber());
        if(obj.isPresent()){
            BankCustomer existingCustomer=obj.get();
            existingCustomer.setName(newCustomer.getName());

            existingCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
            existingCustomer.setBankBalance(newCustomer.getBankBalance());
            bankDBRepository.save(existingCustomer);
            return "Account updated successfully";
        }
        return "Account not found";
    }

    // Deleteby             Acccount Number
    public String deleteAccount(long accountNumber){
        Optional<BankCustomer> obj=findByID(accountNumber);

        if(obj.isPresent()){
            bankDBRepository.delete(obj.get());
            return "Account deleted successfully";
        }
        return "account not found";
    }

    // get balace by account number
    public double getBalance(long accountNumber) {
        Optional<BankCustomer> customer =
                bankDBRepository.findById(accountNumber);

        if (customer.isPresent()) {
            return customer.get().getBankBalance();
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Account not found"
        );
    }


}