package com.example.wateradmin.ui.recordPage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentRecordlistBinding;
import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;

public class RecordListFragment extends Fragment {

    private FragmentRecordlistBinding binding;
    private RecordListViewModel recordListViewModel;
    private TextView tv_date, tv_useType, tv_waterAmount, tv_waterTax;
    private ListView lv_waterData;


    // https://itstudy-mary.tistory.com/207

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        recordListViewModel = new ViewModelProvider(this).get(RecordListViewModel.class);
        binding = FragmentRecordlistBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        tv_date = binding.recordListTvDateView;
//        tv_useType = bin
//        ding.recordListTvUseType;
//        tv_waterAmount = binding.recordListTvUseWater;
//        tv_waterTax = binding.recordListTvWaterTax;


        //tv_date.setText(recordListViewModel.getLaundry().toString());
//        tv_date.setText(recordListViewModel.getLaundryDate());
//        tv_useType.setText(recordListViewModel.getLaundryTag());
//        tv_waterAmount.setText(String.valueOf(recordListViewModel.getLaundryAmount()));
//        tv_waterTax.setText(String.valueOf(recordListViewModel.getLaundryWaterTax()));



    }
}
