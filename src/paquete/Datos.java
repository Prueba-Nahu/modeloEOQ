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
public class Datos {
    private int demandaAnual;
    private double costoUnitario;
    private double costoPorPedido;
    private double tasaCostoRetencion;
    private int cantidadEOQ;
    private int cantidadCategorias;
    private double descuento;
    public Datos(int demandaAnual, double costoUnitario, double costoPorPedido, double tasaCostoRetencion,int cantidadCategorias) {
        this.demandaAnual = demandaAnual;
        this.costoUnitario = costoUnitario;
        this.costoPorPedido = costoPorPedido;
        this.tasaCostoRetencion = tasaCostoRetencion;
        this.cantidadCategorias = cantidadCategorias;
    }

    public Datos() {
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    

    public int getDemandaAnual() {
        return demandaAnual;
    }

    public void setDemandaAnual(int demandaAnual) {
        this.demandaAnual = demandaAnual;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getCostoPorPedido() {
        return costoPorPedido;
    }

    public void setCostoPorPedido(double costoPorPedido) {
        this.costoPorPedido = costoPorPedido;
    }

    public double getTasaCostoRetencion() {
        return tasaCostoRetencion;
    }

    public void setTasaCostoRetencion(double tasaCostoRetencion) {
        this.tasaCostoRetencion = tasaCostoRetencion;
    }

    public int getCantidadEOQ() {
        return cantidadEOQ;
    }

    public void setCantidadEOQ(int cantidadEOQ) {
        this.cantidadEOQ = cantidadEOQ;
    }

    public int getCantidadCategorias() {
        return cantidadCategorias;
    }

    public void setCantidadCategorias(int cantidadCategorias) {
        this.cantidadCategorias = cantidadCategorias;
    }
    
    
    public double costoUnitarioConDescuento(){
        return (this.costoUnitario - this.costoUnitario*descuento);
    }
    public double obtenerCantidadEOQ(){
        return Math.sqrt((2*this.demandaAnual*this.costoPorPedido)/(this.tasaCostoRetencion*this.costoUnitarioConDescuento()));
    }
}
