package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.ViewModel;

public class UsedWaterInputWashCarViewModel extends ViewModel {
    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private double WashCarWaterCount = 1.0;
    private double usedCarWashWater;

    public void addShowerWaterAmountRecord(int WashCarWaterCount){
        Double.valueOf(WashCarWaterCount);
        UsedWaterInputWashCarRecord washCarRecord = new UsedWaterInputWashCarRecord(setUsedCarWashWater(WashCarWaterCount));
        waterUsageRecordRepository.setAddWashCar(washCarRecord);

    }

    public double getWashCarWaterCount() {
        return WashCarWaterCount;
    }

    public void setWashCarWaterCount(double washCarWaterCount) {
        WashCarWaterCount = washCarWaterCount;
    }

    public double getUsedCarWashWater() {
        return usedCarWashWater;
    }

    public double setUsedCarWashWater(double WashCarWaterCount) {
        this.usedCarWashWater = WashCarWaterCount * 100;

        return usedCarWashWater;
    }
}
