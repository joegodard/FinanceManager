package com.example.financemanager.persistence;

import android.transition.TransitionManager;

import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

import java.util.ArrayList;

public interface ITransactionsDB {

    void addToTransactions(Transaction transaction);

    Transaction removeFromTransactions(Transaction transaction);

    void updateTransaction(Transaction transaction);

    ArrayList<Transaction> getAllTransactions();

    ArrayList<Transaction> getAccountTransactions(Account account);

    Transaction getTransactionByID(int id);

    int getNextID();
}
