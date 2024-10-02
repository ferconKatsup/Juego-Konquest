/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024;

/**
 *
 * @author fer
 */
public class Posicion {
    private int x;
    private int y; 
    
    public Posicion (int x, int y){
    this.x = x;
    this.y = y; 
    
}//fin constructor 
    
    
    public int getX(){
    return x; 
}
    public int getY(){
        return y;
    }
    
    public String toString(){
        return "("+x+" , "+y+")";
        
    }
}
