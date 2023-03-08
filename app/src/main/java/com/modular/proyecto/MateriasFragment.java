package com.modular.proyecto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.modular.proyecto.adapter.MateriaAdapter;
import com.modular.proyecto.model.Materia;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class MateriasFragment extends Fragment {


    MateriaAdapter mAdapter;
    FirebaseFirestore mFirestore;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public MateriasFragment() {
        // Required empty public constructor
    }



    public static MateriasFragment newInstance(String param1, String param2) {
        MateriasFragment fragment = new MateriasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mRecycler =inflater.inflate(R.layout.fragment_materias, container, false);
        mFirestore =FirebaseFirestore.getInstance();
        RecyclerView recyclerView = (RecyclerView) mRecycler.findViewById(R.id.recyclerViewSingle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        Query query=mFirestore.collection("materias");

        FirestoreRecyclerOptions<Materia> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Materia>().setQuery(query,Materia.class).build();
        mAdapter=new MateriaAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return mRecycler;


    }
}