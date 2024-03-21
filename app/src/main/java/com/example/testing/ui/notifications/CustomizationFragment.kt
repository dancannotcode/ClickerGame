package com.example.testing.ui.notifications

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testing.databinding.FragmentCustomizationBinding

class CustomizationFragment : Fragment() {

    private var _binding: FragmentCustomizationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val customizationViewModel =
            ViewModelProvider(this)[CustomizationViewModel::class.java]

        _binding = FragmentCustomizationBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.colorButton.setOnClickListener{
            binding.enemy.setColorFilter(Color.BLACK)
        }
        binding.colorButton2.setOnClickListener{
            binding.enemy.setColorFilter(Color.BLUE)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}