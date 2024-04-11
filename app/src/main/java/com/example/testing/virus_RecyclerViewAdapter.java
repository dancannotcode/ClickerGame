package com.example.testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class virus_RecyclerViewAdapter extends RecyclerView.Adapter<virus_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<virusModel> virusModel;
    public virus_RecyclerViewAdapter(Context context, ArrayList<virusModel> virusModel){
        this.context = context;
        this.virusModel = virusModel;
    }

    @NonNull
    @Override
    public virus_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflates layout and gives the rows the look
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent,false);
        return new virus_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull virus_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //makes the rows go in the correct place after scrolling
        holder.imageView.setImageResource(virusModel.get(position).getImage());
        holder.virusName.setText(virusModel.get(position).getVirusName());

    }

    @Override
    public int getItemCount() {
        //how many items are there total
        return virusModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView virusName;
        //does the creating of the rows
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.virusImageCollection);
            virusName = itemView.findViewById(R.id.virusNameCollection);
        }
    }
}
