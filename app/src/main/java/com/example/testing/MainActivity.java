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

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use view binding to inflate the layout and get a reference to the root view
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Directly use the BottomNavigationView from the binding instead of finding it again
        BottomNavigationView navView = binding.navView;

        // Simplify AppBarConfiguration by including only unique IDs needed for top-level destinations
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_homepage, R.id.navigation_dashboard, R.id.navigation_customizationcheck,
                R.id.navigation_login, R.id.navigation_customization
        ).build();

        // Get the NavController from the NavHostFragment
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Setup ActionBar with NavController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Setup the BottomNavigationView with NavController
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
