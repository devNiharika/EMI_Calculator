package com.emi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.emi_calculator.Adapter.ProjectionAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class ProjectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projection);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        int principal = Integer.parseInt(intent.getStringExtra("principal"));
        int tenure = Integer.parseInt(intent.getStringExtra("tenure"));

        int start = Math.max(0, tenure - 3);
        int end = tenure + 3;

        ArrayList<String> sno = new ArrayList<>();
        ArrayList<String> term = new ArrayList<>();
        ArrayList<String> emi = new ArrayList<>();
        ArrayList<String> total = new ArrayList<>();

        for (int i = 1, k = start; k <= end; k++, i++) {
            sno.add(String.valueOf(i));
            term.add(String.valueOf(k));
            emi.add(String.valueOf(emi(principal, k)));
            total.add(String.valueOf(emi(principal, k) * k));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = ButterKnife.findById(this, R.id.projection);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        ProjectionAdapter projectionAdapter = new ProjectionAdapter(this, sno, term, emi, total);
        recyclerView.setAdapter(projectionAdapter);
    }

    float emi(int principal, int tenure) {
        return (float) (principal * .03 * (Math.pow(1.03, tenure)) / ((Math.pow(1.03, tenure) - 1)));
    }
}

