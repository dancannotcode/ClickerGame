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
import com.example.testing.ui.Homepage.HomepageFragment;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.username.getText().toString().trim();
                String password = binding.password.getText().toString().trim();
                if (!email.isEmpty() && !password.isEmpty()) {
                    loginUser(email, password);
                } else {
                    Toast.makeText(getActivity(), "Please enter email and password", Toast.LENGTH_SHORT).show();
                }
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

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success
                        Toast.makeText(getActivity(), "Authentication successful.", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_navigation_login_to_navigation_home);
                    } else {
                        // If sign in fails, display a message to the user
                        Toast.makeText(getActivity(), "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getActivity(), "Registration Successful, now try to login with that information", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}