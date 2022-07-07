package com.example.wateradmin.ui.inputPage;

import android.util.Log;

public class UsedWaterInputLaundryRecord {

    private LaundryType type;
    private static double usedWaterAmount;
    public UsedWaterInputLaundryRecord(double usedLaundryWaterAmount){
        this.usedWaterAmount = usedLaundryWaterAmount;
    }

    public LaundryType getType() {
        return type;
    }

    public void setType(LaundryType type) {
        this.type = type;
    }

    public double getUsedWaterAmount() {
        return usedWaterAmount;
    }

    public void setUsedWaterAmount(double usedWaterAmount) {
        this.usedWaterAmount = usedWaterAmount;

    }

}
