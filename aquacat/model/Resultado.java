package model;

import view.Fase;

public class Resultado {
	
	public static boolean vitoria(Fase fase) {
		boolean isVenceu = false;
		if (fase.getGato().getVizinhos().isEmpty()) {
			fase.getTemporizador().stop();
			fase.getGato().ponto.setOcupado(true);
			isVenceu = true;
			for (Ponto[] vetorAtual:fase.getGato().getMatriz()) {
				for (Ponto pontoAtual:vetorAtual) {if (!(pontoAtual.isOcupado())) {isVenceu = false;}}}
			}return isVenceu;}

}
