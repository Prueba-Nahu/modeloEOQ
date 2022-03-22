/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nahuelskdujfsif
 */
public class Controlador {

    ArrayList<Double> CT = new ArrayList<>();
    ArrayList<Integer> cantidadEOQSinAjuste = new ArrayList<>();
    ArrayList<Integer> cantidadEOQConAjuste = new ArrayList<>();

    private int rangoA;
    private int rangoB;
    Datos d;
    Scanner sc = new Scanner(System.in);

    public Controlador(Datos d) {
        this.d = d;
    }

    public void calcularCantidadEOQ() {

        for (int i = 1; i <= d.getCantidadCategorias(); i++) {
            this.ingresoDatos();
            this.cantidadEOQSinAjuste.add(d.getCantidadEOQ());
            if (d.getCantidadEOQ() >= rangoA && d.getCantidadEOQ() <= rangoB) {
                this.calcularCostoTotal();
                this.cantidadEOQConAjuste.add(d.getCantidadEOQ());
            } else if (d.getCantidadEOQ() < rangoA) {
                d.setCantidadEOQ(rangoA);
                this.calcularCostoTotal();
                this.cantidadEOQConAjuste.add(d.getCantidadEOQ());
            }

        }

    }
    
    private void ingresoDatos(){
        System.out.println("Ingrese el primer punto del rango: ");
            rangoA = sc.nextInt();
            System.out.println("Ingrese el segundo punto del rango");
            rangoB = sc.nextInt();
            System.out.println("Ingrese el porcentaje de descuento");
            d.setDescuento(sc.nextDouble());
            d.setCantidadEOQ((int) d.obtenerCantidadEOQ());
    }

    private void calcularCostoTotal() {
        double costoTotal;
        costoTotal = (d.getCantidadEOQ() * d.costoUnitarioConDescuento() * d.getTasaCostoRetencion()) / 2
                + (d.getDemandaAnual() * d.getCostoPorPedido()) / d.getCantidadEOQ() + d.getDemandaAnual() * d.costoUnitarioConDescuento();
        this.CT.add(costoTotal);
    }

    public double costoTotalMinimo() {
        double costoTotalMinimo = CT.get(0);
        for (int i = 0; i < CT.size(); i++) {
            double costo = CT.get(i);
            if (costo < costoTotalMinimo) {
                costoTotalMinimo = costo;
            }
        }
        return costoTotalMinimo;
    }

    public void mostrarCostosTotales() {
        System.out.println("--------------------------------------");
        System.out.println("       COSTOS TOTALES ANUALES");
        System.out.println("--------------------------------------");
        for (Double total : CT) {
            System.out.println("Costo total anual ---> " + total);
        }
        System.out.println("--------------------------------------");
        System.out.println("");
        System.out.println("--------------------------------------");
    }

    public void mostrarCantidadesEOQSinAjuste() {
        System.out.println("------------------------");
        System.out.println("CANTIDAD EOQ SIN AJUSTE");
        System.out.println("------------------------");
        for (Integer eoq : cantidadEOQSinAjuste) {
            System.out.println(eoq);
        }
    }

    public void mostrarCantidadesEOQConAjuste() {
        System.out.println("------------------------");
        System.out.println("CANTIDAD EOQ CON AJUSTE");
        System.out.println("------------------------");
        for (Integer eoq : cantidadEOQConAjuste) {
            System.out.println(eoq);
        }
    }

}
