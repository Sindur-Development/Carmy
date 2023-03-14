package com.sindurdevelopment.carmy.ui.carinfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sindurdevelopment.carmy.VehicleManager;

import java.io.IOException;

public class CarInfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CarInfoViewModel() throws IOException {
        VehicleManager.startVehicleManager();
//        VehicleManager.updateEngineDiagnostic();
        mText = new MutableLiveData<>();
//        mText.setValue(VehicleManager.getCurrentVehicle().getEngineDiagnostic().toString());
    }

    public LiveData<String> getText() {
        return mText;
    }
}