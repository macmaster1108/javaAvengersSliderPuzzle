package code;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseListenerNG implements MouseListener {
	private PlaySound _playsound;
	private JFrame _sf;
	private int boardnumber = 1;
	public boolean firstgamestarted = false;

	public MouseListenerNG(JFrame startframe){
		_sf = startframe;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//_sf.dispose();
		firstgamestarted = true;
		switch(boardnumber){
		case 1:
			new FifteenPuzzle("Images/Thor.png",1);
			break;
		case 2:
			new FifteenPuzzle("Images/ironman.png",2);
			break;
		case 3:
			new FifteenPuzzle("Images/hulk2.png",3);
			break;
		case 4:
			new FifteenPuzzle("Images/blackwidow.png",4);
			break;
		case 5:
			new FifteenPuzzle("Images/capamer.png",5);
			break;
		case 6:
			new FifteenPuzzle("Images/Loki.png",6);
			break;
		case 7:
			new FifteenPuzzle("Images/15puzassemble.png",7);
			break;
		case 8:
			//TODO DO SOMETHING FANCY
		}
		boardnumber++;

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(firstgamestarted == false){
		_playsound = new PlaySound("Sounds/BringingTheParty.wav");
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		_playsound.dispose();

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// Auto-generated method stub

	}

	public boolean getIfStarted() {
		return firstgamestarted;
	}

}
