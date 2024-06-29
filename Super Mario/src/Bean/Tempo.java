package Bean;

import java.util.Timer;
import java.util.TimerTask;

import Graphics.Accoglienza;
import Graphics.BaseFrame;
import Graphics.Caricamento;
import Graphics.Creatore;
import Graphics.Livelli;
import Graphics.Mario;

public class Tempo { //classe che gestise la durata dei tempi di caricamento

	private static Timer tm = new Timer();
	private static int conta = 0;
	
	public Tempo() {
		 
	}
	
	public static void timerDelCaricamento() {
		tm.schedule( new java.util.TimerTask() { @Override public void run() { Caricamento.caricamentoRemover(); Creatore.creatoreAdder();} }, 5000);
	}
	
	public static void timerDelLogo() {
		tm.schedule( new java.util.TimerTask() { @Override public void run() { Creatore.creatoreRemover(); Accoglienza.accoglienzaAdder();} }, 5000);
	}
	
	public static void timerDelCaricamentoLv() {
		tm.schedule( new java.util.TimerTask() { @Override public void run() { Caricamento.caricamentoRemover(); Livelli.tutorialVisible(); Mario.visibleCharacter();} }, 5000);
	}
	
	public static void timerDelSalto() {
		 tm.schedule( new java.util.TimerTask() { @Override public void run() { Collisioni.attivaControlloGravTutorial(); } }, 200);
	}
	
	public static void controlloGravit() {
		Timer tmEs = new Timer();
		long tempo = 2;
		
		if(conta>=20) tempo = 1;
		
		tmEs.schedule(new TimerTask() {
		
		  @Override
		  public void run() {
		    if(Collisioni.verificaGravitaTutorial(Mario.getMarioRt())) {
		    	tmEs.cancel();
		    	conta++;
		    }
		  }
		}, 0, tempo);
		
	}
}
