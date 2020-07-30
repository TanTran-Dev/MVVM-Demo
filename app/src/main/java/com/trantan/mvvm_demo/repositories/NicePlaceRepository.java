package com.trantan.mvvm_demo.repositories;

import androidx.lifecycle.MutableLiveData;

import com.trantan.mvvm_demo.model.NicePlace;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Pattern
 */

public class NicePlaceRepository {
    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();
    public static  NicePlaceRepository getInstance(){
        if (instance == null) {
            instance = new NicePlaceRepository();
        }
        return instance;
    }


    // Pretend to get data from a web service or online source
    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        setNicePlaces();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);

        return data;
    }

    private void setNicePlaces(){

    }
}
