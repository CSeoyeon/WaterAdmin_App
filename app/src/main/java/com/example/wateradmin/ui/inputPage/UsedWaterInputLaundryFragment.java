package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentUsedwaterinputlaundryBinding;

public class UsedWaterInputLaundryFragment extends Fragment {

    private FragmentUsedwaterinputlaundryBinding binding;
    private WaterUseInputViewModel waterUseInputViewModel;

    private RadioButton radioBt_basicModeCold;
    private RadioButton radioBt_basicModeHot;
    private RadioButton radioBt_beddingMode;
    private EditText et_usedCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        waterUseInputViewModel = new ViewModelProvider(this).get(WaterUseInputViewModel.class);

        binding = FragmentUsedwaterinputlaundryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //매핑
        radioBt_basicModeCold = binding.usedWaterLaundryRadioBtBasicModeCold;
        radioBt_basicModeHot = binding.usedWaterLaundryRadioBtBasicModeHot;
        radioBt_beddingMode = binding.usedWaterLaundryRadioBtBedding;
        et_usedCount = binding.usedWaterLaundryEtUsedCount;

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            //https://developer.android.com/guide/topics/ui/controls/radiobutton?hl=ko
        }
    }

}
