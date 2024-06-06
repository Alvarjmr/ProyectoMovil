package com.example.nominavalen.ui.xdias;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nominavalen.R;
import com.example.nominavalen.databinding.FragmentXdiasBinding;
import com.example.nominavalen.ui.xdias.XdiasViewModel;

import java.util.Calendar;

public class XdiasFragment extends Fragment {

    EditText fechainicioxdias,fechafinxdias;

    @SuppressLint({"MissingInflatedId", "WrongViewCast", "CutPasteId"})
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xdias, container, false);
        XdiasViewModel xdiasViewModel = new ViewModelProvider(this).get(XdiasViewModel.class);
        final TextView textView = view.findViewById(R.id.salarixdias);
        xdiasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        fechainicioxdias = view.findViewById(R.id.fechainicioxdias);
        fechafinxdias = view.findViewById(R.id.fechafinxdias);

        ImageView btnfechainioxdias = view.findViewById(R.id.btnfechainioxdias);
        ImageView btnfechafinxdias =view.findViewById(R.id.btnfechafinxdias);

        //fecha inicio
        btnfechainioxdias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechainicioxdias.setText(year + "/" + month + "/" + dayOfMonth);
                    }
                }, 2024, Calendar.JANUARY, 1);
                d.show();
            }
        });
        //fin fecha inicio

        //fecha fin
        btnfechafinxdias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechafinxdias.setText(year + "/" + month + "/" + dayOfMonth);
                    }
                }, 2024, Calendar.JANUARY, 1);
                d.show();
            }
        });
        //fin fecha fin
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}