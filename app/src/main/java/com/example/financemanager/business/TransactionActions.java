package com.example.financemanager.business;

import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;
import com.example.financemanager.persistence.DBManager;

import java.util.ArrayList;

public class TransactionActions implements ITransactionActions{
    @Override
    public void addToTransactions(Transaction transaction) {
        transaction.setTransactionID(DBManager.getTransactionsDB().getNextID());
        DBManager.getTransactionsDB().addToTransactions(transaction);
    }

    @Override
    public void updateTransaction(Transaction transaction) {

    }

    @Override
    public void removeTransaction(Transaction transaction) {

    }

    @Override
    public Transaction getTransaction(int position) {
        return DBManager.getTransactionsDB().getAllTransactions().get(position);
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return DBManager.getTransactionsDB().getAllTransactions();
    }

    @Override
    public Transaction getTransactionByID(int id) {
        return DBManager.getTransactionsDB().getTransactionByID(id);
    }

    @Override
    public ArrayList<Transaction> getAccountTransactions(Account account) {
        return DBManager.getTransactionsDB().getAccountTransactions(account);
    }

    @Override
    public Account getAccountByID(int id) {
        return null;
    }
}
