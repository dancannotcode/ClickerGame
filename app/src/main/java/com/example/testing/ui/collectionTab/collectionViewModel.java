package com.example.testing.ui.collectionTab;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class collectionViewModel extends ViewModel {

    public collectionViewModel() {
        MutableLiveData<String> mText = new MutableLiveData<>();
        mText.setValue("This is a brand new Fragment");
    }

}