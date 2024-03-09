package com.example.app_3_pop2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.app_3_pop2.databinding.Fragment3Binding;

public class Fragment_3 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Fragment3Binding binding = Fragment3Binding.inflate(inflater, container, false);
        getChildFragmentManager()
                .setFragmentResultListener("requestKey", this, ((requestKey, result) -> {
                    binding.button3.setText(result.getString("bundleKey"));
                }));
        return binding.getRoot();
    }
}