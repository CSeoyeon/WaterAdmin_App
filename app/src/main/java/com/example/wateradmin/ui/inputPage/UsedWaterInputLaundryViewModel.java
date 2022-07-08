package com.example.wateradmin.ui.inputPage;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class UsedWaterInputLaundryViewModel extends ViewModel {
    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private String selectedRadioValue;
    private double usedWaterCount, laundryWaterAmount;

    public void addLaundryWaterAmountRecord(double usedLaundryWaterAmount, double usedCount) {

        LaundryType laundryType = LaundryType.BASIC_MODE_COLD;
        switch (selectedRadioValue) {
            case "표준 모드(냉수)":
                laundryType = LaundryType.BASIC_MODE_COLD;
                break;
            case "표준 모드(40도 이상)":
                laundryType =LaundryType.BASIC_MODE_HOT;
                break;
            case "이불 세탁":
                laundryType = LaundryType.BEDDING_MODE;
                break;
        }
        UsedWaterInputLaundryRecord laundryAdd = new UsedWaterInputLaundryRecord(laundryType, setUsedLaundryWater(usedLaundryWaterAmount, usedCount), System.currentTimeMillis());
        waterUsageRecordRepository.setAddLaundry(laundryAdd);
        waterUsageRecordRepository.addUsageRecord(laundryAdd);

    }

    public String getSelectedRadioValue() {
        return selectedRadioValue;
    }

    public void setSelectedRadioValue(String selectedRadioValue) {
        this.selectedRadioValue = selectedRadioValue;
    }

    public double setUsedLaundryWater(double laundryWaterAmount, double usedWaterCount) {
        this.usedWaterCount = usedWaterCount;
        laundryWaterAmount = laundryWaterAmount * usedWaterCount;
        return laundryWaterAmount;

    }

    public double getUsedWaterCount() {
        return usedWaterCount;
    }

    public void setUsedWaterCount(double usedWaterCount) {
        this.usedWaterCount = usedWaterCount;
    }

    public double getLaundryWaterAmount() {
        return laundryWaterAmount;
    }

    public void setLaundryWaterAmount(double laundryWaterAmount) {
        this.laundryWaterAmount = laundryWaterAmount;
    }
}
