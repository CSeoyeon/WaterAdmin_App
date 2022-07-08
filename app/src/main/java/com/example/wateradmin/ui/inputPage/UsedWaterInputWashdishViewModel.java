package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.ViewModel;

public class UsedWaterInputWashdishViewModel extends ViewModel {

    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private String selectedRadioValue;
    private double washDishWaterAmount;

    public void addWashDishAmountRecord(double washDishWaterAmount) {
        DishType dishType = DishType.HAND_MODE;
        switch (selectedRadioValue) {
            case "손 설거지":
                dishType = DishType.HAND_MODE;
                break;
            case "식기세척기":
                dishType =DishType.WASH_MACHINE;
                break;
        }

        UsedWaterInputWashdishRecord washDishAdd = new UsedWaterInputWashdishRecord(dishType, setWashDishWaterAmount(washDishWaterAmount));
        waterUsageRecordRepository.setAddWashdish(washDishAdd);
    }

    public double getWashDishWaterAmount() {
        return washDishWaterAmount;
    }

    public double setWashDishWaterAmount(double washDishWaterAmount) {
        this.washDishWaterAmount = washDishWaterAmount;
        return washDishWaterAmount;
    }

    public String getSelectedRadioValue() {
        return selectedRadioValue;
    }

    public void setSelectedRadioValue(String selectedRadioValue) {
        this.selectedRadioValue = selectedRadioValue;
    }
}
