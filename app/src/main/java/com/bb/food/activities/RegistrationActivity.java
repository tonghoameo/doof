package com.bb.food.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bb.food.MainActivity;
import com.bb.food.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void SignIn(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent( RegistrationActivity.this, MainActivity.class ));
    }
}