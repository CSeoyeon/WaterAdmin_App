package com.example.wateradmin.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.MainActivity;
import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentDashboardBinding;
import com.example.wateradmin.ui.inputPage.WaterUseFragment;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        
        //튕김
        Button inputAdd = (Button)getView().findViewById(R.id.listAddBtn);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        return root;


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
