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

public class EditTransaction extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ITransactionActions transactionActions = new TransactionActions();
    IAccountActions accountActions = new AccountActions();

    private EditText editDate, editItem, editAmount;
    private Spinner pickAccount;
    private Button btnCancel, btnSubmit;

    private Account account;

    ArrayList<String> accountNames = accountActions.getAccountNames();
    private boolean accountSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_transaction);


        Intent prevIntent = getIntent();
        int accountID = prevIntent.getIntExtra("AccountID", -1);
        int transactionID = prevIntent.getIntExtra("TransactionID", -1);
        String origin = prevIntent.getStringExtra("Origin");

        Transaction transaction = transactionActions.getTransactionByID(transactionID);
        Account originalAccount = transaction.getAccount();

        initViews();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, accountNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pickAccount.setAdapter(adapter);
        pickAccount.setOnItemSelectedListener(this);

        setData(transaction);

        Intent intent = new Intent(EditTransaction.this, TransactionInfo.class);
        intent.putExtra("TransactionID", transactionID);
        intent.putExtra("AccountID", accountID);
        intent.putExtra("Origin", origin);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(accountSelected){
                    updateTransaction(transaction, originalAccount);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(EditTransaction.this, "Please select an account.", Toast.LENGTH_SHORT).show();
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

    private void updateTransaction(Transaction transaction, Account original){
        transaction.setDate(editDate.getText().toString());
        transaction.setItem(editItem.getText().toString());
        double originalAmount = transaction.getAmount();
        double change = Double.parseDouble(editAmount.getText().toString()) - originalAmount;
        transaction.setAmount(Double.parseDouble(editAmount.getText().toString()));
        transaction.setAccount(account);
        if(original.equals(transaction.getAccount())){
            accountActions.updateAccountBalance(account, change);
        }
        else{
            accountActions.updateAccountBalance(original, -(originalAmount));
            accountActions.updateAccountBalance(account, transaction.getAmount());
        }
    }

    private void setData(Transaction transaction){
        editDate.setText(transaction.getDate());
        editItem.setText(transaction.getItem());
        editAmount.setText("" + transaction.getAmount());
        pickAccount.setSelection(getAccountNamePos(accountNames, transaction.getAccount().getName()));
    }

    private int getAccountNamePos(ArrayList<String> list, String name){
        int position = -1;
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).equals(name))
                position = i;
        }
        return position;
    }

    private void initViews(){
        editDate = findViewById(R.id.editTransactionDate);
        editItem = findViewById(R.id.editTransactionItem);
        editAmount = findViewById(R.id.editTransactionAmount);

        pickAccount = findViewById(R.id.spinnerEditAccount);

        btnCancel = findViewById(R.id.btnEditTransactionCancel);
        btnSubmit = findViewById(R.id.btnEditTransactionSubmit);
    }
}