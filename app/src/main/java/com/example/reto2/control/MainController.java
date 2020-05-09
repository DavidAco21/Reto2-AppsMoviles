package com.example.reto2.control;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;

import com.example.reto2.R;
import com.example.reto2.model.Data;
import com.example.reto2.model.Playlist;
import com.example.reto2.util.Constants;
import com.example.reto2.util.HTTPSWebUtilDomi;
import com.example.reto2.view.Main2Activity;
import com.example.reto2.view.MainActivity;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {

    private MainActivity activity;
    private HTTPSWebUtilDomi utilDavid;
    private ArrayList<Data> listaPlaylist;
    private Playlist playlist;
    private Main2Activity activity2;


    private Data data;


    public MainController(MainActivity activity){
        this.activity = activity;
        listaPlaylist = new ArrayList<>();
        utilDavid = new HTTPSWebUtilDomi();
        utilDavid.setListener(this);
        this.activity.getBtn_search().setOnClickListener(this);
        playlist = new Playlist();
        data = new Data();

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_search:
                String playList = activity.getEdt_playlist().getText().toString();


                new Thread(
                        ()->{
                            utilDavid.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/search/playlist?q="+playList);


                           if(listaPlaylist.size() <25) {
                               for (int i = 0; i < 25; i++) {
                                   Playlist playlist = new Playlist();
                               }
                           }
                        }

                ).start();

            break;
        }

    }


      public void onResponse(int callbackID, String response) {
        switch(callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                Playlist playlist = gson.fromJson(response, Playlist.class);

                activity.runOnUiThread(

                        ()->{
                            for (int i = 0; i<25;i++){
                                listaPlaylist.add(playlist.getData()[i]);
                                Log.e(">>>>>", String.valueOf(listaPlaylist.size()));
                            }





                        }
                );

                break;

        }
    }





    public ArrayList<Data> getListaPlaylist() {
        return listaPlaylist;
    }

    public void setListaPlaylist(ArrayList<Data> listaPlaylist) {
        this.listaPlaylist = listaPlaylist;
    }
}