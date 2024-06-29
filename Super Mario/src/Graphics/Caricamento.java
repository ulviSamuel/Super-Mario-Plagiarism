package Graphics;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bean.Tempo;

public class Caricamento { //classe che gestisce il caricamento
	
	private static JPanel ld = new JPanel(); 

	public Caricamento() {
		
		ld.setLayout(null);
		ld.setBounds(0, 0, 686, 413);
		ld.setBackground(Color.BLACK);
		
		java.net.URL url = BaseFrame.class.getResource("/gif/mario-run.gif");
		JLabel caricamento = new JLabel("");
		caricamento.setIcon(new ImageIcon("gif\\mario-run.gif"));
		caricamento.setBounds(620, 340, 60, 59);
		ld.add(caricamento);
		
		BaseFrame.addPanel(ld);
		BaseFrame.visiblePanel(ld);
		
		Tempo.timerDelCaricamento();
	}
	
	public static void caricamentoAdder() {
		BaseFrame.visiblePanel(ld);
		Tempo.timerDelCaricamentoLv();
	}
	
	public static void caricamentoRemover() {
		BaseFrame.notVisiblePanel(ld);
	}
	
}
