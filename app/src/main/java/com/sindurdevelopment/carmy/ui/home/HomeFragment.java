package com.sindurdevelopment.carmy.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.sindurdevelopment.carmy.ClimatePopup;
import com.sindurdevelopment.carmy.databinding.FragmentHomeBinding;
import com.sindurdevelopment.carmy.services.commands.UnlockDoors;
import com.sindurdevelopment.carmy.services.status.SentCommandStatus;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView externalTemp = binding.degreesTextView;
        homeViewModel.getTempData().observe(getViewLifecycleOwner(), externalTemp::setText);
        externalTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity() , "External temperature reported by vehicle" , Toast.LENGTH_SHORT).show();

        }});

        final ImageButton precondition = binding.preconditionButton;
        precondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ClimatePopup.class));
            }
        });

        final ImageButton lockBtn = binding.lockButton;
        lockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getActivity(), UnlockDoors.unlockDoors(),Toast.LENGTH_SHORT);
                    Toast.makeText(getActivity(), SentCommandStatus.getSentCommandStatus(),Toast.LENGTH_SHORT);
                    System.out.println(SentCommandStatus.getSentCommandStatus());
                } catch (Exception e) {
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

