package com.example.financemanager.business;

import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ITransactionActions {

    void addToTransactions(Transaction transaction);

    void updateTransaction(Transaction transaction);

    void removeTransaction(Transaction transaction);

    Transaction getTransaction(int position);

    ArrayList<Transaction> getTransactions();

    ArrayList<Transaction> getAccountTransactions(Account account);

    Account getAccountByID(int id);
}
