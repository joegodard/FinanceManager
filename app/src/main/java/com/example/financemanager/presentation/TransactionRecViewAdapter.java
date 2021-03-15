package com.example.financemanager.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financemanager.R;
import com.example.financemanager.objects.Account;
import com.example.financemanager.objects.Transaction;

import java.util.ArrayList;

public class TransactionRecViewAdapter extends RecyclerView.Adapter<TransactionRecViewAdapter.ViewHolder> {

    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Context mContext;
    private String origin;
    private int accountID;

    public TransactionRecViewAdapter(Context mContext, String origin, int accountID){
        this.mContext = mContext;
        this.origin = origin;
        this.accountID = accountID;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(transactions.get(position).getDate());
        holder.account.setText(transactions.get(position).getAccount().getName());
        holder.item.setText(transactions.get(position).getItem());
        holder.amount.setText("$" + transactions.get(position).getAmount());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TransactionInfo.class);
                intent.putExtra("AccountID", accountID);
                intent.putExtra("Origin", origin);
                intent.putExtra("TransactionID", transactions.get(position).getTransactionID());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public void setTransactions(ArrayList<Transaction> transactions){
        this.transactions = transactions;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView date, account, item, amount;
        private CardView parent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.txtTransactionDate);
            account = itemView.findViewById(R.id.txtAccountName);
            item = itemView.findViewById(R.id.txtTransactionItem);
            amount = itemView.findViewById(R.id.txtTransactionAmount);

            parent = itemView.findViewById(R.id.transactionsCardView);

        }
    }
}
