package com.sindurdevelopment.carmy.ui.carinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sindurdevelopment.carmy.databinding.FragmentCarinfoBinding;
import com.sindurdevelopment.carmy.services.status.Doors;
import com.sindurdevelopment.carmy.services.status.Windows;

import org.json.JSONException;

import java.io.IOException;

public class CarInfoFragment extends Fragment {
    private FragmentCarinfoBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CarInfoViewModel carInfoViewModel =
                new ViewModelProvider(this).get(CarInfoViewModel.class);

        binding = FragmentCarinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView odometerText = binding.odometerData;
        carInfoViewModel.getText().observe(getViewLifecycleOwner(), odometerText::setText);

        odometerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getActivity() , Windows.getWindowStatus(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}