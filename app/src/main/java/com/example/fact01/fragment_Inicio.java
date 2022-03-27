package com.example.fact01;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class fragment_Inicio extends Fragment {

    //ImageButton btnPerfil;
    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__inicio, container, false);
        ImageView btnPerfil = (ImageView) view.findViewById(R.id.imgUsuarioInicio);
        /**/
        mAuth = FirebaseAuth.getInstance();
        /**/
        btnPerfil.setOnClickListener(v -> {
            AlertDialog.Builder myBulid = new AlertDialog.Builder(fragment_Inicio.this.getContext());
            myBulid.setMessage("¿Deseas cerrar sesion?");
            myBulid.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mAuth.signOut();
                    Toast.makeText(fragment_Inicio.this.getContext(), "Cerraste sesion", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), Login.class));
                    getActivity().finish();
                }
            });
            myBulid.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = myBulid.create();
            dialog.show();
        });
        /*NO SE MUEVE EL RETURN VIEW*/
        return view;
    }
    /**/


}