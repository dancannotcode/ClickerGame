package com.example.testing.ui.notHome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotHomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is a brand new Fragment"
    }
    val text: LiveData<String> = _text
}