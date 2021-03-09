package com.example.financemanager.business;

import com.example.financemanager.objects.Account;

public interface IAccountActions {

    void addToAccounts(Account account);

    void updateAccount(Account account);

    void removeAccount(Account account);
}