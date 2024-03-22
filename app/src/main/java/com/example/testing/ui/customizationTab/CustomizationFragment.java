package com.example.testing.ui.customizationTab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testing.R;
import com.example.testing.databinding.FragmentCustomizationBinding;

public class CustomizationFragment extends Fragment implements View.OnClickListener {

    private FragmentCustomizationBinding binding;

    Button black;
    Button blue;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.example.testing.ui.customizationTab.CustomizationViewModel notificationsViewModel =
                new ViewModelProvider(this).get(com.example.testing.ui.customizationTab.CustomizationViewModel.class);
        assert container != null;

       /* Button one = blue.findViewById(R.id.color_button);
        one.setOnClickListener(this);
        Button two = black.findViewById(R.id.color_button2);
        two.setOnClickListener(this);*/

        binding = FragmentCustomizationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.color_button){
            binding.enemy.setColorFilter(Color.BLACK);
        }
        else if(v.getId() == R.id.color_button2){
            binding.enemy.setColorFilter(Color.BLUE);
        }
    }
}