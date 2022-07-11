package com.example.wateradmin.ui.inputPage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentUsedwaterinputwashcarBinding;
import com.example.wateradmin.ui.inputPage.model.UsageType;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;
import com.example.wateradmin.ui.inputPage.viewmodel.WaterUseInputViewModel;

public class UsedWaterInputWashCarFragment extends Fragment {

    private FragmentUsedwaterinputwashcarBinding binding;
    private WaterUseInputViewModel waterUseInputViewModel;

    private EditText et_usedCount;
    private Button bt_save;

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
        et_usedCount = binding.usedWaterWashCarEtUsedCount;
        bt_save = binding.usedWaterInputUserInputBtSave;

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int numTimes = Integer.parseInt(et_usedCount.getText().toString());
                waterUseInputViewModel.addNewUsageRecord(new WaterUsageRecord(UsageType.CAR_WASH, numTimes * 100, System.currentTimeMillis()));

            }
        });
    }
}
