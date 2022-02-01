package com.example.mytask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class main_adapter extends RecyclerView.Adapter<main_adapter.MyViewHolder> {
private static final String TAG = "adapter";

private List<item_model> list;
private Context context;
private boolean isNewTask;
        int size=0;
        int lastlist=0;

public main_adapter(List<item_model> list, Context con) {
        this.list = list;
        lastlist=list.size();
        this.context = con;
        this.isNewTask = isNewTask;

        }

@Override
public main_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new main_adapter.MyViewHolder(itemView);
        }

   /* @Override
    public void onBindViewHolder(@NonNull main_adapter holder, int position) {

    }*/


    @Override
public void onBindViewHolder(final main_adapter.MyViewHolder holder, final int position) {

        final item_model obj = list.get(position);
        holder.Tv_name.setText(obj.getName());
          holder.Tv_bid.setText(Double.toString(obj.getBid()));

        holder.Tv_ask.setText(Double.toString(obj.getAsk()));

if(position!=0) {
    if (obj.getBid() > list.get(position - 1).getBid()) {
        holder.laybid.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
    }else if (obj.getBid() == list.get(position - 1).getBid()){

    }else {
        holder.laybid.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
    }


    if (obj.getAsk() > list.get(position - 1).getAsk()) {
        holder.layask.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
    }else if(obj.getAsk() == list.get(position - 1).getAsk())
    {}else {
        holder.layask.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
    }
}


        }







@Override
public int getItemCount() {
        return list.size();
        }



public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private CardView taskCard;
    private TextView Tv_name, Tv_bid, Tv_ask;
    private LinearLayout laybid,layask;



    private MyViewHolder(View view) {
        super(view);
        taskCard = view.findViewById(R.id.task_card);


        Tv_name= view.findViewById(R.id.tv_name);
        Tv_bid= view.findViewById(R.id.tv_bid);
       Tv_ask = view.findViewById(R.id.tv_ask);


       laybid = view.findViewById(R.id.layout_bid);


        layask = view.findViewById(R.id.layout_ask);



        taskCard.setOnClickListener(this);
        // phone_id= view.findViewById(R.id.phone_id);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        Intent intent= new Intent(context, GraphActivity.class);
        intent.putExtra("name", list.get(position).getName());

        context.startActivity(intent);


    }

}





}

