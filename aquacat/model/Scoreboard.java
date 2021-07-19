package model;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import view.Fase;
import view.Transicao;

@SuppressWarnings("serial")
public class Scoreboard{

	public static final int FACIL = 3, MEDIO = 2, DIFICIL = 1;
	private int dificuldade;
	public int delay;

	int score;
	ImageIcon estrela, estrelaApagada;
	
	ImageIcon[] estrelas;
	
	BufferedImage scorePanel;
	
	Transicao telaTransicao;
	Fase fase;
	
	public Scoreboard(int dificuldade, Fase fase) {
		super();
		
		this.fase = fase;
		estrela = new ImageIcon(getClass().getClassLoader().getResource("img/star.png"));
		estrelaApagada = new ImageIcon(getClass().getClassLoader().getResource("img/staroff.png"));
		
		this.score = 3;
		
		switch (dificuldade) {
		case FACIL: {
			this.delay = 10*FACIL;
			break;
		}
		case MEDIO: {
			this.delay = 10*MEDIO;
			break;
		}
		case DIFICIL: {
			this.delay = 10*DIFICIL;
			break;
		}
		default:
			this.delay = 10*FACIL;
			break;
		}
		
		estrelas = new ImageIcon[3];
		estrelas[0] = estrela;
		estrelas[1] = estrela;
		estrelas[2] = estrela;
	}
	
	
	public void atualizarEstrelas(int score) {
		if (score == 3) {
			estrelas[0] = estrela;
			estrelas[1] = estrela;
			estrelas[2] = estrela;
		}
		else if (score == 2) {
			estrelas[0] = estrela;
			estrelas[1] = estrela;
			estrelas[2] = estrelaApagada;
		}
		else if (score == 1) {
			estrelas[0] = estrela;
			estrelas[1] = estrelaApagada;
			estrelas[2] = estrelaApagada;
		}
		else if (score == 0) {
			estrelas[0] = estrelaApagada;
			estrelas[1] = estrelaApagada;
			estrelas[2] = estrelaApagada;
		}
	}

	public void setScorePanel(BufferedImage scorePanel) {
		this.scorePanel = scorePanel;
	}

	public ImageIcon getEstrela() {
		return estrela;
	}

	public void setEstrela(ImageIcon estrela) {
		this.estrela = estrela;
	}

	public ImageIcon getEstrelaApagada() {
		return estrelaApagada;
	}

	public void setEstrelaApagada(ImageIcon estrelaApagada) {
		this.estrelaApagada = estrelaApagada;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Transicao getTelaTransicao() {
		return telaTransicao;
	}

	public void setTelaTransicao(Transicao telaTransicao) {
		this.telaTransicao = telaTransicao;
	}
	
	public int getDificuldade() {
		return dificuldade;
	}
	
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public ImageIcon[] getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(ImageIcon[] estrelas) {
		this.estrelas = estrelas;
	}

}
