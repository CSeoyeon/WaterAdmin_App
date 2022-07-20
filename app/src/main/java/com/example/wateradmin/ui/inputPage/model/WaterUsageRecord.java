package com.example.wateradmin.ui.inputPage.model;

import com.example.wateradmin.ui.inputPage.WaterTaxCalculator;
import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.model.UsageType;

public class WaterUsageRecord {
    private UsageType type;
    private double usedAmountInLiters;
    private UsageRecordDate date;

    public WaterUsageRecord(UsageType type, double usedAmountInLiters, long timeInMillis) {
        this.type = type;
        this.usedAmountInLiters = usedAmountInLiters;
        this.date = new UsageRecordDate(timeInMillis);
    }

    public UsageType getType() {
        return type;
    }

    public void setType(UsageType type) {
        this.type = type;
    }

    public double getUsedAmountInLiters() {
        return usedAmountInLiters;
    }

    public void setUsedAmountInLiters(double usedAmountInLiters) {
        this.usedAmountInLiters = usedAmountInLiters;
    }

    public UsageRecordDate getDate() {
        return date;
    }

    public void setDate(UsageRecordDate date) {
        this.date = date;
    }

    public String getFormatDate(){
        return (date.getYear() + "년 " + date.getMonth() + "월 " + date.getDay()+"일");
    }
    public double getWaterTax(){
        return WaterTaxCalculator.calculateWaterTax(getUsedAmountInLiters());
    }

}
