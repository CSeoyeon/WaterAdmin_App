package com.example.wateradmin.ui.inputPage.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentLocalinputBinding;
import com.example.wateradmin.ui.connection.ConnectionActivity;
import com.example.wateradmin.ui.connection.Results;
import com.example.wateradmin.ui.connection.RetrofitClient;
import com.example.wateradmin.ui.inputPage.viewmodel.LocalInputViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalInputFragment extends Fragment {

    private FragmentLocalinputBinding binding;
    private LocalInputViewModel localInputViewModel;

    private Spinner sp_siDo;
    private Button bt_save;
    private TextView tv_regionWaterTax;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        localInputViewModel = new ViewModelProvider(this).get(LocalInputViewModel.class);
        binding = FragmentLocalinputBinding.inflate(inflater, container, false);
        localInputViewModel.loadSiDoList();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sp_siDo = binding.inputLocalSpSido;
        bt_save = binding.inputLocalBtSave;
        tv_regionWaterTax = binding.localInputTvReigonwaterTax;

        localInputViewModel.isSiDoLoaded().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoaded) {
                if(isLoaded)
                {
                    List<String> siDoList = localInputViewModel.getSiDoList();
                    String[] stringArray = new String[siDoList.size()];
                    siDoList.toArray(stringArray);

                    ArrayAdapter<String> inputRegionAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, stringArray);
                    inputRegionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_siDo.setAdapter(inputRegionAdapter);
                }
            }
        });
    }
}
