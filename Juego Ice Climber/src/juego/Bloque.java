package juego;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Bloque {

	private SpriteBloque bloque;
	private Rectangle colision;
	private String ruta_;

	/** Bloque
	 * Constructor del objeto bloque
	 * @param ruta
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
    public Bloque(String ruta, float x, float y) throws SlickException {
    	this.ruta_ = ruta;
        this.bloque = new SpriteBloque(ruta, x, y);
        this.colision = new Rectangle(this.bloque.getPosicion_x(), this.bloque.getPosicion_y(), (float) this.bloque.getWidth(), (float) this.bloque.getHeight());
    }
    
    /** getRuta_
     * Consigue la ruta de la imagen del bloque
     * @return ruta_
     */
    public String getRuta_() {
		return ruta_;
	}
    /** setRuta_ 
     * setea la ruta de la imagen del bloque
     * @param ruta_
     */
	public void setRuta_(String ruta_) {
		this.ruta_ = ruta_;
	}

	/** draw 
	 * dibuja el bloque en la pantalla
	 */
	public void draw() {
        this.bloque.draw();
    }
    
	/** update
	 * Actualiza el estado del bloque
	 * @param delta
	 */
    public void update(int delta) {
        sincronizarArea();
    }

    /** getColision
     * consigue la colision rectangular del objeto bloque
     * @return
     */
	public Rectangle getColision() {
		return colision;
	}

	/** getAreaColision
	 * consigue el Area de la colision del objeto bloque 
	 * @return
	 */
	public Shape getAreaColision() {
        return this.colision;
    }
    /** sincronizarArea
     *  Setea la posicion de la colision junto con la posicion de la imagen
     */
    public void sincronizarArea() {
        this.colision.setX(this.bloque.getPosicion_x());
        this.colision.setY(this.bloque.getPosicion_y());
    }
    /** getIzquierdo
     * Obtiene el borde izquierdo del bloque
     * @return this.bloque.getPosicion_x();
     */
    public float getIzquierdo() {
    	return this.bloque.getPosicion_x();
    }
    /** getDerecho
     * Obtiene el borde derecho del bloque
     * @return (this.bloque.getPosicion_x() + this.bloque.getWidth()
     */
    public float getDerecho() {
    	return (this.bloque.getPosicion_x() + this.bloque.getWidth());
    }
    /** getArriba
     * obtiene el lado superior del bloque
     * 
     * @return this.bloque.getPosicion_y();
     */
    public float getArriba() {
    	return this.bloque.getPosicion_y();
    }
    
    /**
     *  Obtiene el lado inferior del bloque
     * @return(this.bloque.getPosicion_y() + this.bloque.getHeight());
     */
    public float getAbajo() {
    	return (this.bloque.getPosicion_y() + this.bloque.getHeight());
    }
    
    /** setY
     * Setea la posicion Y del bloque
     * @param f
     */
    public void setY(float f) {
    	this.bloque.setPosicion_y(f);
    }
}
   

