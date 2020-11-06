package tp2;

import java.util.ArrayList;

public class Fourmi {

	private static int Q =1; //Quantite de phéromones communes aux fourmis 
	
	
    private int id;
    private Ville villeCourante;
    private double distanceParcourue;
    private ArrayList<Arete> villesParcourue;
    
    public Fourmi( int id) {
    	this.id = id;
    	this.villeCourante = null;
    	this.distanceParcourue = 0.0;
    }
    
    public void initialiseVilles(){
    	villesParcourue.clear();
    }
    
    public void ajoutVille(Arete arete){
    	villesParcourue.add(arete);
    }
       
    public void setDistance(double distance) {
    	distanceParcourue += distance;
    }
    
    public void setVille(Ville ville) {
    	villeCourante = ville;
    }
    
    

}
