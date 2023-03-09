package com.modular.proyecto.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.modular.proyecto.R;
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



        }
    }
}
