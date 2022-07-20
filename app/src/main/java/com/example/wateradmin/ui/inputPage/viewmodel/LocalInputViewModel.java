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

    private List<String> siDoList;

    private HashMap<List<String>, List<String>> regionWaterTax;

    public void loadSiDoList()
    {
        regionRepository.getRegions(new RegionRepository.RepositoryCallback<List<String>>() {
            @Override
            public void onComplete(List<String> result) {
                siDoList = result;
                siDoLoaded.postValue(true);
            }
        });
    }

    public List<String> getSiDoList()
    {
        return siDoList;
    }

    public LiveData<Boolean> isSiDoLoaded()
    {
        return siDoLoaded;
    }
}
