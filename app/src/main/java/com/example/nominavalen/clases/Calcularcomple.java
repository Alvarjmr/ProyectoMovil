package com.example.nominavalen.clases;

public class Calcularcomple {

    private int periodo;
    private int diaslaborados;
    private int salario;
    private int transporte;
    private int censantias;
    private int interesescesantias;
    private int primaprimersemestre;
    private int primasegundosemestre;
    private int vacaciones;
    private int deducionessalud;
    private int deducionpension;
    private int total;

    //contructor
    public Calcularcomple(int periodo, int diaslaborados, int salario, int transporte, int censantias, int interesescesantias, int primaprimersemestre, int primasegundosemestre, int vacaciones, int deducionessalud, int deducionpension, int total) {
        this.periodo = periodo;
        this.diaslaborados = diaslaborados;
        this.salario = salario;
        this.transporte = transporte;
        this.censantias = censantias;
        this.interesescesantias = interesescesantias;
        this.primaprimersemestre = primaprimersemestre;
        this.primasegundosemestre = primasegundosemestre;
        this.vacaciones = vacaciones;
        this.deducionessalud = deducionessalud;
        this.deducionpension = deducionpension;
        this.total = total;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getDiaslaborados() {
        return diaslaborados;
    }

    public void setDiaslaborados(int diaslaborados) {
        this.diaslaborados = diaslaborados;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getTransporte() {
        return transporte;
    }

    public void setTransporte(int transporte) {
        this.transporte = transporte;
    }

    public int getCensantias() {
        return censantias;
    }

    public void setCensantias(int censantias) {
        this.censantias = censantias;
    }

    public int getInteresescesantias() {
        return interesescesantias;
    }

    public void setInteresescesantias(int interesescesantias) {
        this.interesescesantias = interesescesantias;
    }

    public int getPrimaprimersemestre() {
        return primaprimersemestre;
    }

    public void setPrimaprimersemestre(int primaprimersemestre) {
        this.primaprimersemestre = primaprimersemestre;
    }

    public int getPrimasegundosemestre() {
        return primasegundosemestre;
    }

    public void setPrimasegundosemestre(int primasegundosemestre) {
        this.primasegundosemestre = primasegundosemestre;
    }

    public int getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(int vacaciones) {
        this.vacaciones = vacaciones;
    }

    public int getDeducionessalud() {
        return deducionessalud;
    }

    public void setDeducionessalud(int deducionessalud) {
        this.deducionessalud = deducionessalud;
    }

    public int getDeducionpension() {
        return deducionpension;
    }

    public void setDeducionpension(int deducionpension) {
        this.deducionpension = deducionpension;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public  int ()
}
