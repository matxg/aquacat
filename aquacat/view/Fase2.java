package view;

import controller.EventoTeclado;
import model.Gato;
import model.Malha;
import model.Scoreboard;
import model.Temporizador;

public class Fase2 extends Fase{
	
	public Fase2() {
		super();
		
		malha = new Malha(2, 2);
		gato = new Gato(malha, malha.getPontos().get(0));
		addKeyListener(new EventoTeclado(this));
		scoreboard = new Scoreboard(1, this);
		temporizador = new Temporizador(this);
		temporizador.start();
		
		repaint();
	}

	@Override
	public void criarProximaFase() {
		dispose();
		new Fase3();
	}

	@Override
	public void recriarFase() {
		dispose();
		new Fase2();
	}
	
	

}
