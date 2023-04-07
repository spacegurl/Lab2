package com.example.lab2.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentArchiveBinding;
import com.example.lab2.data.models.ArchiveListItem;
import com.example.lab2.ui.state_holder.adapter.ArchiveListAdapter;
import com.example.lab2.ui.state_holder.view_models.ArchiveViewModel;

import java.util.List;

public class ArchiveFragment extends Fragment {

    private FragmentArchiveBinding binding;
    private ArchiveViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentArchiveBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ArchiveViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        viewModel.archive_list_ld.observe(getViewLifecycleOwner(), new Observer<List<ArchiveListItem>>() {
            @Override
            public void onChanged(List<ArchiveListItem> archiveListItems) {
                ArchiveListAdapter adapter = new ArchiveListAdapter(requireContext(), R.layout.item_archive_list, archiveListItems);
                binding.archiveList.setAdapter(adapter);
            }
        });



    }
}
