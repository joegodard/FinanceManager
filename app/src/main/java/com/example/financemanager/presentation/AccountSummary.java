package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.financemanager.R;
import com.example.financemanager.business.AccountActions;
import com.example.financemanager.business.IAccountActions;
import com.example.financemanager.objects.Account;
import com.example.financemanager.persistence.DBManager;

import java.util.ArrayList;

public class AccountSummary extends AppCompatActivity {

    private IAccountActions accountActions = new AccountActions();
    private RecyclerView accountsRecView;
    private AccountRecViewAdapter adapter;
    private Button btnAddAccount, btnToTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_summary);

        adapter = new AccountRecViewAdapter(this);
        accountsRecView = findViewById(R.id.accountsRecView);
        btnAddAccount = findViewById(R.id.btnAddAccount);
        btnToTransactions = findViewById(R.id.btnToTransactions);

        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountSummary.this, AddAccount.class);
                startActivity(intent);
            }
        });

        btnToTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountSummary.this, ViewTransactions.class);
                intent.putExtra("id", -1);
                intent.putExtra("Origin", "All");
                startActivity(intent);
            }
        });

        accountsRecView.setAdapter(adapter);
        accountsRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setAccounts(accountActions.getAccounts());
    }
}