package com.example.wateradmin.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.inputPage.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.UsedWaterInputLaundryRecord;
import com.example.wateradmin.ui.inputPage.WaterUsageRecord;
import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private final MutableLiveData<String> mText;
    private String usedWaterAmount, waterTax;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }


    public double getUsedLaundryWaterAmount(){
        return waterUsageRecordRepository.setCalculateWaterAmount();
    }

    public double getUsedLaundryWaterTax(){
        return waterUsageRecordRepository.setCalculateWaterTax();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public String getUsedWater() {
        return usedWaterAmount;
    }

    public void setUsedWater(String usedWater) {
        this.usedWaterAmount = usedWater;
    }

    public String getWaterTax() {
        return waterTax;
    }

    public void setWaterTax(String waterTax) {
        this.waterTax = waterTax;
    }
}