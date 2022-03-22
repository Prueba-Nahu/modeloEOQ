/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author Nahuel
 */
public class Principal {

    
    public static void main(String[] args) {
        Datos d = new Datos(1600,3600,300,0.20,4);
        Controlador c = new Controlador(d);
        c.calcularCantidadEOQ();
        c.mostrarCantidadesEOQSinAjuste();
        c.mostrarCantidadesEOQConAjuste();
        c.mostrarCostosTotales();
        
        System.out.println("");
        System.out.println("EL COSTO TOTAL MINIMO ES ---> "+c.costoTotalMinimo());
        
        
    }
    
}
