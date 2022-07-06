package com.example.wateradmin.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.inputPage.UsageRecordDate;
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

    public List<WaterUsageRecord> getAllUsageRecords()
    {
        return waterUsageRecordRepository.getAllUsageRecords();
    }

    public List<WaterUsageRecord> getUsageRecordsForDate(UsageRecordDate date)
    {
        return waterUsageRecordRepository.getUsageRecordsForDate(date);
    }

    public double getUsedLaundryWaterAmount(){
        return waterUsageRecordRepository.getCalculateWaterAmount();
    }

    public double getUsedLaundryWaterTax(){
        return waterUsageRecordRepository.getCalculateWaterTax();
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