package com.example.testing.ui.Homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import com.example.testing.R;
import com.example.testing.databinding.FragmentHomepageBinding;

public class HomepageFragment extends Fragment {

    private FragmentHomepageBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomepageViewModel homeViewModel =
                new ViewModelProvider(this).get(HomepageViewModel.class);

        binding = FragmentHomepageBinding.inflate(inflater, container, false);
        binding.btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomepageFragment.this).navigate(R.id.action_navigation_homepage_to_navigation_home);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}