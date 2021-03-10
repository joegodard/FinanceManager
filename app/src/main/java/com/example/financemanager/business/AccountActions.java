package com.example.financemanager.business;

import com.example.financemanager.objects.Account;
import com.example.financemanager.persistence.DBManager;

public class AccountActions implements IAccountActions {
    @Override
    public void addToAccounts(Account account) {
        account.setAccountID(DBManager.getAccountsDB().getNextID());
        DBManager.getAccountsDB().addToAccounts(account);
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void removeAccount(Account account) {

    }

    @Override
    public Account getAccount(int position) {
        return DBManager.getAccountsDB().getAccounts().get(position);
    }
}
