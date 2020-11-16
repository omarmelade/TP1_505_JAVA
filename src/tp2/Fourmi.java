package tp2;

import java.util.ArrayList;

public class Fourmi {

	private static int Q = 1; //Quantite de phéromones communes aux fourmis
	
	
    private int id;
    private Ville villeCourante;
    private double distanceParcourue;
    private ArrayList<Arete> villesParcourue;

    /**
     * Caractèrise une fourmi, par son id et la distance qu'elle a parcourue
     * @param id l'identifiant unique de la fourmi
     */
    public Fourmi( int id) {
    	this.id = id;
    	this.villeCourante = null;
    	this.distanceParcourue = 0.0;
    }

    /**
     * supprime toutes les villes parcourues par la fourmi
     * si il en existe
     */
    public void initialiseVilles(){
    	villesParcourue.clear();
    }

    /**
     * Ajoute l'Arete que la fourmi a traversé
     * @param arete l'arete courante entre les villes
     */
    public void ajoutVille(Arete arete){
    	villesParcourue.add(arete);
    }
       
    public void setDistance(double distance) {
    	distanceParcourue += distance;
    }
    
    public void setVille(Ville ville) {
    	villeCourante = ville;
    }
    
    public Ville getVilleCourante() {
    	return villeCourante;
    }


    @Override
    public String toString() {
        return "Fourmi{" +
                "id=" + id +
                ", villeCourante=" + villeCourante +
                ", distanceParcourue=" + distanceParcourue +
                ", villesParcourue=" + villesParcourue +
                '}';
    }
    
	 public void depotPheromone (Fourmi fourmi) {
		 double quantite = Q/distanceParcourue;
		 for(int i =0;i<villesParcourue.size();i++) {
			 villesParcourue.get(i).setPheromone(quantite);
		 }
	 }
}
