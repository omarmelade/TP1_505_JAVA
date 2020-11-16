package tp2;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	 
	static Random rand =new Random();

	 public static void repartitionAleatoire(Reseau reseau, Colonie colonie) {
		 ArrayList<Ville> VillesAttribuables = reseau.getVilles();
		 for(int i = 0; i< colonie.getNbFourmi();i++) {
			 int id = rand.nextInt(VillesAttribuables.size());
			 colonie.getColonie().get(i).setVille(VillesAttribuables.get(id));
			 VillesAttribuables.remove(id);
		 }
	 }

	 public static void main(String[] args) {
		 
		 Reseau reseau = new Reseau(20);
		 Colonie colonie = new Colonie(20);

		 //Répartition des fourmis aléatoire avec 1 ville = 1 fourmie
		 repartitionAleatoire(reseau,colonie);
		 
	 }
	 
	 
	 
	 

}
