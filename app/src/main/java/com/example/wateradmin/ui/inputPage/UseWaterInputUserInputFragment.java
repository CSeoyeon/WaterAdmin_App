package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentUsedwaterinputuserinputBinding;
import com.example.wateradmin.databinding.FragmentUsedwaterinputwashdishBinding;

public class UseWaterInputUserInputFragment extends Fragment {

    private FragmentUsedwaterinputuserinputBinding binding;
    private WaterUseInputViewModel waterUseInputViewModel;
    private EditText tx_userInput;

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
        tx_userInput = binding.usedWaterInputUserInputEtUsedCount;

    }
}
