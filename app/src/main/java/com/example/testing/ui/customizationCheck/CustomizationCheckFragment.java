package com.example.testing.ui.customizationCheck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.testing.R;

import java.util.Objects;

public class CustomizationCheckFragment extends Fragment{

    private com.example.testing.databinding.FragmentCustomizationcheckBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = com.example.testing.databinding.FragmentCustomizationcheckBinding.inflate(inflater, container, false);

        binding.customizationButton.setOnClickListener(v -> NavHostFragment.findNavController(CustomizationCheckFragment.this).navigate(R.id.action_navigation_customizationcheck_to_navigation_customization));
        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).show();
    }
}