package Graphics;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Livelli { //classe che gestisce  livelli

	private static JPanel map = new JPanel(); 
	private static JLabel mappa = new JLabel("");
	private static boolean livelli = false;
	private static boolean usaCmd = false;
	
	public Livelli() {
		map.setLayout(null);
		map.setBackground(Color.CYAN);
	}
	
	public static boolean getPassato() {
		return livelli;
	}
	
	public static boolean getUsaCmd() {
		return usaCmd;
	}
	
	public static void tutorialAdder() {
		
		livelli = true;
		
		map.setBounds(0, 0, 4000, 413);
		mappa.setIcon(new ImageIcon("img\\tutorial.png"));
		mappa.setBounds(0, 0, 4000, 413);
		map.add(mappa);
		
		BaseFrame.addPanel(map);
		BaseFrame.visiblePanel(map);
		
	}
	
	public static void tutorialVisible() {
		BaseFrame.visiblePanel(map);
		usaCmd = true;
	}
	
	public static void tutorialRemover() {
		BaseFrame.removePanel(map);
		livelli = false;
	}
	
}
