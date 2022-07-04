package com.example.wateradmin.ui.inputPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterUsageRecordRepository {
    private static final WaterUsageRecordRepository INSTANCE = new WaterUsageRecordRepository();

    private List<WaterUsageRecord> allUsageRecords;
    private Map<UsageRecordDate, List<WaterUsageRecord>> dateUsageRecordsMap;

    private WaterUsageRecordRepository() {
        allUsageRecords = new ArrayList<>();
        dateUsageRecordsMap = new HashMap<>();
    }

    public static WaterUsageRecordRepository getInstance() {
        return INSTANCE;
    }

    public void addUsageRecord(WaterUsageRecord toAdd) {
        allUsageRecords.add(toAdd);
        if (dateUsageRecordsMap.containsKey(toAdd.getDate())) {
            List<WaterUsageRecord> recordsForDate = dateUsageRecordsMap.get(toAdd.getDate());
            recordsForDate.add(toAdd);
        } else {
            List<WaterUsageRecord> recordListToAdd = new ArrayList<>();
            recordListToAdd.add(toAdd);
            dateUsageRecordsMap.put(toAdd.getDate(), recordListToAdd);
        }
    }

    public List<WaterUsageRecord> getAllUsageRecords() {
        return allUsageRecords;
    }

    public List<WaterUsageRecord> getUsageRecordsForDate(UsageRecordDate date) {
        return dateUsageRecordsMap.get(date);
    }
}
