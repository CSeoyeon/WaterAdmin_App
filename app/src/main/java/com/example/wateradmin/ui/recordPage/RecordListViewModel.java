package com.example.wateradmin.ui.recordPage;

import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;
import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.model.UsageType;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

import java.util.ArrayList;
import java.util.List;

public class RecordListViewModel extends ViewModel
{
    private WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();

    public List<WaterUsageRecord> getRecordList()
    {
        return waterUsageRecordRepository.getAllUsageRecords();
    }
}
