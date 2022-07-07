package com.example.wateradmin.ui.inputPage;


import androidx.lifecycle.ViewModel;

public class UsedWaterInputShowerViewModel extends ViewModel {
    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private double usedWaterCount, showerWaterMinute;

    public void addShowerWaterAmountRecord(int usedShowerMinute){
        UsedWaterInputShowerRecord showerRecord = new UsedWaterInputShowerRecord(setShowerWaterMinute(usedShowerMinute));
        waterUsageRecordRepository.setAddShower(showerRecord);

    }

    public double getUsedWaterCount() {
        return usedWaterCount;
    }

    public void setUsedWaterCount(double usedWaterCount) {
        this.usedWaterCount = usedWaterCount;
    }

    public double getShowerWaterMinute() {
        return showerWaterMinute;
    }

    public double setShowerWaterMinute(double showerWaterMinute) {
        this.showerWaterMinute = showerWaterMinute;
        return   showerWaterMinute * 12;
    }
}
