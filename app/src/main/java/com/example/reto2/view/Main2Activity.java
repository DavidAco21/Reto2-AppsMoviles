package com.example.reto2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reto2.R;
import com.example.reto2.model.Track;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements RecyclerViewClickInterface{

    private ImageView img_banner;
    private TextView tv_namePlaylist;
    private TextView user;
    private TextView tv_songs;
    private ListView lv_songs;
    private ArrayList<Track> tracks;
    private AdapterTrack adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        img_banner = findViewById(R.id.img_banner);
        tv_namePlaylist = findViewById(R.id.tv_namePlaylist);
        user = findViewById(R.id.tv_user);
        tv_songs = findViewById(R.id.tv_songs);
        lv_songs = findViewById(R.id.lv_songs);
        tracks = new ArrayList<Track>();


        Intent intent =  getIntent();
        String nameP = intent.getStringExtra("namePlaylist");
        String nameU = intent.getStringExtra("nameUser");
        String nb_tracks = intent.getStringExtra("nbTracks");
        String imgBanner = intent.getStringExtra("img");
        String userx = intent.getStringExtra("user");


        tracks = (ArrayList<Track>) intent.getExtras().getSerializable("track");
        tv_namePlaylist.setText(nameP);
        user.setText(nameU);
        tv_songs.setText(nb_tracks);
        user.setText(userx);


        Glide.with(img_banner).load(imgBanner).centerCrop().into(img_banner);

        adapter = new AdapterTrack(tracks,this, this);
        lv_songs.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
        intent.putExtra("nameT", tracks.get(position).getTitle());
        intent.putExtra("nameArtist", tracks.get(position).getArtist().getName());
        intent.putExtra("nameAlbum", tracks.get(position).getAlbum().getTitle());
        intent.putExtra("duration",tracks.get(position).getDuration());
        intent.putExtra("urlImg", tracks.get(position).getAlbum().getCover_medium());
        intent.putExtra("prev", tracks.get(position).getPreview());
        startActivity(intent);
    }

    @Override
    public void onLongItemClick(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
