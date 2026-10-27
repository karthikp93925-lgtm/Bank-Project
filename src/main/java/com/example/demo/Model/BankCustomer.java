package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bank")
@Entity

public class BankCustomer {

    @Id
    @Column
    long accountNumber;
    @Column
    String name;
    @Column
    long phoneNumber;
    @Column
    double bankBalance;


}
