package com.example.lab2.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentArchiveBinding;
import com.example.lab2.domain.entity.ArchiveListItem;
import com.example.lab2.ui.state_holder.ArchiveListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ArchiveFragment extends Fragment {

    private FragmentArchiveBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentArchiveBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] arr = {"Cambridge Campus", "Chelsea Cottage", "Gherkin Vogue Office",
                "Oxford Campus", "Birmingham Campus", "Manchester Campus", "Bristol Campus", "Leeds Campus"};
        List<ArchiveListItem> list = new ArrayList<>();

        for (int i = 0; i < 250; i++){
            list.add(new ArchiveListItem(R.drawable.cat_on_docs, arr[(int)(Math.random() * arr.length)]));
        }

        ArchiveListAdapter adapter = new ArchiveListAdapter(requireContext(), R.layout.item_archive_list, list);
        binding.archiveList.setAdapter(adapter);

    }
}
