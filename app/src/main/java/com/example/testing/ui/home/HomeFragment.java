package com.example.testing.ui.home;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testing.R;
import com.example.testing.databinding.FragmentHomeBinding;
import android.media.*;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    MediaPlayer mediaPlayer = new MediaPlayer();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


// ***************************************************************************************/
// *    Title: MediaPlayer sound source code
// *    Author: global_warming
// *    Date: 2018
// *    Code version: 1.0
// *    Availability: https://stackoverflow.com/questions/48534509/my-android-app-stop-playing-sound-on-button-tap-after-some-time
// *
// ***************************************************************************************/

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.text_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.gameclick);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mp = null;
                    }
                });
                mediaPlayer.start();


            }

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}