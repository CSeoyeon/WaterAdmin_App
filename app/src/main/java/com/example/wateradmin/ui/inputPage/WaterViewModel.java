package com.example.wateradmin.ui.inputPage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.fragment.NavHostFragment;

import com.example.wateradmin.R;

public class WaterViewModel extends ViewModel {

    private WaterUsageRecordRepository waterUsageRecordRepository = WaterUsageRecordRepository.getInstance();
    private String selectedSpinnnerValue;
    public void addNewUsageRecord(double amountInLiters) {
        UsageType usageType = UsageType.SHOWER;
        switch (selectedSpinnnerValue) {
            case "세탁":
                usageType = UsageType.LAUNDRY;
                break;
            case "세차":
                usageType = UsageType.CAR_WASH;
                break;
            case "설거지":
                usageType = UsageType.DISH_WASH;
                break;
            case "샤워":
                usageType = UsageType.SHOWER;
                break;
            case "사용자 입력":
                usageType = UsageType.USER_INPUT;
                break;
        }

        WaterUsageRecord toAdd = new WaterUsageRecord(usageType, amountInLiters, System.currentTimeMillis());
        waterUsageRecordRepository.addUsageRecord(toAdd);
    }

    public String getSelectedSpinnnerValue() {
        return selectedSpinnnerValue;
    }

    public void setSelectedSpinnnerValue(String selectedSpinnnerValue) {
        this.selectedSpinnnerValue =selectedSpinnnerValue;
    }


}
