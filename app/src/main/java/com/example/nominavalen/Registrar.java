package com.example.nominavalen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;//importar
import com.google.firebase.database.FirebaseDatabase;//imprtar

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Registrar extends AppCompatActivity {



    private TextInputEditText rnombre;
    private TextInputEditText rapellidos;
    private TextInputEditText rcorreo;
    private TextInputEditText rcontrasena;
    private TextInputEditText rcontancto;
    private Button btn_registrar;

    //variables que vamos a registrar

    FirebaseAuth mAuth;
    DatabaseReference refe;
    private  String autnombre;
    private  String autapellidos;
    private  String autcorreo;
    private  String autcontrasena;
    private  String autcontancto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);

        mAuth=FirebaseAuth.getInstance();
        refe = FirebaseDatabase.getInstance().getReference();

        rnombre = findViewById(R.id.rnombre);
        rapellidos = findViewById(R.id.rapellidos);
        rcorreo = findViewById(R.id.rcorreo);
        rcontrasena = findViewById(R.id.rcontrasena);
        rcontancto = findViewById(R.id.rcontancto);
        btn_registrar = findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autnombre = rnombre.getText().toString().trim();
                autapellidos = rapellidos.getText().toString().trim();
                autcorreo = rcorreo.getText().toString().trim();
                autcontrasena = rcontrasena.getText().toString().trim();
                autcontancto = rcontancto.getText().toString().trim();

                if (!autnombre.isEmpty() && !autapellidos.isEmpty() && !autcorreo.isEmpty() && !autcontrasena.isEmpty() && !autcontancto.isEmpty()){
                    if (autcontrasena.length()>=6){
                        registaruser();
                    }
                    else{
                        Toast.makeText(Registrar.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Registrar.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

      }
    private  void registaruser (){
        mAuth.createUserWithEmailAndPassword(autcorreo,autcontrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Map<String,Object> map = new HashMap<>();
                    map.put("Nombre", autnombre);
                    map.put("Apellidos", autapellidos);
                    map.put("Correo", autcorreo);
                    map.put("Contraseña", autcontrasena);
                    map.put("Contacto", autcontancto);
                    String id = mAuth.getCurrentUser().getUid();
                    refe.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Intent intent = new Intent(Registrar.this, Login.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(Registrar.this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(Registrar.this, "No se crearon los datos correctamente", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
                else{
                    Toast.makeText(Registrar.this, "No se puede registar el usurio", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}



