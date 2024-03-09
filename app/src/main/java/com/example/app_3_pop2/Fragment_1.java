package com.example.app_3_pop2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.app_3_pop2.databinding.FragmentSecondBinding;

import java.util.zip.Inflater;

public class Fragment_1 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(
                            R.id.fragment_container,
                            Fragment_2.class,
                            null
                    )
                    .commit();
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(
                            R.id.fragment_container_2,
                            Fragment_3.class,
                            null
                    )
                    .commit();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSecondBinding binding = FragmentSecondBinding.inflate(inflater, container, false);
        getChildFragmentManager()
                .setFragmentResultListener("requestKey", this, ((requestKey, result) -> {
                    binding.daleeButton.setText(result.getString("bundleKey"));
                }));
        return binding.getRoot();
    }
}