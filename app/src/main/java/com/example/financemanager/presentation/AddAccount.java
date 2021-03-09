package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.financemanager.R;
import com.example.financemanager.business.AccountActions;
import com.example.financemanager.business.IAccountActions;
import com.example.financemanager.objects.Account;

public class AddAccount extends AppCompatActivity {

    IAccountActions accountActions = new AccountActions();

    private EditText inputBank, inputName, inputType, inputBalance;

    private Button btnCancel, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        initViews();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddAccount.this, AccountSummary.class);
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account newAccount = initAccount();
                accountActions.addToAccounts(newAccount);
                Intent intent = new Intent(AddAccount.this, AccountSummary.class);
                startActivity(intent);
            }
        });
    }

    private Account initAccount(){
        String bank = inputBank.getText().toString();
        String name = inputName.getText().toString();
        String type = inputType.getText().toString();
        double balance = Double.parseDouble(inputBalance.getText().toString());
        return new Account(-1, name, bank, type, balance);
    }

    private void initViews(){
        inputBank = findViewById(R.id.inputAccountBank);
        inputName = findViewById(R.id.inputAccountName);
        inputType = findViewById(R.id.inputAccountType);
        inputBalance = findViewById(R.id.inputAccountBalance);

        btnCancel = findViewById(R.id.btnAddAccountCancel);
        btnSubmit = findViewById(R.id.btnAddAccountSubmit);
    }
}