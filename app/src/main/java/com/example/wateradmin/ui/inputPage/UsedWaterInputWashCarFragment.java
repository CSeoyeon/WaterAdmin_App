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

import com.example.wateradmin.databinding.FragmentUsedwaterinputwashcarBinding;

public class UsedWaterInputWashCarFragment extends Fragment {

    private FragmentUsedwaterinputwashcarBinding binding;
    private UsedWaterInputWashCarViewModel usedWaterInputWashCarViewModel;

    private EditText et_usedCount;
    private Button bt_save;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        usedWaterInputWashCarViewModel = new ViewModelProvider(this).get(UsedWaterInputWashCarViewModel.class);

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

                usedWaterInputWashCarViewModel.addShowerWaterAmountRecord(Integer.parseInt(et_usedCount.getText().toString()));

            }
        });
    }
}
