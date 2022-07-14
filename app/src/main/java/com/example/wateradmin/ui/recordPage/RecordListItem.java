package com.example.wateradmin.ui.recordPage;

import android.widget.TextView;

import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;

public class RecordListItem {

    private UsageRecordDate tv_date;
    private Double tv_usedWater;
    private Double tv_usedWaterTax;


    public RecordListItem(UsageRecordDate tv_date, Double tv_usedWater, Double tv_usedWaterTax) {
        this.tv_date = tv_date;
        this.tv_usedWater = tv_usedWater;
        this.tv_usedWaterTax = tv_usedWaterTax;
    }

    public UsageRecordDate getTv_date() {
        return tv_date;
    }

    public void setTv_date(UsageRecordDate tv_date) {
        this.tv_date = tv_date;
    }

    public double getTv_usedWater() {
        return tv_usedWater;
    }

    public void setTv_usedWater(double tv_usedWater) {
        this.tv_usedWater = tv_usedWater;
    }

    public double getTv_usedWaterTax() {
        return tv_usedWaterTax;
    }

    public void setTv_usedWaterTax(double tv_usedWaterTax) {
        this.tv_usedWaterTax = tv_usedWaterTax;
    }

}
