//Written by Stephen Keller in CSE115 at University at Buffalo
//Some code used for image procccessing by Carl Alphonce and Sound Processing from internet
//All Images used for "Avengers" game from their respective owners

package code;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import code.HelpfulImageMethods;



public class FifteenPuzzle {
	private FifteenPuzzle fp;
	private JPanel _panel;
	private int _width;
	private int _height;
	private int clickNumber = 0;
	private JLabel label0;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel _blank;
	
	private int soundnumber = 0;
	//REFERENCES FOR BLANK X AND Y
	private int _curBlankX = 2;
	private int _curBlankY = 2;
	//# OF ROWS AND COLUMNS
	private int rows = 3;
	private int colum = 3;

	public FifteenPuzzle(String filePath, int layoutnumber) {


		//FRAME SETUP OF PUZZLE
		JFrame f = new JFrame();
		Container p = f.getContentPane();
		f.getContentPane().setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		f.setResizable(false);


		//CREATE A BUFFERED IMAGE OF WHOLE PICTURE AND GET ITS WIDTH X HEIGHT
		BufferedImage bi = HelpfulImageMethods.loadImage(filePath);
		int width = bi.getWidth()/3;
		int height = bi.getHeight()/3;
		_width = width;
		_height = height;


		//SPLIT THE BIG IMAGE UP INTO DESIRED AMOUNT OF SMALLER PICS
		BufferedImage[] bilist = new BufferedImage[8];
		java.util.List<BufferedImage> coll; 
		coll = new java.util.LinkedList<BufferedImage>();
		for(int a = 0; a<3; a++) {
			for(int b = 0; b<3; b++){
				BufferedImage bl1 = HelpfulImageMethods.createSubImage(bi, a*width, b*height,width, height);
				coll.add(bl1);
			}
		}

		//REMOVE THE LAST LITTLE PIC FOR BLANK SPACE
		coll.remove(8);


		//CREATE AN ITERATOR FOR THE COLLECTION OF LITTLE PICS AND ADD TO ARRAY OF BUFFERED IMAGES
		java.util.Iterator<BufferedImage> it = coll.iterator();

		for(int gob = 0; gob<8; gob++){
			BufferedImage im = it.next();
			bilist[gob] = im;
		}

		//SETUP PANEL FOR PIECES
		_panel = new JPanel();
		_panel.setLayout(null);
		_panel.setBackground(java.awt.Color.WHITE);
		_panel.setPreferredSize(new Dimension (3*width+2*rows+2,3*height+2*colum+2));
		p.add(_panel);

		//ADD THE LITTLE PICS INTO PANEL
		int spottyx = 0;
		int spottyy = 0;
		switch(layoutnumber){
		
		case 1:
			label6 = new JLabel(new ImageIcon(bilist[2]));
			label6.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label6);
			spottyx++;
			label0 = new JLabel(new ImageIcon(bilist[0]));
			label0.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label0);
			spottyx++;
			label1 = new JLabel(new ImageIcon(bilist[3]));
			label1.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label1);
			spottyx = 0;
			spottyy++;
			label5 = new JLabel(new ImageIcon(bilist[7]));
			label5.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label5);
			spottyx++;
			label3 = new JLabel(new ImageIcon(bilist[1]));
			label3.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label3);
			spottyx++;
			label2 = new JLabel(new ImageIcon(bilist[6]));
			label2.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label2);
			spottyx = 0;
			spottyy++;
			label4 = new JLabel(new ImageIcon(bilist[4]));
			label4.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label4);
			spottyx++;
			label7 = new JLabel(new ImageIcon(bilist[5]));
			label7.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label7);
			break;
		
		case 2:
			label2 = new JLabel(new ImageIcon(bilist[6]));
			label2.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label2);
			spottyx++;
			label6 = new JLabel(new ImageIcon(bilist[2]));
			label6.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label6);
			spottyx++;
			label0 = new JLabel(new ImageIcon(bilist[0]));
			label0.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label0);
			spottyx = 0;
			spottyy++;
			label3 = new JLabel(new ImageIcon(bilist[1]));
			label3.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label3);
			spottyx++;
			label4 = new JLabel(new ImageIcon(bilist[4]));
			label4.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label4);
			spottyx++;
			label7 = new JLabel(new ImageIcon(bilist[5]));
			label7.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label7);
			spottyx = 0;
			spottyy++;
			label5 = new JLabel(new ImageIcon(bilist[7]));
			label5.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label5);
			spottyx++;
			label1 = new JLabel(new ImageIcon(bilist[3]));
			label1.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label1);
			break;
		
		case 3:
			label7 = new JLabel(new ImageIcon(bilist[5]));
			label7.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label7);
			spottyx++;
			label6 = new JLabel(new ImageIcon(bilist[2]));
			label6.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label6);
			spottyx++;
			label1 = new JLabel(new ImageIcon(bilist[3]));
			label1.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label1);
			spottyx = 0;
			spottyy++;
			label3 = new JLabel(new ImageIcon(bilist[1]));
			label3.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label3);
			spottyx++;
			label4 = new JLabel(new ImageIcon(bilist[4]));
			label4.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label4);
			spottyx++;
			label0 = new JLabel(new ImageIcon(bilist[0]));
			label0.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label0);
			spottyx = 0;
			spottyy++;
			label2 = new JLabel(new ImageIcon(bilist[6]));
			label2.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label2);
			spottyx++;
			label5 = new JLabel(new ImageIcon(bilist[7]));
			label5.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label5);
			break;
		
		case 4:
			label3 = new JLabel(new ImageIcon(bilist[1]));
			label3.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label3);
			spottyx++;
			label5 = new JLabel(new ImageIcon(bilist[7]));
			label5.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label5);
			spottyx++;
			label6 = new JLabel(new ImageIcon(bilist[2]));
			label6.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label6);
			spottyx = 0;
			spottyy++;
			label1 = new JLabel(new ImageIcon(bilist[3]));
			label1.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label1);
			spottyx++;
			label7 = new JLabel(new ImageIcon(bilist[5]));
			label7.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label7);
			spottyx++;
			label2 = new JLabel(new ImageIcon(bilist[6]));
			label2.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label2);
			spottyx = 0;
			spottyy++;
			label0 = new JLabel(new ImageIcon(bilist[0]));
			label0.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label0);
			spottyx++;
			label4 = new JLabel(new ImageIcon(bilist[4]));
			label4.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label4);
			break;
		
		case 5:
			label0 = new JLabel(new ImageIcon(bilist[0]));
			label0.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label0);
			spottyx++;
			label3 = new JLabel(new ImageIcon(bilist[1]));
			label3.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label3);
			spottyx++;
			label7 = new JLabel(new ImageIcon(bilist[5]));
			label7.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label7);
			spottyx = 0;
			spottyy++;
			label4 = new JLabel(new ImageIcon(bilist[4]));
			label4.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label4);
			spottyx++;
			label1 = new JLabel(new ImageIcon(bilist[3]));
			label1.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label1);
			spottyx++;
			label6 = new JLabel(new ImageIcon(bilist[2]));
			label6.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label6);
			spottyx = 0;
			spottyy++;
			label5 = new JLabel(new ImageIcon(bilist[7]));
			label5.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label5);
			spottyx++;
			label2 = new JLabel(new ImageIcon(bilist[6]));
			label2.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label2);
			break;
		
		case 6:
			label2 = new JLabel(new ImageIcon(bilist[6]));
			label2.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label2);
			spottyx++;
			label6 = new JLabel(new ImageIcon(bilist[2]));
			label6.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label6);
			spottyx++;
			label0 = new JLabel(new ImageIcon(bilist[0]));
			label0.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label0);
			spottyx = 0;
			spottyy++;
			label3 = new JLabel(new ImageIcon(bilist[1]));
			label3.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label3);
			spottyx++;
			label4 = new JLabel(new ImageIcon(bilist[4]));
			label4.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label4);
			spottyx++;
			label7 = new JLabel(new ImageIcon(bilist[5]));
			label7.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label7);
			spottyx = 0;
			spottyy++;
			label5 = new JLabel(new ImageIcon(bilist[7]));
			label5.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label5);
			spottyx++;
			label1 = new JLabel(new ImageIcon(bilist[3]));
			label1.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label1);
			break;
		case 7:
			label5 = new JLabel(new ImageIcon(bilist[7]));
			label5.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label5);
			spottyx++;
			label6 = new JLabel(new ImageIcon(bilist[2]));
			label6.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label6);
			spottyx++;
			label4 = new JLabel(new ImageIcon(bilist[4]));
			label4.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label4);
			spottyx = 0;
			spottyy++;
			label0 = new JLabel(new ImageIcon(bilist[0]));
			label0.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label0);
			spottyx++;
			label1 = new JLabel(new ImageIcon(bilist[3]));
			label1.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label1);
			spottyx++;
			label3 = new JLabel(new ImageIcon(bilist[1]));
			label3.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label3);
			spottyx = 0;
			spottyy++;
			label7 = new JLabel(new ImageIcon(bilist[5]));
			label7.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label7);
			spottyx++;
			label2 = new JLabel(new ImageIcon(bilist[6]));
			label2.setBounds((spottyx*width) +spottyx*2 +2, (spottyy*height)+spottyy*2+2, width, height);
			_panel.add(label2);
			break;
		}

		//ADD BLANK TILE
		_panel.addMouseListener(new WorldListener(this,_panel));
		_blank = new JLabel();
		_blank.setBounds((2*width) +2*2 +2, (2*height)+2*2+2, width, height);
		_panel.add(_blank);

		//FRAME BASICS
		f.pack();
		f.setVisible(true);
	}
	


	public void tileClicked(Point point){

		int tx = bigToUnderstandableX((int) point.getX());
		int ty = bigToUnderstandableY((int) point.getY());
		int bx = blankgetX();
		int by = blankgetY();
		
		JLabel label;
		JLabel labelblank;

		if(tx==bx) {
			if((by-ty)==1||((by-ty)==-1)){
				clickNumber++;
				label = (JLabel) _panel.getComponentAt(_width*tx+2*tx+3, _height*ty+2*ty+3);
				_panel.remove(label);
				labelblank = (JLabel) _panel.getComponentAt(_width*bx+2*bx+3, _height*by+2*by+3);
				_panel.remove(label);
				label.setBounds((bx*_width) +bx*2 +2, (by*_height)+by*2+2, _width, _height);
				_panel.add(label);
				blankSetX(tx);
				blankSetY(ty);
				labelblank.setBounds((tx*_width) +tx*2 +2, (ty*_height)+ty*2+2, _width, _height);
				_panel.add(labelblank);
				_panel.repaint();
			}
		}
		else if(ty==by){
			if((bx-tx)==1||(bx-tx)==-1){
				clickNumber++;
				label = (JLabel) _panel.getComponentAt(_width*tx+2*tx+3, _height*ty+2*ty+3);
				_panel.remove(label);
				labelblank = (JLabel) _panel.getComponentAt(_width*bx+2*bx+3, _height*by+2*by+3);
				_panel.remove(label);
				label.setBounds((bx*_width) +bx*2 +2, (by*_height)+by*2+2, _width, _height);
				_panel.add(label);
				blankSetX(tx);
				blankSetY(ty);
				labelblank.setBounds((tx*_width) +tx*2 +2, (ty*_height)+ty*2+2, _width, _height);
				_panel.add(labelblank);
				_panel.repaint();
			}
		}
	}
	
	
	public int blankgetX(){
		return _curBlankX;
	}

	public int blankgetY(){
		return _curBlankY;
	}
	
	public void blankSetX(int x){
		_curBlankX = x;
	}
	
	public void blankSetY(int y){
		_curBlankY = y;
	}
	
	public int bigToUnderstandableX(int big){
		int small;
		if(big>2&&big<_width+2){
			small = 0;
		}
		else if(big>_width+4&&big<2*_width+4){
			small = 1;
		}
		else if(big>2*_width+6&&big<3*_width+6){
			small = 2;
		}
		else{
			small = -500;
		}
		return small;
	}
	public int bigToUnderstandableY(int big){
		int small;
		if(big>2&&big<_height+2){
			small = 0;
		}
		else if(big>_height+4&&big<2*_height+4){
			small = 1;
		}
		else if(big>2*_height+6&&big<3*_height+6){
			small = 2;
		}
		else{
			small = -500;
		}
		return small;
	}
	
	public void isComplete(JPanel panel){
		int wide = _width/2;
		int high = _height/2;
		if(panel.getComponentAt(wide, high).equals(label0)&&
				panel.getComponentAt(3*wide, high).equals(label1)&&
				panel.getComponentAt(5*wide, high).equals(label2)&&
				panel.getComponentAt(wide, 3*high).equals(label3)&&
				panel.getComponentAt(3*wide, 3*high).equals(label4)&&
				panel.getComponentAt(5*wide, 3*high).equals(label5)&&
				panel.getComponentAt(wide, 5*high).equals(label6)&&
				panel.getComponentAt(3*wide, 5*high).equals(label7)){
			//THIS IS WHAT HAPPENS WHEN YOU GOT IT RIGHT
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame ,"You Solved the Puzzle in "+clickNumber+" clicks! Click 'New Game' To Continue!","CONGRATULATIONS! Enjoy some shawarma!",JOptionPane.ERROR_MESSAGE);
		//TODO Play some sounds or schtuefs
			switch(soundnumber % 3){
				case 0:
					new PlaySound("Sounds/BringingTheParty.wav");
					break;
				case 1:
					new PlaySound("Sounds/rocket.wav");
					break;
				case 2:
					new PlaySound("Sounds/drums.wav");
					break;
			}
			soundnumber++;		
		}
	}



	public JPanel getCurrentPanel() {
		return _panel;
	}
}
