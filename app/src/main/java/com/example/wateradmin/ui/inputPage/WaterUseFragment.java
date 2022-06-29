package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentUsedWaterInputBinding;

public class WaterUseFragment extends Fragment {

    private FragmentUsedWaterInputBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WaterViewModel waterViewModel =
                new ViewModelProvider(this).get(WaterViewModel.class);


        binding = FragmentUsedWaterInputBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

}

