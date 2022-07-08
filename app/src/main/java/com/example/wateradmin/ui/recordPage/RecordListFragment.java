package com.example.wateradmin.ui.recordPage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentRecordlistBinding;

public class RecordListFragment extends Fragment {

    private FragmentRecordlistBinding binding;
    private RecordListViewModel recordListViewModel;
    private TextView tv_data, tv_useType, tv_waterAmount, tv_waterTax;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        recordListViewModel = new ViewModelProvider(this).get(RecordListViewModel.class);
        binding = FragmentRecordlistBinding.inflate(inflater, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_data = binding.recordListTvDateView;
        tv_useType = binding.recordListTvUseType;
        tv_waterAmount = binding.recordListTvUseWater;
        tv_waterTax = binding.recordListTvWaterTax;




    }
}
