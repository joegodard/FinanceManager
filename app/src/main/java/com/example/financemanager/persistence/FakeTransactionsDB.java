package com.example.financemanager.persistence;

import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

import java.util.ArrayList;

public class FakeTransactionsDB implements ITransactionsDB{

    private ArrayList<Transaction> transactionsList;
    private static int nextID = 0;

    public FakeTransactionsDB(){
        transactionsList = new ArrayList<Transaction>();
    }

    @Override
    public void addToTransactions(Transaction transaction) {
        transactionsList.add(transaction);
        nextID++;
    }

    @Override
    public Transaction removeFromTransactions(Transaction transaction) {
        return null;
    }

    @Override
    public void updateTransaction(Transaction transaction) {

    }

    @Override
    public ArrayList<Transaction> getAllTransactions() {
        return transactionsList;
    }

    @Override
    public ArrayList<Transaction> getAccountTransactions(Account account) {
        return null;
    }

    @Override
    public Transaction getTransactionByID(int id) {
        return null;
    }

    @Override
    public int getNextID() {
        return nextID;
    }
}
