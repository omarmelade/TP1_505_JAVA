package tp2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fenetre extends JFrame {
	
//Taille de la fen�tre 
final static int HAUTEUR= 800;
final static int LARGEUR= 1600;

public Fenetre() {
	 Reseau reseau = new Reseau(20);
	//Informations g�n�rales de la fen�tre
    setTitle("Algorithme des fourmis");
    setSize(LARGEUR,HAUTEUR);
    setMinimumSize(new Dimension(LARGEUR,HAUTEUR));
    
    //Cr�ation du panel contenant les informations importantes et le panel contenant le dessein de la carte 
    JPanel Info = new JPanel();
    Info.setLayout(new GridLayout(4,1));
    JPanel boutons = new JPanel();
    BorderLayout layout = new BorderLayout();
    add(Info,BorderLayout.WEST);
    //Dessein du r�seau
    Carte carte = new Carte(reseau);
    add(carte,BorderLayout.CENTER);
    //Element du panneau de contr�le 
    JLabel information = new JLabel("Panneau de commande");
    JButton nouveau = new JButton("Nouveau r�seau");
    JButton start = new JButton("D�marr� cycles");
    JButton etape = new JButton("nouveau cycle");
    JLabel cycle = new JLabel ("Cycle n� ");
    
    
    
    //Ajout des �l�ments
    Info.add(information);
    Info.add(cycle);
    boutons.add(start);
    boutons.add(etape);
    Info.add(boutons);
    

    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
