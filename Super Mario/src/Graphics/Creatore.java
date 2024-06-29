package Graphics;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Bean.Audio;
import Bean.Tempo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Creatore { //classe che mostra il creatore per cambiare la solita slide del caricamento

	private static JPanel cr = new JPanel(); 
	
	public Creatore() {
		cr.setLayout(null);
		cr.setBounds(0, 0, 686, 413);
		cr.setBackground(Color.black);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("img\\immagine_2022-08-07_154310386_preview_rev_1.png"));
		logo.setBounds(60, 114, 580, 170);
		cr.add(logo);
		BaseFrame.addPanel(cr);
	}
	
	public static void creatoreAdder() { 
		BaseFrame.visiblePanel(cr);
		Tempo.timerDelLogo();
	}
	
	public static void creatoreRemover() {
		BaseFrame.removePanel(cr);
	}

}
