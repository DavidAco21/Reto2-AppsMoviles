package com.example.reto2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reto2.R;

public class Main3Activity extends AppCompatActivity {

    private TextView tv_nameTrack;
    private TextView tv_nameArtist;
    private TextView tv_nameAlbum;
    private TextView tv_duration;
    private Button btn_escuchar;
    private ImageView img_track;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_nameTrack = findViewById(R.id.tv_nameTrack);
        tv_nameArtist = findViewById(R.id.tv_nameArtist);
        tv_nameAlbum = findViewById(R.id.tv_nameAlbum);
        tv_duration = findViewById(R.id.tv_duration);
        btn_escuchar = findViewById(R.id.btn_escuchar);
        img_track = findViewById(R.id.img_track);


        Intent intent =  getIntent();
        String nameTrack = intent.getStringExtra("nameT");
        String nameArtist= intent.getStringExtra("nameArtist");
        String nameAlbum = intent.getStringExtra("nameAlbum");
        String duration = intent.getStringExtra("duration" );
        String urlImg = intent.getStringExtra("urlImg");
        String prev = intent.getStringExtra("prev");

        tv_nameTrack.setText(nameTrack);
        tv_nameArtist.setText(nameArtist);
        tv_nameAlbum.setText(nameAlbum);
        tv_duration.setText(duration+"s");

        Glide.with(img_track).load(urlImg).centerCrop().into(img_track);

        btn_escuchar.setOnClickListener(

                v->{
                    Uri uri = Uri.parse(prev);
                    Intent inte = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(inte);

        }
        );
    }
}
