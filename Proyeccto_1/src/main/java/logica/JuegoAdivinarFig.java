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

    
    public JuegoAdivinarFig(  Jugador jugador) {
        this.figuras = new ArrayList<>();
        crearFiguras();
    }

   
    
    
    public JuegoAdivinarFig() {
        this.figuras = new ArrayList<>();
        crearFiguras();
    }

    
    
    public void añadirFigura (Figura fig){
        figuras.add(fig);
        System.out.println(fig.getNombre());
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
        
    public ArrayList<Figura> obtenerFiguras() {
        return figuras;
    }
    
    public void reiniciarValores(){
        for (int i = 0; i < figuras.size(); i++) {
            figuras.get(i).setOpcionCorrecta();
            System.out.println(figuras.get(i).getNombre());
            System.out.println(figuras.get(i).getOpcionCorrecta());
        }
    }
}
