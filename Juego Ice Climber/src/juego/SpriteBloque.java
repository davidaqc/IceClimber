package juego;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteBloque extends Image {
	
    private float posicion_x;
    private float posicion_y;

    /***
     * Constructor de SpriteBloque
     * @param ruta
     * @param x
     * @param y
     * @throws SlickException
     */
    public SpriteBloque(String ruta, float x, float y) throws SlickException {
        super(ruta);
		posicion_x = x;
		posicion_y = y;
    }
    /** draw
	 * Dibujar el objeto en pantalla
	 */
    public void draw() {
        super.draw(this.posicion_x, this.posicion_y);
    }
    
    /**getPosicion_x
     * Obtiene la posicion X 
     * @return posicion_x
     */
	public float getPosicion_x() {
		return posicion_x;
	}
	
	 /**getPosicion_y
     * Obtiene la posicion Y
     * @return posicion_y
     */
	public float getPosicion_y() {
		return posicion_y;
	}

	 /**setPosicion_x
     * Setea la posicion X 
     */
	public void setPosicion_x(float posicion_x) {
		this.posicion_x = posicion_x;
	}

	 /**setPosicion_y
     * Setea la posicion Y 
     */
	public void setPosicion_y(float posicion_y) {
		this.posicion_y = posicion_y;
	}
		
}
