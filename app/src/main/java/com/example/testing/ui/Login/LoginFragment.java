package com.example.testing.ui.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import com.example.testing.R;
import com.example.testing.databinding.FragmentLoginBinding;
import com.example.testing.ui.Login.LoginFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

/**
 * A {@link Fragment} subclass that provides login and registration functionalities
 * using Firebase Authentication. This fragment handles user authentication processes and
 * navigates to the home page upon successful login.
 *
 * The fragment utilizes {@link FragmentLoginBinding} for layout binding to interact with
 * UI elements programmatically. It manages user authentication with {@link FirebaseAuth}.
 */
public class LoginFragment extends Fragment {

    /**
     * Binding instance for accessing the fragment's layout views.
     */
    private FragmentLoginBinding binding;

    /**
     * Firebase authentication instance to handle login and registration.
     */
    private FirebaseAuth mAuth;

    /**
     * Initializes the Firebase Authentication instance when the fragment is created.
     *
     * @param savedInstanceState If the fragment is being re-created from a previous saved state, this is the state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    /**
     * Inflates the fragment's view and sets up event listeners for the login and registration buttons.
     * Users are required to enter their email and password to either login or register.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        binding.loginButton.setOnClickListener(v -> {
            String email = binding.username.getText().toString().trim();
            String password = binding.password.getText().toString().trim();
            if (!email.isEmpty() && !password.isEmpty()) {
                loginUser(email, password);
            } else {
                Toast.makeText(getActivity(), "Please enter email and password", Toast.LENGTH_SHORT).show();
            }
        });

        binding.registerButton.setOnClickListener(v -> {
            String email = binding.username.getText().toString().trim();
            String password = binding.password.getText().toString().trim();
            if (!email.isEmpty() && !password.isEmpty()) {
                registerUser(email, password);
            } else {
                Toast.makeText(getActivity(), "Please enter email and password", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

    /**
     * Attempts to log in the user with the provided email and password.
     * On successful login, navigates to the home page fragment.
     * On failure, shows a Toast message with the error.
     *
     * @param email The user's email address.
     * @param password The user's password.
     */
    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getActivity(), "Authentication successful.", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(LoginFragment.this)
                                .navigate(R.id.action_navigation_login_to_navigation_home);
                    } else {
                        Toast.makeText(getActivity(), "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    /**
     * Attempts to register the user with the provided email and password.
     * On successful registration, shows a Toast message prompting the user to log in.
     * On failure, shows a Toast message with the error.
     *
     * @param email The user's email address.
     * @param password The user's password.
     */
    private void registerUser(String email, String password) {


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), task -> {
                    if (task.isSuccessful()) {
                        String userId = mAuth.getCurrentUser().getUid();

                        FirebaseFirestore.getInstance().collection(email)
                                .document(userId)
                                .set(new HashMap<String, Object>())
                                .addOnSuccessListener(aVoid -> {
                                    Toast.makeText(getActivity(), "Registration Successful, now try to login with that information", Toast.LENGTH_SHORT).show();
                                })
                                .addOnFailureListener(e -> {
                                    Toast.makeText(getActivity(), "Failed to store user ID in Firestore: " + e.getMessage(), Toast.LENGTH_LONG).show();
                                });

                    } else {
                        Toast.makeText(getActivity(), "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    /**
     * Cleans up resources when the view is destroyed, particularly clearing the binding to prevent memory leaks.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
