package com.example.wateradmin.ui.inputPage;

public class UsedWaterInputLaundryRecord {

    private LaundryType type;
    private double LaundryUsedWaterAmount;
    public UsedWaterInputLaundryRecord(double usedLaundryWaterAmount){
        this.LaundryUsedWaterAmount = usedLaundryWaterAmount;
    }

    public LaundryType getType() {
        return type;
    }

    public void setType(LaundryType type) {
        this.type = type;
    }

    public double getUsedWaterAmount() {
        return  LaundryUsedWaterAmount;
    }

    public void setUsedWaterAmount(double LaundryUsedWaterAmount) {
        this. LaundryUsedWaterAmount = LaundryUsedWaterAmount;

    }

}
