package com.juego.game;

        import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

        import javax.sound.sampled.Line;

/**
 * Created by Ines on 18/06/2018.
 */

public class Cuadrado implements Forma {
    ShapeRenderer shapeRenderer;
    public Cuadrado(){
        shapeRenderer = new ShapeRenderer();
    }
    @Override
    public void definirForma(float x,float y, float lado) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(x,y,lado,lado);
        shapeRenderer.end();
    }
}
