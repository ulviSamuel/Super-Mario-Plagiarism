package Bean;

import Graphics.Accoglienza;
import Graphics.BaseFrame;
import Graphics.Livelli;
import Graphics.MainMenu;
import Graphics.Mario;

public class GestoreInterazioniEAnimazioni { //classe che gestisce le interazioni tastiera

	public GestoreInterazioniEAnimazioni() {
		
	}
	
	public static void muoviDestra() {
		
		if(Livelli.getUsaCmd() && !Collisioni.getDNo()) {
			
			if(BaseFrame.getXMap()>(-BaseFrame.getWMap()+690)) {
				
				if(BaseFrame.getXMario()<330 || -(BaseFrame.getXMap())>=BaseFrame.getWidthMap()-700) {
					BaseFrame.setMario(BaseFrame.getXMario()+10, BaseFrame.getYMario());
					Mario.setMarioRt((int)Mario.getMarioRt().getX()+10, (int)Mario.getMarioRt().getY());
				} else {
					BaseFrame.setMap(BaseFrame.getXMap()-10, BaseFrame.getYMap());
					Collisioni.setCollisioniTutorial(-10, 0);
				}
				
				Collisioni.verificaCollisioneTutorial(Mario.getMarioRt(), 'd');
			}
			
			Collisioni.attivaControlloGravTutorial();
		}
	}
	
	public static void muoviSinistra() {
		if(Livelli.getUsaCmd() && !Collisioni.getANo()) {
			
			if(BaseFrame.getXMap()==0 || BaseFrame.getXMap()<=-3300 && BaseFrame.getXMario()>330) {
				if(BaseFrame.getXMario()>10) {
					BaseFrame.setMario(BaseFrame.getXMario()-10, BaseFrame.getYMario());
					Mario.setMarioRt((int)Mario.getMarioRt().getX()-10, (int)Mario.getMarioRt().getY());
				}
			} else {
				BaseFrame.setMap(BaseFrame.getXMap()+10, BaseFrame.getYMap());
				Collisioni.setCollisioniTutorial(+10, 0);
			}
			Collisioni.verificaCollisioneTutorial(Mario.getMarioRt(), 'a');
			Collisioni.attivaControlloGravTutorial();
	 	}
		
	}
	
	public static void salta() {
		
		//verificare se posso saltare prima di saltare e se posso saltare solo per il valore permesso es. Se ho 20 pixel in alto e salto 30 salto solo 20		
		if(Livelli.getUsaCmd()  && !Collisioni.getWNo()) {
			BaseFrame.setMario(BaseFrame.getXMario(), BaseFrame.getYMario()-30);
			Mario.setMarioRt((int) Mario.getMarioRt().getX(), (int) Mario.getMarioRt().getY()-30);
			Tempo.timerDelSalto();
			Collisioni.verificaCollisioneTutorial(Mario.getMarioRt(), 'w');
		}
	}
	
	public static void prosegui() {
		if(Accoglienza.getPassato()) { 
			Accoglienza.accoglienzaRemover();
	  		Audio.sceltaMenu();
	  		MainMenu.mainMenuAdder();
  		}
	}
}
