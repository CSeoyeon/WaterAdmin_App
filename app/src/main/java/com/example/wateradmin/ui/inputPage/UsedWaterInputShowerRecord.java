package com.example.wateradmin.ui.inputPage;

public class UsedWaterInputShowerRecord {
    private double ShowerUsedWaterAmount;

    public UsedWaterInputShowerRecord(double ShowerUsedWaterAmount){
        this.ShowerUsedWaterAmount = ShowerUsedWaterAmount;
    }

    public double getUsedShowerWaterAmount() {
        return ShowerUsedWaterAmount;
    }

    public void setUsedShowerWaterAmount(double showerUsedWaterAmount) {
        ShowerUsedWaterAmount = showerUsedWaterAmount;
    }
}
