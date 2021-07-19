package model;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Ponto extends Point{
	
	ImageIcon parede;
	
	private boolean ocupado;
	private boolean bloqueado;
	private static int largura = 64;
	private static int altura = 64;

	public Ponto(int x, int y) {
		super(x, y);
		ocupado = false;
		bloqueado = false;
		
		parede = new ImageIcon(getClass().getClassLoader().getResource("img/parede.png"));
	}

	public ImageIcon getParede() {
		return parede;
	}

	public void setParede(ImageIcon parede) {
		this.parede = parede;
	}

	public void bloquear() {
		bloqueado = true;
		ocupado = true;
	}
	
	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupada) {
		this.ocupado = ocupada;
	}

	public static int getLarguraCelula() {
		return largura;
	}

	public static void setLarguraCelula(int larguraCelula) {
		Ponto.largura = larguraCelula;
	}

	public static int getAlturaCelula() {
		return altura;
	}

	public static void setAlturaCelula(int alturaCelula) {
		Ponto.altura = alturaCelula;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")" ;
	}
}
