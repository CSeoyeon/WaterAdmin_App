package com.example.wateradmin.ui.recordPage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wateradmin.databinding.FragmentRecordlistBinding;
import com.example.wateradmin.ui.inputPage.model.UsageRecordDate;
import com.example.wateradmin.ui.inputPage.model.UsageType;

import java.util.ArrayList;
import java.util.List;

public class RecordListFragment extends ListFragment {

    private FragmentRecordlistBinding binding;

    private RecordListViewModel recordListViewModel;
    private double waterAmount = 10;
    private double watertax =10;

    private ListView lv_waterData;
    private List waterUsedRecords = new ArrayList(){};
    private RecordListAdapter recordListAdapter = new RecordListAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        recordListViewModel = new ViewModelProvider(this).get(RecordListViewModel.class);
        binding = FragmentRecordlistBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(recordListAdapter);

        //recordListAdapter.addItem(날짜, 수도 사용량, 수도세);
        //recordListAdapter.addItem(null, waterAmount, watertax);



       lv_waterData = binding.list;
       for(Object record: recordListViewModel.getRecordList()){
           waterUsedRecords.add(record);
       }


        ArrayAdapter<String> recordAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, waterUsedRecords);
        lv_waterData.setAdapter(recordAdapter);


    }
}
