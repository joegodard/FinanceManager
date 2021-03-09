package com.example.financemanager.persistence;

import com.example.financemanager.objects.Account;

public class DBManager {

    static final IAccountsDB accountsDB = new FakeAccountsDB();


    public static void initialize(){
        accountsDB.addToAccounts(new Account(accountsDB.getNextID(), "Staff Chequing", "Caisse", "Chequing", 2000));
        accountsDB.addToAccounts(new Account(accountsDB.getNextID(), "Student Chequing", "RBC", "Chequing", 4000));
    }

    public static IAccountsDB getAccountsDB(){
        return accountsDB;
    }
}
