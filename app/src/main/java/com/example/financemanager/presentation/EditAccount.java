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

public class EditAccount extends AppCompatActivity {

    IAccountActions accountActions = new AccountActions();

    private EditText editBank, editName, editType, editBalance;
    private Button btnCancel, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        Intent intent = getIntent();
        int accountID = intent.getIntExtra("id", -1);
        Account account = accountActions.getAccountByID(accountID);

        initViews();
        setData(account);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditAccount.this, AccountInfo.class);
                intent.putExtra("id", account.getAccountID());
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData(account);
                Intent intent = new Intent(EditAccount.this, AccountInfo.class);
                intent.putExtra("id", account.getAccountID());
                startActivity(intent);
            }
        });

    }

    private void initViews(){
        editBank = findViewById(R.id.editAccountBank);
        editName = findViewById(R.id.editAccountName);
        editType = findViewById(R.id.editAccountType);
        editBalance = findViewById(R.id.editAccountBalance);

        btnCancel = findViewById(R.id.btnEditAccountCancel);
        btnSubmit = findViewById(R.id.btnEditAccountSubmit);
    }

    private void setData(Account account){
        editBank.setText(account.getBank());
        editName.setText(account.getName());
        editType.setText(account.getType());
        editBalance.setText("" + account.getBalance());
    }

    private void updateData(Account account){
        String bank = editBank.getText().toString();
        String name = editName.getText().toString();
        String type = editType.getText().toString();
        double balance = Double.parseDouble(editBalance.getText().toString());
        Account newAccount = new Account(account.getAccountID(), name, bank, type, balance);
        accountActions.updateAccount(newAccount);
    }
}