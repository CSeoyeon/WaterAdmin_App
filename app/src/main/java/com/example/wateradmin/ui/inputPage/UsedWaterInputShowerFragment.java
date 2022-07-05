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

import com.example.wateradmin.databinding.FragmentUsedwaterinputshowerBinding;

public class UsedWaterInputShowerFragment extends Fragment {

    FragmentUsedwaterinputshowerBinding binding;
    WaterViewModel waterViewModel = new WaterViewModel();

    private EditText et_UsedMinute;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        waterViewModel = new ViewModelProvider(this).get(WaterViewModel.class);

        binding = FragmentUsedwaterinputshowerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_UsedMinute = binding.usedWaterShowerEtUsedCount;

    }
}
