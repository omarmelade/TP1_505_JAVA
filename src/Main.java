import tp1.Diagramme;
import tp1.Fenetre;
import tp1.MotCles;

import java.util.ArrayList;
import java.util.HashMap;

public class Main   {


    public static void main(String[] args) {
//    	new Fenetre();
//    	System.out.println("Test");
//    	MotCles m = new MotCles();
//    	System.out.println("Responses question 1");
//    	System.out.println("====================");
//    	System.out.println("Test correct");
//    	System.out.println(m.keyword("Bonjour", "Je suis un test, Bonjour"));
//    	System.out.println("Test incorrect");
//    	System.out.println(m.keyword("Bonjour", "Je suis un test, Bonj"));
//    	String mot = "test";
//    	System.out.println(mot.subSequence(3, 4));
//

    	ArrayList<HashMap<String,Integer>> arr = new ArrayList<>();
    	
    	//Question avec automate
		HashMap<String, Integer> map0 = new HashMap<>();
		map0.put("I", 3);
		map0.put("R", 2);
		map0.put("N", 1);
		arr.add(map0);
		HashMap<String, Integer> map1 = new HashMap<>();
		map1.put("I", 2);
		arr.add(map1);
		HashMap<String, Integer> map2 = new HashMap<>();
		map2.put("E", 5);
		arr.add(map2);
		HashMap<String, Integer> map3 = new HashMap<>();
		map3.put("R", 6);
		arr.add(map3);
		HashMap<String, Integer> map4 = new HashMap<>();
		map4.put("R", 6);
		map4.put("F", -1);
		arr.add(map4);
		HashMap<String, Integer> map5 = new HashMap<>();
		map5.put("I", 8);
		map5.put("N", 7);
		arr.add(map5);
		HashMap<String, Integer> map6 = new HashMap<>();
		map6.put("E", 6);
		arr.add(map6);
		HashMap<String, Integer> map7 = new HashMap<>();
		map7.put("E", 10);
		arr.add(map7);
		HashMap<String, Integer> map8 = new HashMap<>();
		map8.put("N", 11);
		arr.add(map8);
		HashMap<String, Integer> map9 = new HashMap<>();
    	map9.put("N", 12);
    	map9.put("I", 8);
    	arr.add(map9);
		HashMap<String, Integer> map10 = new HashMap<>();
		map10.put("RENE", -1);
		arr.add(map10);
		HashMap<String, Integer> map11 = new HashMap<>();
		map11.put("I",4);
		map11.put("REIN", -1);
		arr.add(map11);
		HashMap<String, Integer> map12 = new HashMap<>();
		map12.put("I", 4);
		arr.add(map12);
		HashMap<String, Integer> map13 = new HashMap<>();
		map13.put("RENE", -1);
		map13.put("IRENE", -1);
		arr.add(map13);

		Diagramme d = new Diagramme( arr);
		System.out.println(d.estDedans(arr,"ANNIE N'HONNIT NI NINA NI IRENE"));
    }
}