package tp2;

import java.util.ArrayList;

public class Fourmi {

	private static int Q = 1; //Quantite de phéromones communes aux fourmis
	
	
    private int id;
    private Ville villeCourante;
    private double distanceParcourue;
    private ArrayList<Arete> arretesParcourues;
    private ArrayList<Ville> villesParcourues;

    /**
     * Caractèrise une fourmi, par son id et la distance qu'elle a parcourue
     * @param id l'identifiant unique de la fourmi
     */
    public Fourmi( int id) {
    	this.id = id;
    	this.villeCourante = null;
    	this.distanceParcourue = 0.0;
    	this.arretesParcourues = new ArrayList<>();
    	this.villesParcourues = new ArrayList<>();
    }


    /**
     * supprime toutes les villes parcourues par la fourmi
     * si il en existe
     */
    public void initialiseVilles(){
    	arretesParcourues.clear();
    }

    /**
     * Ajoute l'Arete que la fourmi a traversé
     * @param arete l'arete courante entre les villes
     */
    public void ajoutArete(Arete arete){
    	arretesParcourues.add(arete);
    }
       
    public void setDistance(double distance) {
    	distanceParcourue += distance;
    }
    
    public void setVille(Ville ville) {
    	villeCourante = ville;
    	villesParcourues.add(villeCourante);
    }
    
    public Ville getVilleCourante() {
    	return villeCourante;
    }

    public ArrayList<Arete> getArretesParcourues() {
        return arretesParcourues;
    }

    public ArrayList<Ville> getVillesParcourues() {
        return villesParcourues;
    }

    public void setVillesParcourues(ArrayList<Ville> villesParcourues) {
        this.villesParcourues = villesParcourues;
    }

    /**
     * Supprime les données recoltées par la fourmi
     */
    public void resetFourmi(){
        distanceParcourue = 0.0;
        arretesParcourues.clear();
        villeCourante = null;
    }

    @Override
    public String toString() {
        return "Fourmi{" +
                "id=" + id +
                ", villeCourante=" + villeCourante +
                ", distanceParcourue=" + distanceParcourue +
                ", villesParcourue=" + arretesParcourues +
                '}';
    }
    
	 public void depotPheromone (Fourmi fourmi) {
		 double quantite = Q/distanceParcourue;
		 for(int i = 0; i< arretesParcourues.size(); i++) {
			 arretesParcourues.get(i).setPheromone(quantite);
		 }
	 }
	 
}
