package com.juego.game;

import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

/**
 * Created by Ines on 23/06/2018.
 */

public class Entrada extends InputAdapter {
    float XtableroControl, YtableroControl, tamañoLado;
    Tablero tableroPrincipal;
    TableroControl tableroControl;
    Forma forma;
    ArrayList<Bloque> bloques;
    ArrayList<ArrayList<Bloque>> conjuntoBloques;
    Casilla casilla;

    public Entrada(float XtableroControl, float YtableroControl, float ladoCasilla, TableroControl tableroControl,Tablero tableroPrincipal, Forma forma, ArrayList<Bloque> bloques){
        this.XtableroControl=XtableroControl;
        this.YtableroControl=YtableroControl;
        this.tableroControl=tableroControl;
        this.tableroPrincipal=tableroPrincipal;
        this.forma=forma;
        this.bloques=bloques;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        casilla = tableroControl.obtenerCasilla(screenX,screenY);
        System.out.println(casilla.getX());
        System.out.println("X es"+ casilla.getEtiquetaX());
        System.out.println("Y es"+ casilla.getEtiquetaY());
        tableroControl.crearBloque(casilla.getEtiquetaX(),casilla.getEtiquetaY(),forma,bloques);
        return false;
    }
/*
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (Casilla casilla: tableroControl.getCasillas()){
            casilla.setBloque(null);
        }
        for(Bloque bloque: bloques){
            bloque.setPieza(bloques);
        }
        tableroPrincipal.agregarBloque(0,0,forma, bloques);
        bloques.clear();
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        int x= (int)((screenX-posX)/tamañoLado);
        int y=  (int)((posY-screenY)/tamañoLado);
        tableroControl.agregarBloque(x,y,forma,bloques);
        return false;
    }*/
}
