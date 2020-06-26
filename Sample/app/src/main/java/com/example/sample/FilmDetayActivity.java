package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sample.model.Show;
import com.squareup.picasso.Picasso;

public class FilmDetayActivity extends AppCompatActivity {
    private Show show;

    private ImageView imgFilm;
    private TextView txtFilmDetay, txtFilmDili, txtFilmPuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detay);

        // önceki sayfadan gelen model nesnesini okuyoruz.
        show = (Show) getIntent().getSerializableExtra("film_detay");

        // toolbar
        setSupportActionBar((Toolbar) findViewById(R.id.activity_film_detay_toolbar));
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // film ismi
            getSupportActionBar().setTitle(show.getName());
        }

        // görsel nesneleri tanımlıyoruz.
        imgFilm = findViewById(R.id.activity_film_detay_img);
        txtFilmDetay = findViewById(R.id.activity_film_detay_txt_detay);
        txtFilmDili = findViewById(R.id.activity_film_detay_txt_dil);
        txtFilmPuan = findViewById(R.id.activity_film_detay_txt_puan);

        // film görseli
        if (show.getImage() != null)
            Picasso.with(getApplicationContext()).load(show.getImage().getOriginal()).into(imgFilm);

        // film detay
        txtFilmDetay.setText(Html.fromHtml(show.getSummary()));

        // film dili
        txtFilmDili.setText(show.getLanguage());

        // film puanı
        if (show.getRating().getAverage() != null)
            txtFilmPuan.setText(show.getRating().getAverage()+"/10");
        else
            txtFilmPuan.setText("-");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}