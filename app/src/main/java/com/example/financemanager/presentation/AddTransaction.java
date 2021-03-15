package com.example.financemanager.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.financemanager.R;
import com.example.financemanager.business.AccountActions;
import com.example.financemanager.business.IAccountActions;
import com.example.financemanager.business.ITransactionActions;
import com.example.financemanager.business.TransactionActions;
import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

import java.util.ArrayList;

public class AddTransaction extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ITransactionActions transactionActions = new TransactionActions();
    IAccountActions accountActions = new AccountActions();

    private EditText inputDate, inputItem, inputAmount;
    private Spinner accountSpinner;
    private Button btnCancel, btnSubmit;
    private Account account;

    ArrayList<String> accountNames = accountActions.getAccountNames();
    boolean accountSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);


        Intent prevIntent = getIntent();
        int accountID = prevIntent.getIntExtra("id", -1);
        String origin = prevIntent.getStringExtra("Origin");
        initViews();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, accountNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountSpinner.setAdapter(adapter);
        accountSpinner.setOnItemSelectedListener(this);

        Intent intent = new Intent(AddTransaction.this, ViewTransactions.class);
        intent.putExtra("Origin", origin);

        if(accountID == -1){
            intent.putExtra("id", -1);
        }
        else{
            intent.putExtra("id", accountID);
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(accountSelected) {
                    Transaction newTransaction = initTransaction(account);
                    transactionActions.addToTransactions(newTransaction);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AddTransaction.this, "Please select an account.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String accountName = accountNames.get(position);
        account = accountActions.getAccountByName(accountName);
        accountSelected = true;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        accountSelected = false;
    }

    private Transaction initTransaction(Account account){
        String date = inputDate.getText().toString();
        String item = inputItem.getText().toString();
        double amount = Double.parseDouble(inputAmount.getText().toString());
        return new Transaction(-1, date, account, item, amount);
    }

    private void initViews(){
        inputDate = findViewById(R.id.inputAddTransactionDate);
        inputItem = findViewById(R.id.inputAddTransactionItem);
        inputAmount = findViewById(R.id.inputAddTransactionAmount);

        accountSpinner = findViewById(R.id.spinnerPickAccount);

        btnCancel = findViewById(R.id.btnAddTransactionCancel);
        btnSubmit = findViewById(R.id.btnAddTransactionSubmit);
    }
}