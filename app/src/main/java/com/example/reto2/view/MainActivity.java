package com.example.reto2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.reto2.R;
import com.example.reto2.control.MainController;
import com.example.reto2.model.Data;
import com.example.reto2.model.Playlist;
import com.example.reto2.model.Track;
import com.example.reto2.util.Constants;
import com.example.reto2.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface, HTTPSWebUtilDomi.OnResponseListener {

    private MainController controller;
    private Button btn_search;
    private EditText edt_playlist;
    private RecyclerView recyclerList;
    private AdapterList adapter;
    private ArrayList<Data> listaPlaylist;
    private String idPlayList;
    private HTTPSWebUtilDomi utilDavid;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPlaylist = new ArrayList<>();
        recyclerList = findViewById(R.id.recycler_view);
        btn_search = findViewById(R.id.btn_search);
        edt_playlist = findViewById(R.id.edt_playlist);
        controller = new MainController(this);
        recyclerList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterList(controller.getListaPlaylist(), this);
        recyclerList.setAdapter(adapter);
        utilDavid = new HTTPSWebUtilDomi();
        utilDavid.setListener(this);




        Log.e(">>>>", String.valueOf(controller.getListaPlaylist().size()));
    }


    public MainController getController() {
        return controller;
    }

    public Button getBtn_search() {
        return btn_search;
    }

    public EditText getEdt_playlist() {
        return edt_playlist;
    }

    @Override
    public void onItemClick(int position) {

        name = controller.getListaPlaylist().get(position).getUser().getName();

        new Thread(
                () -> {
                    idPlayList = controller.getListaPlaylist().get(position).getId();
                    Log.e(">>>>>>>>>>>>>","hey heyeyheye"+idPlayList);


                    utilDavid.GETrequest(Constants.SEARCH_PLAYLIST,
                            "https://api.deezer.com/playlist/"+idPlayList);



                }
        ).start();

    }

    public void onResponse(int callbackID, String response) {
        switch (callbackID) {
            case Constants.SEARCH_PLAYLIST:
                Gson gson = new Gson();
                Data data = gson.fromJson(response, Data.class);

                Log.e(">>>>>>>",response);

                ArrayList<Track> tracks = new ArrayList<>();

                for(int i = 0; i<data.getTracks().getData().length; i++){
                    tracks.add(data.getTracks().getData()[i]);
                }


                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("namePlaylist", data.getTitle());
                intent.putExtra("nbTracks", data.getNb_tracks());
                intent.putExtra("img", data.getPicture_big());
                intent.putExtra("user", name);

                intent.putExtra("track", tracks);

                startActivity(intent);


        }

    }

    public String getIdPlayList() {
        return idPlayList;
    }

    @Override
    public void onLongItemClick(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
