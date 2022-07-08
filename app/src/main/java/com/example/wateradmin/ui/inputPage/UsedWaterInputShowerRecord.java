package com.example.wateradmin.ui.inputPage;

public class UsedWaterInputShowerRecord {
    private double ShowerUsedWaterAmount;
    private String showerType;

    public UsedWaterInputShowerRecord(String showerType, double ShowerUsedWaterAmount){
        this.showerType = showerType;
        this.ShowerUsedWaterAmount = ShowerUsedWaterAmount;
    }

    public double getUsedShowerWaterAmount() {
        return ShowerUsedWaterAmount;
    }

    public void setUsedShowerWaterAmount(double showerUsedWaterAmount) {
        ShowerUsedWaterAmount = showerUsedWaterAmount;
    }

    public String getShowerType() {
        return showerType;
    }

    public void setShowerType(String showerType) {
        this.showerType = showerType;
    }
}
