package salek;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private Cube cube = new Cube();
	Collision collision = new Collision(cube);
	
	public Panel() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) { }
			@Override
			public void keyPressed(KeyEvent e) {
				cube.keyPressed(e);
			}
			@Override
			public void keyTyped(KeyEvent e) { }
		});
		setFocusable(true);
	}
	
	public void  paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
		cube.paint(g2d);
	}

}
