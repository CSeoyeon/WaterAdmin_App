package com.example.wateradmin.ui.recordPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wateradmin.databinding.FragmentRecordlistBinding;

public class RecordListFragment extends Fragment
{

    private FragmentRecordlistBinding binding;
    private RecordListViewModel recordListViewModel;
    private RecordRecyclerViewAdapter recordRecyclerViewAdapter;

    private RecyclerView rv_records;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        recordListViewModel = new ViewModelProvider(this).get(RecordListViewModel.class);
        binding = FragmentRecordlistBinding.inflate(inflater, container, false);

        rv_records = binding.recordListRvRecords;
        if(recordRecyclerViewAdapter == null)
            recordRecyclerViewAdapter = new RecordRecyclerViewAdapter(recordListViewModel.getRecordList());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        rv_records.setLayoutManager(new LinearLayoutManager(requireContext()));
        rv_records.setAdapter(recordRecyclerViewAdapter);

        recordRecyclerViewAdapter.notifyDataSetChanged();
    }
}
