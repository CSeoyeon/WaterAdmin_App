package com.example.wateradmin.ui.inputPage;

import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterUsageRecordRepository
{
    private static final WaterUsageRecordRepository INSTANCE = new WaterUsageRecordRepository();

    private List<WaterUsageRecord> allUsageRecords;
    private Map<UsageRecordDate, List<WaterUsageRecord>> dateUsageRecordsMap;

    private WaterUsageRecordRepository()
    {
        allUsageRecords = new ArrayList<>();
        dateUsageRecordsMap = new HashMap<>();
    }
///
    public static WaterUsageRecordRepository getInstance()
    {
        return INSTANCE;
    }

    public List<WaterUsageRecord> getAllUsageRecords()
    {
        return allUsageRecords;
    }

    public List<WaterUsageRecord> getAllUsageRecordForDate(UsageRecordDate date)
    {
        return dateUsageRecordsMap.get(date);
    }

    public void addUsageRecord(WaterUsageRecord toAdd)
    {
        allUsageRecords.add(toAdd);
        if(dateUsageRecordsMap.containsKey(toAdd.getDate()))
        {
            dateUsageRecordsMap.get(toAdd.getDate()).add(toAdd);
        }
        else
        {
            List<WaterUsageRecord> newRecordList = new ArrayList<>();
            newRecordList.add(toAdd);
            dateUsageRecordsMap.put(toAdd.getDate(), newRecordList);
        }
    }

    public List<WaterUsageRecord> getLaundryRecordsForToday()
    {
        List<WaterUsageRecord> toReturn = new ArrayList<>();
        for(WaterUsageRecord record : allUsageRecords)
        {
            toReturn.add(record);
        }
        return toReturn;
    }
}