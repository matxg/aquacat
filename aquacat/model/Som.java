package model;

import java.applet.Applet;
import java.applet.AudioClip;

@SuppressWarnings("deprecation")
public class Som {
	
	private AudioClip missClick, impact;

	public Som() {
		super();
		this.missClick = Applet.newAudioClip(this.getClass().getClassLoader().getResource("res/click.wav"));
		this.impact = Applet.newAudioClip(this.getClass().getClassLoader().getResource("res/panimpact.wav"));
	}
	
	public void colidiu() {
		new Thread(new Runnable() {@Override public void run() {impact.play();}}).start();
	}
		
	public void bloqueado() {
		new Thread(new Runnable() {@Override public void run() {missClick.play();}}).start();
	}
}
