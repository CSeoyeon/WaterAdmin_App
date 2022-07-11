package com.example.wateradmin.ui.inputPage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentUsedwaterinputlaundryBinding;
import com.example.wateradmin.ui.inputPage.model.UsageType;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;
import com.example.wateradmin.ui.inputPage.viewmodel.WaterUseInputViewModel;

public class UsedWaterInputLaundryFragment extends Fragment {

    private FragmentUsedwaterinputlaundryBinding binding;
    private WaterUseInputViewModel waterUseInputViewModel;

    private RadioGroup radioG_laundryMode;
    private EditText et_usedCount;
    private Button bt_save;

    private UsageType selectedUsageType;
    protected static double laundryWaterAmount = 0.0;

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
        radioG_laundryMode = view.findViewById(R.id.usedWaterLaundry_radigG_modeChoice);
        et_usedCount = binding.usedWaterLaundryEtUsedCount;
        bt_save = binding.usedWaterInputLaundryBtSave;

        radioG_laundryMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                switch(checked){
                    case R.id.usedWaterLaundry_radioBt_basicModeCold:
                        selectedUsageType = UsageType.LAUNDRY_BASIC_MODE_COLD;
                        laundryWaterAmount = 89.0;
                        break;

                    case R.id.usedWaterLaundry_radioBt_basicModeHot:
                        selectedUsageType = UsageType.LAUNDRY_BASIC_MODE_HOT;
                        laundryWaterAmount = 80.5;
                        break;
                    case R.id.usedWaterLaundry_radioBt_bedding:
                        selectedUsageType = UsageType.LAUNDRY_BEDDING_MODE;
                        laundryWaterAmount = 157.0;
                        break;
                }
            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                waterUseInputViewModel.addNewUsageRecord(new WaterUsageRecord(selectedUsageType, laundryWaterAmount, System.currentTimeMillis()));

            }
        });



    }


}
