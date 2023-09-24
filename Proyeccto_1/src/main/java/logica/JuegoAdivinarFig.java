/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import modelo.Figura;
import modelo.Jugador;



/**
 *
 * @author pablo y titi
 */
public class JuegoAdivinarFig {
    private ArrayList<Figura> figuras;
    private Jugador jugador;

    public JuegoAdivinarFig(  Jugador jugador) {
        this.jugador = jugador;
        this.figuras = new ArrayList<>();
        crearFiguras();
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
    }
    
    public void crearFiguras(){
        Figura circuloPequeno = new Figura("circulo", "pequeno", "a");
        Figura circuloMediano = new Figura("circulo", "mediano", "a");
        Figura circuloGrande  = new Figura("circulo", "grande", "a");
        Figura cuadradoPequeno  = new Figura("cuadrado", "pequeno", "a");
        Figura cuadradoMediano  = new Figura("cuadrado", "mediano", "a");
        Figura cuadradoGrande  = new Figura("cuadrado", "grande", "a");
        Figura trianguloPequeno  = new Figura("triangulo", "pequeno", "a");
        Figura trianguloMediano  = new Figura("triangulo", "mediano", "a");
        Figura trianguloGrande  = new Figura("triangulo", "grande", "a");
        
        añadirFigura(circuloPequeno);
        añadirFigura(circuloMediano);
        añadirFigura(circuloGrande);
        añadirFigura(cuadradoPequeno);
        añadirFigura(cuadradoMediano);
        añadirFigura(cuadradoGrande);
        añadirFigura(trianguloPequeno);
        añadirFigura(trianguloMediano);
        añadirFigura(trianguloGrande);
        
    }
    
    public boolean iniciarJuego(){
        
        for (int i = 0; i < figuras.size(); i++) {
            figuras.get(i).getNombre();
            System.out.println(figuras.get(i).getNombre());
            System.out.println(figuras.get(i).getOpcionCorrecta());
            
        }
        
        
        return true;
    }
    
    
    
    
    
    
}
