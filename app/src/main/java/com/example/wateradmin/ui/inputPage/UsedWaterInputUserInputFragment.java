package com.example.wateradmin.ui.inputPage;

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

import com.example.wateradmin.databinding.FragmentUsedwaterinputuserinputBinding;
import com.example.wateradmin.databinding.FragmentUsedwaterinputwashdishBinding;

public class UsedWaterInputUserInputFragment extends Fragment {

    private FragmentUsedwaterinputuserinputBinding binding;
    private UsedWaterInputUserInputViewModel usedWaterInputUserInputViewModel;
    private EditText tx_userInput;
    private Button bt_save;

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

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usedWaterInputUserInputViewModel.addUserInputWaterAmountRecord(Double.parseDouble(tx_userInput.getText().toString()));

            }
        });

    }
}
