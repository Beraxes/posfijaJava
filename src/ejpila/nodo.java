/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejpila;

/**
 *
 * @author beraxes
 */
public class nodo {
    private String dato;
    public nodo enlace;
    
    public nodo(){
        dato="";
        enlace=null;
    }

    public String getExpresion() {
        return dato;
    }

    public void setExpresion(String dato) {
        this.dato = dato;
    }

    public nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(nodo enlace) {
        this.enlace = enlace;
    }

    
    public void mostrar(){
        System.out.println(getExpresion());
    }
}
