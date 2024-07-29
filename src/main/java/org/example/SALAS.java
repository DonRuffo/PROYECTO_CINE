package org.example;

public class SALAS {
    String pelicula, hora, fecha, asientos_vendidos, asientos_disponibles, n_asiento;
    public SALAS(){}
    public SALAS(String pelicula, String hora, String fecha, String asientos_vendidos,
                 String asientos_disponibles, String n_asiento){
        this.pelicula = pelicula;
        this.hora = hora;
        this.fecha = fecha;
        this.asientos_vendidos = asientos_vendidos;
        this.asientos_disponibles = asientos_disponibles;
        this.n_asiento = n_asiento;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setAsientos_vendidos(String asientos_vendidos) {
        this.asientos_vendidos = asientos_vendidos;
    }

    public void setAsientos_disponibles(String asientos_disponibles) {
        this.asientos_disponibles = asientos_disponibles;
    }

    public void setN_asiento(String n_asiento) {
        this.n_asiento = n_asiento;
    }

    //getters
    public String getPelicula() {
        return pelicula;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getAsientos_vendidos() {
        return asientos_vendidos;
    }

    public String getAsientos_disponibles() {
        return asientos_disponibles;
    }

    public String getN_asiento() {
        return n_asiento;
    }
}
