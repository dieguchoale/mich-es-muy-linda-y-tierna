package com.juego.game;

import java.util.ArrayList;

/**
 * Created by Ines on 18/06/2018.
 */

public class Tablero{
    private float anchoPantalla;
    private float altoPantalla;
    private float lado_casilla;
    public ArrayList<Casilla> casillas;



    public Tablero(float anchoPantalla, float altoPantalla, float lado_casilla){
        this.anchoPantalla=anchoPantalla;
        this.altoPantalla=altoPantalla;
        this.lado_casilla=lado_casilla;
        casillas = new ArrayList<Casilla>();
    }



    public void crearCasillas(Forma forma){

        float y = (altoPantalla - 50) - (lado_casilla*15);
        float x = anchoPantalla/2 - lado_casilla*5/2;


        for (int i=0; i<15; i++){
            for (int j=0; j<5; j++){
                Casilla casilla =new Casilla(x,y,lado_casilla, forma, i+1 , j+1);
                casillas.add(casilla);
                x+=lado_casilla;
            }
            y+=lado_casilla;
            x = anchoPantalla/2 - lado_casilla*5/2;
        }
    }



    public void agregarBloque(float posX, float posY,Forma forma, ArrayList<Bloque> bloques){
        // Bloque bloque=new Bloque(forma,posX,posY);
    }
    public double getLado_casilla() {
        return lado_casilla;
    }

    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }


}
