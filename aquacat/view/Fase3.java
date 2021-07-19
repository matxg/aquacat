package view;

import controller.EventoTeclado;
import model.Gato;
import model.Malha;
import model.Scoreboard;
import model.Temporizador;

public class Fase3 extends Fase{
	
	public Fase3() {
		super();
		
		malha = new Malha(3, 3);
		gato = new Gato(malha, malha.getPontos().get(8));
		
		addKeyListener(new EventoTeclado(this));
		scoreboard = new Scoreboard(2, this);
		temporizador = new Temporizador(this);
		temporizador.start();
		repaint();
	}

	@Override
	public void criarProximaFase() {
		dispose();
		new Fase4();
	}

	@Override
	public void recriarFase() {
		dispose();
		new Fase3();
	}

}
