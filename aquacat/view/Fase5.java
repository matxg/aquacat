package view;

import controller.EventoTeclado;
import model.Gato;
import model.Malha;
import model.Scoreboard;
import model.Temporizador;

public class Fase5 extends Fase{
	
	public Fase5() {

		malha = new Malha(3, 3);
		malha.bloquearPonto(1, 2);
		malha.bloquearPonto(1, 1);
		gato = new Gato(malha, malha.getPontos().get(2));
		
		addKeyListener(new EventoTeclado(this));
		scoreboard = new Scoreboard(1, this);
		temporizador = new Temporizador(this);
		temporizador.start();
		repaint();
	}

	@Override
	public void criarProximaFase() {
		dispose();
		new Fase6();
	}

	@Override
	public void recriarFase() {
		dispose();
		new Fase5();
	}
	
	

}
