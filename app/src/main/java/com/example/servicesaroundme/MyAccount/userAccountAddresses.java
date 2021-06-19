package com.example.servicesaroundme.MyAccount;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.location.Address;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.servicesaroundme.R;
import com.example.servicesaroundme.UtilityFunctions.cardViewAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link userAccountAddresses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class userAccountAddresses extends Fragment {

    Boolean isRotate = false;
    private ArrayList<AddressBook> myAddressBook = new ArrayList<>();
    RecyclerView.Adapter adapter;
    //private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("AddressBook/14lPnJEl22rfR5toUfyz");
    private CollectionReference mColRef = FirebaseFirestore.getInstance().collection("AddressBook");

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public userAccountAddresses() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment userAccountBillingInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static userAccountAddresses newInstance(String param1, String param2) {
        userAccountAddresses fragment = new userAccountAddresses();
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

        View tmpView = inflater.inflate(R.layout.fragment_user_account_addresses, container, false);

        FloatingActionButton fabAddAddress = tmpView.findViewById(R.id.fabAddAddress);
        FloatingActionButton fabAddDelAddress = tmpView.findViewById(R.id.fabAddAddress_Del);
        FloatingActionButton fabAddBillAddress = tmpView.findViewById(R.id.fabAddAddress_Bill);

        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        recyclerView = tmpView.findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter and pass in our data model list
        adapter = new cardViewAdapter(myAddressBook, getContext());
        recyclerView.setAdapter(adapter);

        loadUserAddressBook();

        init(fabAddDelAddress);
        init(fabAddBillAddress);
        fabAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRotate = rotateFab(fabAddAddress,!isRotate);

                if(isRotate){
                    showIn(fabAddDelAddress);
                    showIn(fabAddBillAddress);
                }else{
                    showOut(fabAddDelAddress);
                    showOut(fabAddBillAddress);
                }
            }
        });
        fabAddBillAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAddress();
            }
        });
        fabAddDelAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Inflate the layout for this fragment
        return tmpView;
    }

    private void inputAddress() {

    }

    public void loadUserAddressBook() {
        // load from Firestore
        mColRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Toast.makeText(getContext(), "Document does exist - " + queryDocumentSnapshots.size(), Toast.LENGTH_LONG).show();
                for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots){
                    AddressBook address = documentSnapshot.toObject(AddressBook.class);
                    address.setAddressId(documentSnapshot.getId());
                    myAddressBook.add(address);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        mColRef.get().addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(getContext(), "Failed to load data", Toast.LENGTH_LONG).show();
            }
        });
        // To fetch document there are following methods
        // 1st Method
        //nickName = documentSnapshot.getString("NickName");
        // 2nd Method
        //Map<String,Object> myData = documentSnapshot.getData();
        // 3rd Method
        //AddressBook address = documentSnapshot.toObject(AddressBook.class);
    }

    public void saveAddress(View view){

    }

    // HELPER Functions for Fab Button
    public static boolean rotateFab(final View v, boolean rotate) {
        v.animate().setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .rotation(rotate ? 135f : 0f);
        return rotate;
    }
    public static void showIn(final View v) {
        v.setVisibility(View.VISIBLE);
        v.setAlpha(0f);
        v.setTranslationY(0);
        v.animate()
                .setDuration(200)
                .translationY(80)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .alpha(1f)
                .start();
    }
    public static void showOut(final View v) {
        v.setVisibility(View.VISIBLE);
        v.setAlpha(1f);
        v.setTranslationY(80);
        v.animate()
                .setDuration(200)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        v.setVisibility(View.GONE);
                        super.onAnimationEnd(animation);
                    }
                }).alpha(0f)
                .start();
    }
    public static void init(final View v) {
        v.setVisibility(View.GONE);
        v.setTranslationY(v.getHeight());
        v.setAlpha(0f);
    }

    public static class AddressBook {
        private String AddressId, AddressTypeID, UserID, StatusID;
        private String NickName;
        private String Line1;
        private String Line2;
        private String City;
        private String Country;
        private String Postcode;
        private String Phone;
        private String Instructions;

        public AddressBook() { }
        public AddressBook(String addressId,
                           String addressTypeID,
                           String userID,
                           String statusID,
                           String nickName,
                           String line1,
                           String line2,
                           String city,
                           String country,
                           String postcode,
                           String phone,
                           String instructions) {
            AddressId = addressId;
            AddressTypeID = addressTypeID;
            UserID = userID;
            StatusID = statusID;
            NickName = nickName;
            Line1 = line1;
            Line2 = line2;
            City = city;
            Country = country;
            Postcode = postcode;
            Phone = phone;
            Instructions = instructions;
        }

        public String getAddressId() {
            return AddressId;
        }
        public void setAddressId(String addressId) {
            AddressId = addressId;
        }
        public String getAddressTypeId() {
            return AddressTypeID;
        }
        public void setAddressTypeId(String addressTypeId) {
            AddressTypeID = addressTypeId;
        }
        public String getUserId() {
            return UserID;
        }
        public void setUserId(String userId) {
            UserID = userId;
        }
        public String getStatusId() {
            return StatusID;
        }
        public void setStatusId(String statusId) {
            StatusID = statusId;
        }
        public String getNickName() {
            return NickName;
        }
        public void setNickName(String nickName) {
            NickName = nickName;
        }
        public String getLine1() {
            return Line1;
        }
        public void setLine1(String line1) {
            Line1 = line1;
        }
        public String getLine2() {
            return Line2;
        }
        public void setLine2(String line2) {
            Line2 = line2;
        }
        public String getCity() {
            return City;
        }
        public void setCity(String city) {
            City = city;
        }
        public String getCountry() {
            return Country;
        }
        public void setCountry(String country) {
            Country = country;
        }
        public String getPostcode() {
            return Postcode;
        }
        public void setPostcode(String postcode) {
            Postcode = postcode;
        }
        public String getPhone() {
            return Phone;
        }
        public void setPhone(String phone) {
            Phone = phone;
        }
        public String getInstructions() { return Instructions; }
        public void setInstructions(String instructions) { Instructions = instructions; }
    }
}
// BELOW IS ONLY FOR TEST - REPLACE IT WITH THE DATA FROM FIRESTORE
//        for (int i = 1; i <= 5; i++) {
//            myAddressBook.add(new AddressBook("AddressId" + i,
//                    "AddressTypeId",
//                    "UserId",
//                    "StatusId",
//                    "NickName",
//                    "Line1",
//                    "Line2",
//                    "city",
//                    "country",
//                    "Postcode",
//                    "phone" ));
//        }

//Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
