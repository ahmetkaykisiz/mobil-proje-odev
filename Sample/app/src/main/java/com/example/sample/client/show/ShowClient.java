package com.example.sample.client.show;

import com.example.sample.client.APIClient;
import com.example.sample.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShowClient {
    @GET(APIClient.BASE_URL+"search/shows")
    Call<List<Item>> getItems(@Query("q") String key);
}
