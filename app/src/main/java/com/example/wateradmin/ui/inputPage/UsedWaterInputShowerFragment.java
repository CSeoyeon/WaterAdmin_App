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

import com.example.wateradmin.databinding.FragmentUsedwaterinputshowerBinding;

public class UsedWaterInputShowerFragment extends Fragment {

    FragmentUsedwaterinputshowerBinding binding;
    UsedWaterInputShowerViewModel usedWaterInputShowerViewModel = new UsedWaterInputShowerViewModel();

    private EditText et_usedMinute;
    private Button bt_save;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        usedWaterInputShowerViewModel = new ViewModelProvider(this).get(UsedWaterInputShowerViewModel.class);

        binding = FragmentUsedwaterinputshowerBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_usedMinute = binding.usedWaterShowerEtUsedCount;
        bt_save = binding.usedWaterInputShowerBtSave;

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usedWaterInputShowerViewModel.addShowerWaterAmountRecord(Integer.parseInt(et_usedMinute.getText().toString()));

            }
        });


    }
}
