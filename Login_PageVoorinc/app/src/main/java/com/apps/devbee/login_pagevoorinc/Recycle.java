package com.apps.devbee.login_pagevoorinc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycle extends AppCompatActivity {

    RecyclerView recyclerView;
    TransactionsAdapter adapter;
    List<TransactionsModel> mList;
    ArrayList<TransactionsModel> mtext = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        setUp();
    }

    public void setUp(){
        mtext.add(new TransactionsModel(System.currentTimeMillis(), 500.5f, "USD",(short)1));
        mtext.add(new TransactionsModel(System.currentTimeMillis(), 200.5f, "EUR",(short)1));
        mtext.add(new TransactionsModel(System.currentTimeMillis(), 50.5f, "GBP",(short)0));
        mtext.add(new TransactionsModel(System.currentTimeMillis(), 400.5f, "EUR",(short)1));
        mtext.add(new TransactionsModel(System.currentTimeMillis(), 350.5f, "GBP",(short)0));
        recycler();
    }

    private void recycler(){
        recyclerView = findViewById(R.id.recycle);
        adapter = new TransactionsAdapter(this,mtext);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
