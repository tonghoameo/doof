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
import com.bb.food.models.UserManagerFood;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistrationActivity extends AppCompatActivity {
    Button regBtn;
    TextView signin;
    EditText username, email, password;

    FirebaseFirestore firestore;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.regname);
        email = findViewById(R.id.regemail);
        password = findViewById(R.id.regpassword);
        regBtn  = findViewById(R.id.registerBtn);
        signin  = findViewById(R.id.regsignin);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

    }
    private void createUser(){
        String name  = username.getText().toString();
        String mail  = email.getText().toString();
        String passwd  = password.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(mail, passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    UserManagerFood userManagerFood = new UserManagerFood(name, mail,passwd);
                    String idUser = task.getResult().getUser().getUid();

                    firestore.collection("users_food").add(userManagerFood)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d("SUCCESS", "DocumentSnapshot added with ID: " + documentReference.getId());
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("FAILURE", "Error adding document", e);

                                }
                            });
                    Toast.makeText(RegistrationActivity.this, "Register success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void SignIn(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }

    public void mainActivity(View view) {
        
        startActivity(new Intent( RegistrationActivity.this, MainActivity.class ));
    }
}