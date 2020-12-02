package tp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class NouveauReseauListener implements ActionListener{
	Reseau reseau;
	Colonie colonie;
	JTextField nb;
	public NouveauReseauListener(Reseau reseau,Colonie colonie,JTextField nb) {
		this.reseau = reseau;
		this.colonie = colonie;
		this.nb = nb;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 int nombre = Integer.parseInt(nb.getText());
		 reseau.setReseau(nombre);;
		 colonie.setColonie(nombre);
	     reseau.notifyObservers();
	     System.out.println("============================NOUVEAU RESEAU DE TAILLE : "+reseau.getNbVilles()+"============================");
	}
}
