package com.example.lab2.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentSignInBinding;
import com.example.lab2.databinding.FragmentSignUpBinding;
import com.example.lab2.ui.state_holder.view_models.SignInViewModel;

public class SignInFragment extends Fragment {
    private FragmentSignInBinding binding;

    private SignInViewModel signInViewModel;

    public static final String KEY_PHONE = "key phone";
    public static final String KEY_PASSWORD = "key password";
    public static final String KEY_RESULT = "key result";
    public static final String KEY_NUMBER = "key number";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        signInViewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        binding.buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.enterPhone.getText().toString();
                if (signInViewModel.SignInLogin(
                        binding.enterPhone.getText().toString(), binding.enterPasswd.getText().toString()
                ))
                  Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_menuFragment);

            }
        });

        binding.hintSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_signUpFragment);
            }
        });

        getParentFragmentManager().setFragmentResultListener(KEY_RESULT, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String phone = result.getString(KEY_NUMBER);
                binding.enterPhone.setText(phone);
                binding.enterPasswd.setText(""); // clear password
            }
        });
    }

    /*public static SignInFragment signInFragment(String phone, String password){
        SignInFragment signInFragment = new SignInFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PHONE, phone);
        bundle.putString(KEY_PASSWORD, password);
        signInFragment.setArguments(bundle);
        return signInFragment;
    }*/

    public void getArgs(){
        Bundle bundle = this.getArguments();
        if (bundle != null){
            String phone = bundle.getString(KEY_PHONE);
            String password = bundle.getString(KEY_PASSWORD);
            binding.enterPhone.setText(phone);
            binding.enterPasswd.setText(password);
        }
    }

    /*public static SignInFragment signInFragment(){
        return new SignInFragment();
    }*/
}

