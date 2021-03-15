package com.example.financemanager.business;

import com.example.financemanager.objects.Account;

import java.util.ArrayList;

public interface IAccountActions {

    void addToAccounts(Account account);

    void updateAccount(Account account);

    void removeAccount(Account account);

    Account getAccount(int position);

    ArrayList<Account> getAccounts();

    Account getAccountByID(int id);

    Account getAccountByName(String name);

    ArrayList<String> getAccountNames();
}
