package tp2;

import java.util.Random;

public class Ville {

    final double MAX = 15.0;
    double x;
    double y;

    public Ville(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Ville()
    {
        Random rand = new Random();
        // 0.0 a 15.0
        this.x = rand.nextDouble() * MAX;
        this.y = rand.nextDouble() * MAX;
    }

    public void setX(double newX) {
        x = newX;
    }

    public void setY(double newY) {
        y = newY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
