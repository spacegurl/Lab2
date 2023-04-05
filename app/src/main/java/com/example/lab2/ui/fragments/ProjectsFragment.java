package com.example.lab2.ui.fragments;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.BannersAndService;
import com.example.lab2.R;
import com.example.lab2.databinding.FragmentProjectsBinding;
import com.example.lab2.data.database.entity.ProjectListItem;
import com.example.lab2.ui.state_holder.ProjectListRecyclerViewAdapter;
import com.example.lab2.ui.state_holder.view_models.ProjectsViewModel;

import java.util.List;

public class ProjectsFragment extends Fragment {

    private FragmentProjectsBinding binding;
    private static final String CHANNEL_ID = "notification";

    private ProjectsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProjectsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ProjectsViewModel.class);
        super.onViewCreated(view, savedInstanceState);

        viewModel.project_list_ld.observe(getViewLifecycleOwner(), new Observer<List<ProjectListItem>>() {
            @Override
            public void onChanged(List<ProjectListItem> projectListItems) {
                ProjectListRecyclerViewAdapter adapter = new ProjectListRecyclerViewAdapter(requireContext(), projectListItems); //получили список и отрисовали
                binding.recyclerView.setAdapter(adapter);
            }
        });



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager notificationManager =
                    (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }

        binding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notification = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.baseline_notifications_none_24)
                        .setContentTitle("Менеджер поставок")
                        .setContentText("Сдвигаются сроки поставки")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .build();

                NotificationManager notificationManager =
                        (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(1, notification);

                Intent intent = new Intent(requireContext(), BannersAndService.class);
                requireActivity().startService(intent);
            }
        });
    }
}
