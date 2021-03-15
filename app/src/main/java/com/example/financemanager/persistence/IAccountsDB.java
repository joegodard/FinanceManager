package com.example.financemanager.persistence;

import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

import java.util.ArrayList;

public interface IAccountsDB {

    void addToAccounts(Account account);

    Account removeFromAccounts(Account account);

    void updateAccount(Account account);

    void updateAccountBalance(Account account, double change);

    ArrayList<Account> getAccounts();

    Account getAccountByID(int id);

    Account getAccountByName(String name);

    int getNextID();
}
