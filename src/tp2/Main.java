package tp2;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	 public static void main(String[] args) {
		 
		 
		 Reseau reseau = new Reseau(20);
		 Colonie colonie = new Colonie(20);
		 
		 //Répartition des fourmis avec 1 ville = 1 fourmie
		 ArrayList<Ville> VillesAttribuables = reseau.getVilles();
		 Random rand = new Random();
		 for(int i = 0; i< colonie.getNbFourmi();i++) {
			 int id = rand.nextInt(VillesAttribuables.size());

			 VillesAttribuables.remove(id);
		 }
		 
	 }
}
