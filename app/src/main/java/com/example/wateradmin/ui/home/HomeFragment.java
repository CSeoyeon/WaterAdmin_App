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
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.wateradmin.MainActivity;
import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentHomeBinding;
import com.example.wateradmin.ui.inputPage.WaterUseFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Button AddBtn;
    private TextView todayUsedWater, todayWaterTax;
    Double getTodayUsedWater, getTodayWaterTax;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
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

        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                getTodayUsedWater = bundle.getDouble(("일_사용량"));
                getTodayWaterTax = bundle.getDouble(("일_수도세"));

                todayUsedWater.setText(getTodayUsedWater.toString());
                todayWaterTax.setText(getTodayWaterTax.toString());
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}