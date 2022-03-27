package com.example.fact01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdpatadorCliente1 extends RecyclerView.Adapter<AdpatadorCliente1.MyViewHolder> {

    ArrayList<Clientes> list;
    Context contex;

    public AdpatadorCliente1() {
    }

    public AdpatadorCliente1(Context contex, ArrayList<Clientes> list) {
        this.contex = contex;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contex).inflate(R.layout.item_cliente, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Clientes pro = list.get(position);
        holder.cliApellidos.setText(pro.getCliApellidos());
        holder.cliNombres.setText((pro.getCliNombres()));
        holder.cliCedula.setText((pro.getCliCedula()));
        holder.cliCorreo.setText((pro.getCliCorreo()));
        holder.cliDireccion.setText((pro.getCliDireccion()));
        holder.cliTelefono.setText((pro.getCliTelefono()));
        holder.cliFechaCreacion.setText((pro.getCliFechaCreacion()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cliNombres, cliApellidos, cliCedula, cliCorreo, cliDireccion, cliTelefono, cliFechaCreacion;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cliApellidos = itemView.findViewById(R.id.tvNombreCliente);
            cliNombres = itemView.findViewById(R.id.tvApellidoCliente);
            cliCedula = itemView.findViewById(R.id.tvCedulaCliente);
            cliCorreo = itemView.findViewById(R.id.tvCorreoCliente);
            cliDireccion = itemView.findViewById(R.id.tvDireccionCliente);
            cliTelefono = itemView.findViewById(R.id.tvTelefonoCliente);
            cliFechaCreacion = itemView.findViewById(R.id.tvFechaCreacion);
        }
    }
}