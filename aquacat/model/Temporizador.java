package model;

import view.Fase;
import view.Transicao;

public class Temporizador extends Thread{
	
	Fase fase;
	Scoreboard scoreboard;
	
	public Temporizador(Fase fase) {
		this.fase = fase;
		this.scoreboard = fase.getScoreboard();
	}
	
	public void run() {
		synchronized (this) {
			while (scoreboard.getScore() >= 0) {
				try {
					scoreboard.atualizarEstrelas(scoreboard.getScore());
					scoreboard.setScore(scoreboard.getScore()-1);
					sleep((scoreboard.delay/4)*1000);
					fase.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				sleep(1000);
				new Transicao(fase,	Transicao.RETRY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}