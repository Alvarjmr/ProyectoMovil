package com.example.nominavalen.ui.reporte;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReportesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ReportesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Reportes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}