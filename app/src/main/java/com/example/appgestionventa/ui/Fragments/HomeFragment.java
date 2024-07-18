package com.example.appgestionventa.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appgestionventa.R;
import com.example.appgestionventa.databinding.FragmentHomeBinding;
//import com.example.appgestionventa.ui.home.HomeViewModel;

public class HomeFragment extends Fragment {

    View viewLayout;


    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        viewLayout=inflater.inflate(R.layout.fragment_home,container,false);



        return viewLayout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewLayout= null;
    }
}
