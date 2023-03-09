package com.modular.proyecto.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.modular.proyecto.R;
import com.modular.proyecto.model.Materia;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MateriaAdapter extends FirestoreRecyclerAdapter<Materia,MateriaAdapter.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MateriaAdapter(@NonNull FirestoreRecyclerOptions<Materia> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull Materia Materia) {
        viewHolder.carrera.setText("Carrera: "+Materia.getCarrera());
        viewHolder.creditos.setText("Creditos: "+Materia.getCreditos());
        viewHolder.crn.setText("Clave: "+Materia.getCrn());
        Glide.with(viewHolder.img.getContext()).load(Materia.getImg()).into(viewHolder.img);
        viewHolder.maestro.setText("Profesor: "+Materia.getMaestro());
        viewHolder.materia.setText(Materia.getMateria());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_materia_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView carrera,creditos,crn,maestro,materia;
        CircleImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carrera=itemView.findViewById(R.id.textcarrera);
            creditos=itemView.findViewById(R.id.txtcreditos);
            crn=itemView.findViewById(R.id.txtcrn);
            img=(CircleImageView) itemView.findViewById(R.id.imagen_Materia);
            maestro=itemView.findViewById(R.id.txtmaestro);
            materia=itemView.findViewById(R.id.textmateria);


        }
    }
}
