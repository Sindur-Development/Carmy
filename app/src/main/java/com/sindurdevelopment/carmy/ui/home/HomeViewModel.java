package com.sindurdevelopment.carmy.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sindurdevelopment.carmy.services.Temperature;
import com.sindurdevelopment.carmy.services.VehicleManager;
import org.json.JSONException;
import java.io.IOException;
import java.net.MalformedURLException;


public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> data;
    private final String listData;

    public HomeViewModel() throws IOException, InterruptedException, JSONException {
        try {
            VehicleManager.startVehicleManager();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


        listData = Temperature.getTemperature();

        data = new MutableLiveData<>();
        data.setValue(listData);
    }

    public LiveData<String> getData() {
        return data;
    }
}