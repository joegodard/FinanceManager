package com.example.financemanager.persistence;

import com.example.financemanager.objects.Account;

import java.util.ArrayList;

public interface IAccountsDB {

    void addToAccounts(Account account);

    Account removeFromAccounts(Account account);

    void updateAccount(Account account);

    ArrayList<Account> getAccounts();

    Account getAccountByID(int id);

    Account getAccountByName(String name);

    int getNextID();
}
