package tp1;

import java.util.ArrayList;
import java.util.*;

public class Diagramme {
	
	//Representation sous forme d'automate 
	private ArrayList<HashMap<String,Integer>> automate; 
	private HashMap<String,Integer> resultat;
	private boolean trouve;
	
	public Diagramme( ArrayList<HashMap<String,Integer>> automate) {
		this.automate = automate; 
		this.resultat = new HashMap<String,Integer>();
	}
	
	
	
	
	//Fonction retournant un dictionnaire de mots associés à l'indice auxquelles ils apparraissent
	public HashMap<String,Integer> estDedans(String phrase) {
		
		//HashMap<String,Integer> resultat= new HashMap<String,Integer>();
		int indice = 0;
		int debutMot = 0;
		
		
		
		
		for(int i = 0;i<phrase.length();i++){
        	boolean trouve =false;
        	//indice = chercheDico (automate.get(indice),(String)phrase.subSequence(i,i+1),resultat);
	     /*   for (Map.Entry mapentry : automate.get(indice).entrySet()){
	        	//On verifie si le caractère actuel de la chaine correspond à une transition de l'état en cours de l'automate
	        	if((int)mapentry.getValue()== -1 ) {
	        		resultat.put((String)mapentry.getKey(),i-((String)mapentry.getKey()).length());
	        	}
	        	if(mapentry.getKey().toString().equals(phrase.subSequence(i,i+1))&& trouve == false){
	        		indice = (int)mapentry.getValue();
	        		trouve = true;
	        		debutMot = i;

	        	}
	        }*/
        	
	        if(trouve==false) {
	        	//Si la lettre ne correspond à aucun des caractères de la lettre actuelle, on vérifie sur la transition initiale
	        	indice = chercheDico(automate.get(0),(String)phrase.subSequence(i,i+1),resultat);
	        }
		}
		
		//Boucle verifiant la liaisons atteintes par le dernier caractère de la phrase
        for (Map.Entry mapentry : automate.get(indice).entrySet()){
        	//On verifie si le caractère actuel de la chaine correspond à une transition de l'état en cours de l'automate
        	if((int)mapentry.getValue()== -1 ) {
        		resultat.put((String)mapentry.getKey(),0);
        	}
        }
		System.out.println("Les mots trouvés sont:");
		return resultat;
	}
	
	
	
	public int chercheDico (HashMap<String,Integer> dico,String car, HashMap<String,Integer> resultat) {
		boolean trouve=false;
		int indice = 0;
        for (Map.Entry mapentry : dico.entrySet()){
        	//On verifie si le caractère actuel de la chaine correspond à une transition de l'état en cours de l'automate
        	if((int)mapentry.getValue()== -1 ) {
        		resultat.put((String)mapentry.getKey(),0);
        	}
        	if(mapentry.getKey().toString().equals(car)&& trouve == false){
        		indice = (int)mapentry.getValue();
        		trouve = true;

        	}
        }
		return indice;
	}
	
	
	
}
