package com.modular.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.modular.proyecto.adapter.BecasAdapter;
import com.modular.proyecto.model.Beca;

public class Becas extends AppCompatActivity {
    RecyclerView bRecycler;
    BecasAdapter bAdapter;
    FirebaseFirestore mFirestore;
    Query query;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_becas);

        mFirestore =FirebaseFirestore.getInstance();
        bRecycler=findViewById(R.id.recyclerViewSingleBecas);
        bRecycler.setLayoutManager(new LinearLayoutManager(this));









        query=mFirestore.collection("becas");
        FirestoreRecyclerOptions<Beca> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Beca>().setQuery(query,Beca.class).build();
        bAdapter=new BecasAdapter(firestoreRecyclerOptions);
        bAdapter.notifyDataSetChanged();
       bRecycler.setAdapter(bAdapter);

    }


    @Override
    protected void onStart() {
        super.onStart();
       bAdapter.startListening();
        bRecycler.getRecycledViewPool().clear();
        bAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bAdapter.stopListening();
    }
}