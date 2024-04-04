package com.example.testing.ui.customizationCheck;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomizationCheckViewModel extends ViewModel {

    public CustomizationCheckViewModel() {
        MutableLiveData<String> mText = new MutableLiveData<>();
        mText.setValue("This is a brand new Fragment");
    }

}