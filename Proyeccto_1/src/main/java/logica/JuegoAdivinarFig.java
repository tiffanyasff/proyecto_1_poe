/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Figura;
import modelo.Jugador;



/**
 *
 * @author pablo y titi
 */
public class JuegoAdivinarFig {
    private int posicionArreglos;
    private ArrayList<Figura> figuras;
    private Jugador jugador;
    private Scanner scanner = new Scanner(System.in);

    public JuegoAdivinarFig(  Jugador jugador) {
        this.jugador = jugador;
        this.figuras = new ArrayList<>();
        this.posicionArreglos = 0;
        crearFiguras();
    }

    public int getPosicionArreglos() {
        return posicionArreglos;
    }

    public void setPosicionArreglos(int posicionArreglos) {
        this.posicionArreglos = posicionArreglos;
    }
    
    
    public JuegoAdivinarFig() {
        this.figuras = new ArrayList<>();
        crearFiguras();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public void añadirFigura (Figura fig){
        figuras.add(fig);
        System.out.println("Figura añadida correctamente.");
        System.out.println(fig.getOpcionCorrecta());
    }
    
    public void crearFiguras(){
        Figura circulo = new Figura("circulo", "pequeno", "a");
        Figura cuadrado = new Figura("circulo", "mediano", "a");
        Figura triangulo  = new Figura("circulo", "grande", "a");
        Figura rectangulo  = new Figura("cuadrado", "pequeno", "a");
        Figura estrella  = new Figura("cuadrado", "mediano", "a");
        Figura otraFig1  = new Figura("cuadrado", "grande", "a");
        Figura otraFig2  = new Figura("triangulo", "pequeno", "a");
        Figura otraFig3  = new Figura("triangulo", "mediano", "a");
        Figura otraFig4  = new Figura("triangulo", "grande", "a");
        
        añadirFigura(circulo);
        añadirFigura(cuadrado);
        añadirFigura(triangulo);
        añadirFigura(rectangulo);
        añadirFigura(estrella);
        añadirFigura(otraFig1);
        añadirFigura(otraFig2);
        añadirFigura(otraFig3);
        añadirFigura(otraFig4);
        
    }
    
    public boolean iniciarJuego(){
        
        for (int i = 0; i < figuras.size(); i++) {
            
            //System.out.println(figuras.get(i).getNombre());
            //System.out.println(figuras.get(i).getOpcionCorrecta());
            boolean respuestaCorrecta = false;
            while (!respuestaCorrecta) {
                System.out.print("¿Cuál es la opción correcta (1, 2 o 3)? ");
                int opcionUsuario = scanner.nextInt();
                
                if (figuras.get(i).validarOpcion(opcionUsuario)) {
                    System.out.println("¡Respuesta correcta!");
                    respuestaCorrecta = true;
                } else {
                    System.out.println("Respuesta incorrecta. Inténtalo nuevamente.");
                }
            }
        }
        
        scanner.close();
        
        return true;
    }   
    
    public ArrayList<Figura> obtenerFiguras() {
        return figuras;
    }
}
