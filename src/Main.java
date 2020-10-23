import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tp1.Fenetre;
import tp1.MotCles;

public class Main   {


    public static void main(String[] args) {
    	new Fenetre();
    	System.out.println("Test");
    	MotCles m = new MotCles();
    	System.out.println("Reponses question 1");
    	System.out.println("====================");
    	System.out.println("Test correct");
    	System.out.println(m.keyword("Bonjour", "Je suis un test, Bonjour"));
    	System.out.println("Test incorrect");
    	System.out.println(m.keyword("Bonjour", "Je suis un test, Bonj"));
    	String mot = "test";
    	System.out.println(mot.subSequence(3, 4));
    	
    	
    	
    	
    	//Question avec automate
    }
}