package com.example.appgestionventa.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.appgestionventa.Controllers.UsuarioController;
import com.example.appgestionventa.Modelos.Usuario;
import com.example.appgestionventa.R;
import com.example.appgestionventa.databinding.FragmentAdministradorBinding;
import com.example.appgestionventa.ui.modals.ModalAdministrador;
import com.example.appgestionventa.ui.modals.ModalProduct;

import java.util.ArrayList;
import java.util.List;

public class AdministradorFragment extends Fragment {
    private View viewLayout;
    private ListView listView;
    private List<Usuario> lUsuarios=new ArrayList<>();
    private ArrayAdapter<Usuario>adapter;
    private FragmentAdministradorBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        viewLayout=inflater.inflate(R.layout.fragment_administrador,container,false);
        listView=viewLayout.findViewById(R.id.listAdministrador);

        UsuarioController usuarioController = new UsuarioController();
        adapter = new ArrayAdapter<>(viewLayout.getContext(), android.R.layout.simple_list_item_1, lUsuarios);
        List<Usuario> listaUsuariosd = usuarioController.usuarios(viewLayout.getContext());
        // Agregar los productos a la lista
        lUsuarios.addAll(listaUsuariosd);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //invocando y enviando datos al modal de un producto
                Bundle arg=new Bundle();
                String detalle="Nombre: "+listaUsuariosd.get(i).getNombre()+"\nApellidos: "+listaUsuariosd.get(i).getApellidos()
                        +"\nCorreo: "+listaUsuariosd.get(i).getCorreo()+"\nUsuario:"+listaUsuariosd.get(i).getUsuario();
                arg.putString("detalleAdministrador",detalle);
                ModalAdministrador dialogFragment = new ModalAdministrador();
                dialogFragment.setArguments(arg);
                dialogFragment.show(getChildFragmentManager(), "Modal");
            }
        });

        return viewLayout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewLayout = null;
    }
}
