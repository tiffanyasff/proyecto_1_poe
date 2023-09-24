/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author pablo
 */


import java.util.Random;

public class Figura {
    String nombre;
    String tamano;
    String rutaImg;
    int opcionCorrecta;

    public Figura(String nombre, String tamano, String rutaImg) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.rutaImg = rutaImg;
        Random random = new Random();
        this.opcionCorrecta = random.nextInt(3) + 1;
     
    }

    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(int opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }
    
    public boolean validarOpcion(int opcion){
        return opcion == this.getOpcionCorrecta();
    }
    
    
    
    
}
