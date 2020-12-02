package tp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
	
//Taille de la fenêtre 
final static int HAUTEUR= 800;
final static int LARGEUR= 1600;

    public Fenetre() {
        Reseau reseau = new Reseau(10);
        Colonie colonie = new Colonie(10);
        //Informations générales de la fenêtre
        setTitle("Algorithme des fourmis");
        setSize(LARGEUR,HAUTEUR);
        setMinimumSize(new Dimension(LARGEUR,HAUTEUR));

        //Création du panel contenant les informations importantes et le panel contenant le dessein de la carte
        JPanel Info = new JPanel();
        Info.setLayout(new GridLayout(5,1));
        add(Info,BorderLayout.WEST);


        //Element du panneau de contrôle
        JLabel information = new JLabel("Panneau de commande");
        JPanel nouveau = new JPanel();
        nouveau.setLayout(new GridLayout(3,1));
        JLabel nb = new JLabel("Nombre de villes: ");
        JTextField nbEntree = new JTextField("");
        JButton changerNb = new JButton("Changer");
        JButton start = new JButton("Lancer");
        JLabel distance= new JLabel("Plus courte distance :");
        //Ajout au panel de changement de réseau
        nouveau.add(nb);
        nouveau.add(nbEntree);
        nouveau.add(changerNb);

        //Ajout des éléments
        Info.add(information);
        Info.add(nouveau);
        Info.add(start);
        Info.add(distance);
        
        //Dessein du réseau et ajout aux observers
        Carte carte = new Carte(reseau,colonie);
        reseau.addObserver(carte);
        add(carte,BorderLayout.CENTER);
        
        //===============================Gestion Listeners=============================================================
        //Changer la taille du réseau ou simplement en avoir un nouveau
        ActionListener nouv =  new NouveauReseauListener(reseau,colonie,nbEntree);
        changerNb.addActionListener(nouv);
        //Lancer un parcours jusqu'à atteindre la convergence
        ActionListener cycleComplet = new CycleCompletListener(reseau,colonie,distance);
        start.addActionListener(cycleComplet);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
