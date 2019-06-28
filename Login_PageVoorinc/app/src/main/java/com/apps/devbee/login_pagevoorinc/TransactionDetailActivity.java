package com.apps.devbee.login_pagevoorinc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class TransactionDetailActivity extends AppCompatActivity {

    TextView tv, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv = findViewById(R.id.textView15);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigate();

            }
        });

        text = findViewById(R.id.tv);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabbed();
            }
        });
    }

    private void tabbed(){
        Intent in = new Intent(this,Tabs.class);
        startActivity(in);
    }

    private void navigate() {
        Intent it = new Intent(this,NavDrawer.class);
        startActivity(it);
    }

}
