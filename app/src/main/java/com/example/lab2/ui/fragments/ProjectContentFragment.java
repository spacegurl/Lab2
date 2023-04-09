package com.example.lab2.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.R;
import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.databinding.FragmentProjectContentBinding;
import com.example.lab2.ui.state_holder.adapter.ProjectListRecyclerViewAdapter;
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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.project_content, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        binding.dotsMenu.setAdapter(adapter);
        binding.dotsMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    String content = binding.projectContentText.getText().toString();
                    Intent textIntent = new Intent(Intent.ACTION_SEND); // открывается список приложений,
                    // которые принимают это action
                    textIntent.setType("text/plain"); // тип содержимого
                    textIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sheshukov_leonid@edu.mirea.ru"});
                    textIntent.putExtra(Intent.EXTRA_SUBJECT, "This Is The Way of " + getString(R.string.app_name));
                    textIntent.putExtra(Intent.EXTRA_TEXT, content);
                    requireActivity().startActivity(textIntent);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        projectContentViewModel.project_content_ld.observe(getViewLifecycleOwner(), new Observer<ProjectListItem>() {
            @Override
            public void onChanged(ProjectListItem projectListItem) {
                binding.projectName.setText(projectListItem.getCurrent_project());
            }
        });
    }
}
