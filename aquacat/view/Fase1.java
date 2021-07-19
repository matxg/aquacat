package view;

import java.awt.Color;

import controller.EventoTeclado;
import model.Gato;
import model.Malha;
import model.Scoreboard;
import model.Temporizador;

public class Fase1 extends Fase{
	
	public Fase1() {
		super();
		
		malha = new Malha(2, 2);
		malha.bloquearPonto(1, 0);
		malha.bloquearPonto(1, 1);
		gato = new Gato(malha, malha.getPontos().get(0));
		addKeyListener(new EventoTeclado(this));
		scoreboard = new Scoreboard(1, this);
		temporizador = new Temporizador(this);
		temporizador.start();
		repaint();
	}
	public void criarProximaFase() {
		dispose();
		new Fase2();
	}
	public void recriarFase() {
		dispose();
		new Fase1();
	}
}
