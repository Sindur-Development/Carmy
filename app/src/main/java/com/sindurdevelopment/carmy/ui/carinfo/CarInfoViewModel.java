package com.sindurdevelopment.carmy.ui.carinfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CarInfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CarInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}