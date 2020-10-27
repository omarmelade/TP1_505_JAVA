package tp1;

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

    JPanel Question =new JPanel();
    GridLayout layout = new GridLayout(3,2,50,50);
    Question.setLayout(layout);

    //Affichage pour la question
    Font f = new Font("Serif", Font.PLAIN, 36); // par exemple
    JLabel nomPhrase = new JLabel("Phrase de recherche: ");
    nomPhrase.setFont(f);
    JTextField phrase = new JTextField();
    phrase.setFont(f);
    JLabel nomMot = new JLabel("Mot à chercher/ Liste trouvée: ");
    nomMot.setFont(f);
    JTextArea mot = new JTextArea();
    mot.setFont(f);
	JButton  valider1 = new JButton("Recherche d'un mot");
	valider1.setFont(f);
	JButton  valider2 = new JButton("Recherche de la liste");
	valider2.setFont(f);
	Question.add(nomPhrase);
	Question.add(phrase);
	Question.add(nomMot);
	Question.add(mot);
	Question.add(valider1);
	Question.add(valider2);

	
	ActionListener search1 = new RechercheListener1(phrase,mot);
	valider1.addActionListener(search1);
	ActionListener search2 = new RechercheListener2(phrase,mot);
	valider2.addActionListener(search2);

	
	

	
	
	
    
	add(Question);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
