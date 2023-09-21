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
    
    public boolean iniciarJuego(){
        
        for (int i = 0; i < figuras.size(); i++) {
            figuras.get(i).getNombre();
        }
        
        
        return true;
    }
    
    
    
    
    
    
}
