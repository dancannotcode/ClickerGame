package com.example.testing.ui.Login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel for the LoginFragment. This ViewModel holds and manages UI-related data in a lifecycle conscious way.
 * The ViewModel allows data to survive configuration changes such as screen rotations.
 */
public class LoginViewModel extends ViewModel {

    /**
     * LiveData holding a string message. This can be used to expose fragment specific messages and status updates.
     */
    private final MutableLiveData<String> mText;

    /**
     * Initializes the ViewModel. Here, the 'mText' MutableLiveData is initialized with a default message.
     * This message is intended to represent a state or informational text relating to the login process.
     */
    public LoginViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is login fragment");
    }

    /**
     * Returns the LiveData for observing by the associated UI (LoginFragment), allowing the UI to be updated
     * in a lifecycle-aware manner. LiveData supports observing changes to data values and ensures the UI matches
     * the current data state.
     *
     * @return LiveData object containing a String value, representing the current status or message to be displayed.
     */
    public LiveData<String> getText() {
        return mText;
    }
}
