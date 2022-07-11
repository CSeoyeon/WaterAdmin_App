package com.example.wateradmin.ui.inputPage.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;
import com.example.wateradmin.ui.inputPage.model.UsageType;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

public class WaterUseInputViewModel extends ViewModel {
    private WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();

    public void addNewUsageRecord(WaterUsageRecord toAdd)
    {
        waterUsageRecordRepository.addUsageRecord(toAdd);
    }

}
