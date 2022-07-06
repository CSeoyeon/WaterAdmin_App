package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.ViewModel;

public class UsedWaterInputLaundryViewModel extends ViewModel {
    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private String selectedRadioValue;
    private double usedWaterCount, laundryWaterAmount;    
    private static double usedWaterAmount;
    private static double waterTax;

    public void addLaundryWaterAmountRecord(double amountInLiters) {
        LaundryType laundryType = LaundryType.BASIC_MODE_COLD;
        switch (selectedRadioValue) {
            case "표준 모드(냉수)":
                laundryType = LaundryType.BASIC_MODE_COLD;
                laundryWaterAmount = 89;
                break;
            case "표준 모드(40도 이상)":
                laundryType =LaundryType.BASIC_MODE_HOT;
                laundryWaterAmount = 80.5;
                break;
            case "이불 세탁":
                laundryType = LaundryType.BEDDING_MODE;
                laundryWaterAmount = 157.0;
                break;
        }

        //UsedWaterInputLaundryRecord addLaundryWaterAmount = new UsedWaterInputLaundryRecord(laundryType, laundryWaterAmount);
        waterUsageRecordRepository.addCalculateWaterAmount(setUsedLaundryWater(usedWaterCount));
        waterUsageRecordRepository.addCalculateWaterTax(laundryWaterAmount);
    }


    public String getSelectedRadioValue() {
        return selectedRadioValue;
    }

    public void setSelectedRadioValue(String selectedRadioValue) {
        this.selectedRadioValue = selectedRadioValue;
    }

    public double setUsedLaundryWater(double usedWaterCount) {
        this.usedWaterCount = usedWaterCount;
        laundryWaterAmount = laundryWaterAmount * usedWaterCount;

        return laundryWaterAmount;
    }

    public static double getWaterTax() {
        return waterTax;
    }

    public static void setWaterTax(double waterTax) {
        UsedWaterInputLaundryViewModel.waterTax = waterTax;
    }



    
}
