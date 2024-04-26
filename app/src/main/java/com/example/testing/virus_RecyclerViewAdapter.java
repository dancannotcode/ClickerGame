package com.example.testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/**
 * Adapter class for managing a RecyclerView that displays a list of viruses. This class
 * binds data from a collection of {@link virusModel} to views that are displayed within a RecyclerView.
 */
public class virus_RecyclerViewAdapter extends RecyclerView.Adapter<virus_RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<virusModel> virusModel;

    /**
     * Constructs the adapter with a specific context and a list of virus models.
     *
     * @param context the context where the adapter is being used
     * @param virusModel the data models representing each virus
     */
    public virus_RecyclerViewAdapter(Context context, ArrayList<virusModel> virusModel) {
        this.context = context;
        this.virusModel = virusModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflates the layout and assigns the appearance to the rows in the RecyclerView
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Binds the virus data to the row elements, ensuring they are displayed correctly
        holder.imageView.setImageResource(virusModel.get(position).getImage());
        holder.virusName.setText(virusModel.get(position).getVirusName());
    }

    @Override
    public int getItemCount() {
        // Returns the total number of items in the dataset
        return virusModel.size();
    }

    /**
     * ViewHolder class for the RecyclerView, holding references to the ImageView and TextView in each row.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView virusName;

        /**
         * Constructs the ViewHolder for the adapter, initializing UI components that will display virus data.
         *
         * @param itemView the root view of the row where data will be displayed
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.virusImageCollection);
            virusName = itemView.findViewById(R.id.virusNameCollection);
        }
    }
}
