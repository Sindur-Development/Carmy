package com.sindurdevelopment.carmy.ui.carinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sindurdevelopment.carmy.VehicleManager;
import com.sindurdevelopment.carmy.databinding.FragmentCarinfoBinding;

import org.w3c.dom.Text;

public class CarInfoFragment extends Fragment {
    private FragmentCarinfoBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CarInfoViewModel carInfoViewModel =
                new ViewModelProvider(this).get(CarInfoViewModel.class);

        binding = FragmentCarinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


//        TextView textView = binding.textView1;
//        carInfoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}