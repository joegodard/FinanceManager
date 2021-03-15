package com.example.financemanager.persistence;

import com.example.financemanager.objects.Account;

import java.util.ArrayList;

public class FakeAccountsDB implements IAccountsDB{

    private ArrayList<Account> accountsList;
    private static int nextID = 0;

    public FakeAccountsDB(){
        accountsList = new ArrayList<Account>();
    }

    @Override
    public void addToAccounts(Account account) {
        accountsList.add(account);
        nextID++;
    }

    @Override
    public Account removeFromAccounts(Account account) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {
        Account oldAccount = getAccountByID(account.getAccountID());
        oldAccount.setBalance(account.getBalance());
        oldAccount.setBank(account.getBank());
        oldAccount.setName(account.getName());
        oldAccount.setType(account.getType());
    }

    @Override
    public ArrayList<Account> getAccounts() {
        return accountsList;
    }

    @Override
    public Account getAccountByID(int id) {
        Account account = null;
        for (Account x:accountsList) {
            if(x.getAccountID() == id)
                account = x;
        }
        return account;
    }

    @Override
    public Account getAccountByName(String name) {
        Account account = null;
        for (Account x:accountsList) {
            if(x.getName().equals(name))
                account = x;
        }
        return account;
    }

    @Override
    public int getNextID() {
        return nextID;
    }
}
