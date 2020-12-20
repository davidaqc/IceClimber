package juego;

public class Punto {
    private float f0x;
    private float f1y;

    /** Punto
     * Constructor del objeto punto
     * @param x
     * @param y
     */
    public Punto(float x, float y) {
        this.f0x = x;
        this.f1y = y;
    }

    /** get X
     * Consigue el valor X del punto
     * @return
     */
    public float getX() {
        return this.f0x;
    }

    /** get Y
     *  Consigue el valor Y del punto
     * @return
     */
    public float getY() {
        return this.f1y;
    }

    /** set X 
     * Setea la posicion X para el punto
     * @param x
     */
    public void setX(float x) {
        this.f0x = x;
    }
    /** set Y 
     * Setea la posicion Y para el punto
     * @param y
     */
    public void setY(float y) {
        this.f1y = y;
    }
}
