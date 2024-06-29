package Graphics;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import Bean.Audio;
import Bean.Collisioni;

public class MainMenu { //menu che gestisce la scelta del livello
	
	private static JPanel mn = new JPanel(); 
	
	public MainMenu(){ 
		mn.setLayout(null);
		mn.setBounds(0, 0, 686, 413);
		mn.setBackground(new Color(160, 82, 45));
		
		JButton tutorial = new JButton("TUTORIAL");
		tutorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainMenuRemover();
				Audio.sceltaMenu();
				Caricamento.caricamentoAdder();
				Mario.characterAdder();
				Livelli.tutorialAdder();
				Collisioni.addTutorial();
			}
		});
		tutorial.setBounds(10, 10, 160, 70);
		mn.add(tutorial);
		
		JButton livello1 = new JButton("LIVELLO 1");
		livello1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainMenuRemover();
				Audio.sceltaMenu();
				Caricamento.caricamentoAdder();
				Livelli.tutorialAdder();
				Mario.characterAdder();
			}
		});
		livello1.setBounds(180, 10, 160, 70);
		mn.add(livello1);
		
		JButton livello2 = new JButton("LIVELLO 2");
		livello2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainMenuRemover();
				Audio.sceltaMenu();
				Caricamento.caricamentoAdder();
				Livelli.tutorialAdder();
				Mario.characterAdder();
			}
		});
		livello2.setBounds(350, 10, 160, 70);
		mn.add(livello2);
		
		JButton livello3 = new JButton("LIVELLO 3");
		livello3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainMenuRemover();
				Audio.sceltaMenu();
				Caricamento.caricamentoAdder();
				Livelli.tutorialAdder();
				Mario.characterAdder();
			}
		});
		livello3.setBounds(520, 10, 160, 70);
		mn.add(livello3);
		
		BaseFrame.addPanel(mn);
	}
	
	public static void mainMenuAdder() { 
		BaseFrame.visiblePanel(mn);
	}
	
	public static void mainMenuRemover() {
		BaseFrame.removePanel(mn);
	}
}
