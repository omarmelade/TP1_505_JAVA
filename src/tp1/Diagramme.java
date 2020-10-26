package tp1;

import java.util.ArrayList;
import java.util.*;

public class Diagramme {
	/*private ArrayList<HashMap<String,Integer>> automate;  */
	
	
	
	
	
	
	public Diagramme( /*ArrayList<HashMap<String,Integer>> automate*/) {
		/*this.automate = automate;*/ 
	}
	
	
	//Fonction retournant un dictionnaire de mots associés à l'indice auxquelles ils apparraissent
	public HashMap<String,Integer> estDedans(ArrayList<HashMap<String,Integer>>automate, String phrase) {
		HashMap<String,Integer> resultat= new HashMap<String,Integer>();
		int indice = 0;
		
		for(int i = 0;i<phrase.length();i++){
			
	        for (Map.Entry mapentry : automate.get(indice).entrySet()){
	        	System.out.println(mapentry.getKey()+"=="+phrase.subSequence(i,i+1));
	        	boolean trouve =false;
	        	//On verifie si le caractère actuel de la chaine correspond à une transition de l'état en cours de l'automate
	        	if((int)mapentry.getValue()==-1 && trouve == false) {
	        		resultat.put((String)mapentry.getKey(),0);
	        		trouve = true;
	        	}
	        	if(mapentry.getKey().toString()== phrase.subSequence(i,i+1)){
	        		System.out.println("pareil");
	        		indice = (int)mapentry.getValue();
	        	}else {
	        		indice =0;
	        	}
	        }
		}
		return resultat;
	}
	
	
	
	
	
	
}
