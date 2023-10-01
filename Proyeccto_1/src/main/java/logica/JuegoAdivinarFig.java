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
        Figura circulo = new Figura("circulo", "pequeno", "img/circulo.png");
        Figura cuadrado = new Figura("cuadrado", "mediano", "img/cuadrado.png");
        Figura triangulo  = new Figura("triangulo", "grande", "img/triangulo.png");
        Figura rectangulo  = new Figura("rectangulo", "pequeno", "img/rectangulo.png");
        Figura estrella  = new Figura("estrella", "mediano", "img/estrella.png");
        Figura luna  = new Figura("luna", "grande", "img/luna.png");
        Figura corazon  = new Figura("corazon", "pequeno", "img/corazon.png");
        Figura pentagono  = new Figura("pentagono", "mediano", "img/pentagono.png");
        Figura hexagono  = new Figura("hexagono", "grande", "img/hexagono.png");
        
        añadirFigura(circulo);
        añadirFigura(cuadrado);
        añadirFigura(triangulo);
        añadirFigura(rectangulo);
        añadirFigura(estrella);
        añadirFigura(luna);
        añadirFigura(corazon);
        añadirFigura(pentagono);
        añadirFigura(hexagono);
        
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
