package com.example.registrounivalle;

public class estudiante {
    private int codigoEstudiante;
    private String nombre;
    private String apellido;
    private String email;
    private int celular;

    public estudiante(int codigoEstudiante, String nombre, String apellido, String email, int celular) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
    }
}
