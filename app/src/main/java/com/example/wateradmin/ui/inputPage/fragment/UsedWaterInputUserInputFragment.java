package com.example.wateradmin.ui.inputPage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentUsedwaterinputuserinputBinding;
import com.example.wateradmin.ui.inputPage.model.UsageType;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;
import com.example.wateradmin.ui.inputPage.viewmodel.WaterUseInputViewModel;

public class UsedWaterInputUserInputFragment extends Fragment {

    private FragmentUsedwaterinputuserinputBinding binding;
    private WaterUseInputViewModel waterUseInputViewModel;
    private EditText tx_userInputType, tx_userInputAmount;
    private Button bt_save;
    private Spinner sp_unit;

    static final String[] waterUnit = new String[]{
            "ml(밀리리터)",
            "dl(데시리터)",
            "L(리터)",
            "cm3(세제곱센티미터)"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        waterUseInputViewModel = new ViewModelProvider(this).get(WaterUseInputViewModel.class);
        binding = FragmentUsedwaterinputuserinputBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tx_userInputType = binding.usedWaterInputUserInputEtTypeUserInput;
        tx_userInputAmount = binding.usedWaterInputUserInputEtUsedWater;
        bt_save = binding.usedWaterInputUserInputBtSave;
        sp_unit = binding.usedWaterInputUserInputSpLiterChoice;

        ArrayAdapter<String> unitSpinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, waterUnit);
        unitSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_unit.setAdapter(unitSpinnerAdapter);
        sp_unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long ld) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if(sp_unit.getSelectedItem().toString() == "L(리터)"){

                }
                else if(sp_unit.getSelectedItem().toString() == "ml(밀리리터)"){

                }
                else if(sp_unit.getSelectedItem().toString() == "dl(데시리터)"){

                }
                else if(sp_unit.getSelectedItem().toString() == "cm3(세제곱센티미터)"){

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
                });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waterUseInputViewModel.addNewUsageRecord(new WaterUsageRecord(UsageType.USER_INPUT, Double.parseDouble(tx_userInputAmount.getText().toString()), System.currentTimeMillis()));
            }
        });

    }
}
