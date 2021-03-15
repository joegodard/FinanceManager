package com.example.financemanager.business;

import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

import java.util.ArrayList;

public interface IAccountActions {

    void addToAccounts(Account account);

    void updateAccount(Account account);

    void removeAccount(Account account);

    void updateAccountBalance(Account account, double change);

    Account getAccount(int position);

    ArrayList<Account> getAccounts();

    Account getAccountByID(int id);

    Account getAccountByName(String name);

    ArrayList<String> getAccountNames();
}
