package com.example.lab2.ui.fragments;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentSignInAdminBinding;
import com.example.lab2.ui.state_holder.view_models.AdminViewModel;



public class AdminSignInFragment extends Fragment {
    private FragmentSignInAdminBinding binding;
    private AdminViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignInAdminBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AdminViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        binding.buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewModel.AdminLogin(
                        binding.enterPhone.getText().toString(), binding.enterPasswd.getText().toString(), allowedPermission()
                ))
                  Navigation.findNavController(view).navigate(R.id.action_signInAdminFragment_to_menuAdminFragment);
            }
        });
    }

    private boolean allowedPermission() {
        if (checkSelfPermission(requireContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PermissionChecker.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
    }
}
