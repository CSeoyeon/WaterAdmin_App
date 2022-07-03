package com.example.wateradmin.ui.inputPage;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


import com.example.wateradmin.R;
import com.example.wateradmin.databinding.FragmentUsedWaterInputBinding;
import com.example.wateradmin.ui.home.HomeFragment;

public class WaterUseFragment extends Fragment {

    private FragmentUsedWaterInputBinding binding;
    private WaterViewModel waterViewModel;
    Button e;
    public static WaterUseFragment newInstance(){return new WaterUseFragment();}

    static final String[] laundry =new String[]{"표준코스(40도 이상)", "표준 코드(냉수)", "이불 세탁", "없음"};
    static final String[] dishwash =new String[]{"식기세척기(5~12인용)", "손 설거지", "없음"};
    static double laundryUsed, showerUsed, Ingestion, carWashUsed, UserInputUsed, ingestionMinute, washDishMinute, watertax = 0.0;
    static String laundryResult, washDishResult ="";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        waterViewModel =
                new ViewModelProvider(this).get(WaterViewModel.class);

        binding = FragmentUsedWaterInputBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //매핑
        //입력
        EditText ETshower = binding.showerInput;
        EditText ETCarWash = binding.washcarInput;
        EditText ETUserInput = binding.userInput;
        EditText ETIngestionInput = binding.ingestionInput;
        Spinner SLaundry  = binding.spinnerWash;
        Spinner SWashDish = binding.spinnerDishWash;

        //세탁 선택
        ArrayAdapter<String> laundryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, laundry);
        laundryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SLaundry.setAdapter(laundryAdapter);
        SLaundry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String laundryText =parent.getItemAtPosition(position).toString();
                if (laundryText == "표준코스(40도 이상)"){
                    laundryResult ="표준코스(40도 이상)";
                    laundryUsed =89;
                }
                else if (laundryText == "표준 코드(냉수)"){
                    laundryResult ="표준 코드(냉수)";
                    laundryUsed = 80.5;
                }
                else if (laundryText == "이불 세탁"){
                    laundryResult ="이불 세탁";
                    laundryUsed =157;
                }
                else if (laundryText == "없음"){
                    laundryResult ="없음";
                    laundryUsed =0;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                laundryUsed = 0;
            }

        });

        //설거지 선택
        ArrayAdapter<String> washDishAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, dishwash);
        washDishAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SWashDish.setAdapter(washDishAdapter);
        SWashDish.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String washdishText =parent.getItemAtPosition(position).toString();
                if (washdishText == "식기세척기(5~12인용)"){
                    washDishResult = "식기세척기(5~12인용)";
                    washDishMinute =22.5;
                }
                else if (washdishText == "손 설거지"){
                    washDishResult = "손 설거지";
                    washDishMinute = 18.75;
                }
                else if (washdishText == "없음"){
                    washDishResult = "없음";
                    washDishMinute = 0;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                washDishMinute = 0;
            }
        });

        //총 사용량
        TextView ETUsed = binding.usedText;


        //**사용 시간 계산**
        //설거지
        if(ETIngestionInput != null){
            Ingestion = Double.parseDouble(String.valueOf(ETshower.getText()));
            if(washDishResult == "식기세척기(5~12인용)"){
                if(Ingestion >=1 && Ingestion <= 12){
                    ingestionMinute = 22.5;
                }
                else if(Ingestion == 0){
                    ingestionMinute =0;
                }
                else if(Ingestion >= 13){
                    ingestionMinute = Ingestion *1.8;
                    ingestionMinute += 22.5;
                }
            }
            if(washDishResult == "손 설거지"){
                washDishMinute = 18.75 * Ingestion;
            }
        }
        else{washDishMinute =0;}

        //세차
        if(ETCarWash != null){
            int carNumber= Integer.parseInt(String.valueOf(ETCarWash.getText()));
            carWashUsed = 100 * carNumber;
        }
        else{washDishMinute =0;}


        //목욕(분)
        if(ETshower.getText() != null){
            int bathTime = Integer.parseInt(String.valueOf(ETshower.getText()));
            showerUsed = 12*bathTime;
        }
        else{showerUsed =0;}

        //사용자 입력
        if(ETUserInput.getText() != null){
            UserInputUsed = Integer.parseInt(String.valueOf(ETshower.getText()));
        }
        else{UserInputUsed =0;}

        double allUsed = laundryUsed + washDishMinute + carWashUsed + showerUsed + UserInputUsed;

        //수도세 계산
        if(allUsed >= 0 && allUsed <= 20000){
            watertax = allUsed * 460;
        }
        else if(allUsed >= 21000 && allUsed <40000){
            watertax = allUsed * 720;
        }
        else{ watertax = allUsed * 950; }

        Button saveBtn = binding.saveBtn;
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                ETUsed.setText(Double.toString(allUsed));
                waterViewModel.setCarWash(ETCarWash.getText().toString());
                waterViewModel.setUserInputtedTime(ETUserInput.getText().toString());
                waterViewModel.setshowerTime(ETshower.getText().toString());
                waterViewModel.setIngestionPerson(ETIngestionInput.getText().toString());

                /*
                Log.v("car","time: " + carWashUsed);
                Log.v("shower","time: " + showerUsed);
                Log.v("user","time: " + UserInputUsed);
                Log.v("laundry","time: " + laundryUsed);
                Log.v("dish","time: " + washDishMinute);
                */

            }
        });

        Button ResultBtn = binding.inputResultBtn;
        NavController waterUseNavController = NavHostFragment.findNavController(WaterUseFragment.this);
        ResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){


                Bundle result = new Bundle();
                result.putDouble("일_사용량",allUsed);
                result.putDouble("일_수도세",watertax);

                getParentFragmentManager().setFragmentResult("requestKey", result);

                waterUseNavController.navigate(R.id.action_navigation_waterUserFragment_to_navigation_home);
            }
        });

    }
}

