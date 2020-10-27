package tp1;

import java.util.ArrayList;
import java.util.*;

public class Diagramme {
	
	//Representation sous forme d'automate
	private ArrayList<HashMap<String,Integer>> automate;
	private HashMap<Integer,String> resultat;
	private boolean trouve;

	public Diagramme( ArrayList<HashMap<String,Integer>> automate) {
		this.automate = automate;
		this.resultat = new HashMap<Integer,String>();
		this.trouve = false;
	}

	//Fonction retournant un dictionnaire de mots associés à l'indice auxquelles ils apparraissent
	public HashMap<Integer,String> estDedans(String phrase) {

		//HashMap<String,Integer> resultat= new HashMap<String,Integer>();
		int indice = 0;


		for(int i = 0;i<phrase.length();i++){
        	trouve = false;
        	indice = chercheDico (automate.get(indice),(String)phrase.subSequence(i,i+1), resultat, i);

	        if(!trouve) {
	        	//Si la lettre ne correspond à aucun des caractères de la lettre actuelle, on vérifie sur la transition initiale
	        	indice = chercheDico(automate.get(0),(String)phrase.subSequence(i,i+1),resultat, i);
	        }
		}
		
		//Boucle verifiant la liaisons atteintes par le dernier caractère de la phrase
        for (Map.Entry mapentry : automate.get(indice).entrySet()){
			//int debutMot = i - ((String)mapentry.getKey()).length();
        	//On verifie si le caractère actuel de la chaine correspond à une transition de l'état en cours de l'automate
        	if((int)mapentry.getValue()== -1 ) {
        		int debutMot = phrase.length()-((String)mapentry.getKey()).length(); //Correspond à la position du dernier mot trouver si celui-ci est à la fin de la phrase
        		resultat.put(debutMot,(String)mapentry.getKey());
        	}
        }
		System.out.println("Les mots trouvés sont:");
		return resultat;
	}
	
	

	public int chercheDico (HashMap<String,Integer> dico,String car, HashMap<Integer,String> resultat, int i_upper_loop) {
		trouve = false;
		int indice = 0;
        for (Map.Entry mapentry : dico.entrySet()){

        	// un entier qui determine la position du 1er caractère du mot recherché dans la phrase
        	int debutMot = i_upper_loop - ((String)mapentry.getKey()).length();

        	//On verifie si le caractère actuel de la chaine correspond à une transition de l'état en cours de l'automate
			//On verifie si l'état est final
        	if((int)mapentry.getValue() == -1 ) {
        		// si c'est le cas on stock le mot et l'indice du debut de celui ci
        		resultat.put(debutMot,(String)mapentry.getKey());
        	}
        	// on verifie si le caractère suivant correspond a celui du dico
        	if(mapentry.getKey().toString().equals(car) && !trouve){
        		// si c'est le cas on continue a parcourir les indices que fourni le dico
        		indice = (int)mapentry.getValue();

        		trouve = true;
        	}
        }
		return indice;
		

	}
	public String afficheRes() {
		String liste ="";
        for (Map.Entry mapentry : resultat.entrySet()){
        	liste = liste +" | "+ (String)mapentry.getValue()+" à L'indice "+Integer.toString((Integer)mapentry.getKey())+ " | "; 
        }
		return liste;
	}
}
