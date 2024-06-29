package Graphics;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bean.Audio;
import Bean.GestoreInterazioniEAnimazioni;

import java.awt.Color;
import javax.swing.JButton;

public class BaseFrame implements KeyListener{ //classe baseFrame cioè la classe che corrisponde al frame di base, un frame quasi vuoto che contiene solo qello che verrà usato in qualsiasi situazione.

	private static JFrame mainFrame = new JFrame("Super Mario Plagiarism"); //frame static in modo che c'è ne sia uno solo in tutto il programma e in modo che sia modificabile da tutti senza complicanze
	private static JPanel livello; //panel solo per i livelli in quanto se non lo metto qua non lo posso spostare al digitare dei comandi
	private static JLabel mario; //per lo stesso motivo di prima
	
	public BaseFrame(){ //impostazioni di base del frame, vengono inserite subito cme il frame viene creato
		mainFrame.setBackground(Color.WHITE);
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\Super-Mario-Logo.png"));
		mainFrame.setBounds(100, 100, 700, 450);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.addKeyListener(this);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void addPanel(JPanel panel) { //per poter modificare il frame da altre classi occore far scrivere a queste classi dei panel che verranno messi sopra al frame con tutte le info del momento come il menu di selezione del livello o il pre-menu
		if(Livelli.getPassato()==true) { 
			livello = panel;
			mainFrame.getContentPane().add(livello);
		} else mainFrame.getContentPane().add(panel);
		panel.setVisible(false); //tutto questo in modo che quando l'utente avvia l'applicazione tutto sia già caricato
	}
	
	public static void removePanel(JPanel panel) { //stessa identica cosa di prima ma rimuove il panel
		panel.setVisible(false); //essendo che il panel non viene rimosso all'istante e resta visibile lo rimuovo prima visibilmente e poi il pc procederà a rimuoverlo definitivamente
		mainFrame.getContentPane().remove(panel);
		mainFrame.requestFocusInWindow(); //riporto l'attenzione sui listener di tastiera in quanto i listener dei buttom interrompono quelli di tastiera
	}
	
	public static void visiblePanel(JPanel panel) { //quando mi serve visualizzo il panel
		panel.setVisible(true);
		mainFrame.setVisible(true); //va messo in modo da aggiornare il nuovo contenuto
	}
	
	public static void notVisiblePanel(JPanel panel) { //quando non mi serve in quel momento ma mi servirà nascondo il panel senza rimuoverlo
		panel.setVisible(false);
	}
	
	public static void addCharacter(JLabel label) {
		mario = label;
		mainFrame.getContentPane().add(mario);
		label.setVisible(false);
	}
	
	public static void removeCharacter(JLabel label) {
		mario.setVisible(false);
		mario = label;
		mainFrame.getContentPane().add(mario);
		label.setVisible(false);
	}
	
	public static void visibleCharacter(JLabel label) {
		label.setVisible(true);
		mainFrame.setVisible(true);
	}
	
	public static int getXMario() {
		return mario.getX();
	}
	
	public static int getYMario() {
		return mario.getY();
	}
	
	public static void setMario(int x, int y) {
		if(Livelli.getPassato()) mario.setLocation(x, y);
	}
	
	public static int getWMap() {
		return livello.getWidth();
	}
	
	public static int getXMap() {
		return livello.getX();
	}
	
	public static int getYMap() {
		return livello.getY();
	}
	
	public static int getWidthMap() {
		return livello.getWidth();
	}
	
	public static void setMap(int x, int y) {
		if(Livelli.getPassato()) livello.setLocation(x, y);
	}

	@Override
	public void keyTyped(KeyEvent e) {  //questi tre metodi sono dei listener, continuano all'infinito a vedere se qualche tasto della tastiera viene cliccato e agiscono di conseguenza
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case 65: GestoreInterazioniEAnimazioni.muoviSinistra();
		break;
		
		case 68: GestoreInterazioniEAnimazioni.muoviDestra();
		break;
		
		case 32: GestoreInterazioniEAnimazioni.salta();
		break;
		
		case 10: GestoreInterazioniEAnimazioni.prosegui();
		break;
	 }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*System.out.println("You released key char: " + e.getKeyChar());
		System.out.println("You released key code: " + e.getKeyCode());*/
	}
}
