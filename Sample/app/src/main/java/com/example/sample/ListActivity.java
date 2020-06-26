package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sample.client.APIClient;
import com.example.sample.client.show.ShowRequest;
import com.example.sample.model.Item;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private String filmIsmi;

    private RecyclerView rcyFilmler;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // toolbar
        setSupportActionBar((Toolbar) findViewById(R.id.activity_film_list_toolbar));
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // görsel nesneleri tanımlıyoruz.
        rcyFilmler = findViewById(R.id.activity_film_listesi_rcy_filmler);

        // bir önceki sayfadan gelen veriyi okuyoruz.
        filmIsmi = getIntent().getStringExtra("film_ismi");

        new ShowRequest().getCameraSignals(new APIClient.BasicRequestEvents() {
            @Override
            public void onSuccess(List<Item> items) {
                itemAdapter = new ItemAdapter(items, ListActivity.this);
                rcyFilmler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                rcyFilmler.setAdapter(itemAdapter);
            }

            @Override
            public void onFailure(String s) { }
        }, ListActivity.this, filmIsmi);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}