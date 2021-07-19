package model;

import view.Fase;
import view.Transicao;

public class Movimento extends Thread{
	
	Fase fase;
	Gato gato;
	
	public Movimento(Fase fase) {
		super();
		this.fase = fase;
		this.gato = fase.getGato();
	}
	
	public void run() {
		synchronized (fase) {
		while (gato.getPosX() != gato.getPonto().x
				||
				gato.getPosY() != gato.getPonto().y) {
			try {
				moverX();
				moverY();
				sleep(0,1);
				fase.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
				}	
			
			}
		
		if (gato.getVizinhos().isEmpty()) {
			try {sleep(1000);} 
			catch (InterruptedException e1) {e1.printStackTrace();}
		}
		
		if (Resultado.vitoria(fase)) {
			if (fase.isUltimaFase()) {
				new Transicao(fase, 2);
			} else new Transicao(fase, 0);
		} 
		else if (gato.getVizinhos().isEmpty()) {
			new Transicao(fase, 1);
		}
		}
	}
	
	public void moverX() {
		if (gato.getPosX() < gato.getPonto().x) {
			gato.setPosX(gato.getPosX() + 1);
		}
		else if (gato.getPosX() > gato.getPonto().x) {
			gato.setPosX(gato.getPosX() - 1);
		}
	}
	public void moverY() {
		if (gato.getPosY() < gato.getPonto().y) {
			gato.setPosY(gato.getPosY() + 1);
		}
		else if (gato.getPosY() > gato.getPonto().y) {
			gato.setPosY(gato.getPosY() - 1);
		}
	}
	
}
