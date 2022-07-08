package com.example.wateradmin.ui.inputPage;

public class UsedWaterInputWashCarRecord {

    private double usedWashCarWaterAmount;
    private String carWashType;

    public UsedWaterInputWashCarRecord(String carWashType, double usedWashCarWaterAmount){

        this.carWashType = carWashType;
        this.usedWashCarWaterAmount =usedWashCarWaterAmount;
    }

    public double getUseWashCarWaterAmount() {
        return usedWashCarWaterAmount;
    }

    public void setUseWashCarWaterAmount(double usedWashCarWaterAmount) {
        this.usedWashCarWaterAmount = usedWashCarWaterAmount;
    }

    public String getCarWashType() {
        return carWashType;
    }

    public void setCarWashType(String carWashType) {
        this.carWashType = carWashType;
    }
}
