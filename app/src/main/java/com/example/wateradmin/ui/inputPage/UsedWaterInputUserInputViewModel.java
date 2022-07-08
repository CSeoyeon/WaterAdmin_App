package com.example.wateradmin.ui.inputPage;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class UsedWaterInputUserInputViewModel extends ViewModel {
    WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();

    private String usedWaterType;
    private double usedWaterInput;
    private String unitSelectedSpinnerValue;

    public void addUserInputWaterAmountRecord(String usedWaterType, double usedWaterInput){

        setUsedWaterInput(usedWaterInput);
        UsedWaterInputUserInputRecord usedWaterInputRecord  = new UsedWaterInputUserInputRecord(usedWaterType, setUnitSelectedSpinnerValue(unitSelectedSpinnerValue));

        waterUsageRecordRepository.setAddUserInput(usedWaterInputRecord);
    }

    public double getUsedWaterInput() {
        return usedWaterInput;
    }

    public void setUsedWaterInput(double usedWaterInput) {
        this.usedWaterInput = usedWaterInput;
    }

    public String getUsedWaterType() {
        return usedWaterType;
    }

    public void setUsedWaterType(String usedWaterType) {
        this.usedWaterType = usedWaterType;
    }

    public String getUnitSelectedSpinnerValue() {
        return unitSelectedSpinnerValue;
    }

    public double setUnitSelectedSpinnerValue(String unitSelectedSpinnerValue) {
        this.unitSelectedSpinnerValue = unitSelectedSpinnerValue;

        if (unitSelectedSpinnerValue == "L(리터)") {
            return usedWaterInput;
        }
        else if (unitSelectedSpinnerValue == "ml(밀리리터)") {
            return usedWaterInput / 1000;
        }
        else if (unitSelectedSpinnerValue == "dl(데시리터)") {
            return usedWaterInput / 10;
        }
        else if (unitSelectedSpinnerValue == "cm3(세제곱센티미터)") {
            return usedWaterInput * 1000;
        }

        return usedWaterInput;


    }



}
