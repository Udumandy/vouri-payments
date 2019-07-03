package com.apps.devbee.login_pagevoorinc;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.loginTwoFragment.LoginFragment;
import com.apps.devbee.login_pagevoorinc.loginTwoFragment.Sign_upFragment;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Integer>> {
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


    }

    @Override
    protected void onResume() {
        super.onResume();
        new AsyncTask<Integer, Void, Integer>() {

            @Override
            protected Integer doInBackground(Integer... integers) {
                int sums = 0;
                for (i = 0; i < 2000000; i++) {
                    sums += i;
                }
                    return sums;
                }

                @Override
                protected void onPostExecute (Integer integer){
                    super.onPostExecute(integer);
                    Toast.makeText(getApplicationContext(), "" +sum , Toast.LENGTH_SHORT).show();
                }

                @Override
                protected void onPreExecute () {
                    super.onPreExecute();
                }

                @Override
                protected void onProgressUpdate (Void...values){
                    super.onProgressUpdate(values);
                }
            }//.execute()
         ;

        getSupportLoaderManager().initLoader(0,new Bundle(), this);
        }
    public ImageView getLogo_vouriinc() {
        return logo_vouriinc;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    @NonNull
    @Override
    public Loader<List<Integer>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new StringListLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Integer>> loader, List<Integer> data) {
        Toast.makeText(this, "Operation Complete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {

    }

    public static class StringListLoader extends AsyncTaskLoader<List<Integer>> {


        public StringListLoader(@NonNull Context context) {
            super(context);
        }

        @Nullable
        @Override
        public List<Integer> loadInBackground() {
            List<Integer> list = new ArrayList<>(2000000);
            for(int y =0; y < 2000000; y++){
                list.add(y);
            }
            return list;
        }
    }

}
