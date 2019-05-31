package com.apps.devbee.login_pagevoorinc.Card_Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.devbee.login_pagevoorinc.R;

import java.util.List;

public class Card_adapter  extends RecyclerView.Adapter<Card_adapter.ViewHolder> {
    List<Model> modelList;
    Context context;

    public Card_adapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext () ).inflate (R.layout.item_card_design ,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String name = modelList.get(i).getName();
        viewHolder.setname(name);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.card_user_name);
        }
        public void setname(String name){
            textView.setText(name);
        }
    }
}
