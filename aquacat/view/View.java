package view;

import controller.ExitController;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class View extends JFrame{
    
    public static final int WIDTH = 400, HEIGHT = 562;
    
    public ImageIcon background;
    JLabel labelFundo;
    
    ImageIcon icone;
    
    public View(){
    	super("AquaCat");
        icone = new ImageIcon(getClass().getClassLoader().getResource("img/Gato.png"));
        setIconImage(icone.getImage().getScaledInstance(16, 16, 100));
        
//        fundo = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        
        background = new ImageIcon(getClass().getClassLoader().getResource("img/background.png"));
        
        setLayout(null);
        
        labelFundo = new JLabel(background);
        
        addKeyListener(new ExitController());
        
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    
}