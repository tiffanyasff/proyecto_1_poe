/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author pablo
 */
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Jugador {
    String nombre; 
    int intentos;
    double intentosFallados;
    double intentosAcertados;

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
    
    public void sumarIntentos(){
        this.intentos +=1;
    }
    
    public void sumarIntentosFallados(){
        this.intentosFallados +=1;
    }
    
    public void sumarIntentosAcertados(){
        this.intentosAcertados +=1;
    }

    public double getIntentosFallados() {
        return intentosFallados;
    }

    public void setIntentosFallados(double intentosFallados) {
        this.intentosFallados = intentosFallados;
    }

    public double getIntentosAcertados() {
        return intentosAcertados;
    }

    public void setIntentosAcertados(double intentosAcertados) {
        this.intentosAcertados = intentosAcertados;
    }
    
    
    
    public double porcentajeAciertos(){
        if (intentos == 0) {
            return 0.0; 
        }

        double porcentaje = ((double) intentosAcertados / intentos) * 100.0;
        
        DecimalFormatSymbols separadores = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", separadores);
        return Double.parseDouble(df.format(porcentaje));
        
       // return porcentaje;
    }
    
    public double porcentajeFallo(){
        if (intentos == 0) {
            return 0.0; 
        }

        double porcentaje = ((double) intentosFallados / intentos) * 100.0;
        
        DecimalFormatSymbols separadores = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", separadores);
        return Double.parseDouble(df.format(porcentaje));
         
        //return porcentaje;
    }
    
    
}
