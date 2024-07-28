package org.example;

public class PELICULAS {
    String titulo, categoria, horario, restriccion, anio, mes,dia, sala, fecha;
    double precio;

    public PELICULAS() {}
    public PELICULAS(String titulo, String categoria, String horario, String restriccion,
                     String anio, String mes,String dia, String sala, String fecha, double precio){
        this.titulo = titulo;
        this.categoria = categoria;
        this.horario = horario;
        this.restriccion = restriccion;
        this.sala = sala;
        this.fecha = fecha;
        this.precio = precio;
        this.dia = dia;
        this.mes=mes;
        this.anio=anio;
    }
    //setters
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

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //getters
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

    public String getSala() {
        return sala;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDia() {
        return dia;
    }

    public String getAnio() {
        return anio;
    }

    public String getMes() {
        return mes;
    }

    public String getFecha() {
        return fecha;
    }
}
