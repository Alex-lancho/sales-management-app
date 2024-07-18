package com.example.appgestionventa.ui.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.appgestionventa.Controllers.ProductoController;
import com.example.appgestionventa.Modelos.Producto;
import com.example.appgestionventa.R;
import com.example.appgestionventa.ui.modals.ModalProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductosFragment extends Fragment {
    private View viewLayout;
    private ListView listView;
    private List<Producto> lproductos=new ArrayList<>();
    private ArrayAdapter<Producto>adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewLayout=inflater.inflate(R.layout.fragment_productos,container,false);
        listView=viewLayout.findViewById(R.id.listProductos);

        ProductoController productos = new ProductoController();
        adapter = new ArrayAdapter<>(viewLayout.getContext(), android.R.layout.simple_list_item_1, lproductos);
        List<Producto> listaProductos = productos.productos(viewLayout.getContext());
        // Agregar los productos a la lista
        lproductos.addAll(listaProductos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //invocando y enviando datos al modal de un producto
                Bundle arg=new Bundle();
                String detalle="Nombre: "+listaProductos.get(i).getNombre()+"\nDescripcion: "+listaProductos.get(i).getDescripcion()
                        +"\nDetalles: "+listaProductos.get(i).getDetalles()+"\nPrecio Unitario: S/ "+listaProductos.get(i).getPrecioUnitario()
                        +"\nProductos Disponibles: "+listaProductos.get(i).getStock();
                arg.putString("detalleProducto",detalle);
                ModalProduct dialogFragment = new ModalProduct();
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

