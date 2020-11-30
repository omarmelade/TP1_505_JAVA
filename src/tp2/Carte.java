package tp2;

import java.awt.Canvas;
import java.util.Observer;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Carte extends JPanel{
	//Constantes
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private Reseau reseau;
	
	//Constructeurs
	public Carte(Reseau reseau) {
		this.reseau =reseau;
	}
	@Override
	public void  paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphic2d = (Graphics2D) g;
		graphic2d.setColor(Color.WHITE);
		graphic2d.fillRect(0, 25, this.getWidth()-25, this.getHeight()-50);
	}
	

	}
	
