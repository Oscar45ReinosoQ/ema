package com.example.fact01;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class fragment_Clientes extends Fragment {

    View vista;
    RecyclerView recyclerView;
    AdpatadorCliente1 adpatadorCliente1;
    ArrayList<Clientes> list;
    DatabaseReference dbProductos;
    ValueEventListener eventListener;
    String TAGLOG = "firebase-db";


    public fragment_Clientes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment__clientes, container, false);

        recyclerView = vista.findViewById(R.id.rvClientes);
        dbProductos = FirebaseDatabase.getInstance().getReference().child("Clientes");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adpatadorCliente1 = new AdpatadorCliente1(getContext(), list);
        recyclerView.setAdapter(adpatadorCliente1);


        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //Opcion 2
                //Productos pro = dataSnapshot.getValue(Productos.class);
                try {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Clientes cliente = dataSnapshot.getValue(Clientes.class);
                        list.add(cliente);
                        adpatadorCliente1.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }

                Toast.makeText(getContext(), "Se a actualizado la base de datos", Toast.LENGTH_LONG);
                Log.e(TAGLOG, "onDataChange:" + snapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAGLOG, "Error!", databaseError.toException());
            }

            ChildEventListener childEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    Log.d(TAGLOG, "onChildAdded{" + snapshot.getKey() + ": " + snapshot.getValue() + "}");
                    Toast.makeText(getContext(), "Se a actualizado la base de datos", Toast.LENGTH_LONG);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    Log.d(TAGLOG, "onChildChanged{" + snapshot.getKey() + ": " + snapshot.getValue() + "}");
                    Toast.makeText(getContext(), "Se a actualizado la base de datos", Toast.LENGTH_LONG);

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                    Log.d(TAGLOG, "onChildRemoved{" + snapshot.getKey() + ": " + snapshot.getValue() + "}");
                    Toast.makeText(getContext(), "Se han eliminado elementos de la base de datos", Toast.LENGTH_LONG);

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    Log.d(TAGLOG, "onChildMoved{" + snapshot.getKey() + ": " + snapshot.getValue() + "}");
                    Toast.makeText(getContext(), "Se han eliminado elementos de la base de datos", Toast.LENGTH_LONG);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e(TAGLOG, "Error!", error.toException());
                    Toast.makeText(getContext(), "Se han producido un error en la base de datos", Toast.LENGTH_LONG);

                }
            };
        };
        dbProductos.addValueEventListener(eventListener);
        return vista;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}