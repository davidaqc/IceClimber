package juego;

public class Punto {
    private float f0x;
    private float f1y;

    public Punto(float x, float y) {
        this.f0x = x;
        this.f1y = y;
    }

    public float getX() {
        return this.f0x;
    }

    public float getY() {
        return this.f1y;
    }

    public void setX(float x) {
        this.f0x = x;
    }

    public void setY(float y) {
        this.f1y = y;
    }
}
