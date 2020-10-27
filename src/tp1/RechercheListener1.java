package tp1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RechercheListener1 implements ActionListener{
	
	private JTextField phrase;
	private JTextArea mot;
	
	
	
	public RechercheListener1(JTextField phrase,JTextArea mot) {
		this.phrase=phrase;
		this.mot =mot;
	}
	
	//méthode
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MotCles recherche = new MotCles();
		
		boolean trouve = recherche.keyword(mot.getText(), phrase.getText());
		if (trouve) {
			//Boîte du message d'erreur
            JOptionPane.showMessageDialog(null, "Le mot est bien dans la phrase ! ", "Resultat", JOptionPane.INFORMATION_MESSAGE);
		}else {
			//Boîte du message de validation
	        JOptionPane.showMessageDialog(null, "Le mot n'est pas dans la phrase !", "Resultat", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
