package com.example.nominavalen.ui.liquidacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nominavalen.databinding.FragmentLiquidacionBinding;
import com.example.nominavalen.ui.liquidacion.LiquidacionViewModel;

public class LiquidacionFragment extends Fragment {

    private FragmentLiquidacionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LiquidacionViewModel liquidacionViewModel =
                new ViewModelProvider(this).get(LiquidacionViewModel.class);

        binding = FragmentLiquidacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLiquidacion;
        liquidacionViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}