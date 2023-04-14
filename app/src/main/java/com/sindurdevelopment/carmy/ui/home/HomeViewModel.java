package com.sindurdevelopment.carmy.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sindurdevelopment.carmy.services.status.Temperature;
import com.sindurdevelopment.carmy.services.VehicleManager;
import com.sindurdevelopment.carmy.services.status.VehicleDetails;

import org.json.JSONException;
import java.io.IOException;


public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> tempData;


    public HomeViewModel() throws IOException, InterruptedException, JSONException {
        try {
            VehicleManager.startVehicleManager();
        } catch (Exception e) {
        }

        tempData = new MutableLiveData<>();
        tempData.setValue(Temperature.getTemperature());
    }


    public LiveData<String> getTempData() {
        return tempData;
    }

}