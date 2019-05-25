package com.apps.devbee.login_pagevoorinc.loginTwoFragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.LoginActivity;
import com.apps.devbee.login_pagevoorinc.MainActivity;
import com.apps.devbee.login_pagevoorinc.R;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    Button login_button_two;
    EditText login_editTextPassword;
    EditText loginEditTextEmail;
    String passwordsize;
    String email;
    int TEXT_REQUEST=1;
    final static String EXTRA_REPLY="2";


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_login, container, false);
        login_button_two=v.findViewById(R.id.login_button_two);
        login_editTextPassword=v.findViewById(R.id.editText);
        loginEditTextEmail=v.findViewById(R.id.editText2);
         passwordsize = login_editTextPassword.getText().toString();
        email = loginEditTextEmail.getText().toString();

        login_button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i,TEXT_REQUEST);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==TEXT_REQUEST){
            if (requestCode==RESULT_OK){
                Uri reply =data.getData();
                Toast.makeText(getContext()," " +reply,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getContext()," no data to reply",Toast.LENGTH_LONG).show();
            }
        }
    }
}
