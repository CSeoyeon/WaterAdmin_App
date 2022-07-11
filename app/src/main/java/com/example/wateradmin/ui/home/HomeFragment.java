package com.example.wateradmin.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentHomeBinding;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;
import com.example.wateradmin.ui.inputPage.viewmodel.WaterUseInputViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Button bt_Add;
    private TextView tv_todayUsedWater, tv_todayWaterTax;
    private HomeViewModel homeViewModel;
    private WaterUseInputViewModel waterUseInputViewModel;

    //기록 이동 버튼
    private Button bt_recordView;
    //

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        waterUseInputViewModel = new ViewModelProvider(requireActivity()).get(WaterUseInputViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        //매핑
        tv_todayUsedWater = binding.homeTxShowtodayWaterUsedAmount;
        tv_todayWaterTax = binding.homeTxShowtodayUsedWaterTax;
        bt_Add = binding.homeBtAdd;

        bt_recordView = binding.homeBtRecordView;

        NavController homeNavController = NavHostFragment.findNavController(HomeFragment.this);
        bt_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeNavController.navigate(R.id.action_navigation_home_to_navigation_waterUserFragment);
            }
        });

        bt_recordView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeNavController.navigate(R.id.action_navigation_home_to_navigation_recordViewFragment);
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_todayUsedWater.setText(String.valueOf(homeViewModel.getTotalWaterUsedForToday()));
        tv_todayWaterTax.setText(String.valueOf(homeViewModel.getTotalCostForToday()));



    }

    private double getTotalUsageAmount(List<WaterUsageRecord> recordList) {
        double toReturn = 0.0;
        for (WaterUsageRecord record : recordList) {
            toReturn += record.getUsedAmountInLiters();
        }
        return toReturn;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}