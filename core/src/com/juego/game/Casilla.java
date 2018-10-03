package com.juego.game;

/**
 * Created by Ines on 18/06/2018.
 */

public class Casilla {
    private boolean ocupada;
    private float x;
    private float  y;
    private float lado_casilla;
    private int etiquetaX, etiquetaY;
    public Forma forma;
    public Bloque bloque;

    public Casilla (float x, float y, float  lado_casilla, Forma forma, int etiquetaX, int etiquetaY){
        // this.ocupada=false;
        this.lado_casilla = lado_casilla;
        this.x=x;
        this.y=y;
        this.bloque=null;
        this.etiquetaX = etiquetaX;
        this.etiquetaY = etiquetaY;
        this.forma = forma;
        this.forma.definirForma(x,y,lado_casilla);
       // System.out.println("lado casillaaaaaaaaaaaaaaaaaaaaaaa == "+lado_casilla);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

    public Bloque getBloque() {
        return bloque;
    }


    public int getEtiquetaX() {
        return etiquetaX;
    }

    public int getEtiquetaY() {
        return etiquetaY;
    }
}
