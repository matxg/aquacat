package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import view.View;

public class Malha {
	
	ImageIcon fillMalha;
	BufferedImage matrizIMG;
	
	int xMalha;
	int yMalha;
	
	int linhas;
	public BufferedImage getMatrizIMG() {
		return matrizIMG;
	}


	public void setMatrizIMG(BufferedImage matrizIMG) {
		this.matrizIMG = matrizIMG;
	}

	int colunas;
	
	int larguraMalha;
	int alturaMalha;
	
	ArrayList<Ponto> pontos;
	Ponto[][] matriz;
	
	public Malha(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		
		this.larguraMalha = this.colunas*Ponto.getLarguraCelula();
		this.alturaMalha = this.linhas*Ponto.getAlturaCelula();
		
		criarMatrizPanel(larguraMalha, alturaMalha);
		
		this.xMalha = buscarXMalha(this.colunas, Ponto.getLarguraCelula(), View.WIDTH);
		this.yMalha = buscarYMalha(this.linhas, Ponto.getAlturaCelula(), View.HEIGHT);
		
		fillMalha = new ImageIcon(getClass().getClassLoader().getResource("img/fill.png"));
		fillMalha.setImage(fillMalha.getImage().getScaledInstance(Ponto.getLarguraCelula()*this.linhas, 
				Ponto.getLarguraCelula()*this.colunas, 100));
		
		
		pontos = new ArrayList<Ponto>();
		
		int xAtual = 0;
		for (int i = 0; i < this.linhas; i++) {
			int yAtual = 0;
			for (int j = 0; j< this.colunas; j++) {
				pontos.add(new Ponto(xAtual, yAtual));
				yAtual += Ponto.getLarguraCelula();
			}
			xAtual += Ponto.getAlturaCelula();
			
		}
		matriz = new Ponto[this.linhas][this.colunas];
		criarMatriz();
	}
	

	public void criarMatriz() {
		int index = 0;
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = pontos.get(index);
				index++;
			}
		}
	}
	
	public void criarMatrizPanel(int larguraMatriz, int alturaMatriz) {
		matrizIMG = new BufferedImage(larguraMatriz, alturaMatriz, BufferedImage.TYPE_4BYTE_ABGR);
	}
	
	public void bloquearPonto(int linha, int coluna) {
		matriz[linha][coluna].bloquear();
	}
	
	public int buscarLinha(Ponto[][] matriz, Ponto ponto) {
		int linha = 0;
		for (Ponto[] vetorAtual: matriz) {
			if (vetorAtual[0].x <= ponto.x) {linha++;}
			}return linha;
	}
	
	public int buscarColuna(Ponto[][] matriz, Ponto ponto) {
		int coluna = 0;
		for (Ponto pontoAtual: matriz[0]) {
			if (pontoAtual.y <= ponto.y) {coluna++;}
			}return coluna;
	}

	public int buscarXMalha(int colunas, int larguraPonto, int larguraTela) {
		return (View.WIDTH/2) - ((colunas*larguraPonto)/2);
	}
	public int buscarYMalha(int linhas, int alturaPonto, int alturaTela) {
		return (View.HEIGHT/2)-((linhas*alturaPonto)/2);
	}

	public int getxMalha() {
		return xMalha;
	}

	public void setxMalha(int xMalha) {
		this.xMalha = xMalha;
	}

	public int getyMalha() {
		return yMalha;
	}

	public void setyMalha(int yMalha) {
		this.yMalha = yMalha;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public int getLarguraMalha() {
		return larguraMalha;
	}

	public void setLarguraMalha(int larguraMalha) {
		this.larguraMalha = larguraMalha;
	}

	public int getAlturaMalha() {
		return alturaMalha;
	}

	public void setAlturaMalha(int alturaMalha) {
		this.alturaMalha = alturaMalha;
	}

	public ArrayList<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}

	public Ponto[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Ponto[][] matriz) {
		this.matriz = matriz;
	}

	public ImageIcon getFillMalha() {
		return fillMalha;
	}
	
	public void setFillMalha(ImageIcon fillMalha) {
		this.fillMalha = fillMalha;
	}
	
}
