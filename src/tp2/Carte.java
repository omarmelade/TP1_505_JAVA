package tp2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
public class Carte extends JPanel implements Observer{
	//Constantes
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private Reseau reseau;
	private Colonie colonie;
	//Constructeurs
	public Carte(Reseau reseau, Colonie colonie) {
		this.reseau = reseau;
		this.colonie = colonie;
	}

	@Override
	public void  paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D graphic2d = (Graphics2D) g;
		Stroke s = graphic2d.getStroke();
		
		graphic2d.setColor(Color.WHITE);
		graphic2d.fillRect(0, 25, this.getWidth()-25, this.getHeight()-50);

		graphic2d.setColor(Color.BLUE);
		//Dessiner les arrêtes en fonction de la quantité de phéromones
		ArrayList<Arete> listeAretes = reseau.getAretes();
		for(int i =0;i<listeAretes.size();i++) {
			int x1 = 15+50*((int)listeAretes.get(i).getV1().getX());
			int y1 = 15+50*((int)listeAretes.get(i).getV1().getY());
			int x2 = 15+50*((int)listeAretes.get(i).getV2().getX());
			int y2 = 15+50*((int)listeAretes.get(i).getV2().getY());
			int epaisseur = (int)listeAretes.get(i).getPhero();
			graphic2d.setStroke(new BasicStroke( (int) (epaisseur/4) ));
			graphic2d.drawLine(x1, y1, x2, y2);
		}

		// colorie le meilleur parcours
		for(Arete a: colonie.getMeilleurParcours()) {
			int x1 = 15+50*((int)a.getV1().getX());
			int y1 = 15+50*((int)a.getV1().getY());
			int x2 = 15+50*((int)a.getV2().getX());
			int y2 = 15+50*((int)a.getV2().getY());
			int epaisseur = (int)a.getPhero();
			graphic2d.setColor(Color.GREEN);
			graphic2d.setStroke(new BasicStroke( (int) (a.getPhero()/2) ));
			graphic2d.drawLine(x1, y1, x2, y2);
		}
		graphic2d.setColor(Color.BLUE);
		graphic2d.setStroke(s);

		//Dessiner les villes avec leur numéro
		graphic2d.setColor(Color.RED);
		ArrayList<Ville> liste = reseau.getVilles();
		for(int i = 0; i<liste.size();i++) {
			int x = 15+50*((int)liste.get(i).getX());
			int y = 15+50*((int)liste.get(i).getY());
			graphic2d.fillOval(x,y, 10, 10);
			graphic2d.drawString("Ville n°"+liste.get(i).getId(), x, 25+y);
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.repaint();
	}
	

	}
	
