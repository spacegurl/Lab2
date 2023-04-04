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

import com.example.lab2.data.models.ProjectListItem;
import com.example.lab2.databinding.FragmentProjectContentBinding;
import com.example.lab2.ui.state_holder.ProjectListRecyclerViewAdapter;
import com.example.lab2.ui.state_holder.view_models.ProjectContentViewModel;

public class ProjectContentFragment extends Fragment {
    private FragmentProjectContentBinding binding;
    private ProjectContentViewModel projectContentViewModel;

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int position = bundle.getInt(ProjectListRecyclerViewAdapter.KEY_POS);
            projectContentViewModel.getProjectContent(position);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProjectContentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        projectContentViewModel = new ViewModelProvider(this).get(ProjectContentViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        parseArgs();
        projectContentViewModel.project_content_ld.observe(getViewLifecycleOwner(), new Observer<ProjectListItem>() {
            @Override
            public void onChanged(ProjectListItem projectListItem) {
                binding.projectName.setText(projectListItem.getCompleted_project());
            }
        });
    }
}
