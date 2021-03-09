package com.example.financemanager.objects;

public class Account {

    private int accountID;
    private String name;
    private String bank;
    private String type;
    private int balance;

    public Account(int accountID, String name, String bank, String type, int balance) {
        this.accountID = accountID;
        this.name = name;
        this.bank = bank;
        this.type = type;
        this.balance = balance;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}