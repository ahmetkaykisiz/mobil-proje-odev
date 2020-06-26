package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText edtArama;
    private Button btnAra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // görsel nesneleri tanımlıyoruz.
        edtArama = findViewById(R.id.activity_main_edt_arama);
        btnAra = findViewById(R.id.activity_main_btn_ara);

        // ara butonu tıklama işlemi.
        btnAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* anahtar kelimeyi diğer sayfaya aktarmak için bir intent oluşturup
                bu intente stringi ekliyoruz. */
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                intent.putExtra("film_ismi", edtArama.getText().toString().trim());
                // yeni sayfaya geç.
                startActivity(intent);
            }
        });
    }
}