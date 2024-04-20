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
 * MainActivity is the entry point of the application and is responsible for handling the navigation
 * and user interface interactions. It sets up the navigation components and controls the visibility
 * of the bottom navigation bar based on the current navigation destination.
 */
public class MainActivity extends AppCompatActivity {

    // Firestore instance for database operations
    FirebaseFirestore firestore;

    /**
     * Called when the activity is starting. This method is where you perform initial setup for the activity.
     * Here we inflate the layout, setup the navigation controller, and handle the visibility of the bottom navigation bar.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use view binding to inflate the layout and get a reference to the root view
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Directly use the BottomNavigationView from the binding instead of finding it again
        BottomNavigationView navView = binding.navView;

        // Define the top-level destinations in the AppBarConfiguration
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_homepage, R.id.navigation_dashboard, R.id.navigation_customizationcheck,
                R.id.navigation_login, R.id.navigation_customization
        ).build();

        // Get the NavController from the NavHostFragment and setup ActionBar and BottomNavigationView with it
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        // Add a listener to hide the navigation view on specific destinations
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.navigation_homepage || destination.getId() == R.id.navigation_login) {
                navView.setVisibility(View.GONE);
            } else {
                navView.setVisibility(View.VISIBLE);
            }
        });

        // Initialize Firestore
        firestore = FirebaseFirestore.getInstance();
    }
}
