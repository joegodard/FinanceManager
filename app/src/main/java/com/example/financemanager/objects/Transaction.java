package com.example.financemanager.objects;

public class Transaction {

    private int transactionID;
    private String date;
    private Account account;
    private String item;
    private double amount;

    public Transaction(int transactionID, String date, Account account, String item, double amount) {
        this.transactionID = transactionID;
        this.date = date;
        this.account = account;
        this.item = item;
        this.amount = amount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
