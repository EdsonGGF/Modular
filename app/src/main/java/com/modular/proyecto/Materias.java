package com.modular.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        mFirestore =FirebaseFirestore.getInstance();
        mRecycler=findViewById(R.id.recyclerViewSingle);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences prefs = getSharedPreferences("datosCarrera", MODE_PRIVATE);
        String carrera = prefs.getString("carrera", null);

       Log.i("FILTRAR","FILTRAR"+ carrera);
        CollectionReference materiasRef=mFirestore.collection("materias");
        Query query=materiasRef.whereEqualTo("carrera", carrera);
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