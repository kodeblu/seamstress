package com.bencorp.theseamstress;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hp-pc on 3/19/2018.
 */

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    ArrayList<JobPending> arrayList = new ArrayList<>();
    private  OnTapListener onTapListener;
    Context context;
    RecyclerAdapter(ArrayList<JobPending> arrayList,Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        final JobPending jobs = arrayList.get(position);
        holder.name.setText(jobs.getName());
        holder.date.setText(jobs.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //if(onTapListener != null){
                   //onTapListener.onTapView(position);

                    Toast.makeText(context,"pos: "+jobs.getId(),Toast.LENGTH_LONG).show();
                //}
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setOnTapListener(OnTapListener onTapListener){
        this.onTapListener = onTapListener;
    }

    public  static  class RecyclerViewHolder extends  RecyclerView.ViewHolder{
        TextView name,price,measurement,date;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            date = (TextView) itemView.findViewById(R.id.date);
        }

    }

}
