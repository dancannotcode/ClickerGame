package com.example.testing.ui.notHome;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotHomeViewModel extends ViewModel {

    public NotHomeViewModel() {
        MutableLiveData<String> mText = new MutableLiveData<>();
        mText.setValue("This is a brand new Fragment");
    }

}