package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentUsedwaterinputwashdishBinding;

public class UserdWaterInputWashdishFragment extends Fragment {

    private FragmentUsedwaterinputwashdishBinding binding;
    private WaterUseInputViewModel waterUseInputViewModel;
    private RadioButton radioBt_handWash;
    private RadioButton radioBt_usedMachine;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        waterUseInputViewModel = new ViewModelProvider(this).get(WaterUseInputViewModel.class);
        binding = FragmentUsedwaterinputwashdishBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radioBt_handWash = binding.usedWaterWashDishRadioBtHandWashDish;
        radioBt_usedMachine = binding.usedWaterWashDishRadioBtWashMachine;
    }
}
