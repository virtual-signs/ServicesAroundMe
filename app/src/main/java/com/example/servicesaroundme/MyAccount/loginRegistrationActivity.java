package com.example.servicesaroundme.MyAccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesaroundme.CoreCapabilities.baseActivity;
import com.example.servicesaroundme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class loginRegistrationActivity extends AppCompatActivity {
    // 1-Define Objects
    FirebaseAuth obj_FirebaseAuth;
    private FirebaseAuth.AuthStateListener obj_AuthStateListener;
    private CollectionReference mColRef = FirebaseFirestore.getInstance().collection("UserAccounts");
    //EditText obj_txtEmail, obj_txtPwd;
    //Button obj_btnLogin, obj_btnRegister;
    TextView tvHelp;

    TextInputLayout txtUserId, txtPassword;
    Button btnLogin, btnRegister;
    RadioGroup rGrpUserType;
    RadioButton rBtnUserType;

    Integer intUserType;
    String strUserType;

    String errorMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registration);

        //2-Find object by id
        obj_FirebaseAuth = FirebaseAuth.getInstance();
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        txtUserId = findViewById(R.id.txtUserId);
        txtPassword = findViewById(R.id.txtPassword);
        rGrpUserType = findViewById(R.id.radioUserType);

        // Initialise & Setup FireBase Auth Listener for user account if pre-saved on the device
        obj_AuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = obj_FirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    startActivity(new Intent(loginRegistrationActivity.this, baseActivity.class));
                    //setupPersonalisation();
                    //Toast.makeText(loginRegistrationActivity.this, "Already logged in, loading User profile.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(loginRegistrationActivity.this, "Enter details to Login/Register.", Toast.LENGTH_LONG).show();
                }
            }
        };

        //3-create functions for objects

        // Upon "User Type" radio option selected:  verify input and store a value in public variable to pass it when user is registered or logged in
        rGrpUserType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                intUserType = rGrpUserType.getCheckedRadioButtonId();

                if(intUserType == R.id.userTypeCustomer){
                    strUserType = "/UserTypes/UTID0001";
                } else if(intUserType == R.id.userTypeServiceProvider){
                    strUserType = "/UserTypes/UTID0002";
                } else {
                    rBtnUserType = findViewById(intUserType);
                    Toast.makeText(loginRegistrationActivity.this, rBtnUserType.getText() + " Incorrect selection.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Upon "Register" button clicked:  validate inputs and then navigate to Base activity on success
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    obj_FirebaseAuth.createUserWithEmailAndPassword(
                            txtUserId.getEditText().getText().toString().trim(),
                            txtPassword.getEditText().getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // create object of the user & save placeholder for additional data to the Firestore
                                Users currentUser = new Users();
                                currentUser.setUserId(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                currentUser.setFirstName("First Name");
                                currentUser.setMiddleName("Middle Name");
                                currentUser.setLastName("Last Name");
                                currentUser.setProfileTitle("Profile Title");
                                currentUser.setProfileDesc("Profile Des");
                                currentUser.setEmail(txtUserId.getEditText().getText().toString().trim());
                                currentUser.setMobile("01234455678");
                                currentUser.setWebsite("www.user.com");
                                currentUser.setTypeId(strUserType);
                                currentUser.setStatusId("/Statuses/STID0041");

                                // store this user to the database table
                                mColRef.document(currentUser.userId).set(currentUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(loginRegistrationActivity.this, "Placeholder data entered", Toast.LENGTH_LONG).show();
                                            setupPersonalisation();
                                            startActivity(new Intent(loginRegistrationActivity.this, baseActivity.class));
                                        } else {
                                            // TODO: Choose on of the toast line
                                            Toast.makeText(loginRegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                            Toast.makeText(loginRegistrationActivity.this, "Error Occurred, unable to register an account.", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(loginRegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(loginRegistrationActivity.this, "Unknown Error occurred", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Upon login button clicked:  validate inputs and then navigate to base activity on success
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    obj_FirebaseAuth.signInWithEmailAndPassword(
                            txtUserId.getEditText().getText().toString().trim(),
                            txtPassword.getEditText().getText().toString()).addOnCompleteListener(loginRegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                setupPersonalisation();
                                startActivity(new Intent(loginRegistrationActivity.this, baseActivity.class));
                            } else {
                                Toast.makeText(loginRegistrationActivity.this, "Login Error, please try again.", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(loginRegistrationActivity.this, "Invalid inputs.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void onStart() {
        super.onStart();
        //obj_FirebaseAuth.addAuthStateListener(obj_AuthStateListener);
    }

    Boolean validateInputs() {
        // Input to validate & their criteria
        // - User Id: Non blank, valid email address
        // - password: non blank
        // - User Type: is selected - TODO

        Boolean validation = false;
        String strUserId = txtUserId.getEditText().getText().toString().trim();
        String strPassword = txtPassword.getEditText().getText().toString();

//        if (strUserType.isEmpty()){
//            Toast.makeText(loginRegistrationActivity.this, "Select User Type.", Toast.LENGTH_LONG).show();
//            rGrpUserType.requestFocus();
//        }

        if (strUserId.isEmpty()) {
            txtUserId.setError("Please enter valid email address");
            txtUserId.requestFocus();
        } else if (strPassword.isEmpty()) {
            txtPassword.setError("Please provide valid password");
            txtPassword.requestFocus();
        } else if (strUserId.isEmpty() && strPassword.isEmpty()) {
            txtUserId.setError("Please enter valid email address");
            txtPassword.setError("Please provide valid password");
            txtUserId.requestFocus();
        } else if (!(strUserId.isEmpty() && strPassword.isEmpty())) {
            validation = true;
        }
        return validation;
    }

    private void setupPersonalisation() {
//        baseActivity.LOGIN_STATUS_FLAG = true;
        // keep User Type in FireAuth database and fetch upon login
        //baseActivity.USER_TYPE = <fetch from fireauth db>;
//        baseActivity.USER_TYPE = 1;         // for testing User
//        baseActivity.USER_TYPE = 2;         // for testing Service Provider / Supplier
//        baseActivity.USER_TYPE = 9;         // for testing Admin
    }
}

/*************************************************************************************/

// To logout
// obj_FirebaseAuth.signOut();