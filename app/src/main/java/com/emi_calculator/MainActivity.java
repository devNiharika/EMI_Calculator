package com.emi_calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.emi_calculator.Data.Query;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R2.id.name)
    TextInputEditText name;
    @BindView(R2.id.email)
    TextInputEditText email;
    @BindView(R2.id.mob_no)
    TextInputEditText mobile;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_login:

                    return true;
                case R.id.navigation_principal:

                    return true;
                case R.id.navigation_projection:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        BottomNavigationView navigation = ButterKnife.findById(this, R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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

        Query query = new Query();
        query.NAME = name.getText().toString();
        query.MOBILE_NUMBER = mobile.getText().toString();
        query.EMAIL = email.getText().toString();
        query.save();

        Log.d("MainActivity", "Data Saved!");
    }
}
