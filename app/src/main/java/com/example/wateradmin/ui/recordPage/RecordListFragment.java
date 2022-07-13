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

import java.util.ArrayList;
import java.util.List;

public class RecordListFragment extends ListFragment {

    private FragmentRecordlistBinding binding;

    private RecordListViewModel recordListViewModel;
    private TextView tv_date, tv_useType, tv_waterAmount, tv_waterTax;

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

       lv_waterData = binding.recordListLvWaterRecord;

       for(Object record: recordListViewModel.getRecordTag()){
           waterUsedRecords.add(record);
       }

       setListAdapter(recordListAdapter);
       //recordListAdapter.addItem(날짜, 수도 사용량, 수도세);


        //ArrayAdapter<String> recordAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, waterUsedRecords);
        //lv_waterData.setAdapter(recordAdapter);



    }
}
