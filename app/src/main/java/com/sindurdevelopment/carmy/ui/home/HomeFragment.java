package com.sindurdevelopment.carmy.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sindurdevelopment.carmy.databinding.FragmentHomeBinding;
import com.sindurdevelopment.carmy.services.Odometer;
import com.sindurdevelopment.carmy.services.VehicleManager;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView externalTemp = binding.degreesTextView;
        homeViewModel.getData().observe(getViewLifecycleOwner(), externalTemp::setText);
        externalTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity() , "External temperature reported by vehicle" , Toast.LENGTH_SHORT).show();

        }});

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

