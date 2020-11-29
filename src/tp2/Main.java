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

	 public static void meilleurParcours(Colonie col, Reseau reseau){
	 	 double distance = col.getColonie().get(0).getDistanceParcourue();
		 ArrayList<Arete> bestWay = new ArrayList<>();
		 for (Fourmi f: col.getColonie()) {
		 		double distanceDeFourmi = f.getDistanceParcourue();
			 	if( distanceDeFourmi < distance){
		 			distance = distanceDeFourmi;

					for (Arete a: f.getArretesParcourues()) {
						bestWay.add(reseau.getArete(a.getV1(), a.getV2()));
					}
				}
		 }
		 col.setMeilleureDistance(distance);
		 col.setMeilleurParcours(bestWay);
		 System.out.println(" nouvelle meilleur  distance : " + distance);
	 }


	 public static void cycleFourmi(Fourmi fourmi, Reseau reseau){
		 ArrayList<Ville> restante = villesRestantes(reseau, fourmi);

		 // Tant qu'il reste des villes a parcourir par la fourmi
		 while(restante.size()>0){

			 //Liste contenant un certain de nombre de fois chaque villes restantes selon la probilité
			 ArrayList<Integer> listeProba = new ArrayList<>();
			 double prob =0.0; //va permettre de savoir la probabilité de choix pour chaque ville
			 double nominateur = 0.0;
			 double denominateur = 0.0;

			 //================= Boucle permettant de calculer la proba =========================
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
	 }

	 public static void main(String[] args) {

		 Reseau reseau = new Reseau(20);
		 Colonie colonie = new Colonie(20);

		 // initialisation des tableau qui repertorient les meilleurs parcours
		 ArrayList<Arete> meilleurParcours = new ArrayList<>();
		 ArrayList<Arete> nouveauMeilleurParcours;

		 //Répartition des fourmis aléatoire avec 1 ville = 1 fourmie
		 repartitionAleatoire(reseau, colonie);
		 new Fenetre();
		 //Tant que non convergence du système faire
		 boolean convergence = false;
		 double distanceAncien = 0.0;
		 double nouvelleDistance = 0.0;
		 double difference = 100;  // init avant le debut de la boucle
		 boolean meilleur;

		 while(!convergence) {
			//Cycle pour l'ensemble de la colonie
			for (Fourmi fourmi : colonie.getColonie()) {
				//Pour chaque fourmi faire
				cycleFourmi(fourmi, reseau);
				System.out.println(fourmi.getVilleCourante());
			}
			// ======= après que toutes les fourmis aient parcourues tout le reseau,  les phéronomones s'évaporent
			evaporationTime(reseau);

			// après que sur chaque arète les phéromones se soient évaporés, les fourmis deposent les leurs de nouveau
			depotPheromone(colonie, reseau);
			//System.out.println("Arete fin de boucle : " + reseau.getAretes());
			// on selectionne le meilleur parcours parmis le parcours des fourmis et on l'enregistre si il est meilleur que l'ancien.

			 // on recupere l'ancienne distance
			distanceAncien = colonie.getMeilleureDistance();
			// le nouveau parcours est stocké dans colonie
			meilleurParcours(colonie, reseau);
			// on recupere la nouvelle distance ainsi que les info du meilleur parcour
			nouvelleDistance = colonie.getMeilleureDistance();
			nouveauMeilleurParcours = colonie.getMeilleurParcours();
			// on calcul la difference entre les 2 distances
			difference = Math.abs(distanceAncien - nouvelleDistance);
			//System.out.println(distanceAncien + " - " + nouvelleDistance + " = " + difference);
			// si c'est la premiere occurence de la boucle OU si le meilleur parcours est moins bon que le nouveau alors :
		 	meilleur = distanceAncien >= nouvelleDistance;
			System.out.println("meillleur ? : " + meilleur);
			if (meilleurParcours.isEmpty() || meilleur) {
				// on enregistre le nouveau parcours
				meilleurParcours = nouveauMeilleurParcours;
				distanceAncien = nouvelleDistance;
			}
			if (difference <= 5) {
				convergence = true;
			}
			 System.out.println("AVANT RESET -----------------------");
			 System.out.println(colonie.getMeilleurParcours());
			for (Fourmi f: colonie.getColonie()) {
				 f.resetFourmi();
			 }
			 System.out.println("APRES RESET -----------------------");
			 System.out.println(colonie.getMeilleurParcours());

		 }
		 System.out.println("meilleur distance " + distanceAncien);
		 //System.out.println("villes a parcourir :" + villesRestantes(reseau, colonie.getFourmi(0)));
	 }


}
