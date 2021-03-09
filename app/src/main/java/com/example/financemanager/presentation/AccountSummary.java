package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.financemanager.R;
import com.example.financemanager.objects.Account;
import com.example.financemanager.persistence.DBManager;

import java.util.ArrayList;

public class AccountSummary extends AppCompatActivity {

    private RecyclerView accountsRecView;
    private AccountRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_summary);

        adapter = new AccountRecViewAdapter(this);
        accountsRecView = findViewById(R.id.accountsRecView);

        accountsRecView.setAdapter(adapter);
        accountsRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setAccounts(DBManager.getAccountsDB().getAccounts());
    }
}