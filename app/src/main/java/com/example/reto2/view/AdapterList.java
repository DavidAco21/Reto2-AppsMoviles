package com.example.reto2.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.reto2.R;
import com.example.reto2.model.Data;
import com.example.reto2.model.Playlist;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolderDatos> {

    ArrayList<Data> listaPlaylist;
    private RecyclerViewClickInterface recyclerViewClickInterface;

    public AdapterList(ArrayList<Data> listaPlaylist, RecyclerViewClickInterface recyclerViewClickInterface){
        this.listaPlaylist = listaPlaylist;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }


    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.name_listTV.setText((CharSequence) listaPlaylist.get(position).getTitle());
        holder.userNameTV.setText((CharSequence) listaPlaylist.get(position).getUser().getName());
        holder.nb_tracksTV.setText(listaPlaylist.get(position).getNb_tracks());

        Glide.with(holder.imgList).load(listaPlaylist.get(position)
                .getPicture()).centerCrop().into(holder.imgList);





    }

    @Override
    public int getItemCount() {
        return listaPlaylist.size();
    }



    public class ViewHolderDatos extends RecyclerView.ViewHolder {

         TextView name_listTV;
         TextView userNameTV;
         TextView nb_tracksTV;
         ImageView imgList;
         RecyclerView recyclerList;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            name_listTV = itemView.findViewById(R.id.name_listTV);
            userNameTV = itemView.findViewById(R.id.userNameTV);
            nb_tracksTV = itemView.findViewById(R.id.nb_tracksTV);
            imgList = itemView.findViewById(R.id.imgList);
            recyclerList = itemView.findViewById(R.id.recycler_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickInterface.onItemClick(getAdapterPosition());



                }
            });

            itemView.setOnLongClickListener((view)->{

                recyclerViewClickInterface.onLongItemClick(getAdapterPosition());
                return  true;

            });

        }






    }
}
