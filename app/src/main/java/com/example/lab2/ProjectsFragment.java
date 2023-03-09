package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2.databinding.FragmentProjectsBinding;

import java.util.ArrayList;
import java.util.List;

public class ProjectsFragment extends Fragment {

    private FragmentProjectsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProjectsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] arr = {"Knightsbridge Penthouse", "London House", "Edinburgh Cottage",
                "Loch-Ness Scotland Villa", "221B Backer Street", "Clarence House", "Chanel Boutique", "Anna Vintour's Apartment"};
        List<ProjectListItem> list = new ArrayList<>();

        for (int i = 0; i < 250; i++){
            list.add(new ProjectListItem(R.drawable.paint_swatches, arr[(int)(Math.random() * arr.length)]));
        }

        ProjectListRecyclerViewAdapter adapter = new ProjectListRecyclerViewAdapter(requireContext(), list);
        binding.recyclerView.setAdapter(adapter);

    }
}
