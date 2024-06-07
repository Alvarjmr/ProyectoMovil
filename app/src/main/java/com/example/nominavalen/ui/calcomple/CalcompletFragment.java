package com.example.nominavalen.ui.calcomple;

import static com.example.nominavalen.R.id.txt_salario;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nominavalen.R;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class CalcompletFragment extends Fragment {
    TextView txt_periodo, txt_diaslaborado, txt_salario, txt_transporte, txt_censantias;

    public CalcompletFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                int salario = bundle.getInt("Salario");
                boolean auxilioTransporte = bundle.getBoolean("auxilioTransporte");
                String fechaInicio = bundle.getString("FechaInicio");
                String fechaFin = bundle.getString("FechaFin");
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
                try {
                    Date dFechaInicio = dateFormat.parse(fechaInicio);
                    Date dFechaFin = dateFormat.parse(fechaFin);
                    if (dFechaInicio != null && dFechaFin != null) {
                        long dias = calculateDaysBetween(dFechaInicio, dFechaFin);

                        long cesantias = CalcularCesantias(salario, dias, auxilioTransporte);
                        double interesesCesantias = CalcularInteresesCesantias(cesantias, dias);
                        long primas = CalcularPrimas(salario, dias);
                        long vacaciones = CalcularVacaciones(salario, dias);

                        double total = cesantias + interesesCesantias + primas + vacaciones;
                        DecimalFormat decimalFormat = new DecimalFormat("#,###");
                        txt_salario.setText(
                                " Periodo: " + fechaInicio + " al "+ fechaFin
                                        + "\n Dias " + dias
                                        + "\n Cesantias: " + decimalFormat.format(cesantias)
                                        + "\n Intereses: " + decimalFormat.format(interesesCesantias)
                                        + "\n Primas: " + decimalFormat.format(primas)
                                        + "\n Vacaciones: " + decimalFormat.format(vacaciones)
                                        + "\n Total: " + decimalFormat.format(total)
                        );

                    } else {
                        //Mostrar un mensaje que indique que se debe ingresar una fecha válida y volver al fragment anterior
                    }
                } catch (ParseException e) {
                    //Mostrar un mensaje que indique que se debe ingresar una fecha válida y volver al fragment anterior
                }

            }
        });
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calcomplet, container, false);

        txt_salario = view.findViewById(R.id.txt_salario);
        return view;
    }

    private long CalcularCesantias(int SalarioMensual, long DiasTrabajados, boolean auxilioTransporte) {
        long cesantias = (SalarioMensual * DiasTrabajados) / 360;
        if (auxilioTransporte) {
            cesantias = cesantias + 100;
        }
        return cesantias;

        //(Salario mensual * Días trabajados)/360
    }

    private double CalcularInteresesCesantias(long Cesantias, long DiasTrabajados) {
        //(Cesantías * Días trabajados * 0,12)/360
        return (Cesantias * DiasTrabajados * 0.12) / 360;
    }

    private long CalcularPrimas(int SalarioMensual, long DiasTrabajados) {
        //(Salario mensual * Días trabajados en el semestre)/360
        return (SalarioMensual * DiasTrabajados) / 360;
    }

    private long CalcularVacaciones(int SalarioMensual, long DiasTrabajados) {
        //Salario mensual básico * Días trabajados)/720
        return (SalarioMensual * DiasTrabajados) / 720;
    }

    private long calculateDaysBetween(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        endCalendar.setTime(endDate);

        int startYear = startCalendar.get(Calendar.YEAR);
        int startMonth = startCalendar.get(Calendar.MONTH);
        int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);

        int endYear = endCalendar.get(Calendar.YEAR);
        int endMonth = endCalendar.get(Calendar.MONTH);
        int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);

        int yearDifference = endYear - startYear;
        int monthDifference = endMonth - startMonth;
        int dayDifference = endDay - startDay;

        long totalDays = (yearDifference * 12L + monthDifference) * 30 + dayDifference;

        return totalDays;
    }
}