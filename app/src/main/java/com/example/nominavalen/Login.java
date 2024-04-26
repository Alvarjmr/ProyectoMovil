package com.example.nominavalen;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class Login extends AppCompatActivity {
    EditText temail ,tpassword;
    Button bnt_ingresar,btn_restablecer,bnt_registrarse ;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        temail = findViewById(R.id.temail);
        tpassword = findViewById(R.id.tpassword);
        btn_restablecer = findViewById(R.id.btn_restablecer);
        bnt_ingresar = findViewById(R.id.btn_ingresar);
        btn_restablecer = findViewById(R.id.btn_restablecer);
        bnt_registrarse = findViewById(R.id.bnt_registrarse);


        //inicio ingresar:
        bnt_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = temail.getText().toString().trim();
                String password = tpassword.getText().toString().trim();
                if(email.isEmpty() && password.isEmpty()){
                    Toast.makeText(Login.this, "Ingrese datos", Toast.LENGTH_SHORT).show();
                }
                else {
                    loginUser(email,password);
                }
            }
        });
        //fin ingresar

        //inicio restablecer contraseña
        btn_restablecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restablecerContrasena();

            }
        });


        // fin restablecer contraseña


        //inicio registro:
        bnt_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(Login.this, Registrar.class);

                startActivity(registro);

            }
        });
        //fin registro

    }
    //iniciar sesion
    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();

                            Intent intent = new Intent(Login.this, Panel.class);
                            startActivity(intent);
                            finish();

                        } else {
                            // Si el inicio de sesión falla, mostrar un mensaje al usuario
                            Toast.makeText(Login.this, "Error al iniciar sesión: " +
                                    task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this,"Error al iniciar sesión",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //restablecer contraseña
    public void restablecerContrasena() {
        String emailolv = temail.getText().toString().trim();

        if (!emailolv.isEmpty()) {
            mAuth.sendPasswordResetEmail(emailolv)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                // Mostrar diálogo modal de éxito
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setTitle("Correo Enviado");
                                builder.setMessage("Se ha enviado un correo para restablecer la contraseña.");
                                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                builder.show();
                            } else {
                                // Mostrar diálogo modal de error
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setTitle("Error");
                                builder.setMessage("Error al enviar el correo de restablecimiento.");
                                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                builder.show();
                            }
                        }
                    });
        } else {
            // Mostrar diálogo modal para ingresar correo electrónico
            AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
            builder.setTitle("Correo Electrónico Vacío");
            builder.setMessage("Ingresa tu correo electrónico.");
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
    }


}