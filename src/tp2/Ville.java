package tp2;

import java.util.Random;

public class Ville {
	
	private int id;
	public final double MAX_Y = 15.0;
	public final double MAX_X = 25.0;
	private double x;
	private double y;

    /**
     * @param x la position x de la Ville
     * @param y la position y de la Ville
     * @param id l'id unique de la Ville
     */
    public Ville(double x, double y, int id)
    {
    	this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * @param id l'id unique de la Ville
     */
    public Ville(int id)
    {
    	this.id = id;
        Random rand = new Random();
        // 0.0 a 15.0
        this.x = rand.nextDouble() * MAX_X;
        this.y = rand.nextDouble() * MAX_Y;
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

    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                '}';
    }
}
