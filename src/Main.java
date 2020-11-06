

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tp1.Diagramme;
import tp1.Fenetre;
import tp1.MotCles;
import tp2.Reseau;
import tp2.Ville;

import java.util.ArrayList;
import java.util.HashMap;

public class Main   {


    public static void main(String[] args) {
    	
    	//new Fenetre();
    	/*System.out.println("Test");
    	MotCles m = new MotCles();
    	System.out.println("Reponses question 1");
    	System.out.println("====================");
    	System.out.println("Test correct");
    	System.out.println(m.keyword("Bonjour", "Je suis un test, Bonjour"));
    	System.out.println("Test incorrect");
    	System.out.println(m.keyword("Bonjour", "Je suis un test, Bonj"));
    	String mot = "test";
    	System.out.println(mot.subSequence(3, 4));*/

    	
    	//Question avec automate
    	
    	//new Fenetre();
    	//Déclaration de notre automate sous forme de ArrayList de dictionnaires
    	/*ArrayList<HashMap<String,Integer>> automate = new ArrayList<HashMap<String,Integer>>();
    	
    	HashMap<String,Integer> dic0 = new HashMap<String,Integer>();
    	dic0.put("I", 3);
    	dic0.put("R", 2);
    	dic0.put("N", 1);
    	automate.add(dic0);
    	
    	HashMap<String,Integer> dic1 = new HashMap<String,Integer>();
    	dic1.put("I", 4);
    	automate.add(dic1);
    	
    	HashMap<String,Integer> dic2 = new HashMap<String,Integer>();
    	dic2.put("E", 5);
    	automate.add(dic2);
    	
    	HashMap<String,Integer> dic3 = new HashMap<String,Integer>();
    	dic3.put("R", 6);
    	automate.add(dic3);
    	
    	HashMap<String,Integer> dic4 = new HashMap<String,Integer>();
    	dic4.put("R", 6);
    	dic4.put("NI", -1);
    	automate.add(dic4);
    	
    	HashMap<String,Integer> dic5 = new HashMap<String,Integer>();
    	dic5.put("I", 8);
    	dic5.put("N",7);
    	automate.add(dic5);
    	
    	HashMap<String,Integer> dic6 = new HashMap<String,Integer>();
    	dic6.put("E", 9);
    	automate.add(dic6);

    	HashMap<String,Integer> dic7 = new HashMap<String,Integer>();
    	dic7.put("E", 10);
    	dic7.put("I", 4);
    	automate.add(dic7);
    	
    	HashMap<String,Integer> dic8 = new HashMap<String,Integer>();
    	dic8.put("R", 6);
    	dic8.put("N",11);
    	automate.add(dic8);
    	
    	HashMap<String,Integer> dic9 = new HashMap<String,Integer>();
    	dic9.put("N", 12);
    	dic9.put("I",8);
    	automate.add(dic9);
    	
    	HashMap<String,Integer> dic10 = new HashMap<String,Integer>();
    	dic10.put("RENE", -1);
    	automate.add(dic10);
    	
    	HashMap<String,Integer> dic11 = new HashMap<String,Integer>();
    	dic11.put("I", 4);
    	dic11.put("REIN",-1);
    	automate.add(dic11);
    	
    	HashMap<String,Integer> dic12 = new HashMap<String,Integer>();
    	dic12.put("I", 4);
    	dic12.put("E", 13);
    	automate.add(dic12);
    	
    	HashMap<String,Integer> dic13 = new HashMap<String,Integer>();
    	dic13.put("IRENE", -1);
    	dic13.put("RENE", -1);
    	automate.add(dic13);
    	Diagramme q2 = new Diagramme(automate);
    	System.out.println(q2.estDedans("ANNI N'HONNIT NI NINA NI IRENE IRENE."));*/


        Reseau r = new Reseau(5);
        Ville v1 = new Ville(8.0, 8.0);
        Ville v2 = new Ville(2.5, 7.3);

    }
}