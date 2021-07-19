package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import controller.EventoTeclado;
import model.Gato;
import model.Malha;
import model.Ponto;
import model.Scoreboard;
import model.Som;
import model.Temporizador;

@SuppressWarnings("serial")
public abstract class Fase extends View{
	
	private boolean ultimaFase;
	
	Malha malha;
	Gato gato;
	
	EventoTeclado teclado;
	Temporizador temporizador;
	
	BufferedImage gamePanel;
	BufferedImage matriz;
	Scoreboard scoreboard;
	
	public Fase() {
		super();
		gamePanel = new BufferedImage(View.WIDTH, View.HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
		ultimaFase = false;
		
		setLayout(null);
	}
	
	public boolean isUltimaFase() {
		return ultimaFase;
	}
	
	public void setUltimaFase(boolean ultimaFase) {
		this.ultimaFase = ultimaFase;
	}

	public Malha getMalha() {
		return malha;
	}
	public void setMalha(Malha malha) {
		this.malha = malha;
	}
	public Gato getGato() {
		return gato;
	}
	public void setGato(Gato gato) {
		this.gato = gato;
	}
	
	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}
	
	public Temporizador getTemporizador() {
		return temporizador;
	}

	public void setTemporizador(Temporizador temporizador) {
		this.temporizador = temporizador;
	}

	public void paint(Graphics g) {
		gamePanel.getGraphics().drawImage(background.getImage(), 0, 0, null);
		gamePanel.getGraphics().drawImage(malha.getFillMalha().getImage(),malha.getxMalha(), malha.getyMalha(), null);
		
		for (Ponto[] vetorAtual: gato.getMatriz()) {
			for (Ponto pontoAtual: vetorAtual) {
				if (pontoAtual.isOcupado()) {
					malha.getMatrizIMG().getGraphics().drawImage(gato.getSpriteCorpo().getImage(), pontoAtual.x, pontoAtual.y, null);
					if (pontoAtual.isBloqueado()) {
						malha.getMatrizIMG().getGraphics().drawImage(pontoAtual.getParede().getImage(), pontoAtual.x, pontoAtual.y, null);
					}
				}
			}
		}
		
		gamePanel.getGraphics().drawImage(scoreboard.getEstrelas()[0].getImage(),14, 8, null);
		gamePanel.getGraphics().drawImage(scoreboard.getEstrelas()[1].getImage(),54, 8, null);
		gamePanel.getGraphics().drawImage(scoreboard.getEstrelas()[2].getImage(),94, 8, null);
		
		malha.getMatrizIMG().getGraphics().drawImage(gato.getSpriteGato().getImage(), gato.getPosX(), 
				gato.getPosY(), this);
		
		gamePanel.getGraphics().drawImage(malha.getMatrizIMG(), malha.getxMalha(), malha.getyMalha(), null);

		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(gamePanel, 0, 0, null);
	}
	
	public abstract void criarProximaFase();
	public abstract void recriarFase();
	
	public void voltarMenu() {
		dispose();
		new MenuView();
	}
	
}
