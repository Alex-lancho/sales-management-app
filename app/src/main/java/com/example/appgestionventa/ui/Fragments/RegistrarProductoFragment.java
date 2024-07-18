package com.example.appgestionventa.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appgestionventa.Controllers.ProductoController;
import com.example.appgestionventa.DB.Querys.Clases.QProducto;
import com.example.appgestionventa.DB.Querys.Interfaces.IProducto;
import com.example.appgestionventa.Modelos.Producto;
import com.example.appgestionventa.R;
import com.example.appgestionventa.databinding.FragmentAdministradorBinding;
import com.example.appgestionventa.databinding.FragmentRegistrarProductoBinding;

public class RegistrarProductoFragment extends Fragment {
    View viewLayout;
    ProductoController productoController;
    EditText txtProducto,txtCantidad,txtPrecio,txtDescripcion,txtObservacion;
    Button btnInsertar,btnBuscarProducto,btnActualizar;
    String idProducto;
    private FragmentRegistrarProductoBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewLayout=inflater.inflate(R.layout.fragment_registrar_producto,container,false);
        txtProducto=viewLayout.findViewById(R.id.txtNombreProducto);
        txtCantidad=viewLayout.findViewById(R.id.txtStockProducto);
        txtPrecio=viewLayout.findViewById(R.id.txtPrecioUniProducto);
        txtDescripcion=viewLayout.findViewById(R.id.txtDescripcionProducto);
        txtObservacion=viewLayout.findViewById(R.id.txtObservacionProducto);
        btnInsertar=viewLayout.findViewById(R.id.btnAgregarProducto);
        btnBuscarProducto=viewLayout.findViewById(R.id.btnBuscarProducto);
        btnActualizar=viewLayout.findViewById(R.id.btnActualizarProducto);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto=new Producto();
                producto.setNombre(txtProducto.getText().toString());
                producto.setStock(Integer.parseInt(txtCantidad.getText().toString()));
                producto.setPrecioUnitario(Double.parseDouble(txtPrecio.getText().toString()));
                producto.setDescripcion(txtDescripcion.getText().toString());
                producto.setObservacion(txtObservacion.getText().toString());
                productoController=new ProductoController();
                if(productoController.insertarProducto(viewLayout.getContext(), producto)){
                    Toast.makeText(viewLayout.getContext(),"Se registro correctamente",Toast.LENGTH_LONG).show();
                    txtProducto.setText("");
                    txtCantidad.setText("");
                    txtPrecio.setText("");
                    txtDescripcion.setText("");
                    txtObservacion.setText("");
                }else{
                    Toast.makeText(viewLayout.getContext(),"No se registro",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBuscarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productoController=new ProductoController();
                if(productoController.getProducto(viewLayout.getContext(), txtProducto.getText().toString())!=null){
                    Producto producto=productoController.getProducto(viewLayout.getContext(), txtProducto.getText().toString());
                    txtProducto.setText(""+producto.getNombre());
                    txtCantidad.setText(""+producto.getStock());
                    txtPrecio.setText(""+producto.getPrecioUnitario());
                    txtDescripcion.setText(""+producto.getDescripcion());
                    txtObservacion.setText(""+producto.getObservacion());
                    idProducto=producto.getIdProducto();
                }else{
                    Toast.makeText(viewLayout.getContext(),"No existe el producto!!!",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto=new Producto();
                producto.setIdProducto(idProducto);
                producto.setNombre(txtProducto.getText().toString());
                producto.setStock(Integer.parseInt(txtCantidad.getText().toString()));
                producto.setPrecioUnitario(Double.parseDouble(txtPrecio.getText().toString()));
                producto.setDescripcion(txtDescripcion.getText().toString());
                producto.setObservacion(txtObservacion.getText().toString());
                productoController=new ProductoController();
                if(productoController.updateProducto(viewLayout.getContext(), producto)){
                    Toast.makeText(viewLayout.getContext(),"Se Actualizó correctamente",Toast.LENGTH_LONG).show();
                    txtProducto.setText("");
                    txtCantidad.setText("");
                    txtPrecio.setText("");
                    txtDescripcion.setText("");
                    txtObservacion.setText("");
                }else{
                    Toast.makeText(viewLayout.getContext(),"No se Actualizo el producto",Toast.LENGTH_LONG).show();
                }
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
