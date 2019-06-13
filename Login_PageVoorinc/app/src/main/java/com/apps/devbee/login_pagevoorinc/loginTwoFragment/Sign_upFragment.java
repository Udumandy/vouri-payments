package com.apps.devbee.login_pagevoorinc.loginTwoFragment;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.Gestures;
import com.apps.devbee.login_pagevoorinc.MainActivity;
import com.apps.devbee.login_pagevoorinc.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sign_upFragment extends Fragment implements AdapterView.OnItemSelectedListener{
        Button sign_up_button_two, butt;
        int i = 0;

    public Sign_upFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sign_up, container, false);

        Spinner sp = (Spinner)v.findViewById(R.id.Spinner);
        if(sp != null){
            sp.setOnItemSelectedListener(this);
        }
        Calendar cl = Calendar.getInstance();
        final int hour = cl.get(Calendar.HOUR_OF_DAY);
        final int min = cl.get(Calendar.MINUTE);

        final int year = cl.get(Calendar.YEAR);
        final int month = cl.get(Calendar.MONTH);
        final int day = cl.get(Calendar.DATE);

        butt = (Button)v.findViewById(R.id.butt);

        butt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DatePickerDialog dp = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayOfMonth, int month, int year) {
                        String date = ("Date set to "+dayOfMonth+"/"+month+"/"+year);
                        Toast.makeText(getContext(),date,Toast.LENGTH_LONG).show();
                    }
                },year,month,day);
                dp.show();
                return false;
            }
        });

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg ="LongClick to sst date";
                Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
                TimePickerDialog tp = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofday, int minute) {
                        String time =("Time set to "+hourofday+":"+minute);
                        Toast.makeText(getContext(),time,Toast.LENGTH_LONG).show();
                    }
                }, hour,min,false);
                tp.show();
            }
        });

        sign_up_button_two =(Button) v.findViewById(R.id.sign_up_button_two);
        sign_up_button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i == 1) {
                            Toast.makeText(getContext(),"DoubleClick for gestures",Toast.LENGTH_LONG).show();
                            AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
                            alertDialog.setTitle("Dialogbox Title");
                            alertDialog.setView(getLayoutInflater().inflate(R.layout.dialogbox, null));
                            alertDialog.setMessage("Message set @setMessage or @setView");

                            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getContext(), "Cancel", Toast.LENGTH_LONG).show();
                                }
                            });

                            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Enter", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getContext(), "Enter", Toast.LENGTH_LONG).show();
                                }
                            });

                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ignore", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getContext(), "Ignore", Toast.LENGTH_LONG).show();
                                }
                            });
                            alertDialog.show();
                        } else if (i == 2) {
                            Intent in = new Intent(getContext(), Gestures.class);
                            startActivity(in);
                        }
                        i = 0;
                    }
                    },500);
                        }
                });
        return  v;
    }

    public void openDialog(){

    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id){
        String sp = adapterView.getItemAtPosition(pos).toString();
        Toast.makeText(getActivity(),sp,Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> adapterView){

    }

}
