package Bean;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio { //classe che gestisce i suoni
	
	private static Clip clipChoice; //conterrà l'audio che suona quando viene fatta una scelta nel menu, static per poter utilizzare gli audio senza dichiarare oggetti
	private static Clip clipSigla; //conterrà l'audio della sigla, static per lo stesso motivo appena descritto
	
	public Audio() {
		
	}
	
	public static void suonaSigla() { //fa uscire in output dalle casse/cuffie la sigla in loop, static per lo stesso motivo precedentemente descritto
		
		File sigla = new File("audio\\sigla.wav");
		
		AudioInputStream audio = null;
		try {
			audio = AudioSystem.getAudioInputStream(sigla);
		} catch (UnsupportedAudioFileException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		clipSigla = null;
		try {
			clipSigla = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			clipSigla.open(audio);
		} catch (LineUnavailableException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clipSigla.loop(1);
	}
	
	public static void sceltaMenu() { //inizializza il suono di scelta nelmenu, blocca la sigla, fa partire la musica di scelta e rifà partire la sigla solo dopo che l'audio sarà finito
		
		File sigla = new File("audio\\choice.wav");
		
		AudioInputStream audio = null;
		try {
			audio = AudioSystem.getAudioInputStream(sigla);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clipChoice = null;
		try {
			clipChoice = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			clipChoice.open(audio);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clipSigla.stop();
		clipChoice.start();
		while(clipChoice.getMicrosecondLength() != clipChoice.getMicrosecondPosition())
		{
		}
		clipSigla.loop(1);
	}
}
