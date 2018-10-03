package com.juego.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Juego extends ApplicationAdapter {
	//SpriteBatch batch;
	//Texture img;
	Tablero tablero;
	Forma forma;
	float anchoPantalla, altoPantalla, lado_casilla, lado_casilla2, XtableroControl, YtableroControl, Xtablero, Ytablero;
	ShapeRenderer shapeRenderer;
	TableroControl tableroControl;
	Entrada entrada;
	ArrayList<Bloque> bloques;
	//ArrayList<Casilla> casillasControl;

	@Override
	public void create () {
		anchoPantalla = Gdx.graphics.getWidth();
		altoPantalla = Gdx.graphics.getHeight();
		lado_casilla = anchoPantalla/40;
		lado_casilla2 = anchoPantalla/30;
		XtableroControl = anchoPantalla/2 - lado_casilla2*5/2;
		YtableroControl = 30;
		Xtablero = anchoPantalla/2 - lado_casilla*5/2;
		Ytablero = (altoPantalla - 50) - (lado_casilla*15);
		//casillasControl = new ArrayList<Casilla>();
		bloques=new ArrayList<Bloque>();
		tablero = new Tablero(anchoPantalla, altoPantalla, lado_casilla);
		forma = new Cuadrado();
		shapeRenderer = new ShapeRenderer();
		tableroControl = new TableroControl(anchoPantalla, altoPantalla, lado_casilla2);
		entrada=new Entrada(XtableroControl, YtableroControl, lado_casilla2 ,tableroControl,tablero, forma, bloques);
		Gdx.input.setInputProcessor(entrada);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0 , 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		tablero.crearCasillas(forma);
		tableroControl.crearTablero(forma);
	/*	System.out.println("ladocasilla == "+lado_casilla);
		System.out.println("lado casilla 22 == "+lado_casilla2);
		System.out.println("Xtablero == "+XtableroControl);*/
		//System.out.println("lado casilla RENDER == "+lado_casilla2);
		//System.out.println("xtablerocontrol RENDER == "+XtableroControl);
		for (Bloque bloque: bloques){
			float   x = (bloque.getX() - 1)*lado_casilla2+XtableroControl;
			float   y = (bloque.getY() - 1)*lado_casilla2+YtableroControl;
			int x1 = (int) x;
			int y1 = (int) y;
		//	System.out.println("X RENDER == "+x);
		//	System.out.println("Y RENDER == "+y);
			//float   y3 = ((Ytablero) - (YtableroControl+lado_casilla2*3))/2 + (YtableroControl+lado_casilla2*3);
			for(Casilla casilla: tableroControl.getCasillas() ) {
				//System.out.println("Y ENTRO == "+casilla.getY());
				//System.out.println("X ENTRO == "+casilla.getX());
				int x2 = (int) casilla.getX();
				int y2 = (int) casilla.getY();
				if  ((x1 == x2)&&(y1 == y2)){
					//System.out.println("ENTROOOOOOOOOOOOOOOOO"+bloque.getX());
					shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
					shapeRenderer.setColor(1, 1, 0, .3f);
					shapeRenderer.rect(casilla.getX(),casilla.getY(),lado_casilla2,lado_casilla2);
					shapeRenderer.end();
				}
				/*if  ((x1== casilla.getX())&&(y1==casilla.getY())){
					texturaBloque=new Texture("casillaVerde2.png");
					batch.begin();
					batch.draw(texturaBloque,casilla.getX(),casilla.getY(), casilla.getWidth(),casilla.getHeight());
					batch.end();
					texturaBloque=new Texture("casillaVerde.png");
				}*/
			}
			float   x4 = (bloque.getX() - 1)*lado_casilla+Xtablero;
			float   y4 = (bloque.getY() - 1)*lado_casilla+50;
			for(Casilla casilla: tablero.getCasillas() ) {
				float  x3 = casilla.getX()*lado_casilla+Xtablero;
				float  y3 = casilla.getY()*lado_casilla+Ytablero;
				int x2 = (int) casilla.getX();
				int y2 = (int) casilla.getY();
				if  ((x3 == casilla.getX())&&(y3 == casilla.getY())){
					System.out.println("ENTROOOO ");
					shapeRenderer = new ShapeRenderer();
					shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
					shapeRenderer.setColor(1, 1, 0, .3f);
					shapeRenderer.rect(casilla.getX(), casilla.getY()+y3,lado_casilla,lado_casilla);
					shapeRenderer.end();
				}
			}
		}

		/*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 1, .3f);
		shapeRenderer.rect(anchoPantalla/2 - lado_casilla*7/2, altoPantalla-50, lado_casilla*7, 50);
		shapeRenderer.end();*/
	}

	@Override
	public void dispose () {
		shapeRenderer.dispose();
		//batch.dispose();
		//img.dispose();
	}
}
