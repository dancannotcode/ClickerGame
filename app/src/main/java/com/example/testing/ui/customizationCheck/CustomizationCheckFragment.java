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
/**
 * A Fragment for verifying and reviewing customization choices made by the user.
 * This fragment displays the final selections and allows navigation back to the customization screen
 * for any necessary adjustments. It also manages the visibility of the app's action bar to focus user attention
 * on the content.
 */
public class CustomizationCheckFragment extends Fragment{

    private com.example.testing.databinding.FragmentCustomizationcheckBinding binding;

    /**
     * Sets the listener for the plus button that navigates to the other page.
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

        binding = com.example.testing.databinding.FragmentCustomizationcheckBinding.inflate(inflater, container, false);

        binding.customizationButton.setOnClickListener(v -> NavHostFragment.findNavController(CustomizationCheckFragment.this).navigate(R.id.action_navigation_customizationcheck_to_navigation_customization));
        return binding.getRoot();
    }

    /**
     * What is done when the page is closed
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Hides the top bar when the page is first opened.
     */
    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).hide();
    }

    /**
     * Unhides the top bar when the page is closed.
     */
    @Override
    public void onStop() {
        super.onStop();
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).show();
    }
}