package com.example.wateradmin.ui.recordPage;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;
import com.example.wateradmin.ui.inputPage.model.UsageType;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

import java.util.ArrayList;
import java.util.List;

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

//    public WaterUsageRecord getRecord(){
//
//        //반복 횟수만큼 배로 가져옴...
//        for(int i =0; i<waterUsageRecordList.size(); i++){
//            waterUsageRecord = waterUsageRecordList.get(i);
//        }
//
//        return waterUsageRecord;
//    }

    public List getRecordList(){

        for(WaterUsageRecord val: waterUsageRecordList){
            recordList.add(val);
        }
        return recordList;
    }

     public List getRecordTag() {

         for(WaterUsageRecord val: waterUsageRecordList){
            recordTagList.add(val.getType());
         }

        Log.v("22", "" + recordTagList);
        return recordTagList;
     }


    public void setRecordTag(UsageType recordTag) {
        this.recordTag = recordTag;
    }


    public List getRecordDate() {
        for(WaterUsageRecord val: waterUsageRecordList){
            recordDateList.add(val.getDate());
        }
        return recordDateList;
    }

//    public void setRecordDate(UsageRecordDate recordDate) {
//        this.recordDate = recordDate;
//    }
//
//    public double getRecordWaterTax() {
//        return waterUsageRecordRepository.getrecordWaterTax();
//    }
//
//    public void setRecordWaterTax(double recordWaterTax) {
//        this.recordWaterTax = recordWaterTax;
//    }
//
//    public double getRecordAmount() {
//        return waterUsageRecordRepository.getrecordAmount();
//    }
//
//    public void setRecordAmount(double recordAmount) {
//        this.recordAmount = recordAmount;
//    }

    
    
}
