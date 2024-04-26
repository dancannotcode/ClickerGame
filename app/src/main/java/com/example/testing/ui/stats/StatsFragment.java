package com.example.testing.ui.stats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.testing.databinding.FragmentStatsBinding;

/**
 * The {@code StatsFragment} class is responsible for displaying the statistics screen in the application.
 * It uses a {@link FragmentStatsBinding} to manage its views which helps in handling lifecycle events more cleanly.
 */
public class StatsFragment extends Fragment {

    private FragmentStatsBinding binding;

    /**
     * Inflates the fragment layout using {@link FragmentStatsBinding} when the fragment view is being created.
     * This method sets up the view for the statistics fragment.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return the root View of the inflated layout, to be attached to the fragment's UI.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStatsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Cleans up resources when the View is about to be destroyed. This method nullifies the binding to prevent
     * memory leaks by ensuring the reference to the binding object is removed when the view is destroyed.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
