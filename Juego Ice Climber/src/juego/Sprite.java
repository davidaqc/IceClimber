package juego;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sprite extends Image {
    protected Punto posicion;

    public Sprite(String ruta, Punto posicion) throws SlickException {
        super(ruta);
        this.posicion = posicion;
    }

    public void draw() {
        super.draw(this.posicion.getX(), this.posicion.getY());
    }

    public Punto getPosicion() {
        return this.posicion;
    }

    public void setPosicion(float x, float y) {
        this.posicion = new Punto(x, y);
    }

    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }
}
