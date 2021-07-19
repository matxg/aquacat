package model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Gato {
	
	Som som;
	
	ArrayList<Ponto> vizinhos;
	
	ImageIcon spriteGato;
	ImageIcon spriteCorpo;
	Ponto ponto;
	Malha malha;
	
	int posX;
	int posY;
	
	int linha;
	int coluna;
	Ponto[][] matriz;
	
	public Gato(Malha malha, Ponto ponto) {
		this.ponto = ponto;
		this.malha = malha;
		spriteGato = new ImageIcon(getClass().getClassLoader().getResource("img/Gato.png"));
		spriteCorpo = new ImageIcon(getClass().getClassLoader().getResource("img/corpo.png"));
		
		this.som = new Som();
		
		this.posX = this.ponto.x;
		this.posY = this.ponto.y;
		
		this.linha = this.malha.buscarLinha(this.malha.matriz, this.ponto) - 1;
		this.coluna = this.malha.buscarColuna(this.malha.matriz, this.ponto) - 1;
		this.matriz = this.malha.getMatriz();
	}
	
	public boolean moverBaixo() {
		posX = ponto.x;
		posY = ponto.y;
		if (limiteBaixo()) {som.bloqueado();return false;}
		for (Ponto[] vetorAtual: matriz) {
			if (vetorAtual[coluna].isOcupado()) {som.colidiu();return false;}
			Ponto anterior = ponto;
			ponto = vetorAtual[coluna];
			if (malha.buscarLinha(matriz, anterior) != malha.buscarLinha(matriz, ponto)) {
				anterior.setOcupado(true);}
			linha = malha.buscarLinha(matriz, ponto)-1;
		}
		som.colidiu();
		return true;
	}
	public boolean moverCima() {
		posX = ponto.x;
		posY = ponto.y;
		if (limiteCima()) {som.bloqueado();return false;}
		ArrayList<Ponto> colunaAtual = new ArrayList<Ponto>();
		for (Ponto[] vetorAtual: matriz) {
			colunaAtual.add(0, vetorAtual[coluna]);
		}
		
		for (Ponto pontoAtual: colunaAtual) {
			if (pontoAtual.isOcupado()) {som.colidiu();return false;}
			Ponto anterior = ponto;
			ponto = pontoAtual;
			if (malha.buscarLinha(matriz, anterior) != malha.buscarLinha(matriz, ponto)) {
				anterior.setOcupado(true);}
			linha = malha.buscarLinha(matriz, ponto)-1;
		}
		som.colidiu();
		return true;
	}
	
	public boolean moverEsquerda() {
		posX = ponto.x;
		posY = ponto.y;
		if (limiteEsquerdo()) {som.bloqueado();return false;}
		ArrayList<Ponto> linhaAtual = new ArrayList<Ponto>();
		for (Ponto e:matriz[linha]) {
			linhaAtual.add(0,e);
		}
		
		for (Ponto pontoAtual:linhaAtual) {
			if (pontoAtual.isOcupado()) {som.colidiu();return false;}
			Ponto anterior = ponto;
			ponto = pontoAtual;
			if (malha.buscarColuna(matriz, anterior) != malha.buscarColuna(matriz, ponto)) {
				anterior.setOcupado(true);}
			coluna = malha.buscarColuna(matriz, ponto)-1;
		}
		som.colidiu();
		return true;
	}
	public boolean moverDireita() {
		posX = ponto.x;
		posY = ponto.y;
		if (limiteDireito()) {som.bloqueado();return false;}
		for (Ponto pontoAtual:matriz[linha]) {
			if (pontoAtual.isOcupado()) {som.colidiu();return false;}
			Ponto anterior = ponto;
			linha = malha.buscarLinha(matriz, ponto)-1;
			coluna = malha.buscarColuna(matriz, pontoAtual)-1;
			setPonto(linha, coluna);
			if (malha.buscarColuna(matriz, anterior) != malha.buscarColuna(matriz, ponto)) {
				anterior.setOcupado(true);}
		}
		som.colidiu();
		return true;
	}
	
	public boolean limiteDireito(){if (coluna == malha.colunas-1) {return true;}return false;}
	public boolean limiteEsquerdo(){if (coluna == 0) {return true;}return false;}
	public boolean limiteCima(){if (linha == 0) {return true;}return false;}
	public boolean limiteBaixo(){ if (linha == malha.linhas-1) {return true;} return false;}
	
	public ArrayList<Ponto> getVizinhos() {
		vizinhos = new ArrayList<Ponto>();
		
		if (!(limiteDireito()) && !(matriz[linha][coluna+1].isOcupado())) {
			vizinhos.add(matriz[linha][coluna+1]);
		}
		
		if (!(limiteEsquerdo()) && !(matriz[linha][coluna-1].isOcupado())) {
			vizinhos.add(matriz[linha][coluna-1]);
		}
		
		if (!(limiteCima()) && !(matriz[linha-1][coluna].isOcupado())) {
			vizinhos.add(matriz[linha-1][coluna]);
		}
		
		if (!(limiteBaixo()) && !(matriz[linha+1][coluna].isOcupado())) {
			vizinhos.add(matriz[linha+1][coluna]);
		}
		
		return vizinhos;
	}

	public ImageIcon getSpriteGato() {
		return spriteGato;
	}
	public void setSpriteGato(ImageIcon spriteGato) {
		this.spriteGato = spriteGato;
	}

	public ImageIcon getSpriteCorpo() {
		return spriteCorpo;
	}
	public void setSpriteCorpo(ImageIcon spriteCorpo) {
		this.spriteCorpo = spriteCorpo;
	}

	public Ponto getPonto() {
		return matriz[linha][coluna];
	}
	public void setPonto(int linha, int coluna) {
		this.ponto = matriz[linha][coluna];
	}

	public Malha getMalha() {
		return malha;
	}
	public void setMalha(Malha malha) {
		this.malha = malha;
	}

	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Ponto[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(Ponto[][] matriz) {
		this.matriz = matriz;
	}
}
