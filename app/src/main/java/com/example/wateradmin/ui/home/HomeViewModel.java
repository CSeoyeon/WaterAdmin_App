package com.example.wateradmin.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.wateradmin.ui.inputPage.WaterTaxCalculator;
import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;
import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private String usedWaterAmount, waterTax;


    public HomeViewModel() {

    }

    public double getTotalWaterUsedForToday()
    {
        List<WaterUsageRecord> recordList = waterUsageRecordRepository.getAllUsageRecordForDate(new UsageRecordDate(System.currentTimeMillis()));
        if(recordList == null)
            return 0.0;
        double toReturn = 0.0;
        for(WaterUsageRecord record : recordList)
        {
            toReturn += record.getUsedAmountInLiters();
        }
        return toReturn;
    }

    public double getTotalCostForToday()
    {
        List<WaterUsageRecord> recordList = waterUsageRecordRepository.getAllUsageRecordForDate(new UsageRecordDate(System.currentTimeMillis()));
        if(recordList == null)
            return 0.0;
        double usedAmount = 0.0;
        for(WaterUsageRecord record : recordList)
        {
            usedAmount += record.getUsedAmountInLiters();
        }
        double toReturn = WaterTaxCalculator.calculateWaterTax(usedAmount);
        return toReturn;
    }
}