package com.modular.proyecto.adapter;


import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.modular.proyecto.LoginActivity;
import com.modular.proyecto.R;
import com.modular.proyecto.WelcomeActivity;
import com.modular.proyecto.detalle_beca;
import com.modular.proyecto.model.Beca;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class BecasAdapter extends FirestoreRecyclerAdapter<Beca,BecasAdapter.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BecasAdapter(@NonNull FirestoreRecyclerOptions<Beca> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull Beca Beca) {
        viewHolder.nombre.setText( Beca.getNombre());
        viewHolder.descripcion.setText(Beca.getDescripcion());
        Glide.with(viewHolder.img.getContext()).load(Beca.getImg()).into(viewHolder.img);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), detalle_beca.class);
                //intent.putExtra("model", model);
                intent.putExtra("nombre", Beca.getNombre());
                intent.putExtra("descripcion", Beca.getDescripcion());
                intent.putExtra("imagen",Beca.getImg());
                v.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_beca_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,descripcion;
        CircleImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.textNombreBeca);
            descripcion=itemView.findViewById(R.id.txtDescripcion);
            img=(CircleImageView) itemView.findViewById(R.id.imagen_Beca);
           // itemView.setOnClickListener(this);
        }
/*
        @Override
        public void onClick(View v) {
        int pos=getAdapterPosition();
            Log.i("POSICION",""+pos);
           Intent intent=new Intent(v.getContext(),detalle_beca.class);
           v.getContext().startActivity(intent);
        }*/
    }
}
