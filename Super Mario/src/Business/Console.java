package Business;

import Graphics.Accoglienza;
import Graphics.BaseFrame;
import Graphics.Caricamento;
import Graphics.Creatore;
import Graphics.Livelli;
import Graphics.MainMenu;
import Graphics.Mario;

public class Console {

	public Console() {
		
	}
	
	public void esegui() {
		BaseFrame bs = new BaseFrame();
		Caricamento ld = new Caricamento(); //do il tempo ai panel di crearsi per poi essere aggiunti al frame quando serve
		Creatore cr = new Creatore(); //altro tempo per caricare
		Accoglienza ac = new Accoglienza(); //Istanzio gli oggetti anche se non li uso fin da subito in modo da caricare tutti i panel mentre l'utente usa il programma e quando serve li visualizzo (altrimenti ho dei ritardi di caricamento)
		MainMenu mn = new MainMenu(); 
		Livelli lv = new Livelli();
		Mario mr = new Mario();
	}
}
