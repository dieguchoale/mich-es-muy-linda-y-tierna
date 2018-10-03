package com.juego.game;

import java.util.ArrayList;

/**
 * Created by Ines on 18/06/2018.
 */

public class Bloque {
    public Forma forma;
    private int x, y;
    private float lado_casilla;
    public ArrayList<Bloque> conjuntoBloques;

    public Bloque(int x, int y, Forma forma, TableroControl tableroControl, ArrayList<Bloque> conjuntoBloques ){
        this.x = x;
        this.y = y;
        this.forma = forma;
        posicionarBloque(tableroControl,conjuntoBloques);
    }


    /* public Bloque (Forma forma, float X, float Y,float anchoPantalla,float altoPantalla, Tablero tablero){
         this.forma = forma;
         this.X=X;
         this.Y=Y;
         posicionarBloque(anchoPantalla,altoPantalla,tablero);
     }*/
    public void posicionarBloque(TableroControl tableroControl, ArrayList<Bloque> conjuntoBloques) {
        if (tableroControl.devuelveCasilla(this.x, this.y).getBloque() == null) {
            tableroControl.devuelveCasilla(this.x, this.y).setBloque(this);
            if (conjuntoBloques != null)
                conjuntoBloques.add(this);
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}