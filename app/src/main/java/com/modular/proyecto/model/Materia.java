package com.modular.proyecto.model;

public class Materia {
    String carrera;
    String creditos;
    String crn;
    String img;
    String maestro;
    String materia;

    public Materia(){}

    public Materia(String carrera, String creditos, String crn,String img, String maestro, String materia) {
        this.carrera = carrera;
        this.creditos = creditos;
        this.crn = crn;
        this.img=img;
        this.maestro = maestro;
        this.materia = materia;
    }



    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getImg() {return img;}

    public void setImg(String img) {this.img = img;}

    public String getMaestro() {
        return maestro;
    }

    public void setMaestro(String maestro) {
        this.maestro = maestro;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
