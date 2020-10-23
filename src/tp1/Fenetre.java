package tp1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
	
	
    
    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
