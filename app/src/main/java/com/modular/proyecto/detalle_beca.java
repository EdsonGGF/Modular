package com.modular.proyecto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import de.hdodenhof.circleimageview.CircleImageView;


public class detalle_beca extends AppCompatActivity {

    TextView nombreBeca,descripcionBeca;
    String url;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_beca);
        nombreBeca=findViewById(R.id.textNombreBeca);
        descripcionBeca=findViewById(R.id.descripcion_beca);
        Intent intent=getIntent();
        String nombre=intent.getStringExtra("nombre");
        String descripcion=intent.getStringExtra("descripcion");
        url=intent.getStringExtra("imagen");
        img=findViewById(R.id.imagen_Beca);
        Glide.with(detalle_beca.this.getApplicationContext())
                        .load(url)
                                .into(img);
        nombreBeca.setText(nombre);
        descripcionBeca.setText(descripcion);
        Log.i("PRUEBA","NOMBRE BECA "+nombre);

    }



}