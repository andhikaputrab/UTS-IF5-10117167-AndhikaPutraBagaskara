package com.apps.andhikaapps.Menu.ui.daily;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DailyActivityViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DailyActivityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}