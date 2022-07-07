package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.ViewModel;

public class UsedWaterInputUserInputViewModel extends ViewModel {
    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private double usedWaterInput;

    public void addUserInputWaterAmountRecord(double usedWaterInput){
        UsedWaterInputUserInputRecord usedWaterInputRecord  = new UsedWaterInputUserInputRecord(usedWaterInput);
        waterUsageRecordRepository.setAddUserInput(usedWaterInputRecord);
    }

    public double getUsedWaterInput() {
        return usedWaterInput;
    }

    public void setUsedWaterInput(double usedWaterInput) {
        this.usedWaterInput = usedWaterInput;
    }
}
