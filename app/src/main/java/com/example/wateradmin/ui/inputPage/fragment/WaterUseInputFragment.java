package com.example.wateradmin.ui.inputPage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentUsedwaterinputBinding;
import com.example.wateradmin.ui.inputPage.viewmodel.WaterUseInputViewModel;

public class WaterUseInputFragment extends Fragment {

    private FragmentUsedwaterinputBinding binding;
    private WaterUseInputViewModel waterUseInputViewModel;

    static final String[] useWaterInputSpUseType =new String[]{
            "세탁",
            "세차",
            "설거지",
            "목욕",
            "사용자 입력"
    };

    private NavController navController;
    private Button bt_save;
    private Spinner sp_useType;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        navController = NavHostFragment.findNavController(WaterUseInputFragment.this);
        waterUseInputViewModel = new ViewModelProvider(requireActivity()).get(WaterUseInputViewModel.class);
        binding = FragmentUsedwaterinputBinding.inflate(inflater, container, false);


        //매핑
        bt_save = binding.useWaterInputBtSave;
        sp_useType = binding.useWaterInputSpUseType;



        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //waterUseInputViewModel.addNewUsageRecord(Double.parseDouble(et_testInput.getText().toString()));
                navController.navigate(R.id.action_navigation_waterUserInputFragment_to_navigation_home);
            }
        });

        //사용 용도 종류
        ArrayAdapter<String> useTypeSpinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, useWaterInputSpUseType);
        useTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_useType.setAdapter(useTypeSpinnerAdapter);
        sp_useType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long ld) {
                String selectedItem = parent.getItemAtPosition(position).toString();


                FragmentTransaction fragmentManager = getChildFragmentManager().beginTransaction();

                if(sp_useType.getSelectedItem().toString() == "세탁"){

                    UsedWaterInputLaundryFragment usedWaterInputLaundryFragment = new UsedWaterInputLaundryFragment();
                    fragmentManager.replace(R.id.usedwaterinput_frameLayout, usedWaterInputLaundryFragment).commit();

                }
                else if(sp_useType.getSelectedItem().toString() == "세차"){
                    UsedWaterInputWashCarFragment usedWaterInputWashCarFragment = new UsedWaterInputWashCarFragment();
                    fragmentManager.replace(R.id.usedwaterinput_frameLayout, usedWaterInputWashCarFragment).commit();
                }

                else if(sp_useType.getSelectedItem().toString() == "설거지"){
                    UsedWaterInputWashdishFragment usedWaterInputWashdishFragment = new UsedWaterInputWashdishFragment();
                    fragmentManager.replace(R.id.usedwaterinput_frameLayout, usedWaterInputWashdishFragment).commit();

                }

                else if(sp_useType.getSelectedItem().toString() == "목욕"){
                    UsedWaterInputShowerFragment usedWaterInputShowerFragment = new UsedWaterInputShowerFragment();
                    fragmentManager.replace(R.id.usedwaterinput_frameLayout, usedWaterInputShowerFragment).commit();

                }

                else if(sp_useType.getSelectedItem().toString() == "사용자 입력"){
                    UsedWaterInputUserInputFragment usedWaterInputShowerFragment = new UsedWaterInputUserInputFragment();
                    fragmentManager.replace(R.id.usedwaterinput_frameLayout, usedWaterInputShowerFragment).commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}

        });
    }

}


