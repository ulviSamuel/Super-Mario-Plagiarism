package Graphics;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mario { //classe che gestisce il personaggio
	
	private static JLabel mario = new JLabel();
	private static Rectangle marioRt = new Rectangle();

	public Mario() {
		ImageIcon marioImg = new ImageIcon("img\\mario.png");
		
		mario.setBounds(10, 255, 25, 33);
		mario.setIcon(marioImg);
		
		marioRt.setBounds(10, 255, 25, 33);
	}

	public static void characterAdder() {
		BaseFrame.addCharacter(mario);
	}
	
	public static void characterRemover() {
		BaseFrame.removeCharacter(mario);
	}

	public static void visibleCharacter() {
		BaseFrame.visibleCharacter(mario);
	}
	
	public static void setMarioRt(int x, int y) {
		if(Livelli.getPassato()) marioRt.setLocation(x, y);
	}
	
	public static Rectangle getMarioRt() {
		return marioRt;
	}
}
