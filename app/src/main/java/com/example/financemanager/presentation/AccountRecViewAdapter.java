package com.example.financemanager.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financemanager.R;
import com.example.financemanager.objects.Account;

import java.util.ArrayList;

public class AccountRecViewAdapter extends RecyclerView.Adapter<AccountRecViewAdapter.ViewHolder> {

    private ArrayList<Account> accounts = new ArrayList<Account>();
    private Context mContext;

    public AccountRecViewAdapter(Context mContext){this.mContext = mContext;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bank.setText(accounts.get(position).getBank());
        holder.name.setText(accounts.get(position).getName());
        holder.balance.setText("$" + accounts.get(position).getBalance());

        holder.downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accounts.get(position).setExpanded(true);
                notifyItemChanged(position);
            }
        });

        holder.upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accounts.get(position).setExpanded(false);
                notifyItemChanged(position);
            }
        });

        if(accounts.get(position).isExpanded()){
            holder.expandedLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
            holder.upArrow.setVisibility(View.VISIBLE);
        }
        else{
            holder.expandedLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
            holder.upArrow.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public void setAccounts(ArrayList<Account> accounts){
        this.accounts = accounts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView bank, name, balance;
        private LinearLayout expandedLayout;
        private ImageView downArrow, upArrow;
        private Button btnMoreInfo, btnAccountActivity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bank = itemView.findViewById(R.id.txtBankName);
            name = itemView.findViewById(R.id.txtAccountName);
            balance = itemView.findViewById(R.id.txtAccountBalance);

            expandedLayout = itemView.findViewById(R.id.accountCardViewExpanded);

            downArrow = itemView.findViewById(R.id.accountDownArrow);
            upArrow = itemView.findViewById(R.id.accountUpArrow);

            btnMoreInfo = itemView.findViewById(R.id.btnAccountMoreInfo);
            btnAccountActivity = itemView.findViewById(R.id.btnAccountActivity);
        }
    }
}
