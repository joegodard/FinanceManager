package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.financemanager.R;
import com.example.financemanager.business.ITransactionActions;
import com.example.financemanager.business.TransactionActions;
import com.example.financemanager.objects.Transaction;

public class TransactionInfo extends AppCompatActivity {

    ITransactionActions transactionActions = new TransactionActions();

    private TextView txtDate, txtAccount, txtItem, txtAmount;
    private Button btnBack, btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_info);

        Intent intent = getIntent();
        int transactionID = intent.getIntExtra("TransactionID", -1);
        int accountID = intent.getIntExtra("AccountID", -1);
        String origin = intent.getStringExtra("Origin");

        Transaction transaction = transactionActions.getTransactionByID(transactionID);

        initViews();
        setData(transaction);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransactionInfo.this, ViewTransactions.class);
                intent.putExtra("id", accountID);
                intent.putExtra("Origin", origin);
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setData(Transaction transaction){
        txtDate.setText(transaction.getDate());
        txtAccount.setText(transaction.getAccount().getName());
        txtItem.setText(transaction.getItem());
        txtAmount.setText("$" + transaction.getAmount());
    }

    private void initViews(){
        txtDate = findViewById(R.id.txtTransactionDate);
        txtAccount = findViewById(R.id.txtTransactionAccount);
        txtItem = findViewById(R.id.txtTransactionItem);
        txtAmount = findViewById(R.id.txtTransactionAmount);

        btnBack = findViewById(R.id.btnBackToTransactions);
        btnEdit = findViewById(R.id.btnEditTransaction);
    }
}