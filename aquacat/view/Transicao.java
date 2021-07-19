package view;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import controller.ControllerTransicao;
import controller.ExitController;

public class Transicao extends JFrame{
	
	public static final int LEVELUP = 0, RETRY = 1, HOME = 2;
	
	Fase faseAnterior;
	
	ImageIcon retrySprite, nextSprite, homeSprite, exitSprite;
	
	JButton buttonRetry, buttonNext, buttonHome, buttonExit;

	public Transicao(Fase faseAnterior, int modo){
		super();
		this.faseAnterior = faseAnterior;
		
		retrySprite = new ImageIcon(getClass().getClassLoader().getResource("img/retry.png"));
		nextSprite = new ImageIcon(getClass().getClassLoader().getResource("img/next.png"));
		homeSprite = new ImageIcon(getClass().getClassLoader().getResource("img/home.png"));
		exitSprite = new ImageIcon(getClass().getClassLoader().getResource("img/exit.png"));
		
		setLayout(null);
		
		
		buttonHome = new JButton(homeSprite);
		buttonHome.setBorder(null);
		buttonHome.setBackground(new Color(0,168,236));
		
		buttonRetry = new JButton(retrySprite);
		buttonRetry.setBorder(null);
		buttonRetry.setBackground(new Color(0,168,236));
		
		buttonNext = new JButton(nextSprite);
		buttonNext.setBorder(null);
		buttonNext.setBackground(new Color(0,168,236));
		
		buttonExit = new JButton(exitSprite);
		buttonExit.setBorder(null);
		buttonExit.setBackground(new Color(0,168,236));
		
		buttonRetry.addActionListener(new ControllerTransicao(this));
		buttonNext.addActionListener(new ControllerTransicao(this));
		buttonHome.addActionListener(new ControllerTransicao(this));

		switch (modo) {
		case LEVELUP: {
			add(buttonRetry);
			add(buttonNext);
			buttonRetry.setBounds(47, 40, retrySprite.getIconWidth(), retrySprite.getIconHeight());
			buttonNext.setBounds(180, 39, nextSprite.getIconWidth(), nextSprite.getIconHeight());
			break;
		}
		
		case RETRY:{
			add(buttonHome);
			add(buttonRetry);
			buttonHome.setBounds(47, 40, homeSprite.getIconWidth(), homeSprite.getIconHeight());
			buttonRetry.setBounds(180, 39, retrySprite.getIconWidth(), retrySprite.getIconHeight());
			break;
		}
		
		case HOME:{
			add(buttonRetry);
			add(buttonHome);
			buttonHome.setBounds(180, 40, homeSprite.getIconWidth(), homeSprite.getIconHeight());
			buttonRetry.setBounds(47, 40, retrySprite.getIconWidth(), retrySprite.getIconHeight());
			break;
		}
		default:
			break;
		}
		
		add(buttonExit); buttonExit.setBounds(56, 113, exitSprite.getIconWidth(), exitSprite.getIconHeight());
		buttonExit.addActionListener(new ControllerTransicao(this));
		
		getContentPane().setBackground(new Color(0,168,236));

		setType(Type.UTILITY);
		setSize(300,170);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
	}

	public Fase getFaseAnterior() {
		return faseAnterior;
	}

	public void setFaseAnterior(Fase faseAnterior) {
		this.faseAnterior = faseAnterior;
	}

	public JButton getButtonRetry() {
		return buttonRetry;
	}

	public void setButtonRetry(JButton buttonRetry) {
		this.buttonRetry = buttonRetry;
	}

	public JButton getButtonNext() {
		return buttonNext;
	}

	public void setButtonNext(JButton buttonNext) {
		this.buttonNext = buttonNext;
	}

	public JButton getButtonHome() {
		return buttonHome;
	}

	public void setButtonHome(JButton buttonHome) {
		this.buttonHome = buttonHome;
	}

	public JButton getButtonExit() {
		return buttonExit;
	}

	public void setButtonExit(JButton buttonExit) {
		this.buttonExit = buttonExit;
	}
	
	
}
