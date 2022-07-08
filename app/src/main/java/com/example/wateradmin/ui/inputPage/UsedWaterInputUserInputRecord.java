package com.example.wateradmin.ui.inputPage;

public class UsedWaterInputUserInputRecord {

    private String usedType;
    private double usedWater;

    public UsedWaterInputUserInputRecord(String usedType, double usedWater){
        this.usedType = usedType;
        this.usedWater = usedWater;
    }

    public double getUsedWater() {
        return usedWater;
    }

    public void setUsedWater(double usedWater) {
        this.usedWater = usedWater;
    }

    public String getUsedType() {
        return usedType;
    }

    public void setUsedType(String usedType) {
        this.usedType = usedType;
    }
}


