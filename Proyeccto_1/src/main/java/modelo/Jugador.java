/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author pablo
 */
public class Jugador {
    String nombre; 
    int intentos;
    int intentosFallados;
    int intentosAcertados;

    public Jugador(String nombre) {
        this.nombre = nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getIntentosFallados() {
        return intentosFallados;
    }

    public void setIntentosFallados(int intentosFallados) {
        this.intentosFallados = intentosFallados;
    }

    public int getIntentosAcertados() {
        return intentosAcertados;
    }

    public void setIntentosAcertados(int intentosAcertados) {
        this.intentosAcertados = intentosAcertados;
    }
    
    public void sumarIntentos(){
        this.intentos +=1;
    }
    
    public void sumarIntentosFallados(){
        this.intentosFallados +=1;
    }
    
    public void sumarIntentosAcertados(){
        this.intentosAcertados +=1;
    }
    
    
    
}
