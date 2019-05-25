package com.apps.devbee.login_pagevoorinc;

import android.graphics.drawable.AnimationDrawable;
import android.os.PersistableBundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.loginTwoFragment.LoginFragment;
import com.apps.devbee.login_pagevoorinc.loginTwoFragment.Sign_upFragment;

public class LoginActivity extends AppCompatActivity {
    ViewPager login_two_viewpager;
    TabLayout tabLayout;
    ImageView logo_vouriinc;
    ProgressBar progressBar;
    int i =4;
    int j=10;
    int sum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_two);
        login_two_viewpager=findViewById(R.id.login_two_viewpager);
        setupViewPager(login_two_viewpager);
        tabLayout=findViewById(R.id.tabLayout);
        setupViewPager(login_two_viewpager);
        tabLayout.setupWithViewPager(login_two_viewpager);
        logo_vouriinc=findViewById(R.id.logo_vouriinc);
        progressBar=findViewById(R.id.login_progressBar);
        ConstraintLayout constraintLayout=findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        logo_vouriinc.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade));
        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("sum");

        }

    }

    public void setupViewPager(ViewPager viewPager){
        Bundle bundle = new Bundle();
        TabsAdapter tabsAdapter=new TabsAdapter(getSupportFragmentManager());
        tabsAdapter.addFragment(new LoginFragment(),"Login");
        tabsAdapter.addFragment(new Sign_upFragment(),"Sign up");
        viewPager.setAdapter(tabsAdapter);
        Toast.makeText(getApplicationContext(),"That is onresume" + sum,Toast.LENGTH_LONG).show();


    }

    public ImageView getLogo_vouriinc() {
        return logo_vouriinc;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }


}
