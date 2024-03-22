package com.example.testing.ui.customizationTab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testing.databinding.FragmentCustomizationBinding;

public class CustomizationFragment extends Fragment implements View.OnClickListener{

    private FragmentCustomizationBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        com.example.testing.ui.customizationTab.CustomizationViewModel notificationsViewModel =
                new ViewModelProvider(this).get(com.example.testing.ui.customizationTab.CustomizationViewModel.class);

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
    }
}