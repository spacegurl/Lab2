package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2.databinding.FragmentSignInBinding;
import com.example.lab2.databinding.FragmentSignUpBinding;

public class SignInFragment extends Fragment {
    private FragmentSignInBinding binding;

    public static final String KEY_PHONE = "key phone";
    public static final String KEY_PASSWORD = "key password";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        binding.buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.enterPhone.getText().toString();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, MenuFragment.menuFragment(phone))
                        .addToBackStack(null).commit();

            }
        });
    }

    public static SignInFragment signInFragment(String phone, String password){
        SignInFragment signInFragment = new SignInFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PHONE, phone);
        bundle.putString(KEY_PASSWORD, password);
        signInFragment.setArguments(bundle);
        return signInFragment;
    }

    public void getArgs(){
        Bundle bundle = this.getArguments();
        if (bundle != null){
            String phone = bundle.getString(KEY_PHONE);
            String password = bundle.getString(KEY_PASSWORD);
            binding.enterPhone.setText(phone);
            binding.enterPasswd.setText(password);
        }
    }

    public static SignInFragment signInFragment(){
        return new SignInFragment();
    }
}

