package tp2;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	 


	 public static void repartitionAleatoire(Reseau reseau, Colonie colonie) {
		 Random rand = new Random();
		 ArrayList<Ville> villesAttribuables = (ArrayList<Ville>) reseau.getVilles().clone();
		 for(int i = 0; i< colonie.getNbFourmi();i++) {
			 int id = rand.nextInt(villesAttribuables.size());
			 colonie.getColonie().get(i).setVille(villesAttribuables.get(id));
			 villesAttribuables.remove(id);
		 }
	 }

	 public static ArrayList<Ville> villesRestantes(Reseau r, Fourmi f){
	 	ArrayList<Ville> villesRestantes = (ArrayList<Ville>) r.getVilles().clone();
	 	System.out.println(f.getVilleCourante());
		 System.out.println(villesRestantes);

		villesRestantes.removeAll(f.getVillesParcourues());

		return villesRestantes;
	 }

/*	 public void cycleFourmi(Reseau reseau, Fourmi fourmi){
	 	int nbVilles = reseau.getNbVilles();
	 	ArrayList<Ville> villesRestantes = villesRestantes(reseau, fourmi);
	 	while(villesRestantes.size() > 0){

		}

	 }*/

	 public static void main(String[] args) {

		 Reseau reseau = new Reseau(20);
		 Colonie colonie = new Colonie(20);

		 //Répartition des fourmis aléatoire avec 1 ville = 1 fourmie
		 repartitionAleatoire(reseau, colonie);
		 
		 //Tant que non convergence du système faire
		 
		 //Cycle pour l'ensemble de la colonie
		 //Pour chaque fourmi faire
		 for(Fourmi fourmi : colonie.getColonie()) {
			 while(villesRestantes(reseau, fourmi).size()>0) {
				 
			 }
			 
		 }
		 

		 System.out.println("villes a parcourir :" + villesRestantes(reseau, colonie.getFourmi(0)));
	 }
	 
	 
	 
	 

}
