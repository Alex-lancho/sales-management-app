package com.example.appgestionventa.ui.modals;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.appgestionventa.R;

public class ModalProduct extends DialogFragment {
    TextView descripcion;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        Bundle args = getArguments();

        // Inflar el diseño personalizado del diálogo modal
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.modal_products, null);
        // Obtener referencia del TextView y establecer el texto
        descripcion = view.findViewById(R.id.descripcionProducto);
        descripcion.setText(args != null ? args.getString("detalleProducto") : "");

        builder.setView(view)
                .setTitle("Detalles del producto")
                .setMessage("__________________________")
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    // Acción al hacer clic en el botón "Aceptar"
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {
                    // Acción al hacer clic en el botón "Cancelar"
                });


        return builder.create();
    }
}
