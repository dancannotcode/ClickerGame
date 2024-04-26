package com.example.testing.ui.collectionTab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.testing.R;
import com.example.testing.databinding.FragmentCollectionBinding;
import com.example.testing.virusModel;
import com.example.testing.virus_RecyclerViewAdapter;
import java.util.ArrayList;
import java.util.Objects;

import com.example.testing.saveData;


public class collectionFragment extends Fragment{

    ArrayList<virusModel> virusModel = new ArrayList<>();
    private FragmentCollectionBinding binding;

    /**
     * Class that runs everything need immediately to make the page
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return the fragment
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCollectionBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * The class run when the page is created, it houses the layout inflater.
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        RecyclerView recyclerView = view.findViewById(R.id.virusRecyclerView);
        setVirusModel();
        virus_RecyclerViewAdapter adapter = new virus_RecyclerViewAdapter(getContext(),virusModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /**
     * This class handles what happens when the view is destroyed. As in the page is stopped.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * This class removes the top action bar when the page is pulled into focus.
     */
    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).hide();
    }
    /**
     * This class unhides the top action bar when the page is no longer in focus.
     */
    @Override
    public void onStop() {
        super.onStop();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).show();
    }

    /**
     * This class is responsible for getting the lists of array of types and colors
     * that will be used along with the names and pictures to create the scrollable
     * area full of all viruses that the user has created between every run.
     */
    private void setVirusModel(){
        saveData saveData = new saveData();
        String[] virusName = saveData.getVirusName();
        int[] virusPicture = saveData.getVirusPicture();
        saveData.setVirusNamePart("Test", 1);
        String[] virusType = getResources().getStringArray(R.array.virus_type);
        String[] virusColor = getResources().getStringArray(R.array.virus_color);

        for (int i = 0; i < virusName.length; i++){
            virusModel.add(new virusModel(virusColor[i],virusType[i],virusName[i],virusPicture[i]));
        }
    }

}