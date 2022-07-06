package com.example.wateradmin.ui.inputPage;

public class UsedWaterInputLaundryRecord {

    private LaundryType type;
    private double usedWaterAmount;
    public UsedWaterInputLaundryRecord(LaundryType type, double usedLaundryWaterAmount){
        this.type = type;
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
