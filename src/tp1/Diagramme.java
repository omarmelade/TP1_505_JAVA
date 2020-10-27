package tp1;

import java.util.ArrayList;
import java.util.*;

public class Diagramme {
	/*private ArrayList<HashMap<String,Integer>> automate;  */
	
	
	
	
	
	
	public Diagramme( /*ArrayList<HashMap<String,Integer>> automate*/) {
		/*this.automate = automate;*/ 
	}
	
	
	//Fonction retournant un dictionnaire de mots associ�s � l'indice auxquelles ils apparraissent
	public HashMap<String,Integer> estDedans(ArrayList<HashMap<String,Integer>>automate, String phrase) {
		HashMap<String,Integer> resultat= new HashMap<String,Integer>();
		int indice = 0;
		for(int i = 0;i<phrase.length();i++){
        	boolean trouve =false;
	        for (Map.Entry mapentry : automate.get(indice).entrySet()){
        		//System.out.println(automate.get(indice));
	        	//System.out.println(mapentry.getKey()+"=="+phrase.subSequence(i,i+1));
	        	//On verifie si le caract�re actuel de la chaine correspond � une transition de l'�tat en cours de l'automate
	        	if((int)mapentry.getValue()== -1 ) {
	        		resultat.put((String)mapentry.getKey(),0);
	        	}
	        	if(mapentry.getKey().toString().equals(phrase.subSequence(i,i+1))&& trouve == false){
	        		indice = (int)mapentry.getValue();
	        		trouve = true;

	        	}
	        }
	        if(trouve==false) {
	        	//Si la lettre ne correspond � aucun des caract�res de la lettre actuelle, on v�rifie sur la transition initiale
	        	indice = chercheDico(automate.get(0),(String)phrase.subSequence(i,i+1),resultat);
	        }
		}
		
		//Boucle verifiant la liaisons atteintes par le dernier caract�re de la phrase
        for (Map.Entry mapentry : automate.get(indice).entrySet()){
        	//On verifie si le caract�re actuel de la chaine correspond � une transition de l'�tat en cours de l'automate
        	if((int)mapentry.getValue()== -1 ) {
        		resultat.put((String)mapentry.getKey(),0);
        	}
        }
		System.out.println("Les mots trouv�s sont:");
		return resultat;
	}
	
	
	//
	public int chercheDico (HashMap<String,Integer> dico,String car, HashMap<String,Integer> resultat) {
		boolean trouve=false;
		int indice = 0;
        for (Map.Entry mapentry : dico.entrySet()){
        	//On verifie si le caract�re actuel de la chaine correspond � une transition de l'�tat en cours de l'automate
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
