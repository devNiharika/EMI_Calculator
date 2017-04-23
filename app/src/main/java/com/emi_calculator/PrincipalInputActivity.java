package com.emi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Niharika Rastogi on 23-04-2017.
 */

public class PrincipalInputActivity extends AppCompatActivity {

    @BindView(R2.id.principal)
    TextInputEditText principal;
    @BindView(R2.id.tenure)
    TextInputEditText tenure;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_input);
        ButterKnife.bind(this);
        Log.d("PrincipalInputActivity", getIntent().getStringExtra("mobile"));
    }

    @OnClick(R2.id.calculate)
    void calculate() {
        if (principal.getText().toString().equals("")) {
            principal.requestFocus();
            principal.setError("Please enter the Principal!");
            return;
        } else if (tenure.getText().toString().equals("")) {
            tenure.requestFocus();
            tenure.setError("Please enter the Tenure!");
            return;
        }

        startActivity(new Intent(this, ProjectionActivity.class).putExtra("principal", principal.getText().toString()).putExtra("tenure", tenure.getText().toString()));
        finish();
    }
}
