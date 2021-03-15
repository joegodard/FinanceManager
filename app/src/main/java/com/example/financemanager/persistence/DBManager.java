package com.example.financemanager.persistence;

import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

public class DBManager {

    static final IAccountsDB accountsDB = new FakeAccountsDB();
    static final ITransactionsDB transactionsDB = new FakeTransactionsDB();


    public static void initialize(){
        Account account1 = new Account(accountsDB.getNextID(), "Staff Chequing", "Caisse", "Chequing", 2000);
        accountsDB.addToAccounts(account1);
        Account account2 = new Account(accountsDB.getNextID(), "Student Chequing", "RBC", "Chequing", 4000);
        accountsDB.addToAccounts(account2);

        transactionsDB.addToTransactions(new Transaction(transactionsDB.getNextID(), "02/02/21", account1, "Tims", -5.50));
        transactionsDB.addToTransactions(new Transaction(transactionsDB.getNextID(), "05/03/21", account2, "Money", -45.00));
    }

    public static IAccountsDB getAccountsDB(){
        return accountsDB;
    }
    public static ITransactionsDB getTransactionsDB(){
        return transactionsDB;
    }
}
