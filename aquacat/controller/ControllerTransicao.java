package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Transicao;

public class ControllerTransicao implements ActionListener{
	
	Transicao telaTransicao;

	public ControllerTransicao(Transicao telaTransicao) {
		super();
		this.telaTransicao = telaTransicao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(telaTransicao.getButtonRetry())){
			telaTransicao.getFaseAnterior().recriarFase();
			telaTransicao.dispose();
		}
		
		if (e.getSource().equals(telaTransicao.getButtonNext())) {
			telaTransicao.getFaseAnterior().criarProximaFase();
			telaTransicao.dispose();
		}
		
		if (e.getSource().equals(telaTransicao.getButtonHome())) {
			telaTransicao.getFaseAnterior().voltarMenu();
			telaTransicao.dispose();
		}
		
		if (e.getSource().equals(telaTransicao.getButtonExit())) {
			System.exit(0);
		}
		
	}

}
