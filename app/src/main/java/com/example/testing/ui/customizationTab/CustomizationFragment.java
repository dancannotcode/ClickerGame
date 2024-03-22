package com.example.testing.ui.customizationTab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testing.R;
import com.example.testing.databinding.FragmentCustomizationBinding;

public class CustomizationFragment extends Fragment{

    private FragmentCustomizationBinding binding;
    ImageView enemy;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View CustomizationFragment = inflater.inflate(R.layout.fragment_customization, container, false);
        // Get the count text view
        enemy = CustomizationFragment.findViewById(R.id.enemy);
        com.example.testing.ui.customizationTab.CustomizationViewModel CustomizationViewModel =
                new ViewModelProvider(this).get(com.example.testing.ui.customizationTab.CustomizationViewModel.class);

        binding = FragmentCustomizationBinding.inflate(inflater, container, false);

        //return binding.getRoot();
        return CustomizationFragment;

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        view.findViewById(R.id.color_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.BLACK;
                changeColor(view, color);
            }

        });
        view.findViewById(R.id.color_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.BLUE;
                changeColor(view, color);
            }

        });
    }
    private void changeColor(View view,int color) {
        enemy.setColorFilter(color);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}