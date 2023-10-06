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
    String rutaImg;
    int opcionCorrecta;
    Random random = new Random();

    public Figura(String nombre, String tamano, String rutaImg) {
        this.nombre = nombre;
        this.rutaImg = rutaImg;
        this.opcionCorrecta = random.nextInt(3) + 1;     
    }

    
    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }

    
    public void setOpcionCorrecta() {
        this.opcionCorrecta = random.nextInt(3) + 1;
    }
    

    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
