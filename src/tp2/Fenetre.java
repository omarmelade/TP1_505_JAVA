package tp2;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
	
//Taille de la fenêtre 
final static int HAUTEUR= 800;
final static int LARGEUR= 1600;

public Fenetre() {
	//Informations générales de la fenêtre
    setTitle("Algorithme des fourmis");
    setSize(LARGEUR,HAUTEUR);
    setMinimumSize(new Dimension(LARGEUR,HAUTEUR));
    //Création du panel contenant les informations importantes et le panel contenant le dessein de la carte 
    JPanel Info = new JPanel();
    JPanel dessein = new JPanel();
    GridLayout layout = new GridLayout(1,1);
    setLayout(layout);
    add(Info);
    add(dessein);

    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
