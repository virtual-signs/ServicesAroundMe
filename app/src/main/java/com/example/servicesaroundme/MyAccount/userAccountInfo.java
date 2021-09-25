package com.example.servicesaroundme.MyAccount;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.servicesaroundme.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ServerTimestamp;
import com.google.firebase.firestore.auth.User;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

@IgnoreExtraProperties

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link userAccountInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class userAccountInfo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private CollectionReference mColRef = FirebaseFirestore.getInstance().collection("UserAccounts");
    private DocumentReference mDocRef;
    Users currentUser;
    private @ServerTimestamp
    Date timeStamp;
    TextInputLayout txtFullName, txtMobile, txtEmailAdd, txtProfileTitle, txtProfileDesc, txtWebsite;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public userAccountInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment userAccountInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static userAccountInfo newInstance(String param1, String param2) {
        userAccountInfo fragment = new userAccountInfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tmpView = inflater.inflate(R.layout.fragment_user_account_info, container, false);

        // Find objects/hookups
        txtFullName = tmpView.findViewById(R.id.txtFullName);
        txtMobile = tmpView.findViewById(R.id.txtMobile);
        txtEmailAdd = tmpView.findViewById(R.id.txtEmail);
        txtProfileTitle = tmpView.findViewById(R.id.txtProfileTitle);
        txtProfileDesc = tmpView.findViewById(R.id.txtProfileDesc);
        txtWebsite = tmpView.findViewById(R.id.txtWebsite);

        mDocRef = mColRef.document(FirebaseAuth.getInstance().getCurrentUser().getUid());
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                currentUser = documentSnapshot.toObject(Users.class);
                loadDataInFrag();
            }
        });
        return tmpView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDocRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w("SaME_LOG", "Listen failed.", e);
                    return;
                }
                if (snapshot != null && snapshot.exists()) {
                    mDocRef.update("mobile", txtMobile.getEditText().getText().toString());
                    Log.d("SaME_LOG", "Current data: " + snapshot.getData());
//                    String fullName = txtFullName.getEditText().getText().toString();
//                    String firstName = fullName.substring(0,fullName.indexOf(" "));
//                    String lastName =fullName.substring(fullName.lastIndexOf(" "));
//
//                    Log.d("SaME_LOG", "Current data: " + firstName + " " + lastName);


//                    mDocRef.update(
//                            "firstName",  txtFullName.getEditText().getText().toString().substring(0,indexOf)),
//                            "middleName", .getEditText().getText().toString());
//                    mDocRef.update("lastName", .getEditText().getText().toString());
                    //mDocRef.update("mobile", txtMobile.getEditText().getText().toString());
//                    mDocRef.update("email", .getEditText().getText().toString());
//                    mDocRef.update("", .getEditText().getText().toString());


                    //updateUserObject();
                    //loadDataInFrag();
                } else {
                    Log.d("SaME_LOG", "Current data: null");
                }
            }
        });
    }

//  HELPER FUNCTIONS

    private void loadDataInFrag() {
        // load data in Fragment from Current USER object
        if(currentUser !=null) {
            txtFullName.getEditText().setText(currentUser.firstName + " " + currentUser.middleName + " " + currentUser.lastName);
            txtMobile.getEditText().setText(currentUser.mobile);
            txtEmailAdd.getEditText().setText(currentUser.email);
            txtProfileTitle.getEditText().setText(currentUser.profileTitle);
            txtProfileDesc.getEditText().setText(currentUser.profileDesc);
            txtWebsite.getEditText().setText(currentUser.website);
            txtWebsite.getEditText().setText(currentUser.statusId);
        }
    }

    private void updateUserObject (){
        if(currentUser !=null) {
            currentUser.setFirstName("First");
            currentUser.setFirstName("Second");
            currentUser.setMobile(txtFullName.getEditText().getText().toString());
        }
    }
}