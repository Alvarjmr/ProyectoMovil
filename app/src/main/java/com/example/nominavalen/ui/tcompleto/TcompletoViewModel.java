package com.example.nominavalen.ui.tcompleto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TcompletoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TcompletoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tiempo Completo");
    }

    public LiveData<String> getText() {
        return mText;
    }
}