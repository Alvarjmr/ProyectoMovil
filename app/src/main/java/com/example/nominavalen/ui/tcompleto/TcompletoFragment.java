package com.example.nominavalen.ui.tcompleto;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nominavalen.R;
import com.example.nominavalen.databinding.FragmentTcompletoBinding;
import com.example.nominavalen.ui.tcompleto.TcompletoViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class TcompletoFragment extends Fragment {
    EditText fechainicio;

    private FragmentTcompletoBinding binding;
    @SuppressLint("WrongViewCast")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tcompleto, container, false);
        TcompletoViewModel tcompletoViewModel = new ViewModelProvider(this).get(TcompletoViewModel.class);
        binding = FragmentTcompletoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textTcompleto;
        tcompletoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        fechainicio = view.findViewById(R.id.fechaini);



        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;


    }

    public void calendarioini(View view) {
        DatePickerDialog d = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fechainicio.setText(year +"/"+ month + "/" + dayOfMonth);
            }
        }, 2024, Calendar.JANUARY, 1);
        d.show();
    }
}