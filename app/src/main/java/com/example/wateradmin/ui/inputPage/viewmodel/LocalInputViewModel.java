package com.example.wateradmin.ui.inputPage.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wateradmin.ui.connection.RegionRepository;

import java.util.HashMap;
import java.util.List;

public class LocalInputViewModel extends ViewModel {

    private RegionRepository regionRepository = RegionRepository.getInstance();

    private MutableLiveData<Boolean> siDoLoaded = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> regionWaterTaxLoaded = new MutableLiveData<>(false);

    private List<String> siDoList;
    private List<String> regionWaterTaxList;

    public void loadSiDoList() {
        regionRepository.getRegions(new RegionRepository.RepositoryCallback<List<String>>() {
            @Override
            public void onComplete(List<String> regionResult, List<String> regionWaterTaxResult) {

                siDoList = regionResult;
                regionWaterTaxList = regionWaterTaxResult;

                siDoLoaded.postValue(true);

            }
        });
    }

    public List<String> getSiDoList() {
        return siDoList;
    }

    public LiveData<Boolean> isSiDoLoaded() {
        return siDoLoaded;
    }

    public List<String> getRegionWaterTaxList() {
        return regionWaterTaxList;
    }

    public void setRegionWaterTaxList(List<String> regionWaterTaxList) {
        this.regionWaterTaxList = regionWaterTaxList;
    }
}

