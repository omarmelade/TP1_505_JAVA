package tp1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Fenetre extends JFrame {
	
//Taille de la fenêtre 
final static int HAUTEUR= 800;
final static int LARGEUR= 1600;

//Panel de test   
private JTabbedPane tabbedPane = new JTabbedPane();
private JPanel Question_1 =new JPanel();
private  JPanel Question_2 =new JPanel();


public Fenetre() {
	//Informations générales de la fenêtre
    setTitle("Gestion de projet");
    setSize(LARGEUR,HAUTEUR);
    setMinimumSize(new Dimension(LARGEUR,HAUTEUR));
    
    JTextField phrase = new JTextField();
    phrase.setSize(1400, 200);
    JTextField mot = new JTextField();
    mot.setSize(200, 200);
	JButton  validerQ1 = new JButton("Recherche Q1");
	validerQ1.setSize(200, 200);
	add(phrase);
	add(mot);
	add(validerQ1);
    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
