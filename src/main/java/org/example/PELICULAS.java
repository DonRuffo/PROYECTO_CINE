package org.example;

public class PELICULAS {
    String titulo, categoria, horario, restriccion, dia;
    int sala;
    double precio;

    public PELICULAS() {}
    public PELICULAS(String titulo, String categoria, String horario, String restriccion,String dia,int sala, double precio){
        this.titulo = titulo;
        this.categoria = categoria;
        this.horario = horario;
        this.restriccion = restriccion;
        this.sala = sala;
        this.precio = precio;
        this.dia = dia;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setRestriccion(String restriccion) {
        this.restriccion = restriccion;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getHorario() {
        return horario;
    }

    public String getRestriccion() {
        return restriccion;
    }

    public int getSala() {
        return sala;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDia() {
        return dia;
    }
}
