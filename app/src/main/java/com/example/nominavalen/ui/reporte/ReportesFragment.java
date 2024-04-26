package com.example.nominavalen.ui.reporte;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nominavalen.databinding.FragmentReportesBinding;
import com.example.nominavalen.ui.reporte.ReportesViewModel;

public class ReportesFragment extends Fragment {

    private FragmentReportesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReportesViewModel reportesViewModel =
                new ViewModelProvider(this).get(ReportesViewModel.class);

        binding = FragmentReportesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textReporte;
        reportesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}