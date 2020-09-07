package com.mahao.leshan.ui.personal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalCenterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PersonalCenterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}