package com.example.wateradmin.ui.recordPage;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;
import com.example.wateradmin.ui.inputPage.model.UsageType;
import com.example.wateradmin.ui.inputPage.model.WaterUsageRecord;

import java.util.List;

public class RecordListViewModel extends ViewModel {

    //private String laundryTag;
    private UsageType laundryTag;
    private UsageRecordDate laundryDate;
    private double laundryWaterTax;
    private double laundryAmount;
    private WaterUsageRecord testRecord;

    private  WaterUsageRecord testRecord2;
    private UsageType testTag;

    private WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();


//    public WaterUsageRecord getLaundry(){
//
//
//        testRecord = waterUsageRecordRepository.getLaundryRecordsForToday().get(0);
//        //for each문 돌려서 다 뽑아내기
//
//        laundryTag = testRecord.getType();
//        Log.v("11", ""+ laundryTag);
//
//
//
//         return waterUsageRecordRepository.getLaundryRecordsForToday().get(0);
//    }



    //laundry 사용 기록 확인
    // public String getLaundryTag() {
//        return waterUsageRecordRepository.getLaundryTag();
//    }
//
//    public void setLaundryTag(String laundryTag) {
//        this.laundryTag = laundryTag;
//    }
//
//    public String getLaundryDate() {
//        return waterUsageRecordRepository.getLaundryDate();
//    }
//
//    public void setLaundryDate(UsageRecordDate laundryDate) {
//        this.laundryDate = laundryDate;
//    }
//
//    public double getLaundryWaterTax() {
//        return waterUsageRecordRepository.getLaundryWaterTax();
//    }
//
//    public void setLaundryWaterTax(double laundryWaterTax) {
//        this.laundryWaterTax = laundryWaterTax;
//    }
//
//    public double getLaundryAmount() {
//        return waterUsageRecordRepository.getLaundryAmount();
//    }
//
//    public void setLaundryAmount(double laundryAmount) {
//        this.laundryAmount = laundryAmount;
//    }
}
