package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.financemanager.R;
import com.example.financemanager.objects.Account;
import com.example.financemanager.persistence.DBManager;

import java.util.ArrayList;

public class AccountSummary extends AppCompatActivity {

    private RecyclerView accountsRecView;
    private AccountRecViewAdapter adapter;
    private Button btnAddAccount, btnAddTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_summary);

        adapter = new AccountRecViewAdapter(this);
        accountsRecView = findViewById(R.id.accountsRecView);
        btnAddAccount = findViewById(R.id.btnAddAccount);

        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountSummary.this, AddAccount.class);
                startActivity(intent);
            }
        });


        accountsRecView.setAdapter(adapter);
        accountsRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setAccounts(DBManager.getAccountsDB().getAccounts());
    }
}