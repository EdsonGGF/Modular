package com.modular.proyecto.model;

public class Beca {
    String descripcion;
    String img;
    String nombre;

    public Beca() {
    }

    public Beca(String descripcion, String img, String nombre) {
        this.descripcion = descripcion;
        this.img=img;
        this.nombre = nombre;

    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}