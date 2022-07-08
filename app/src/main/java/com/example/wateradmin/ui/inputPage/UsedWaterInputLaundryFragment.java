package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentUsedwaterinputlaundryBinding;

import org.w3c.dom.Text;

public class UsedWaterInputLaundryFragment extends Fragment {

    private FragmentUsedwaterinputlaundryBinding binding;
    private UsedWaterInputLaundryViewModel usedWaterInputLaundryViewModel;

    private RadioGroup radioG_laundryMode;
    private EditText et_usedCount;
    private Button bt_save;


    protected static double laundryWaterAmount = 0.0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        usedWaterInputLaundryViewModel = new ViewModelProvider(this).get(UsedWaterInputLaundryViewModel.class);

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
                String selectedItem = ""; 
                switch(checked){
                    case R.id.usedWaterLaundry_radioBt_basicModeCold:
                        selectedItem = "표준 모드(냉수)";
                        laundryWaterAmount = 89.0;
                        break;

                    case R.id.usedWaterLaundry_radioBt_basicModeHot:
                        selectedItem = "표준 모드(40도 이상)";
                        laundryWaterAmount = 80.5;
                        break;
                    case R.id.usedWaterLaundry_radioBt_bedding:
                        selectedItem = "이불 세탁";
                        laundryWaterAmount = 157.0;
                        break;
                }
                usedWaterInputLaundryViewModel.setSelectedRadioValue(selectedItem);
            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usedWaterInputLaundryViewModel.addLaundryWaterAmountRecord(laundryWaterAmount, Double.parseDouble(et_usedCount.getText().toString()));

            }
        });



    }


}
