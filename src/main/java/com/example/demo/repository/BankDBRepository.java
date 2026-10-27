package com.example.demo.repository;

import com.example.demo.Model.BankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDBRepository extends JpaRepository<BankCustomer, Long> {

}