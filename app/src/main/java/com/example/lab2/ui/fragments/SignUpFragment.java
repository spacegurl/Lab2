package com.example.lab2.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentSignUpBinding;
import com.example.lab2.ui.state_holder.view_models.SignUpViewModel;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;
    private SignUpViewModel signUpViewModel;
    private static final String SHARED_PREF_NAME = "name";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        super.onViewCreated(view, savedInstanceState);

        // read
        SharedPreferences sharedPrefRead =
                requireActivity().getPreferences(Context.MODE_PRIVATE);
        String sign_up_SP = sharedPrefRead.getString(SHARED_PREF_NAME, "");
        binding.regInputName.setText(sign_up_SP);

        binding.buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.enterPhone.getText().toString();
                String password = binding.enterPasswd.getText().toString();
                // write
                SharedPreferences sharedPrefWrite =
                        requireActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefWrite.edit();
                editor.putString(SHARED_PREF_NAME, binding.regInputName.getText().toString());
                editor.apply();
                if (signUpViewModel.SignUpLogin(
                        binding.regInputName.getText().toString(),
                        binding.enterPhone.getText().toString(),
                        binding.enterPasswd.getText().toString()
                )){
                    Bundle bundle = new Bundle();
                    bundle.putString(SignInFragment.KEY_PHONE, phone);
                    bundle.putString(SignInFragment.KEY_PASSWORD, password);

                    Navigation.findNavController(view)
                            .navigate(R.id.action_signUpFragment_to_signInFragment, bundle);
                }
            }
        });

        binding.hintSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.enterPhone.getText().toString();
                String password = binding.enterPasswd.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString(SignInFragment.KEY_PHONE, phone);
                bundle.putString(SignInFragment.KEY_PASSWORD, password);

                Navigation.findNavController(view)
                        .navigate(R.id.action_signUpFragment_to_signInFragment, bundle);
            }
        });
    }

    public static SignUpFragment signUpFragment(){
        return  new SignUpFragment();
    }


}
