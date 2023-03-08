package com.modular.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.modular.proyecto.adapter.MateriaAdapter;
import com.modular.proyecto.databinding.ActivityMateriasBinding;
import com.modular.proyecto.databinding.ActivityStudentBinding;
import com.modular.proyecto.model.Materia;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class Materias extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMateriasBinding binding;
    RecyclerView mRecycler;
    MateriaAdapter mAdapter;
    FirebaseFirestore mFirestore;
    Query query;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        mFirestore =FirebaseFirestore.getInstance();
        mRecycler=findViewById(R.id.recyclerViewSingle);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));









        query=mFirestore.collection("materias");
        FirestoreRecyclerOptions<Materia> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Materia>().setQuery(query,Materia.class).build();
        mAdapter=new MateriaAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

    }


    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}