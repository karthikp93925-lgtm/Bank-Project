package com.example.demo.repository;


import com.example.demo.Model.BankCustomer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

    @Repository
    public class BankRepository {

        ArrayList<BankCustomer> list = new ArrayList<>();

        public String save(BankCustomer customer) {
            list.add(customer);
            return "Account saved successfully";
        }


        public ArrayList<BankCustomer> getList(){
            return list;
        }


    }

