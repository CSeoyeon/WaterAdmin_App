package com.example.wateradmin.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.wateradmin.MainActivity;
import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentHomeBinding;
import com.example.wateradmin.ui.inputPage.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.WaterUsageRecord;
import com.example.wateradmin.ui.inputPage.WaterUseFragment;
import com.example.wateradmin.ui.inputPage.WaterViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Button AddBtn;
    private TextView todayUsedWater, todayWaterTax;
    private HomeViewModel homeViewModel;
    private WaterViewModel waterViewModel;

    Double getTodayUsedWater, getTodayWaterTax;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        waterViewModel = new ViewModelProvider(requireActivity()).get(WaterViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        //매핑
        todayUsedWater = binding.waterUseTX;
        todayWaterTax = binding.waterTaxTX;
        AddBtn = binding.homeAddBtn;

        NavController homeNavController = NavHostFragment.findNavController(HomeFragment.this);
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeNavController.navigate(R.id.action_navigation_home_to_navigation_waterUserFragment);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<WaterUsageRecord> todayUsageRecords = homeViewModel.getUsageRecordsForDate(new UsageRecordDate(System.currentTimeMillis()));

        if (todayUsageRecords != null && todayUsageRecords.size() > 0) {
            todayUsedWater.setText("" + (todayUsageRecords.size()));
            todayWaterTax.setText("" + getTotalUsageAmount(todayUsageRecords));
        }

//        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
//            @Override
//            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
//                getTodayUsedWater = bundle.getDouble(("일_사용량"));
//                getTodayWaterTax = bundle.getDouble(("일_수도세"));
//
//                //데이터 전달된 거 확인
//                Log.v("tag","e"+getTodayUsedWater+getTodayWaterTax);
//                todayUsedWater.setText(getTodayUsedWater.toString());
//                todayWaterTax.setText(getTodayWaterTax.toString());
//            }
//        });

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