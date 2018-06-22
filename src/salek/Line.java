package salek;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Line {

	Dot dot1, dot2;
	private double firstX, firstY, secondX, secondY;
	private double dot1Diameter, dot2Diameter;
	
	public Line(Dot dot1, Dot dot2) {
		this.dot1 = dot1;
		this.dot2 = dot2;
		update();
	}
	
	private void update() {
		firstX = dot1.getX();
		firstY = dot1.getY();
		dot1Diameter = dot1.getD()/2;
		secondX = dot2.getX();
		secondY = dot2.getY();
		dot2Diameter = dot2.getD()/2;
	}
	
	public void paint(Graphics2D g2d) {
		update();
		g2d.setColor(new Color(0, 0, 0));
	    g2d.setStroke(new BasicStroke(3));
		g2d.drawLine((int) (firstX + dot1Diameter), (int) (firstY + dot1Diameter), (int) (secondX + dot2Diameter), (int) (secondY + dot2Diameter));
	}
}
