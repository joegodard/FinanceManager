package com.example.financemanager.persistence;

import com.example.financemanager.objects.Account;

public class DBManager {

    static final IAccountsDB accountsDB = new FakeAccountsDB();


    public static void initialize(){
        accountsDB.addToAccounts(new Account(1, "Staff Chequing", "Caisse", "Chequing", 2000));
        accountsDB.addToAccounts(new Account(2, "Student Chequing", "RBC", "Chequing", 4000));
    }

    public static IAccountsDB getAccountsDB(){
        return accountsDB;
    }
}
