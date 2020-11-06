package tp2;

import java.util.ArrayList;

public class Colonie {
	
	private int nbFourmie;
	private ArrayList<Arete> meilleurParcours;
	private ArrayList<Fourmi> colonie;

	
	public Colonie(int nbFourmie) {
		this.meilleurParcours = new ArrayList<>();
		this.colonie = new ArrayList<>();
		for(int i= 0;i<nbFourmie;i++) {
			colonie.add(new Fourmi(i));
		}
	}
	
	
	//SETTER
	public void setMeilleurParcours(ArrayList<Arete> parcours) {
		meilleurParcours = parcours;
	}
	
	
	
	
	//GETTERS
	
	public ArrayList<Fourmi> getColonie(){
		return colonie;
	}
	public int getNbFourmi(){
		return nbFourmie;
	}
	public ArrayList<Arete> getMeilleurParcours(){
		return meilleurParcours;
	}
	public Fourmi getFourmi(int id) {
		return colonie.get(id);
	}
	
}