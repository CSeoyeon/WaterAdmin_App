package com.example.wateradmin.ui.recordPage;

import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.inputPage.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.WaterUsageRecordRepository;

public class RecordListViewModel extends ViewModel {

    private String laundryTag;
    private UsageRecordDate laundryDate;
    private double laundryWaterTax;
    private double laundryAmount;

    private WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();

    public String getLaundryTag() {
        return waterUsageRecordRepository.getLaundryTag();
    }

    public void setLaundryTag(String laundryTag) {
        this.laundryTag = laundryTag;
    }

    public UsageRecordDate getLaundryDate() {
        return waterUsageRecordRepository.getLaundryDate();
    }

    public void setLaundryDate(UsageRecordDate laundryDate) {
        this.laundryDate = laundryDate;
    }

    public double getLaundryWaterTax() {
        return waterUsageRecordRepository.getLaundryWaterTax();
    }

    public void setLaundryWaterTax(double laundryWaterTax) {
        this.laundryWaterTax = laundryWaterTax;
    }

    public double getLaundryAmount() {
        return waterUsageRecordRepository.getLaundryAmount();
    }

    public void setLaundryAmount(double laundryAmount) {
        this.laundryAmount = laundryAmount;
    }
}
