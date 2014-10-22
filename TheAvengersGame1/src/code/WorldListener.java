package code;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorldListener implements MouseListener {
	private JPanel _p;
	private FifteenPuzzle _fp;

	public WorldListener(FifteenPuzzle fifteenPuzzle, JPanel p){
		_fp = fifteenPuzzle;
		_p=p;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		_fp.tileClicked(e.getPoint());
		JPanel curPanel = _fp.getCurrentPanel();
		_fp.isComplete(curPanel);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
