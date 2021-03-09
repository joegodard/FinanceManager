package com.example.financemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.financemanager.persistence.DBManager;
import com.example.financemanager.presentation.AccountSummary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBManager.initialize();

        Intent intent = new Intent(MainActivity.this, AccountSummary.class);
        startActivity(intent);
    }
}