package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.ViewModel;

public class UsedWaterInputWashCarViewModel extends ViewModel {
    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private double carWashWaterCount = 1.0;
    private double usedCarWashWater;
    private String carWashType = "세차";

    public void addShowerWaterAmountRecord(int carWashWaterCount){
        Double.valueOf(carWashWaterCount);
        UsedWaterInputWashCarRecord washCarRecord = new UsedWaterInputWashCarRecord(carWashType, setUsedCarWashWater(carWashWaterCount));
        waterUsageRecordRepository.setAddWashCar(washCarRecord);

    }

    public double getCarWashWaterCount() {
        return carWashWaterCount;
    }

    public void setCarWashWaterCount(double carWashWaterCount) {
        this.carWashWaterCount = carWashWaterCount;
    }

    public String getCarWashType() {
        return carWashType;
    }

    public void setCarWashType(String carWashType) {
        this.carWashType = carWashType;
    }

    public double getUsedCarWashWater() {
        return usedCarWashWater;
    }

    public double setUsedCarWashWater(double carWashWaterCount) {
        this.usedCarWashWater = carWashWaterCount * 100;

        return usedCarWashWater;
    }
}
