package com.apps.devbee.login_pagevoorinc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.ViewHolder> {

    List<TransactionsModel> mytext;
    LayoutInflater mInflater;
    Context context;



    public TransactionsAdapter(Context context, ArrayList<TransactionsModel> list) {
        mInflater = LayoutInflater.from(context);
        mytext = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View item = mInflater.inflate(viewType,viewGroup,false);
        return new ViewHolder(item, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        //TransactionsModel model = (TransactionsModel) mlist.get(i);
        //viewHolder.textView.setText(""+model.getTransactionAmount());
        viewHolder.textView.setText(""+mytext.get(i).getTransactionAmount());
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return R.layout.cardrecycler1;
        return R.layout.cardrecycler2;
    }

    @Override
    public int getItemCount() {
        //return mlist.size();
        return mytext.size();
    }

    public Context getContext(){
        return context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TransactionsAdapter adapter;
        TextView textView;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView, TransactionsAdapter adapter) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView19);
            layout = itemView.findViewById(R.id.recyclerItemConstraintLayout);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.recyclerItemConstraintLayout:
                    Toast.makeText(this.adapter.getContext(), this.textView.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }


}
