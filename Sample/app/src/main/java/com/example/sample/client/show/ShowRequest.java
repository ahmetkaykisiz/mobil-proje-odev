package com.example.sample.client.show;

import android.content.Context;

import com.example.sample.client.APIClient;
import com.example.sample.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowRequest {
    public void getCameraSignals(final APIClient.BasicRequestEvents events, Context context, String key){
        APIClient.getClient().create(ShowClient.class)
                .getItems(key)
                .enqueue(new Callback<List<Item>>() {
                    @Override
                    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                        if (response.code() == 200){
                            events.onSuccess(response.body());
                        } else {
                            events.onFailure(""+response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Item>> call, Throwable t) {
                        events.onFailure(t.getMessage());
                    }
                });
    }
}
