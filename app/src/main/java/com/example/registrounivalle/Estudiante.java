package com.example.registrounivalle;

import java.io.Serializable;
//Interfaz marcador, no necesita las reglas de juego o metodos
public class Estudiante implements Serializable {
    private String nombre;
    private String apellido;
    private String email;
    private int codigo;
    private int celular;

    public Estudiante(String nombre, String apellido, String email, int codigo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Estudiante: " +'\n'+
                "nombre='" + nombre + '\n' +
                ", apellido='" + apellido + '\n' +
                ", email='" + email + '\n' +
                ", codigo=" + codigo + '\n' +
                ", celular=" + celular
                ;
    }
}
