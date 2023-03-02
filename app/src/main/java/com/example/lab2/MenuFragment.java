package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.lab2.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding;
    private String phone = "";

    public static final String KEY_PHONE = "key phone";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString(SignInFragment.KEY_NUMBER, phone);
                getParentFragmentManager().setFragmentResult(SignInFragment.KEY_RESULT, result);
                requireActivity().onBackPressed();
            }
        });
    }

    public static MenuFragment menuFragment(String phone){
        MenuFragment menuFragment = new MenuFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PHONE, phone);
        menuFragment.setArguments(bundle);
        return menuFragment;
    }

    public void getArgs(){
        Bundle bundle = this.getArguments();
        if (bundle != null){
            phone = bundle.getString(KEY_PHONE);
            binding.number.setText("+7" + phone);
        }
    }


}
