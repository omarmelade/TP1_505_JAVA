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
	 	//System.out.println(f.getVilleCourante());
		 //System.out.println(villesRestantes);
		 villesRestantes.removeAll(f.getVillesParcourues());

		return villesRestantes;
	 }

	 public static void villeSuivante(Fourmi fourmi,Reseau reseau){
		 ArrayList<Ville> villeRest = villesRestantes(reseau, fourmi);
		 double coef =0;
		 ArrayList<Ville> proba = new ArrayList();
		 for(Ville v:villeRest){
			 double distance = new Arete(fourmi.getVilleCourante(),v).getDistance();
			 double distanceCourante = 1*(1/distance);
			 
			 
		 }
	 }

	 public static Ville randVille(Fourmi fourmi, ArrayList<Integer> liste, Reseau reseau){
		 Random rand = new Random();
		 int i = rand.nextInt(liste.size());
		 int indice = liste.get(i);
		 Ville ville = reseau.getVilles().get(indice);
		 fourmi.ajoutArete(reseau.getArete(fourmi.getVilleCourante(), ville)); // ajoute a la liste des arretes parcourues la nouvelle arete.
		 fourmi.setVille(ville); //met à jour la liste de ville parcourue pour cette fourmi et met à jour sa ville courante
		 return ville;
	 }

	 public static void evaporationTime(Reseau reseau){
		 for (Arete a: reseau.getAretes()) {
			 a.setEvaporation();
		 }
	 }

	 public static void depotPheromone(Colonie col, Reseau r){
		 for (Fourmi f: col.getColonie()) {
			 for (Arete a: f.getArretesParcourues()) {
				  // les fourmis deposent pour le moment une quantité 0.5 (arbitraire de phéronmone
				 r.modifieArete(a.getV1(), a.getV2());

			 }
		 }
	 }

	 public static ArrayList<Arete> getMeilleurParcours(Colonie col){
	 	 double distance = col.getColonie().get(0).getDistanceParcourue();
		 ArrayList<Arete> bestWay = new ArrayList<>();
		 for (Fourmi f: col.getColonie()) {
		 		double distanceDeFourmi = f.getDistanceParcourue();
			 	if( distanceDeFourmi < distance){
		 			distance = distanceDeFourmi;
		 			bestWay = f.getArretesParcourues();
				}
		 }
		 return bestWay;
	 }

	 public static void main(String[] args) {

		 Reseau reseau = new Reseau(20);
		 Colonie colonie = new Colonie(20);

		 //Répartition des fourmis aléatoire avec 1 ville = 1 fourmie
		 repartitionAleatoire(reseau, colonie);
		 ArrayList<Arete> meilleurParcours = new ArrayList<>();
		 //Tant que non convergence du système faire
		 //Cycle pour l'ensemble de la colonie
		 //Pour chaque fourmi faire
		 int indiceF = 0;
		 for(Fourmi fourmi : colonie.getColonie()) {
		 	indiceF++;
			 ArrayList<Ville> restante = villesRestantes(reseau, fourmi);

			 while(restante.size()>0){
				 //Liste contenant un certain de nombre de fois chaque villes restantes selon la probilité
				 ArrayList<Integer> listeProba = new ArrayList<>();
				 double prob =0.0; //va permettre de savoir la probabilité de choix pour chaque ville
				 double nominateur = 0.0;
				 double denominateur = 0.0;

				 //==========================================Boucle permettant de calculer la proba
				 for(int i =0;i<restante.size();i++) {
					 Ville temp = restante.get(i);
					 Arete tempArete = reseau.getArete(fourmi.getVilleCourante(), temp);
					 nominateur = (tempArete.getPhero() * Arete.EVAPORATION) * (1 / tempArete.distance);

					 //Boucle permettant de calculer le denominateur
					 for (int j = 0; j < restante.size(); j++) {
						 Ville tempSomme = restante.get(j);
						 Arete areteSomme = reseau.getArete(fourmi.getVilleCourante(), tempSomme);
						 denominateur += (areteSomme.getPhero() * Arete.EVAPORATION) * (1 / areteSomme.distance);
					 }
					 prob = nominateur / denominateur; //Proba pour la ville temporaire
					 prob = Math.ceil(prob * 100);
					 for (int k = 0; k < prob; k++) {
						 listeProba.add(temp.getId());
					 }
				 }
				 //===================================================================================

				 Ville villeChoisie = randVille(fourmi, listeProba, reseau);
				 restante.remove(villeChoisie);
			 }
			 //System.out.println("fourmi " + indiceF + " : "+ fourmi.getArretesParcourues().size());
		 }
		 // ======= après que toutes les fourmis aient parcourues tout le reseau,  les phéronomones s'évaporent
		 evaporationTime(reseau);

		// après que sur chaque arète les phéromones se soient évaporés, les fourmis deposent les leurs de nouveau
		 depotPheromone(colonie, reseau);
		 System.out.println("Arete fin de boucle : " + reseau.getAretes());
		 // on selectionne le meilleur parcours parmis le parcours des fourmis et on l'enregistre si il est meilleur que l'ancien.
		 ArrayList<Arete> nouveauMeilleurParcours = getMeilleurParcours(colonie);
		 if(meilleurParcours.size() > nouveauMeilleurParcours.size()){
			 meilleurParcours = nouveauMeilleurParcours;
		 }


		 //System.out.println("villes a parcourir :" + villesRestantes(reseau, colonie.getFourmi(0)));
	 }




}
