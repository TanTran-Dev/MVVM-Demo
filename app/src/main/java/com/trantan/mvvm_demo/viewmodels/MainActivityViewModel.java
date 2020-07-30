package com.trantan.mvvm_demo.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.trantan.mvvm_demo.model.NicePlace;
import com.trantan.mvvm_demo.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<NicePlace>> nicePlaces;
    private NicePlaceRepository repository;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public void init(){
        if (nicePlaces != null){
            return;
        }
        repository = NicePlaceRepository.getInstance();
        nicePlaces = repository.getNicePlaces();
    }

    public void addNewValue(final NicePlace nicePlace){
        isUpdating.setValue(true);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlaces= nicePlaces.getValue();
                currentPlaces.add(nicePlace);
                nicePlaces.postValue(currentPlaces);
                isUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return nicePlaces;
    }

    public LiveData<Boolean> getIsUpdating(){
        return isUpdating;
    }
}
