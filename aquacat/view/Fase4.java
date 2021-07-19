package view;

import controller.EventoTeclado;
import model.Gato;
import model.Malha;
import model.Scoreboard;
import model.Temporizador;

public class Fase4 extends Fase{
	
	public Fase4() {
		super();
		malha = new Malha(3, 3);
		malha.bloquearPonto(1, 1);
		gato = new Gato(malha, malha.getPontos().get(0));
		
		addKeyListener(new EventoTeclado(this));
		scoreboard = new Scoreboard(2, this);
		temporizador = new Temporizador(this);
		temporizador.start();
		repaint();
	}

	@Override
	public void criarProximaFase() {
		dispose();
		new Fase5();
	}

	@Override
	public void recriarFase() {
		dispose();
		new Fase4();
	}

}
