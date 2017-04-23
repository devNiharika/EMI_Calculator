package com.emi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.emi_calculator.Data.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R2.id.name)
    TextInputEditText name;
    @BindView(R2.id.email)
    TextInputEditText email;
    @BindView(R2.id.mob_no)
    TextInputEditText mobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.submit)
    void submit() {
        if (name.getText().toString().equals("")) {
            name.requestFocus();
            name.setError("Please enter your name!");
            return;
        } else if (mobile.getText().toString().equals("")) {
            mobile.requestFocus();
            mobile.setError("Please enter your mobile number!");
            return;
        } else if (email.getText().toString().equals("")) {
            email.requestFocus();
            email.setError("Please enter your email address!");
            return;
        }

        User user = new User();
        user.NAME = name.getText().toString();
        user.MOBILE_NUMBER = mobile.getText().toString();
        user.EMAIL = email.getText().toString();
        user.save();

        Log.d("LoginActivity", "Data Saved!");

        Log.d("Queries", user.QUERIES().toString());
        startActivity(new Intent(this, PrincipalInputActivity.class).putExtra("mobile", mobile.getText().toString()));
        finish();
    }
}
