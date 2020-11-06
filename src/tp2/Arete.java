package tp2;

public class Arete {

	private static final double PHEROMONE_INIT = 0.5;
    double distance;
    Ville v1, v2;
    double quantitePheromone;

    public Arete(Ville v1, Ville v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.distance = distanceEntreVille();
        this.quantitePheromone = PHEROMONE_INIT;
    }

    // retourne la distance entre 2 villes
    public double distanceEntreVille(){
        double xCarre = Math.pow((v1.getX() - v2.getX()), 2.0);
        double yCarre = Math.pow((v1.getY() - v2.getY()), 2.0);
        double distance = Math.sqrt(xCarre + yCarre);

        // genere aleatoirement une distance entre les villes
        return distance;
    }

    public double getDistance() {
        return distance;
    }

    public Ville getV1() {
        return v1;
    }

    public Ville getV2() {
        return v2;
    }
    
    public void setPheromone(double pheromone){
    	quantitePheromone += pheromone;
    }
    
}
