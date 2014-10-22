package code;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class MouseListenerQUIT implements MouseListener {
	private PlaySound _playsound;

	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		_playsound = new PlaySound("Sounds/WeHaveAHulk.wav");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		_playsound.dispose();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Auto-generated method stub

	}

}
