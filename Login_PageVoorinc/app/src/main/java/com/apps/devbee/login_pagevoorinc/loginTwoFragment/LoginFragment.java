package com.apps.devbee.login_pagevoorinc.loginTwoFragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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


    private android.view.ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater inflater = actionMode.getMenuInflater();
            inflater.inflate(R.menu.option,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.order:
                    Toast.makeText(getContext(),"order clicked",Toast.LENGTH_SHORT).show();

                case R.id.contact:
                    Toast.makeText(getContext(),"contact clicked",Toast.LENGTH_SHORT).show();

                case R.id.favorite:
                    Toast.makeText(getContext(),"favorite clicked",Toast.LENGTH_SHORT).show();

                case R.id.status:
                    Toast.makeText(getContext(),"status clicked",Toast.LENGTH_SHORT).show();

                    return true;
                    default:
                        return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    };

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

        login_button_two.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                getActivity().startActionMode(callback);
                return false;
            }
        });
        login_button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(),MainActivity.class);
                getActivity().startActivity(i);
                getActivity().finish();
            }
        });
        return v;
    }

    /*@Override
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
    }*/
}
