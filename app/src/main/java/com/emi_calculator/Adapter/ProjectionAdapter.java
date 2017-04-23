package com.emi_calculator.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emi_calculator.R;
import com.emi_calculator.R2;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Niharika Rastogi on 23-04-2017.
 */

public class ProjectionAdapter extends RecyclerView.Adapter<ProjectionAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<String> sno, tenure, emi, total;

    public ProjectionAdapter(Context context, ArrayList<String> sno, ArrayList<String> tenure, ArrayList<String> emi, ArrayList<String> total) {
        this.mContext = context;
        this.sno = sno;
        this.tenure = tenure;
        this.emi = emi;
        this.total = total;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_projection, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return sno.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.sno)
        TextView sno;

        @BindView(R2.id.tenure)
        TextView tenure;

        @BindView(R2.id.emi)
        TextView emi;

        @BindView(R2.id.total)
        TextView total;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
