package com.example.wateradmin.ui.inputPage;

import android.util.Log;

public class WaterTaxCalculator
{
    private static double laundryAmount, showerAmount, washdishAmount, washCarAmount, userInputAmount;
    private static double laundryWaterTax, showerWaterTax, washdishWaterTax, washCarWaterTax, userInputWaterTax;

    //수도세
    public static double calculateWaterTax(double usedAmount) {
        double waterTax;
        if(usedAmount >= 0 && usedAmount <= 20000){
            waterTax = usedAmount * 460;
            return waterTax;
        }
        else if(usedAmount >= 21000 && usedAmount <40000){
            waterTax = usedAmount * 720;
            return waterTax;
        }
        else{
            waterTax = usedAmount * 950;
            return waterTax; }
    }


    //물양
    public static double getLaundryAmount() {
        return laundryAmount;
    }

    public static void setLaundryAmount(double laundryAmount) {
        WaterTaxCalculator.laundryAmount = laundryAmount;
    }

    public static double getShowerAmount() {
        return showerAmount;
    }

    public static void setShowerAmount(double showerAmount) {
        WaterTaxCalculator.showerAmount = showerAmount;
    }

    public static double getWashdishAmount() {return washdishAmount;}

    public static void setWashdishAmount(double washdishAmount) {
        WaterTaxCalculator.washdishAmount = washdishAmount;
    }

    public static double getWashCarAmount() {
        return washCarAmount;
    }

    public static void setWashCarAmount(double washCarAmount) {
        WaterTaxCalculator.washCarAmount = washCarAmount;
    }

    public static double getUserInputAmount() {
        return userInputAmount;
    }

    public static void setUserInputAmount(double userInputAmount) {
        WaterTaxCalculator.userInputAmount = userInputAmount;
    }




    //수도세
    public static double getLaundryWaterTax(){
        return  calculateWaterTax(laundryAmount);
    }
    public void setLaundryWaterTax(double laundryWaterTax) {
        this.laundryWaterTax = laundryWaterTax;
    }

    public static double getShowerWaterTax() {
        return calculateWaterTax(showerAmount);
    }

    public static void setShowerWaterTax(double showerWaterTax) {
        WaterTaxCalculator.showerWaterTax = showerWaterTax;
    }

    public static double getWashdishWaterTax() {
        Log.v("",""+calculateWaterTax(washdishAmount));
        return calculateWaterTax(washdishAmount);
    }

    public static void setWashdishWaterTax(double washdishWaterTax) {
        WaterTaxCalculator.washdishWaterTax = washdishWaterTax;
    }

    public static double getWashCarWaterTax()
    {
        return calculateWaterTax(washCarAmount);
    }

    public static void setWashCarWaterTax(double washCarWaterTax) {
        WaterTaxCalculator.washCarWaterTax = washCarWaterTax;
    }

    public static double getUserInputWaterTax() {
        return calculateWaterTax(userInputAmount);
    }

    public static void setUserInputWaterTax(double userInputWaterTax) {
        WaterTaxCalculator.userInputWaterTax = userInputWaterTax;
    }
}