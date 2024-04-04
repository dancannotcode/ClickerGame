package com.example.testing.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testing.R;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testing.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ImageView imageView;
    private boolean isImageVisible = true;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        imageView = binding.getRoot().findViewById(R.id.imageView);

        // Set OnClickListener to move the ImageView to a different spot when clicked
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImage();
            }
        });

        return binding.getRoot();
    }

    private void moveImage() {
        if (isImageVisible) {
            // If image is visible, change its position
            imageView.animate()
                    .translationXBy(100)  // Move it 100 pixels to the right
                    .translationYBy(100)  // Move it 100 pixels down
                    .setDuration(500)     // Animation duration
                    .start();
        } else {
            // If image is not visible, reset its position
            imageView.animate()
                    .translationX(0)  // Move it back to its original X position
                    .translationY(0)  // Move it back to its original Y position
                    .setDuration(500) // Animation duration
                    .start();
        }

        // Toggle the visibility state
        isImageVisible = !isImageVisible;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}