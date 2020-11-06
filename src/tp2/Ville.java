package tp2;

import java.util.Random;

public class Ville {
	
	private int id;
	private final double MAX = 15.0;
	private double x;
	private double y;

    public Ville(double x, double y, int id)
    {
    	this.id = id;
        this.x = x;
        this.y = y;
    }

    public Ville(int id)
    {
    	this.id = id;
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
    public int getId(){
    	return id;
    }
}
