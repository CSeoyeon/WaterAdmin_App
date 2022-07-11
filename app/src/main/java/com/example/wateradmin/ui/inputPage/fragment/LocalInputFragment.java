package com.example.wateradmin.ui.inputPage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentLocalinputBinding;
import com.example.wateradmin.ui.inputPage.viewmodel.LocalInputViewModel;

public class LocalInputFragment extends Fragment {

    FragmentLocalinputBinding binding;
    LocalInputViewModel localInputViewModel = new LocalInputViewModel();

    Spinner sp_sido;
    Spinner sp_sigun;
    Spinner sp_dong;
    Button bt_save;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        localInputViewModel = new ViewModelProvider(this).get(LocalInputViewModel.class);
        binding = FragmentLocalinputBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sp_sido = binding.inputLocalSpSido;
        sp_sigun = binding.inputLocalSpSigun;
        sp_dong = binding.inputLocalSpDong;
        bt_save = binding.inputLocalBtSave;





    }
}
