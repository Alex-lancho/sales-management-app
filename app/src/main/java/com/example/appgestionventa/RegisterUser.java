package com.example.appgestionventa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appgestionventa.Controllers.UsuarioController;
import com.example.appgestionventa.Modelos.Usuario;

public class RegisterUser extends AppCompatActivity {
    EditText nombre,apellidos,correo,usuario,contraseña;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

        nombre=findViewById(R.id.txtNombre);
        apellidos=findViewById(R.id.txtApellido);
        correo=findViewById(R.id.txtCorreo);
        usuario=findViewById(R.id.txtUsuario);
        contraseña=findViewById(R.id.txtContraseña);
        btnRegistrar=findViewById(R.id.btnRegitrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioController user=new UsuarioController();
                Usuario usuario1=new Usuario();
                usuario1.setNombre(nombre.getText().toString());
                usuario1.setApellidos(apellidos.getText().toString());
                usuario1.setCorreo(correo.getText().toString());
                usuario1.setUsuario(usuario.getText().toString());
                usuario1.setContraseña(contraseña.getText().toString());
                if(user.insertar(usuario1,RegisterUser.this)){
                    Toast.makeText(RegisterUser.this,"Tu usuario se creo correctamente",Toast.LENGTH_SHORT).show();
                    // Crear un Intent para iniciar Activity2
                    Intent intent = new Intent(RegisterUser.this, MainActivity.class);
                    // Agregar la bandera FLAG_ACTIVITY_CLEAR_TASK para limpiar cualquier actividad existente en el stack de tareas
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    // Iniciando Login
                    startActivity(intent);
                    // Cerrar Activity actual
                    finish();
                }else{
                    Toast.makeText(RegisterUser.this,"Nose pudeo crear tu usuario, verifica los campor",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}