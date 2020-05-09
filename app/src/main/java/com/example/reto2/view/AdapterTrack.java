package com.example.reto2.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reto2.R;
import com.example.reto2.model.Track;

import java.util.ArrayList;

public class AdapterTrack extends BaseAdapter {

    private ArrayList<Track> listTracks;
    private Context context;
    private RecyclerViewClickInterface recyclerViewClickInterface;

    public AdapterTrack(ArrayList<Track> listTracks, Context context, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.listTracks = listTracks;
        this.context = context;
        this.recyclerViewClickInterface = recyclerViewClickInterface;

    }

    @Override
    public int getCount() {
        return listTracks.size();
    }

    @Override
    public Object getItem(int position) {
        return listTracks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Track track = (Track) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_track,null,false);
        ImageView image = convertView.findViewById(R.id.img_track);
        TextView name_track = convertView.findViewById(R.id.tv_track);
        TextView name_artist = convertView.findViewById(R.id.tv_artist);
        TextView release_year = convertView.findViewById(R.id.tv_year);

        // image.setImageResource();
        name_track.setText("Nombre: "+ track.getTitle());
        name_artist.setText("Artista: "+track.getArtist().getName());
        release_year.setText("Fecha de Lanzamiento: "+ track.getRelease_date());

        Glide.with(image).load(track.getAlbum().getCover_medium()).centerCrop().into(image);

        convertView.setOnClickListener(view -> {
            recyclerViewClickInterface.onItemClick(position);

        });


        return convertView;
    }

    public ArrayList<Track> getListTracks() {
        return listTracks;
    }
}