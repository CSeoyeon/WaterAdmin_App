package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentUsedwaterinputwashdishBinding;

public class UsedWaterInputWashdishFragment extends Fragment {

    private FragmentUsedwaterinputwashdishBinding binding;
    private UsedWaterInputWashdishViewModel usedWaterInputWashdishViewModel;

    private RadioGroup radioG_WashDish;
    private static double washDishAmount = 0.0;
    private Button bt_save;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        usedWaterInputWashdishViewModel = new ViewModelProvider(this).get(UsedWaterInputWashdishViewModel.class);
        binding = FragmentUsedwaterinputwashdishBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radioG_WashDish = binding.usedWaterWashDishRadigGModeChoice;
        bt_save = binding.usedWaterInputUserInputBtSave;

        radioG_WashDish.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                switch (checked){
                    case R.id.usedWaterWashDish_radioBt_handWashDish:
                        washDishAmount = 22.5;
                        break;

                    case R.id.usedWaterWashDish_radioBt_WashMachine:
                        washDishAmount = 18.75;
                        break;
                }
            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usedWaterInputWashdishViewModel.addWashDishAmountRecord(washDishAmount);

            }
        });

    }
}
