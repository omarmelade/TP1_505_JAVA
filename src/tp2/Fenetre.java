package tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
	
//Taille de la fenêtre 
final static int HAUTEUR= 800;
final static int LARGEUR= 1600;

public Fenetre() {
    Reseau reseau = new Reseau(25);
	//Informations générales de la fenêtre
    setTitle("Algorithme des fourmis");
    setSize(LARGEUR,HAUTEUR);
    setMinimumSize(new Dimension(LARGEUR,HAUTEUR));
    
    //Création du panel contenant les informations importantes et le panel contenant le dessein de la carte 
    JPanel Info = new JPanel();
    Info.setLayout(new GridLayout(4,1));
    JPanel boutons = new JPanel();
    BorderLayout layout = new BorderLayout();
    add(Info,BorderLayout.WEST);


    //Element du panneau de contrôle 
    JLabel information = new JLabel("Panneau de commande");
    JButton nouveau = new JButton("Nouveau réseau");
    JButton start = new JButton("Démarrer cycles");
    JButton etape = new JButton("nouveau cycle");
    JLabel cycle = new JLabel ("Cycle n° ");
    
    
    //Ajout des éléments
    Info.add(information);
    Info.add(cycle);
    boutons.add(start);
    boutons.add(etape);
    Info.add(boutons);

    //Gestion Listeners
    ActionListener cycleComplet = new CycleCompletListener(reseau);
    start.addActionListener(cycleComplet);

    //Dessein du réseau
    Carte carte = new Carte(reseau);
    reseau.addObserver(carte);
    add(carte,BorderLayout.CENTER);



    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
