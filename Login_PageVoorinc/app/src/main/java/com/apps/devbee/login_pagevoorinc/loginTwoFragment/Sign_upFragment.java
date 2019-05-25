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

import com.apps.devbee.login_pagevoorinc.MainActivity;
import com.apps.devbee.login_pagevoorinc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sign_upFragment extends Fragment {
        Button sign_up_button_two;
        EditText signupEditText;

    public Sign_upFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sign_up, container, false);
        sign_up_button_two=v.findViewById(R.id.sign_up_button_two);
        signupEditText=v.findViewById(R.id.editText3);
        sign_up_button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String pasword = signupEditText.getText().toString();
                Intent gotohome=new Intent(getActivity(),MainActivity.class);
                getActivity().startActivity(gotohome);
                gotohome.putExtra("password",pasword);*/

                Uri uri= Uri.parse("https;//www.google.com");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }
        });
        return  v;
    }

}
