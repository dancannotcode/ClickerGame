package com.example.testing.ui.collectionTab;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testing.R;
import com.example.testing.databinding.FragmentCollectionBinding;
import com.example.testing.ui.customizationTab.CustomizationFragment;
import com.example.testing.virusModel;
import com.example.testing.virus_RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class collectionFragment extends Fragment{

    ArrayList<virusModel> virusModel = new ArrayList<>();

    String[] virusName = {"Name: ???????","Name: ???????","Name: ???????","Name: ???????","Name: ???????","Name: ???????","Name: ???????"};
    int[] virusPicture = {R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark,R.drawable.question_mark};
    private FragmentCollectionBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCollectionBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        virusPicture[1] = R.drawable.cell_enemy;
        virusPicture[0] = R.drawable.bacteria_enemy;
        virusName[0] = "Name: Test";
        RecyclerView recyclerView = view.findViewById(R.id.virusRecyclerView);
        setVirusModel();
        virus_RecyclerViewAdapter adapter = new virus_RecyclerViewAdapter(getContext(),virusModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    private void setVirusModel(){
        //String[] virusName = getResources().getStringArray(R.array.virus_names);
        String[] virusType = getResources().getStringArray(R.array.virus_type);
        String[] virusColor = getResources().getStringArray(R.array.virus_color);

        for (int i = 0; i < virusName.length; i++){
            virusModel.add(new virusModel(virusColor[i],virusType[i],virusName[i],virusPicture[i]));
        }
    }

}