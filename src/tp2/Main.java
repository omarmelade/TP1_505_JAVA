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
		 System.out.println(colonie.getNbFourmi());
		 for(int i = 0; i< colonie.getNbFourmi();i++) {
			 int id = rand.nextInt(VillesAttribuables.size());
			 colonie.getColonie().get(i).setVille(VillesAttribuables.get(id));
			 VillesAttribuables.remove(id);

			 System.out.println(colonie.getColonie().get(i).getVilleCourante().toString());
		 }
		 
	 }
}
