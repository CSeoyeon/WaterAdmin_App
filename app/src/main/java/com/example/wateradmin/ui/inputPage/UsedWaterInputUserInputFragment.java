package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.util.Log;
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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentUsedwaterinputuserinputBinding;

public class UsedWaterInputUserInputFragment extends Fragment {

    private FragmentUsedwaterinputuserinputBinding binding;
    private UsedWaterInputUserInputViewModel usedWaterInputUserInputViewModel;
    private EditText tx_userInput;
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
        usedWaterInputUserInputViewModel = new ViewModelProvider(this).get(UsedWaterInputUserInputViewModel.class);
        binding = FragmentUsedwaterinputuserinputBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tx_userInput = binding.usedWaterInputUserInputEtUsedWater;
        bt_save = binding.usedWaterInputUserInputBtSave;
        sp_unit = binding.usedWaterInputUserInputSpLiterChoice;

        ArrayAdapter<String> unitSpinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, waterUnit);
        unitSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_unit.setAdapter(unitSpinnerAdapter);
        sp_unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long ld) {
                String selectedItem = parent.getItemAtPosition(position).toString();
               usedWaterInputUserInputViewModel.setUnitSelectedSpinnerValue(selectedItem);

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
                usedWaterInputUserInputViewModel.addUserInputWaterAmountRecord(Double.parseDouble(tx_userInput.getText().toString()));
            }
        });

    }
}
