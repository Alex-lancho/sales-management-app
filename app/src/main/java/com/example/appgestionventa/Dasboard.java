package com.example.appgestionventa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appgestionventa.Modelos.Usuario;
import com.example.appgestionventa.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Dasboard extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    TextView user, fullName, email;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Envio de correo Electronico", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // menu should be considered as top level destinations.
        //mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow).setOpenableLayout(drawer).build();
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home,R.id.nav_productos,R.id.nav_registrar_producto,R.id.nav_ventas,R.id.nav_registrar_venta,R.id.nav_administrador,R.id.nav_clientes,R.id.nav_registrar_cliente).setOpenableLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Seccion Menu
        NavigationView navegacion=findViewById(R.id.nav_view);
        View headerView = navegacion.getHeaderView(0);

        user=headerView.findViewById(R.id.user);
        fullName=headerView.findViewById(R.id.fullname);
        email=headerView.findViewById(R.id.email);

        Intent intent = getIntent();
        Usuario datoUsuario = (Usuario) intent.getSerializableExtra("Usuario");

        user.setText("Usuario: "+ datoUsuario.getUsuario().toString());
        fullName.setText(datoUsuario.getNombre()+" "+datoUsuario.getApellidos());
        email.setText(datoUsuario.getCorreo());
        Toast.makeText(this,"Bienvenido "+datoUsuario.getNombre()+" !",Toast.LENGTH_LONG).show();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
