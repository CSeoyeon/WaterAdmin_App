package com.example.wateradmin.ui.inputPage;

public class UsedWaterInputWashdishRecord {

    private DishType dishType;
    private double usedWashDishWaterAmount;
    public UsedWaterInputWashdishRecord(DishType dishType, double usedWashDishWaterAmount){
        this.dishType = dishType;
        this.usedWashDishWaterAmount = usedWashDishWaterAmount;

    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public double getUsedWashDishWaterAmount() {
        return usedWashDishWaterAmount;
    }

    public void setUsedWashDishWaterAmount(double usedWashDishWaterAmount) {
        this.usedWashDishWaterAmount = usedWashDishWaterAmount;
    }
}
