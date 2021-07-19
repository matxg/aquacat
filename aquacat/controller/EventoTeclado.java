package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Gato;
import model.Movimento;
import view.Fase;
import view.Transicao;

public class EventoTeclado extends KeyAdapter{
	
	Gato gato;
	Fase fase;
	
	
	public EventoTeclado(Fase fase) {
		this.fase = fase;
		this.gato = this.fase.getGato();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP
				||
			e.getKeyCode() == KeyEvent.VK_W) {
			gato.moverEsquerda();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN
				||
			e.getKeyCode() == KeyEvent.VK_S) {
			gato.moverDireita();
			}
			
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT
				||
			e.getKeyCode() == KeyEvent.VK_D) {
			gato.moverBaixo();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT
				||
			e.getKeyCode() == KeyEvent.VK_A) {
			gato.moverCima();
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_R) {
			new Transicao(fase, Transicao.RETRY);
		}
		
		new Movimento(fase).start();
		
	}

}
