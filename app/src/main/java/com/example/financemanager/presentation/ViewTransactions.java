package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.financemanager.R;
import com.example.financemanager.business.ITransactionActions;
import com.example.financemanager.business.TransactionActions;
import com.example.financemanager.objects.Transaction;

import java.util.ArrayList;

public class ViewTransactions extends AppCompatActivity {

    private ITransactionActions transactionActions = new TransactionActions();
    private RecyclerView transactionsRecView;
    private TransactionRecViewAdapter adapter;
    private Button btnAddTransaction, btnToAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);

        transactionsRecView = findViewById(R.id.transactionsRecView);
        adapter = new TransactionRecViewAdapter(this);
        btnAddTransaction = findViewById(R.id.btnAddTransaction);
        btnToAccount = findViewById(R.id.btnToAccounts);

        Intent intent = getIntent();
        String accountName = intent.getStringExtra("Account");
        String origin = intent.getStringExtra("Origin");

        ArrayList<Transaction> transactions = new ArrayList<>();

        if(accountName.equals("All")){
            transactions = transactionActions.getTransactions();
            btnToAccount.setText("To Accounts");
        }

        btnToAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                if(origin.equals("All")){
                    intent = new Intent(ViewTransactions.this, AccountSummary.class);
                }
                startActivity(intent);
            }
        });

        transactionsRecView.setAdapter(adapter);
        transactionsRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setTransactions(transactions);

    }
}