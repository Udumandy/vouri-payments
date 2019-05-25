package com.apps.devbee.login_pagevoorinc.fragment_des_page_de_navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.devbee.login_pagevoorinc.Card_Adapter.Card_adapter;
import com.apps.devbee.login_pagevoorinc.Card_Adapter.Model;
import com.apps.devbee.login_pagevoorinc.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private static RecyclerView card_recycler;
    private static Card_adapter card_adapter;
    private static List<Model> modelList;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        card_recycler=v.findViewById ( R.id.card_recycler );
        modelList=new ArrayList<>(  );
        modelList.add ( new Model ( "Akah Larry") );
        modelList.add ( new Model ( "Ndeme Yvan" ) );
        modelList.add ( new Model ( "Kamdjou Duplex" ) );
        modelList.add ( new Model ( "King Kong" ) );
        modelList.add ( new Model ( "Kim K") );
        modelList.add ( new Model ( "Omega Rugal" ) );
        card_adapter=new Card_adapter (modelList,getActivity() );
        card_recycler.setAdapter ( card_adapter );
        card_recycler.setLayoutManager ( new LinearLayoutManager( getActivity(),LinearLayoutManager.HORIZONTAL ,false) );

        return v;
    }

}
