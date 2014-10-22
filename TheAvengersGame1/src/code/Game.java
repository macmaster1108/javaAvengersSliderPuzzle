package code;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
   
    public Game() {

    	//JFRAME SETUP
		JFrame startframe = new JFrame("The Avengers ver 0.1");
		startframe.setBackground(java.awt.Color.BLACK);
		
		//LOGO PREP, ADD LABEL TO PANEL, AND ADD PANEL TO STARTFRAME
		BufferedImage logopre = HelpfulImageMethods.loadImage("images/StartupLogononame.png");
		ImageIcon iconlogopost = new ImageIcon(logopre);
		JPanel logopanel = new JPanel();
		JLabel logolabel = new JLabel(iconlogopost);
		logopanel.add(logolabel);
		startframe.add(logopanel);
		
		//BUTTON PANEL MAKER
		JPanel buttonpanel = new JPanel();
		
		
		//BUTTON IMAGES PREP
		BufferedImage newgamepre = HelpfulImageMethods.loadImage("images/avengassemnewgame.png");
		ImageIcon newgamepost = new ImageIcon(newgamepre);
		BufferedImage quitpre = HelpfulImageMethods.loadImage("images/hulkquit.png");
		ImageIcon quitpost = new ImageIcon(quitpre);
		
		
		//NEW GAME BUTTON
		JButton newgamebutt = new JButton(newgamepost);
		newgamebutt.addMouseListener(new MouseListenerNG(startframe));
		newgamebutt.setMinimumSize(new Dimension(250,250));
		newgamebutt.setPreferredSize(new Dimension(250,250));
		newgamebutt.setMaximumSize(new Dimension(250,250));
		buttonpanel.add(newgamebutt);
		
		//QUIT BUTTON
		JButton quitbutt = new JButton(quitpost);
		quitbutt.addMouseListener(new MouseListenerQUIT());
		quitbutt.setMinimumSize(new Dimension(250,250));
		quitbutt.setPreferredSize(new Dimension(250,250));
		quitbutt.setMaximumSize(new Dimension(250,250));
		buttonpanel.add(quitbutt);
		
		//FRAME BASICS
		startframe.add(buttonpanel);
		startframe.setVisible(true);
		startframe.setResizable(false);
		Container p = startframe.getContentPane();
		startframe.getContentPane().setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		startframe.pack();
		startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//PLAYING BACKGROUND MUSIC
		new PlaySound("Sounds/AvengersThemeShort.wav");
	}
	
}
