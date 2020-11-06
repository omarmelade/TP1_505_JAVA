package tp2;

public class Distance2Villes {

    double distance;
    Ville v1, v2;

    public Distance2Villes(Ville v1, Ville v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.distance = distanceEntreVille();
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
}
