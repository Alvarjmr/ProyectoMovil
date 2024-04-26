package com.example.nominavalen.ui.liquidacion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiquidacionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LiquidacionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Liquidacion");
    }

    public LiveData<String> getText() {
        return mText;
    }
}