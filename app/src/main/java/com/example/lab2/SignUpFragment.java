package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2.databinding.FragmentSignUpBinding;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.enterPhone.getText().toString();
                String password = binding.enterPasswd.getText().toString();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, SignInFragment.signInFragment(phone, password))
                        .commit();
            }
        });
        binding.hintSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, SignInFragment.signInFragment())
                        .commit();
            }
        });
    }

    public static SignUpFragment signUpFragment(){
        return  new SignUpFragment();
    }


}
