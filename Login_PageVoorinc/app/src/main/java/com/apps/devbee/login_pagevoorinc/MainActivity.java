package com.apps.devbee.login_pagevoorinc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.fragment_des_page_de_navigation.DashFragment;
import com.apps.devbee.login_pagevoorinc.fragment_des_page_de_navigation.ProfileFragment;
import com.apps.devbee.login_pagevoorinc.fragment_des_page_de_navigation.Send_Remove_Fragment;

public class MainActivity extends AppCompatActivity {

    FrameLayout framelayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String intent = getIntent().getStringExtra("password");
        framelayout = findViewById(R.id.framelayout);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new DashFragment()).commit();
        Toast.makeText(getApplicationContext(),intent,Toast.LENGTH_LONG).show();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new DashFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new Send_Remove_Fragment();
                    break;
                case R.id.navigation_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectedFragment).commit();
            return true;
        }
    };

}
