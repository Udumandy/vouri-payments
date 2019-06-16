package com.apps.devbee.login_pagevoorinc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.fragment_des_page_de_navigation.FrameFragment;

public class MainActivity extends AppCompatActivity {

    FrameLayout framelayout;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String intent = getIntent().getStringExtra("password");
        //Toast.makeText(getApplicationContext(),intent,Toast.LENGTH_LONG).show();
        framelayout = findViewById(R.id.framelayout);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfer();
            }
        });

    }

    public void transfer(){
        Intent it = new Intent(this,TransactionDetailActivity.class);
        startActivity(it);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new FrameFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectedFragment).commit();
                    return true;
                case R.id.navigation_dashboard:
                    Uri uri = Uri.parse("tel:+17135692854");
                    Intent it = new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);
                    return true;
                case R.id.navigation_profile:
                    Uri ur = Uri.parse("http://www.google.com");
                    Intent in = new Intent(Intent.ACTION_VIEW,ur);
                    startActivity(in);
                    return true;
                case R.id.navigation_storage:
                    Intent tt = new Intent(Intent.ACTION_GET_CONTENT);
                    tt.setType("image/*");
                    startActivityForResult(tt,TEXT_REQUEST);
                    return true;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectedFragment).commit();


            return false;
        }
    };

    private static final int TEXT_REQUEST = 10;

    @Override
    protected void onPause() {
        super.onPause();
       // Toast.makeText(getApplicationContext(),"the value is " + (i+a),Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.order:
                Toast.makeText(this,"Order clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.status:

            case R.id.favorite:

            case R.id.contact:

            default:
        }
        return super.onOptionsItemSelected(item);
    }
}

