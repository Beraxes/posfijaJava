/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejpila;

import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author beraxes
 */
public class EjPila {

    nodo cima;
    nodo falda;

    public EjPila() {
        cima = null;
        falda = null;
    }

    public void apilar(String item) {
        if (falda == null) {
            falda = new nodo();
            falda.setDato(item);
            cima = falda;

        } else {
            nodo temp = new nodo();
            temp.setDato(item);
            temp.setEnlace(cima);
            cima = temp;
        }
    }

    public String desapilarTodo() {
        nodo temp;
        String aux = "";
        if (cima != null) {
            while (cima != null) {
                //cima.mostrar();

                if (cima == falda) {
                    aux = aux + cima.getDato();
                    cima = null;
                    falda = null;

                } else {
                    temp = cima;
                    if (aux.equals("")) {
                        aux = aux + cima.getDato();
                    }else{
                        aux = aux + ", " + cima.getDato();
                    }
                    

                    cima = cima.getEnlace();
                    temp.setEnlace(null);
                }

            }
        } else {
            System.out.println("no hay pila");
        }
        return aux;
    }

    public String desapilarElemento() {
        nodo temp;
        String aux = "";
        if (cima != null) {

           // cima.mostrar();

            if (cima == falda) {
                aux = aux + cima.getDato();
                cima = null;
                falda = null;

            } else {
                temp = cima;
                aux = cima.getDato();
                cima = cima.getEnlace();
                temp.setEnlace(null);
            }

        } else {
            System.out.println("no hay pila");
        }
        return aux;
    }

    public static int prioridad(String signo) {
        int valorPrioridad = -1;
        if (signo.equals("+") || signo.equals("-")) {
            valorPrioridad = 1;
        } else if (signo.equals("*") || signo.equals("/")) {
            valorPrioridad = 2;
        } else if (signo.equals("^")) {
            valorPrioridad = 3;
        }
        return valorPrioridad;
    }

    public static String vacioComilla(String cadena_epos, String cadena_aux) {
        String opcion = "";
        if (cadena_epos.equals("")) {
            opcion = opcion + cadena_aux;
        } else {
            opcion = opcion + ", " + cadena_aux;
        }
        return opcion;
    }

    public static void main(String[] args) {
        String epos = "", expresionUsuario = JOptionPane.showInputDialog("Ingrese una expresion"); // aqui pido por joption un string al usuario que seria una expresion matematica
        EjPila pila = new EjPila();
        for (int i = 0; i < expresionUsuario.length(); i++) {
            String aux = "";
            aux = aux + expresionUsuario.charAt(i);
            if (aux.equals("(")) {
                pila.apilar(aux);

            } else if (aux.equals(")")) {
                String dato;
                do {
                    dato = pila.desapilarElemento();
                    if (!dato.equals("(")) {
                        epos = epos + vacioComilla(epos, aux);
                    }
                } while (!dato.equals("("));

            } else if (aux.equals("+") || aux.equals("-") || aux.equals("*") || aux.equals("/") || aux.equals("^")) {
                
                if (pila.cima == null) {
                    pila.apilar(aux);
                } else {
                    int operador = prioridad(aux);
                    String salientePila = pila.desapilarElemento();
                    int precedencia = prioridad(salientePila);
                    if (operador == precedencia) {
                        epos = epos + vacioComilla(epos, salientePila);
                        pila.apilar(aux);
                    } else if (operador > precedencia) {
                        pila.apilar(aux);
                    } else {
                        epos = epos + vacioComilla(epos, salientePila);
                        pila.apilar(aux);
                    }
                }

            } else {
                epos = epos + vacioComilla(epos, aux);

            }

        }
        
        String resto = "";
        if (pila.cima != null) {
            resto = pila.desapilarTodo();
        }
        
        epos = epos + vacioComilla(epos, resto);
        
        System.out.println(epos);

    }

}
