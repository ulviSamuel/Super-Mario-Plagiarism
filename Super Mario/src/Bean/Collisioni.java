package Bean;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import Graphics.BaseFrame;
import Graphics.Mario;

public class Collisioni {
	
	private static Rectangle collTutorial[] = {new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle()};
	private static Rectangle bloccoTutorial[] = {new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle()};
	private static Rectangle morteTutorial[] = {new Rectangle(), new Rectangle(), new Rectangle()};
	private static Rectangle vittTutorial = new Rectangle(); 
	private static Rectangle pavimenti[] = {new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle()};
	private static boolean dNo = false;
	private static boolean aNo = false;
	private static boolean wNo = false;
	
	public Collisioni() {
		
	}
	
	public static void addTutorial() {
		
		pavimenti[0].setBounds(0, 285, 355, 20);
		collTutorial[0].setBounds(353, 259, 94, 52);
		pavimenti[1].setBounds(443, 285, 170, 20);
		collTutorial[1].setBounds(609, 227, 94, 83);
		pavimenti[2].setBounds(703, 285, 197, 20);
		collTutorial[2].setBounds(899, 192, 89, 119);
		collTutorial[3].setBounds(899, 94, 30, 25);
		collTutorial[4].setBounds(961, 94, 30, 25);
		pavimenti[3].setBounds(987, 285, 362, 20);
		collTutorial[5].setBounds(1347, 196, 94, 217);
		collTutorial[6].setBounds(1471, 163, 99, 20);
		collTutorial[7].setBounds(1471, 99, 35, 20);
		collTutorial[8].setBounds(1535, 100, 35, 20);
		collTutorial[9].setBounds(1598, 227, 96, 20);
		collTutorial[10].setBounds(1729, 196, 94, 20);
		collTutorial[11].setBounds(1728, 100, 35, 20);
		collTutorial[12].setBounds(1788, 100, 35, 20);
		collTutorial[13].setBounds(1857, 259, 94, 20);
		pavimenti[4].setBounds(1953, 285, 159, 122);
		collTutorial[14].setBounds(2110, 196, 35, 20);
		collTutorial[15].setBounds(2173, 196, 35, 20);
		pavimenti[5].setBounds(2207, 285, 159, 122);
		pavimenti[6].setBounds(2464, 285, 127, 122);
		collTutorial[16].setBounds(2589, 348, 35, 37);
		collTutorial[17].setBounds(2601, 383, 125, 20);
		collTutorial[18].setBounds(2658, 311, 30, 37);
		collTutorial[19].setBounds(2719, 354, 159, 31);
		pavimenti[7].setBounds(2623, 285, 546, 25);
		collTutorial[20].setBounds(2883, 383, 222, 17);
		collTutorial[21].setBounds(2913, 316, 30, 32);
		collTutorial[22].setBounds(2977, 314, 30, 34);
		collTutorial[23].setBounds(3040, 314, 30, 34);
		collTutorial[24].setBounds(3104, 353, 127, 31);
		collTutorial[25].setBounds(3232, 317, 45, 31);
		pavimenti[8].setBounds(3264, 285, 736, 25);
		
		bloccoTutorial[0].setBounds(928, 94, 30, 31);
		bloccoTutorial[1].setBounds(1503, 94, 35, 31);
		bloccoTutorial[2].setBounds(1632, 158, 35, 31);
		bloccoTutorial[3].setBounds(1664, 158, 30, 31);
		bloccoTutorial[4].setBounds(1761, 94, 30, 31);
		bloccoTutorial[5].setBounds(2145, 192, 30, 31);
		bloccoTutorial[6].setBounds(2946, 323, 30, 25);
		bloccoTutorial[7].setBounds(3010, 316, 30, 32);
		
		morteTutorial[0].setBounds(1438, 307, 513, 20);
		morteTutorial[1].setBounds(2110, 307, 98, 17);
		morteTutorial[2].setBounds(2367, 307, 99, 17);
		
		vittTutorial.setBounds(3777, 125, 50, 161);
	}
	
	public static boolean getANo() {
		return aNo;
	}
	
	public static boolean getDNo() {
		return dNo;
	}
	
	public static boolean getWNo() {
		return wNo;
	}
	
	public static void setCollisioniTutorial(int x, int y) {
		for(short i=0;i<26;i++) collTutorial[i].setLocation((int) collTutorial[i].getX()+x, (int) collTutorial[i].getY()+y);
		for(short i=0;i<8;i++) bloccoTutorial[i].setLocation((int) bloccoTutorial[i].getX()+x, (int) bloccoTutorial[i].getY()+y);
		for(short i=0;i<9;i++) pavimenti[i].setLocation((int) pavimenti[i].getX()+x, (int) pavimenti[i].getY()+y);
		for(short i=0;i<3;i++) morteTutorial[i].setLocation((int) morteTutorial[i].getX()+x, (int) morteTutorial[i].getY()+y);
		vittTutorial.setLocation((int) vittTutorial.getX()+x, (int) vittTutorial.getY()+y);
	}
	
	public static void verificaCollisioneTutorial(Rectangle mario, char comando) { //non ho scritto nessun algoritmo speciale perché fare tutte le verifiche non danno poi così tanti problemi al pc
		
		boolean trovato = false;
		aNo = false;
		dNo = false;
		wNo = false;
		
		for(short i=0;i<26;i++) {
			if(collTutorial[i].intersects(mario)) {
				trovato = true;
				break;
			}
		}
		if(!trovato)
			for(short i=0;i<8;i++) {
				if(bloccoTutorial[i].intersects(mario)) {
					trovato = true;
					break;
				}
			}
		if(!trovato) {
			for(short i=0;i<3;i++) {
				if(morteTutorial[i].intersects(mario)) {
					trovato = true;
					break;
				}
			}
		}
		if(!trovato) {
			if(vittTutorial.intersects(mario)) {
				trovato = true;
			}
		}
		
		switch(comando) {
		case 'a': aNo = trovato;
		break;
		
		case 'd': dNo = trovato;
		break;
		
		case 'w': wNo = trovato;
		break;
		}
	}
	
	public static void attivaControlloGravTutorial() {
		if(Mario.getMarioRt().getY()<413) Tempo.controlloGravit();
	}
	
	public static boolean verificaGravitaTutorial(Rectangle mario) {
		
		boolean trovato = false;
		
		if(Mario.getMarioRt().getY()>=413) trovato = true;
		else {
		
			for(short i=0;i<26;i++) {
				if(collTutorial[i].intersects(mario)) {
					trovato = true;
					break;
				}
			}
			if(!trovato)
				for(short i=0;i<8;i++) {
					if(bloccoTutorial[i].intersects(mario)) {
						trovato = true;
						break;
					}
				}
			if(!trovato) {
				for(short i=0;i<3;i++) {
					if(morteTutorial[i].intersects(mario)) {
						trovato = true;
						break;
					}
				}
			}
			if(!trovato) {
				for(short i=0;i<9;i++) {
					if(pavimenti[i].intersects(mario)) {
						trovato = true;
						break;
					}
				}
			}
			if(!trovato) {
				if(vittTutorial.intersects(mario)) {
					trovato = true;
				}
			}
			
			if(!trovato && Mario.getMarioRt().getY()<413) {
				BaseFrame.setMario(BaseFrame.getXMario(), (int) Mario.getMarioRt().getY()+1);
				System.out.println("Mario: "+BaseFrame.getYMario());
				Mario.setMarioRt((int) Mario.getMarioRt().getX(), (int) Mario.getMarioRt().getY()+1);
				System.out.println("MarioRt: "+Mario.getMarioRt().getY());
				System.out.println();
			} else {
				BaseFrame.setMario(BaseFrame.getXMario(), (int) Mario.getMarioRt().getY()-1);
				Mario.setMarioRt((int) Mario.getMarioRt().getX(), (int) Mario.getMarioRt().getY()-1);
			}
		}
		
		return trovato;
	}
}
