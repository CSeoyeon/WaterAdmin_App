package com.example.wateradmin.ui.inputPage;

public class WaterUsageRecord {
    private UsageType type;
    private double usedAmountInLiters;
    private UsageRecordDate date;

    public WaterUsageRecord(UsageType type, double usedAmountInLiters, long timeInMillis) {
        this.type = type;
        this.usedAmountInLiters = usedAmountInLiters;
        this.date = new UsageRecordDate(timeInMillis);
    }

    public UsageType getType() {
        return type;
    }

    public void setType(UsageType type) {
        this.type = type;
    }

    public double getUsedAmountInLiters() {
        return usedAmountInLiters;
    }

    public void setUsedAmountInLiters(double usedAmountInLiters) {
        this.usedAmountInLiters = usedAmountInLiters;
    }

    public UsageRecordDate getDate() {
        return date;
    }

    public void setDate(UsageRecordDate date) {
        this.date = date;
    }



}
