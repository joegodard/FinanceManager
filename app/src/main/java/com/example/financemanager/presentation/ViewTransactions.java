package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.financemanager.R;
import com.example.financemanager.business.AccountActions;
import com.example.financemanager.business.IAccountActions;
import com.example.financemanager.business.ITransactionActions;
import com.example.financemanager.business.TransactionActions;
import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

import java.util.ArrayList;

public class ViewTransactions extends AppCompatActivity {

    private ITransactionActions transactionActions = new TransactionActions();
    private IAccountActions accountActions = new AccountActions();
    private RecyclerView transactionsRecView;
    private TransactionRecViewAdapter adapter;
    private TextView txtTitle;
    private Button btnAddTransaction, btnToAccount;

    private boolean fromAccountsSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);

        transactionsRecView = findViewById(R.id.transactionsRecView);
        adapter = new TransactionRecViewAdapter(this);
        btnAddTransaction = findViewById(R.id.btnAddTransaction);
        btnToAccount = findViewById(R.id.btnToAccounts);

        txtTitle = findViewById(R.id.txtViewTransactionsTitle);

        Intent intent = getIntent();
        int accountID = intent.getIntExtra("id", -1);
        String origin = intent.getStringExtra("Origin");

        ArrayList<Transaction> transactions;
        Account account = null;

        String allTest = "All";

        if(accountID == -1){
            transactions = transactionActions.getTransactions();
            txtTitle.setText("All Transactions");
        }
        else{
            account = accountActions.getAccountByID(accountID);
            transactions = transactionActions.getAccountTransactions(account);
            txtTitle.setText(account.getName() + " Transactions");
        }

        if(allTest.equals(origin)) {
            fromAccountsSummary = true;
            btnToAccount.setText("To Accounts");
        }
        else {
            fromAccountsSummary = false;
            btnToAccount.setText("To " + account.getName());
        }

        Account finalAccount = account;
        btnToAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                if(fromAccountsSummary){
                    intent = new Intent(ViewTransactions.this, AccountSummary.class);
                }
                else{
                    intent = new Intent(ViewTransactions.this, AccountInfo.class);
                    intent.putExtra("id", finalAccount.getAccountID());
                }
                startActivity(intent);
            }
        });

        Account finalAccount1 = account;
        btnAddTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTransactions.this, AddTransaction.class);
                if(finalAccount1 == null)
                    intent.putExtra("id", -1);
                else
                    intent.putExtra("id", finalAccount1.getAccountID());
                intent.putExtra("Origin", origin);
                startActivity(intent);
            }
        });

        transactionsRecView.setAdapter(adapter);
        transactionsRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setTransactions(transactions);
    }
}