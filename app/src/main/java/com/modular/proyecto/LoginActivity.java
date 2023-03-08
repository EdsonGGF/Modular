package com.modular.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button btnLogin;
    TextInputEditText txtInputCodigo, txtInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mAuth= FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);

        txtInputCodigo = findViewById(R.id.edtEmail);
        txtInputPassword = findViewById(R.id.edtContraseña);
        btnLogin = (Button) findViewById(R.id.InicioSesion);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser=txtInputCodigo.getText().toString();
                String passUser=txtInputPassword.getText().toString();

                if(emailUser.isEmpty()){
                    txtInputCodigo.setError("Introduce tu correo electronico");

                }else if(passUser.isEmpty()){
                    txtInputPassword.setError("Introduce tu contraseña");
                }else{
                    loginUser(emailUser, passUser);
                }
            }
        });


    }

    private void loginUser(String emailUser, String passUser) {
        mAuth.signInWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();

                    startActivity(new Intent(LoginActivity.this,StudentActivity.class));
                    Toast.makeText(LoginActivity.this,"Bienvenido",Toast.LENGTH_SHORT).show();

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this,"Contraseña y/o usuario incorrecto",Toast.LENGTH_SHORT).show();

            }
        });
    }


}