package salek;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Dot {
	
	private Color color;
	private Random random = new Random();
	
	private double x, y, d;
	private int r, g, b;
	
	public Dot(double x, double y) {
		this.x = x;
		this.y = y;
		this.d = 20;
		r = random.nextInt(255);
		g = random.nextInt(255);
		b = random.nextInt(255);
		color = new Color(r, g, b);
	}

	
	public void paint(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fillOval((int) x, (int) y, (int) d, (int) d);
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getD() {
		return this.d;
	}

}
