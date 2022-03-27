package com.example.fact01;

public class Clientes {

    String cliApellidos, cliNombres, cliCedula, cliCorreo, cliTelefono, cliDireccion, cliFechaCreacion;

    public Clientes() {
    }

    public Clientes(String cliApellidos, String cliNombres, String cliCedula, String cliCorreo, String cliTelefono, String cliDireccion, String cliFechaCreacion) {
        this.cliApellidos = cliApellidos;
        this.cliNombres = cliNombres;
        this.cliCedula = cliCedula;
        this.cliCorreo = cliCorreo;
        this.cliTelefono = cliTelefono;
        this.cliDireccion = cliDireccion;
        this.cliFechaCreacion = cliFechaCreacion;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public String getCliNombres() {
        return cliNombres;
    }

    public void setCliNombres(String cliNombres) {
        this.cliNombres = cliNombres;
    }

    public String getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliFechaCreacion() {
        return cliFechaCreacion;
    }

    public void setCliFechaCreacion(String cliFechaCreacion) {
        this.cliFechaCreacion = cliFechaCreacion;
    }
}
