package view;

import controller.EventoTeclado;
import model.Gato;
import model.Malha;
import model.Scoreboard;
import model.Temporizador;

public class Fase6 extends Fase{
	
	public Fase6() {

		malha = new Malha(3, 3);
		malha.bloquearPonto(2, 0);
		malha.bloquearPonto(2, 1);
		gato = new Gato(malha, malha.getPontos().get(8));
		
		setUltimaFase(true);
		
		addKeyListener(new EventoTeclado(this));
		scoreboard = new Scoreboard(1, this);
		temporizador = new Temporizador(this);
		temporizador.start();
		repaint();
	}

	@Override
	public void criarProximaFase() {
		dispose();
		new MenuView();
	}

	@Override
	public void recriarFase() {
		dispose();
		new Fase6();
	}
	
}
