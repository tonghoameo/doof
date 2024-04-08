package com.bb.food.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.food.MainActivity;
import com.bb.food.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {
    Button logBtn;
    TextView reg;
    EditText  email, password;

    FirebaseFirestore firestore;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.loginemail);
        password = findViewById(R.id.loginpassword);
        logBtn  = findViewById(R.id.logBtn);
        reg  = findViewById(R.id.login2reg);
    }
    public void register(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }
    public void mainActivity(View view) {

        String mail  = email.getText().toString();
        String passwd  = password.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(mail,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                FirebaseUser currUser = firebaseAuth.getCurrentUser();
                firestore.collection("users_food").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot ds: task.getResult()){
                            String email = ds.getString("email");
                            Long check = ds.getLong("role");
                            if (email.equals(currUser.getEmail()))
                            {
                                if(check == 1 ){
                                    startActivity(new Intent( LoginActivity.this, MainActivity.class ));
                                }else{
                                    Toast.makeText(LoginActivity.this, "heck admin to get role", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });

            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        //startActivity(new Intent( LoginActivity.this, MainActivity.class ));
    }
}