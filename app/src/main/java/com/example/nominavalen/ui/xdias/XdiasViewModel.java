package com.example.nominavalen.ui.xdias;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class XdiasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public XdiasViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}