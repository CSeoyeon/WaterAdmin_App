package com.example.wateradmin.ui.recordPage;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;
import com.example.wateradmin.ui.inputPage.model.UsageType;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecordListViewModel extends ViewModel {


    private WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private List<WaterUsageRecord> waterUsageRecordList = waterUsageRecordRepository.getAllUsageRecords();

    private WaterUsageRecord waterUsageRecord;

    private UsageType recordTag;
    private UsageRecordDate recordDate;
    private double recordWaterTax;
    private double recordAmount;

    private List recordList = new ArrayList(){};
    private List recordTagList = new ArrayList(){};
    private List recordDateList = new ArrayList(){};



    public List getRecordList(){
        for(WaterUsageRecord val: waterUsageRecordList){
            recordTagList.add(val.getType());
            recordTagList.add(val.getDate());
            recordTagList.add(val.getUsedAmountInLiters());
        }
        Log.v("22", "" + recordTagList);
        return recordTagList;
    }

     public UsageType getRecordTag() {
        for(WaterUsageRecord val: waterUsageRecordList){
                 recordTag = (val.getType());
             }
         return recordTag;
         }



    public void setRecordTag(UsageType recordTag) {
        this.recordTag = recordTag;
    }

//
//    public List getRecordDate() {
//
//        return recordDateList;
//    }
//
//    public void setRecordDate(UsageRecordDate recordDate) {
//        this.recordDate = recordDate;
//    }
//
//    public double getRecordAmount() {
//        return ();
//    }
//
//    public void setRecordAmount(double recordAmount) {
//        this.recordAmount = recordAmount;
//    }
//
//    public List getRecordWaterTax() {
//
//        return recordDateList;
//    }
//
//    public void setRecordWaterTax(double recordWaterTax) {
//        this.recordWaterTax = recordWaterTax;
//    }



    
    
}
