package tp2;

public class Arete {

	private static final double PHEROMONE_INIT = 2;
	public static final double EVAPORATION = 0.25;
    double distance;
    Ville v1, v2;
    double quantitePheromone;

    /**
     * Initialise la distance entre les 2 villes qui constitue l'arrete
     * et la quantité de phéromone sur celle-ci
     * @param v1 La ville de départ
     * @param v2 La ville d'arrivé
     */
    public Arete(Ville v1, Ville v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.distance = distanceEntreVille();
        this.quantitePheromone = PHEROMONE_INIT;
    }
    public Arete(Ville v1,Ville v2,double distance, double quantitePheromone) {
    	this.v1 = v1;
    	this.v2=v2;
    	this.distance=distance;
    	this.quantitePheromone=quantitePheromone;
    }

    /**
     * @return la distance entre 2 villes
     */
    // retourne la distance entre 2 villes
    public double distanceEntreVille(){
        double xCarre = Math.pow((v1.getX() - v2.getX()), 2.0);
        double yCarre = Math.pow((v1.getY() - v2.getY()), 2.0);
        double distance = Math.sqrt(xCarre + yCarre);

        // genere aleatoirement une distance entre les villes
        return distance;
    }

    /**
     * @return la distance de l'arete
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @return la ville de depart
     */
    public Ville getV1() {
        return v1;
    }

    /**
     * @return la ville d'arrivée
     */
    public Ville getV2() {
        return v2;
    }

    public double getPhero() {
    	return quantitePheromone;
    }
    /**
     * @param pheromone la quantité de phéromone a déposer sur l'arete
     */
    public void setPheromone(double pheromone){
    	quantitePheromone += pheromone;
    }

    @Override
    public String toString() {
        return "Arete{" +
                "distance=" + distance +
                ", v1=" + v1 +
                ", v2=" + v2 +
                ", quantitePheromone=" + quantitePheromone +
                '}';
    }
}
