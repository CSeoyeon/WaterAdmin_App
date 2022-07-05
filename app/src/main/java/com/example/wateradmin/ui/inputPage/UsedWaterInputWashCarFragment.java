package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentUsedwaterinputwashcarBinding;

public class UsedWaterInputWashCarFragment extends Fragment {

    private FragmentUsedwaterinputwashcarBinding binding;
    private WaterUseInputViewModel waterUseInputViewModel;
    private EditText et_UsedCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        waterUseInputViewModel = new ViewModelProvider(this).get(WaterUseInputViewModel.class);

        binding = FragmentUsedwaterinputwashcarBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_UsedCount = binding.usedWaterWashCarEtUsedCount;
    }
}
