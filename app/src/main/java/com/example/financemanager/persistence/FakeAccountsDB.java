package com.example.financemanager.persistence;

import com.example.financemanager.objects.Account;

import java.util.ArrayList;

public class FakeAccountsDB implements IAccountsDB{

    private ArrayList<Account> accountsList;

    public FakeAccountsDB(){
        accountsList = new ArrayList<Account>();
    }

    @Override
    public void addToAccounts(Account account) {
        accountsList.add(account);
    }

    @Override
    public Account removeFromAccounts(Account account) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public ArrayList<Account> getAccounts() {
        return accountsList;
    }

    @Override
    public Account getAccountByID(int id) {
        return null;
    }
}