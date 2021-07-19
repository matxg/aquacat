package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.ControllerMenu;

public class MenuView extends View{
	
	ImageIcon logo, start, exit;
	
	JLabel labelLogo;
	
	JButton buttonStart;
	JButton buttonExit;
	
	ControllerMenu controlador;

	public MenuView() {
		super();
		logo = new ImageIcon(getClass().getClassLoader().getResource("img/aquacat.png"));
		start = new ImageIcon(getClass().getClassLoader().getResource("img/start.png"));
		exit = new ImageIcon(getClass().getClassLoader().getResource("img/exit.png"));
		
		labelLogo = new JLabel(logo);
		
		buttonStart = new JButton(start);
		buttonExit = new JButton(exit);
		
		buttonStart.setBorder(null);
		buttonStart.setBackground(new Color(254,185,143));
		
		buttonExit.setBorder(null);
		buttonExit.setBackground(new Color(254,185,143));
		
		add(labelLogo);
		add(labelFundo);
		add(buttonStart);
		add(buttonExit);
		
		controlador = new ControllerMenu(this);
		
		controlador.control();
		
		labelLogo.setBounds(76, 110, logo.getIconWidth(), logo.getIconHeight());
		buttonStart.setBounds(100, 345, start.getIconWidth(), start.getIconHeight());
		buttonExit.setBounds(100, 410, exit.getIconWidth(), exit.getIconHeight());
		labelFundo.setBounds(0, 0, WIDTH, HEIGHT);
		
	}

	public JButton getButtonStart() {
		return buttonStart;
	}

	public void setButtonStart(JButton buttonStart) {
		this.buttonStart = buttonStart;
	}

	public JButton getButtonExit() {
		return buttonExit;
	}

	public void setButtonExit(JButton buttonExit) {
		this.buttonExit = buttonExit;
	}

}
