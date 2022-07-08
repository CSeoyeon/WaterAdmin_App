package com.example.wateradmin.ui.inputPage;

public class UsedWaterInputLaundryRecord {

    private LaundryType laundryType;
    private double LaundryUsedWaterAmount;
    private UsageRecordDate date;

    public UsedWaterInputLaundryRecord(LaundryType laundryType, double usedLaundryWaterAmount, long timeInMillis){
        this.laundryType = laundryType;
        this.LaundryUsedWaterAmount = usedLaundryWaterAmount;
        this.date = new UsageRecordDate(timeInMillis);
    }

    public LaundryType getLaundryType() {
        return laundryType;
    }

    public void setLaundryType(LaundryType laundryType) {
        this.laundryType = laundryType;
    }

    public double getUsedWaterAmount() {
        return  LaundryUsedWaterAmount;
    }

    public void setUsedWaterAmount(double LaundryUsedWaterAmount) {
        this. LaundryUsedWaterAmount = LaundryUsedWaterAmount;
    }
    public UsageRecordDate getDate() {
        return date;
    }

    public void setDate(UsageRecordDate date) {
        this.date = date;
    }

}
