package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.financemanager.R;
import com.example.financemanager.business.AccountActions;
import com.example.financemanager.business.IAccountActions;
import com.example.financemanager.objects.Account;

public class AccountInfo extends AppCompatActivity {

    IAccountActions accountActions = new AccountActions();

    private TextView txtBank, txtName, txtType, txtBalance;
    private Button btnBackToSummary, btnEditAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        Intent intent = getIntent();
        int itemID = intent.getIntExtra("id", -1);
        Account account = accountActions.getAccountByID(itemID);

        initViews();
        setData(account);

        btnBackToSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountInfo.this, AccountSummary.class);
                startActivity(intent);
            }
        });

        btnEditAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountInfo.this, EditAccount.class);
                intent.putExtra("id", account.getAccountID());
                startActivity(intent);
            }
        });
    }

    private void initViews(){
        txtBank = findViewById(R.id.txtAccountBankName);
        txtName = findViewById(R.id.txtAccountName);
        txtType = findViewById(R.id.txtAccountType);
        txtBalance = findViewById(R.id.txtAccountBalance);

        btnBackToSummary = findViewById(R.id.btnBackToSummary);
        btnEditAccount = findViewById(R.id.btnEditAccount);
    }

    private void setData(Account account){
        txtBank.setText(account.getBank());
        txtName.setText(account.getName());
        txtType.setText(account.getType());
        txtBalance.setText("$" + account.getBalance());
    }
}