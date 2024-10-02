/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.constructores;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.naves.Nave;

/**
 *
 * @author fer
 */
public abstract class Constructor {

    protected String tipo;
    protected int tiempoDeConstruccion;  // Tiempo para construir la nave
    protected int precioDeCompra;  // Precio para comprar el constructor
    protected int precioDeVenta;  // Precio al que se puede vender el constructor

    public Constructor(String tipo, int tiempoDeConstruccion, int precioDeCompra, int precioDeVenta) {
        this.tipo = tipo;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.precioDeCompra = precioDeCompra;
        this.precioDeVenta = precioDeVenta;
    }
 public Constructor(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public int getTiempoDeConstruccion() {  // Corregido el nombre del método
        return tiempoDeConstruccion;
    }

    public int getPrecioDeCompra() {
        return precioDeCompra;
    }

    public int getPrecioDeVenta() {
        return precioDeVenta;
    }
}//finConstructores
