package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.ViewModel;

public class UsedWaterInputWashdishViewModel extends ViewModel {

    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private double washDishWaterAmount;

    public void addWashDishAmountRecord(double washDishWaterAmount) {

        UsedWaterInputLaundryRecord laundryAdd = new UsedWaterInputLaundryRecord(setWashDishWaterAmount(washDishWaterAmount));
        waterUsageRecordRepository.setAddLaundry(laundryAdd);
    }

    public double getWashDishWaterAmount() {
        return washDishWaterAmount;
    }

    public double setWashDishWaterAmount(double washDishWaterAmount) {
        this.washDishWaterAmount = washDishWaterAmount;
        return washDishWaterAmount;
    }
}
