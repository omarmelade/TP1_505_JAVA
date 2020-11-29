package tp2;

import java.awt.Canvas;
import java.util.Observer;
import java.awt.Color;
import java.awt.Graphics;
public class Carte extends Canvas{
	//Constantes
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private Reseau reseau;
	
	//Constructeurs
	public Carte(Reseau reseau) {
		this.reseau =reseau;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(1000, 1000, 1000, 1000);
		g.drawRect(1000,1000,1000,1000);
	}
	

	}
	
