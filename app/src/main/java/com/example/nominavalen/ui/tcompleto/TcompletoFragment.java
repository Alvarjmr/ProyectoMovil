package com.example.nominavalen.ui.tcompleto;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.nominavalen.R;
import com.example.nominavalen.ui.calcomple.CalcompletFragment;

import java.util.Calendar;

public class TcompletoFragment extends Fragment {
    EditText fechainiciocomple,fechafincomple;
    Button btn_calcularcomplet;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tcompleto, container, false);
        TcompletoViewModel tcompletoViewModel = new ViewModelProvider(this).get(TcompletoViewModel.class);
        final TextView textView = view.findViewById(R.id.salariomensual);
        tcompletoViewModel.getText().observe(getViewLifecycleOwner(),textView::setText);



        fechainiciocomple = view.findViewById(R.id.fechainiciocomple);
        fechafincomple = view.findViewById(R.id.fechafincomple);

        ImageView btnfechainicomple = view.findViewById(R.id.btnfechainicomple);
        ImageView btnfechafincomple =view.findViewById(R.id.btnfechafincomple);

        //fecha inicio
        btnfechainicomple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechainiciocomple.setText(year + "/" + (month +1) + "/" + dayOfMonth);
                    }
                }, 2024, Calendar.JANUARY, 1);
                d.show();
            }
        });
        //fin fecha inicio

        //fecha fin
        btnfechafincomple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechafincomple.setText(year + "/" + (month+1) + "/" + dayOfMonth);
                    }
                }, 2024, Calendar.JANUARY, 1);
                d.show();
            }
        });
        //fin fecha fin

        //inicio calcular tiempo completo
        btn_calcularcomplet= view.findViewById(R.id.btn_calcularcomplet);

        btn_calcularcomplet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_calcompletFragment);



            }
        });




        //fin calcular tiempo completo



        return view;
    }

    @Override
    public void onDestroyView() {


        super.onDestroyView();



    }

}