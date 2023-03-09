package com.modular.proyecto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.modular.proyecto.adapter.BecasAdapter;
import com.modular.proyecto.model.Beca;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BecasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BecasFragment extends Fragment {

    BecasAdapter bAdapter;
    FirebaseFirestore mFirestore;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BecasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_becas.
     */
    // TODO: Rename and change types and number of parameters
    public static BecasFragment newInstance(String param1, String param2) {
        BecasFragment fragment = new BecasFragment();
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
        View mRecycler =inflater.inflate(R.layout.fragment_becas, container, false);
        mFirestore = FirebaseFirestore.getInstance();
        RecyclerView recyclerView = (RecyclerView) mRecycler.findViewById(R.id.recyclerViewSingleBecas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        Query query=mFirestore.collection("becas");

        FirestoreRecyclerOptions<Beca> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Beca>().setQuery(query, Beca.class).build();
        bAdapter=new BecasAdapter(firestoreRecyclerOptions);
        bAdapter.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return mRecycler;
    }
}