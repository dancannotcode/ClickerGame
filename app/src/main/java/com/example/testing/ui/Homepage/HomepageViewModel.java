package com.example.testing.ui.Homepage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel for the HomepageFragment. This ViewModel stores and manages UI-related data for the
 * HomepageFragment in a lifecycle-conscious way, allowing data to survive configuration changes such as screen rotations.
 *
 * It holds a message that can be observed by the HomepageFragment to react to data changes.
 */
public class HomepageViewModel extends ViewModel {

    /**
     * LiveData instance for holding a string message. This is primarily used to display a status or informational
     * text related to the homepage, which can be observed by the UI (HomepageFragment) to ensure it is always
     * up-to-date with the latest data.
     */
    private final MutableLiveData<String> mText;

    /**
     * Constructor for the HomepageViewModel. It initializes the LiveData with a default message indicating
     * that it is related to the HomepageFragment. This message can be used for displaying a greeting or instructions
     * on the homepage.
     */
    public HomepageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is homepage fragment");
    }

    /**
     * Provides the LiveData object containing the current status or message. This method allows the UI
     * (HomepageFragment) to observe changes to the text, enabling the fragment to update what is displayed
     * on the screen whenever the data changes.
     *
     *
     *  Returns the current message that is being observed for changes.
     *  @return the current message as LiveData.
     *
     */
    public LiveData<String> getText() {
        return mText;
    }
}
