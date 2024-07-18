package com.example.appgestionventa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appgestionventa.Controllers.UsuarioController;
import com.example.appgestionventa.DB.Alert;
import com.example.appgestionventa.DB.Querys.Clases.QCliente;
import com.example.appgestionventa.DB.Querys.Clases.QProducto;
import com.example.appgestionventa.DB.Querys.Interfaces.ICliente;
import com.example.appgestionventa.DB.Querys.Interfaces.IProducto;
import com.example.appgestionventa.Modelos.Cliente;
import com.example.appgestionventa.Modelos.Producto;
import com.example.appgestionventa.Modelos.Usuario;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appgestionventa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario, txtContraseña;
    Button btnLogin,btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txtUsuario=findViewById(R.id.txtUsuario);
        txtContraseña=findViewById(R.id.txtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnCreate=findViewById(R.id.btnCreate);
        eventos();
    }

    public void eventos(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioController user=new UsuarioController();
                if(user.login(txtUsuario.getText().toString(),txtContraseña.getText().toString(),MainActivity.this)!=null){
                    Usuario dataUser=user.login(txtUsuario.getText().toString(),txtContraseña.getText().toString(),MainActivity.this);
                    // Crear un Intent para iniciar Activity2
                    Intent intent = new Intent(MainActivity.this, Dasboard.class);
                    // Iniciando Activity2
                    intent.putExtra("Usuario",dataUser);
                    // Agregar la bandera FLAG_ACTIVITY_CLEAR_TASK para limpiar cualquier actividad existente en el stack de tareas
                    //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                    // Cerrar Activity1
                    finish();
                    /*Object usuario=user.login(txtUsuario.getText().toString(),txtContraseña.getText().toString(),MainActivity.this);
                    Intent intent=new Intent(MainActivity.this,)
                    Toast.makeText(MainActivity.this,"Ingresando",Toast.LENGTH_SHORT).show();*/
                }else{
                    Toast.makeText(MainActivity.this,"El usuario no existe, crea una"+user.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent para iniciar Activity2
                Intent intent = new Intent(MainActivity.this, RegisterUser.class);
                // Agregar la bandera FLAG_ACTIVITY_CLEAR_TASK para limpiar cualquier actividad existente en el stack de tareas
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Iniciando Activity2
                startActivity(intent);
                // Cerrar Activity1
                finish();
            }
        });
    }

}