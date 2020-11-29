package tp2;

import java.util.ArrayList;

public class Colonie {
	
	private int nbFourmie;
	private ArrayList<Arete> meilleurParcours;
	private double meilleureDistance;
	private ArrayList<Fourmi> colonie;


	/**
	 * @param nbFourmie le nombre de fourmi que contient la colonie
	 */
	public Colonie(int nbFourmie) {
		this.nbFourmie = nbFourmie;
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

	public double getMeilleureDistance() {
		return meilleureDistance;
	}

	public void setMeilleureDistance(double meilleureDistance) {
		this.meilleureDistance = meilleureDistance;
	}

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

	@Override
	public String toString() {
		return "Colonie{" +
				"nbFourmie=" + nbFourmie +
				", meilleurParcours=" + meilleurParcours +
				", colonie=" + colonie +
				'}';
	}
}