package com.sindurdevelopment.carmy.ui.carinfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sindurdevelopment.carmy.services.Odometer;

import org.json.JSONException;

import java.io.IOException;

public class CarInfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CarInfoViewModel() throws JSONException, IOException, InterruptedException {
        mText = new MutableLiveData<>();
        mText.setValue(Odometer.getOdometer());
    }


   public LiveData<String> getText() {
       return mText;
   }

}