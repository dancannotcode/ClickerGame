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

/**
 * A {@link Fragment} subclass that serves as the homepage for the application. This fragment
 * displays the main screen of the app and provides navigation to other parts of the application,
 * such as the login screen.
 *
 * The fragment uses data binding to interact with the layout, thereby minimizing the code required
 * to connect layout components like buttons directly in the fragment's Java code.
 */
public class HomepageFragment extends Fragment {

    /**
     * Binding instance for accessing the fragment's layout views.
     */
    private FragmentHomepageBinding binding;

    /**
     * Called to have the fragment instantiate its user interface view. This is optional, and
     * non-graphical fragments can return null. This method is called between onCreate(Bundle)
     * and onActivityCreated(Bundle).
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return Returns the root view for the fragment's UI, or null.
     */
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Initialize the ViewModel associated with this fragment.
        HomepageViewModel homeViewModel =
                new ViewModelProvider(this).get(HomepageViewModel.class);

        // Inflate the layout for this fragment using data binding.
        binding = FragmentHomepageBinding.inflate(inflater, container, false);

        // Set an onClickListener for the new game button to navigate to the login fragment.
        binding.btnNewGame.setOnClickListener(v -> {
            NavHostFragment.findNavController(HomepageFragment.this)
                    .navigate(R.id.action_navigation_homepage_to_navigation_login);
        });

        // Return the root view of the inflated layout.
        return binding.getRoot();
    }

    /**
     * Called when the view previously created by onCreateView(LayoutInflater, ViewGroup, Bundle)
     * has been detached from the fragment. The next time the fragment needs to be displayed, a new view will be created.
     * This is where you should clean up resources associated with the initial view hierarchy.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clear references to avoid memory leak.
        binding = null;
    }
}
