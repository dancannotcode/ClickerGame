package com.example.testing;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.testing.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * MainActivity serves as the entry point of the application, orchestrating the initial UI setup,
 * navigation handling, and integration of Firebase services. It manages the display of the
 * bottom navigation bar based on the user's current navigational context.
 */
public class MainActivity extends AppCompatActivity {

    // Instance of FirebaseFirestore to handle data storage and retrieval
    FirebaseFirestore firestore;

    /**
     * Initializes the activity, inflating its UI, setting up navigation components, and configuring visibility
     * rules for UI elements based on the navigation state. It establishes connections with Firestore
     * and configures navigation-dependent UI components like the bottom navigation and action bar.
     *
     * @param savedInstanceState Contains the data most recently supplied in onSaveInstanceState(Bundle) if the activity is re-initialized after previously being shut down. Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding class instance to access views directly
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Accessing the BottomNavigationView from the binding
        BottomNavigationView navView = binding.navView;

        // Configuration of top-level destinations in the app's navigation graph
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        R.id.navigation_homepage, R.id.navigation_dashboard, R.id.navigation_customizationcheck).build();
        // Navigation controller setup for managing UI navigation within the app
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        // Listener to adjust the visibility of the BottomNavigationView based on navigation destination
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.navigation_homepage || destination.getId() == R.id.navigation_login) {
                navView.setVisibility(View.GONE);
            } else {
                navView.setVisibility(View.VISIBLE);
            }
        });

        // Initializing the Firestore database instance
        firestore = FirebaseFirestore.getInstance();
    }
}
