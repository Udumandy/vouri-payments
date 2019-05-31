package com.apps.devbee.login_pagevoorinc.fragment_des_page_de_navigation;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.apps.devbee.login_pagevoorinc.Card_Adapter.Card_adapter;
import com.apps.devbee.login_pagevoorinc.Card_Adapter.Model;
import com.apps.devbee.login_pagevoorinc.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private static RecyclerView card_recycler;
    private static Card_adapter card_adapter;
    private static List<Model> modelList;
    private static CircleImageView profile_image;
    private static Uri mImageUri;
    private static ImageButton imageButton_profile;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        profile_image=v.findViewById(R.id.profile_image);
        card_recycler=v.findViewById ( R.id.card_recycler );
        imageButton_profile=v.findViewById(R.id.imageButton_profile);
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
        imageButton_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_imaghe();
            }
        });
        return v;
    }

    public void check_imaghe(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 555);
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start((Activity) getContext());
            }catch (Exception e){
                e.printStackTrace ();
            }
        } else {
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start((Activity) getContext());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                mImageUri = result.getUri();
                profile_image.setImageURI ( mImageUri );
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
