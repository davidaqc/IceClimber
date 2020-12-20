package juego;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sprite extends Image {
    protected Punto posicion;

    /**
     * Constructor del objeto sprite
     * @param ruta
     * @param posicion
     * @throws SlickException
     */
    public Sprite(String ruta, Punto posicion) throws SlickException {
        super(ruta);
        this.posicion = posicion;
    }

    /** draw 
     * Dibuja el sprite en pantalla
     */
    public void draw() {
        super.draw(this.posicion.getX(), this.posicion.getY());
    }

    /** getPosicion
     * Obtiene la posicion X y Y del sprite
     * @return
     */
    public Punto getPosicion() {
        return this.posicion;
    }

    /** setPosicion
     * setea la posicion X y Y del sprite
     * @param x
     * @param y
     */
    public void setPosicion(float x, float y) {
        this.posicion = new Punto(x, y);
    }

    /** setPosicion
     * setea la posicion X y Y del sprite
     * @param posicion
     */
    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }
}
