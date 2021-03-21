package com.example.servicesaroundme.MyAccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesaroundme.CoreCapabilities.homeActivity;
import com.example.servicesaroundme.R;
import com.example.servicesaroundme.Testing.testActivity;
import com.example.servicesaroundme.Testing.testMapsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginRegisterationActivity extends AppCompatActivity {
    // 1-Define Objects
    FirebaseAuth obj_FirebaseAuth;
    private FirebaseAuth.AuthStateListener obj_AuthStateListener;

    EditText obj_txtEmail, obj_txtPwd;
    Button obj_btnLogin, obj_btnRegister;
    TextView tvHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registeration);

        //2-Find object by id
        obj_FirebaseAuth = FirebaseAuth.getInstance();
        obj_btnLogin = findViewById(R.id.btnLogin);
        obj_btnRegister = findViewById(R.id.btnRegister);
        obj_txtEmail = findViewById(R.id.txtEmailId);
        obj_txtPwd = findViewById(R.id.txtPassword);

        // Initialise & Setup FireBase Auth Listener for user account if already exists (pre-saved)
        obj_AuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = obj_FirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(loginRegisterationActivity.this, "Already logged in.", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(loginRegisterationActivity.this, homeActivity.class));
                    startActivity(new Intent(loginRegisterationActivity.this, testActivity.class));
                } else {
                    Toast.makeText(loginRegisterationActivity.this, "Log in Please.", Toast.LENGTH_SHORT).show();
                }
            }
        };

        //3-create functions for objects
        obj_btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail, strPwd;
                strEmail = obj_txtEmail.getText().toString();
                strPwd = obj_txtPwd.getText().toString();

                if (strEmail.isEmpty()){
                    obj_txtEmail.setError("Please enter a valid email address.");
                    obj_txtEmail.requestFocus();
                }
                else if (strPwd.isEmpty()){
                    obj_txtPwd.setError("Please enter a valid password.");
                    obj_txtPwd.requestFocus();
                }
                else if (strEmail.isEmpty() && strPwd.isEmpty()){
                    Toast.makeText(loginRegisterationActivity.this, "Both Email & Password fields are empty. Please provide valid values.", Toast.LENGTH_SHORT).show();
                }
                else if (!(strEmail.isEmpty() || strPwd.isEmpty())){
                    obj_FirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(loginRegisterationActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(loginRegisterationActivity.this, "Email Id is already registered.", Toast.LENGTH_SHORT).show();
                            }else{
                                startActivity(new Intent(loginRegisterationActivity.this, homeActivity.class));
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(loginRegisterationActivity.this, "Unknown Error occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

        obj_btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail, strPwd;
                strEmail = obj_txtEmail.getText().toString();
                strPwd = obj_txtPwd.getText().toString();

                if (strEmail.isEmpty()){
                    obj_txtEmail.setError("Please enter valid email addres");
                    obj_txtEmail.requestFocus();
                }
                else if (strPwd.isEmpty()){
                    obj_txtPwd.setError("Please provide valid password");
                    obj_txtPwd.requestFocus();
                }
                else if (strEmail.isEmpty() && strPwd.isEmpty()){
                    Toast.makeText(loginRegisterationActivity.this, "Both Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(strEmail.isEmpty() && strPwd.isEmpty())) {
                    obj_FirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(loginRegisterationActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(loginRegisterationActivity.this, "Login Error, please try again", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(loginRegisterationActivity.this, homeActivity.class));
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(loginRegisterationActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                }





                /*************************************************************************************/

                //Intent homeIntent = new Intent(loginRegisterationActivity.this, testMapsActivity.class);
                Intent homeIntent = new Intent(loginRegisterationActivity.this, testActivity.class);
                //Intent homeIntent = new Intent(loginRegisterationActivity.this, homeActivity.class); // add class to open different page for testing

                //Intent homeIntent = new Intent(loginRegisterationActivity.this, homeActivity.class); // on Success, should open a HOME PAGE
                startActivity(homeIntent);
            }
        });
    }
    protected void onStart()
    {
        super.onStart();
        obj_FirebaseAuth.addAuthStateListener(obj_AuthStateListener);
    }
}