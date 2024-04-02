package com.example.testing.ui.customizationTab;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomizationCheckViewModel extends ViewModel {

    public CustomizationCheckViewModel() {
        MutableLiveData<String> mText = new MutableLiveData<>();
        mText.setValue("This is a brand new Fragment");
    }

}