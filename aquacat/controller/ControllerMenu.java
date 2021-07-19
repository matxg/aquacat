package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Fase1;
import view.MenuView;

public class ControllerMenu implements ActionListener{
	
	MenuView menu;
	
	public ControllerMenu(MenuView menu) {
		super();
		this.menu = menu;
	}

	public void control() {
		menu.getButtonStart().addActionListener(this);
		menu.getButtonExit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(menu.getButtonStart())) {
			menu.dispose();
			new Fase1();
		}
		
		if (e.getSource().equals(menu.getButtonExit())) {
			System.exit(0);
		}
	}
	
	

}
