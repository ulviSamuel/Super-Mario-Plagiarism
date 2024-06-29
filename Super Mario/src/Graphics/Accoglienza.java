package Graphics;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Bean.Audio;

public class Accoglienza {
	
	private static JPanel acc = new JPanel(); //il panel del menu di accoglienza che sovrasterà il frame, static per moterla rimuovere in qunto unica (se metto senza creo vari oggetti e diventa problematico)
	private static boolean accoglienza = false; //determina se ci si trova ancora nel menu di accoglienza o no
	
	public Accoglienza(){ //creo il panel
		acc.setLayout(null);
		acc.setBounds(0, 0, 686, 413);
		acc.setBackground(Color.blue);
		
		JLabel superMarioImg = new JLabel("");
		superMarioImg.setIcon(new ImageIcon("img\\Super-Mario-Logo - piccolo.png"));
		superMarioImg.setBounds(37, 40, 590, 283);
		acc.add(superMarioImg);
		
		JLabel mario = new JLabel();
		mario.setBounds(550, 135, 100, 100);
		mario.setIcon(new ImageIcon("img\\mario-grande.png"));
		acc.add(mario);
		
		JLabel enterText = new JLabel("PREMERE INVIO PER GIOCARE");
		enterText.setForeground(Color.WHITE);
		enterText.setBounds(257, 378, 201, 13);
		acc.add(enterText);
		BaseFrame.addPanel(acc);
	}
	
	public static boolean getPassato() { //informo i listener sullo stato dell'utente, se si trova ancora al menu di accoglienza
		return accoglienza;
	}
	
	public static void accoglienzaAdder() {  //aggiungo il panel al frame
		accoglienza = true;
		BaseFrame.visiblePanel(acc);
		Audio.suonaSigla();
	}
	
	public static void accoglienzaRemover() { //rimuovo questo menu per mettere poi il sucessivo, static per il solito problema di unicità
		BaseFrame.removePanel(acc);
		accoglienza = false;
	}
	
}
