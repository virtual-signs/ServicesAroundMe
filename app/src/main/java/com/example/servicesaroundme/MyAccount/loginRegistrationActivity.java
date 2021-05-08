package com.example.servicesaroundme.MyAccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class loginRegistrationActivity extends AppCompatActivity {
    // 1-Define Objects
    FirebaseAuth obj_FirebaseAuth;
    private FirebaseAuth.AuthStateListener obj_AuthStateListener;
    //EditText obj_txtEmail, obj_txtPwd;
    //Button obj_btnLogin, obj_btnRegister;
    TextView tvHelp;

    TextInputLayout txtUserId, txtPassword;
    Button btnLogin, btnRegister;

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

        // Initialise & Setup FireBase Auth Listener for user account if already exists (pre-saved)
        obj_AuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = obj_FirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
//                    baseActivity.LOGIN_STATUS_FLAG = true;
                    setupPersonalisation();
                    Toast.makeText(loginRegistrationActivity.this, "Already logged in.", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(loginRegisterationActivity.this, homeActivity.class));
                    startActivity(new Intent(loginRegistrationActivity.this, baseActivity.class));
                } else {
                    Toast.makeText(loginRegistrationActivity.this, "Log in Please.", Toast.LENGTH_SHORT).show();
                }
            }
        };

        //3-create functions for objects
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUserId = txtUserId.getEditText().getText().toString();
                String strPassword = txtPassword.getEditText().getText().toString();

                if (strUserId.isEmpty()){
                    txtUserId.setError("Please enter a valid email address.");
                    txtUserId.requestFocus();
                }
                else if (strPassword.isEmpty()){
                    txtPassword.setError("Please enter a valid password.");
                    txtPassword.requestFocus();
                }
                else if (strUserId.isEmpty() && strPassword.isEmpty()){
                    Toast.makeText(loginRegistrationActivity.this, "Both Email & Password fields are empty. Please provide valid values.", Toast.LENGTH_SHORT).show();
                }
                else if (!(strUserId.isEmpty() || strPassword.isEmpty())){
                    obj_FirebaseAuth.createUserWithEmailAndPassword(strUserId, strPassword).addOnCompleteListener(loginRegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(loginRegistrationActivity.this, "Email Id is already registered.", Toast.LENGTH_SHORT).show();
                            }else{
//                                baseActivity.LOGIN_STATUS_FLAG = true;
                                setupPersonalisation();
//                                startActivity(new Intent(loginRegisterationActivity.this, homeActivity.class));
                                startActivity(new Intent(loginRegistrationActivity.this, baseActivity.class));
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(loginRegistrationActivity.this, "Unknown Error occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUserId = txtUserId.getEditText().getText().toString();
                String strPassword = txtPassword.getEditText().getText().toString();

                if (strUserId.isEmpty()){
                    txtUserId.setError("Please enter valid email addres");
                    txtUserId.requestFocus();
                }
                else if (strPassword.isEmpty()){
                    txtPassword.setError("Please provide valid password");
                    txtPassword.requestFocus();
                }
                else if (strUserId.isEmpty() && strPassword.isEmpty()){
                    Toast.makeText(loginRegistrationActivity.this, "Both Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(strUserId.isEmpty() && strPassword.isEmpty())) {
                    obj_FirebaseAuth.signInWithEmailAndPassword(strUserId, strPassword).addOnCompleteListener(loginRegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(loginRegistrationActivity.this, "Login Error, please try again", Toast.LENGTH_SHORT).show();
                            } else {
//                                baseActivity.LOGIN_STATUS_FLAG = true;
                                setupPersonalisation();
//                                startActivity(new Intent(loginRegisterationActivity.this, homeActivity.class));
                                startActivity(new Intent(loginRegistrationActivity.this, baseActivity.class));
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(loginRegistrationActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                }

                /*************************************************************************************/

                //Intent homeIntent = new Intent(loginRegisterationActivity.this, testMapsActivity.class);
                //Intent homeIntent = new Intent(loginRegisterationActivity.this, testActivity.class);
                //Intent homeIntent = new Intent(loginRegisterationActivity.this, homeActivity.class); // add class to open different page for testing

                //Intent homeIntent = new Intent(loginRegisterationActivity.this, homeActivity.class); // on Success, should open a HOME PAGE
                //startActivity(homeIntent);
            }
        });
    }
    protected void onStart()
    {
        super.onStart();
        obj_FirebaseAuth.addAuthStateListener(obj_AuthStateListener);
    }
    private void setupPersonalisation (){
//        baseActivity.LOGIN_STATUS_FLAG = true;
        // keep User Type in FireAuth database and fetch upon login
        //baseActivity.USER_TYPE = <fetch from fireauth db>;
//        baseActivity.USER_TYPE = 1;         // for testing User
//        baseActivity.USER_TYPE = 2;         // for testing Service Provider / Supplier
//        baseActivity.USER_TYPE = 9;         // for testing Admin

    }

}