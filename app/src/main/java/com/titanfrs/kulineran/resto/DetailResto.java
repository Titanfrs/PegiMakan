package com.titanfrs.kulineran.resto;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.titanfrs.kulineran.R;

public class DetailResto extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail_resto);

            String nama_resto = getIntent().getExtras().getString("nama_resto");
            String alamat_resto = getIntent().getExtras().getString("alamat_resto");
            String foto_resto = getIntent().getExtras().getString("foto_resto");
            String phone_resto = getIntent().getExtras().getString("phone_resto");

            ImageView foto = (ImageView)findViewById(R.id.gambarresto);
            TextView resto = (TextView)findViewById(R.id.nama_resto);
            TextView alamat = (TextView)findViewById(R.id.alamat);
            TextView phone = (TextView)findViewById(R.id.no_telepon);


            resto.setText(nama_resto);
            alamat.setText(alamat_resto);
            Glide.with(this).load(foto_resto).into(foto);
            phone.setText(phone_resto);

        }
    }