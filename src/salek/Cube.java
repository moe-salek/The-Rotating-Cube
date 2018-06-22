package salek;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cube {
	
	Random random = new Random();
    static final int MAXCUBE = 110;
    static final int MINCUBE = 70;
	private int centerX = Show.WIDTH/2;
	private int centerY = Show.HEIGHT/2;
	private int centerX2 = centerX + 50;
	private int centerY2 = centerY + 50;
	private int distance = 100;
	private double a = 0;
	private int centerMove = 0;
	boolean c = false;
	List<Dot> dots = new ArrayList<>();
	List<Line> lines = new ArrayList<>();
	private double speedX = 5;
	private double speedY = 5;
	private int randomNumber = random.nextInt(50) + 25;
	private boolean turnRight = random.nextBoolean() ? false : true;
	
	public Cube() {
		
		dots.add(new Dot(centerX - distance, centerY));
		dots.add(new Dot(centerX, centerY - distance));
		dots.add(new Dot(centerX + distance, centerY));
		dots.add(new Dot(centerX, centerY + distance));
		
		lines.add(new Line(dots.get(0), dots.get(2)));
		lines.add(new Line(dots.get(0), dots.get(3)));
		lines.add(new Line(dots.get(1), dots.get(3)));
		lines.add(new Line(dots.get(1), dots.get(2)));
		
		
		dots.add(new Dot(centerX2 - distance, centerY2));
		dots.add(new Dot(centerX2, centerY2 - distance));
		dots.add(new Dot(centerX2 + distance, centerY2));
		dots.add(new Dot(centerX2, centerY2 + distance));
		
		lines.add(new Line(dots.get(4), dots.get(6)));
		lines.add(new Line(dots.get(4), dots.get(7)));
		lines.add(new Line(dots.get(5), dots.get(7)));
		lines.add(new Line(dots.get(5), dots.get(6)));
		
		lines.add(new Line(dots.get(0), dots.get(4)));
		lines.add(new Line(dots.get(1), dots.get(5)));
		lines.add(new Line(dots.get(2), dots.get(6)));
		lines.add(new Line(dots.get(3), dots.get(7)));
		
	}
	
	private void update() {
		
		centerX += speedX;
		centerY += speedY;
		
		if(centerMove < randomNumber && c == false) {
			centerMove += 1;
		} else {
			c = true;
			randomNumber = random.nextInt(100) + 75;
		}
		if(c) {
			if(centerMove > -1*randomNumber) {
				centerMove -= 1;
			}
			else {
				c = false;
				randomNumber = random.nextInt(100) + 75;
			}
		}

		centerX2 = centerX + centerMove;
		centerY2 = centerY + centerMove;
		
		if(a > Math.PI * 2) {
			a = 0;
		} else {
			a += 0.015;
		}
		
		
		if(turnRight) {
			//first square
			dots.get(0).setX(centerX + Math.cos(a) * distance);
			dots.get(0).setY(centerY + Math.sin(a) * distance);
			
			dots.get(1).setX(centerX - Math.cos(a) * distance);
			dots.get(1).setY(centerY - Math.sin(a) * distance);
			
			dots.get(2).setX(centerX - Math.sin(a) * distance);
			dots.get(2).setY(centerY + Math.cos(a) * distance);
			
			dots.get(3).setX(centerX + Math.sin(a) * distance);
			dots.get(3).setY(centerY - Math.cos(a) * distance);
			
			//second square
			dots.get(4).setX(centerX2 + Math.cos(a) * distance);
			dots.get(4).setY(centerY2 + Math.sin(a) * distance);
			
			dots.get(5).setX(centerX2 - Math.cos(a) * distance);
			dots.get(5).setY(centerY2 - Math.sin(a) * distance);
			
			dots.get(6).setX(centerX2 - Math.sin(a) * distance);
			dots.get(6).setY(centerY2 + Math.cos(a) * distance);
			
			dots.get(7).setX(centerX2 + Math.sin(a) * distance);
			dots.get(7).setY(centerY2 - Math.cos(a) * distance);
			
		} else {
			dots.get(0).setX(centerX + Math.sin(a) * distance);
			dots.get(0).setY(centerY + Math.cos(a) * distance);
			
			dots.get(1).setX(centerX - Math.sin(a) * distance);
			dots.get(1).setY(centerY - Math.cos(a) * distance);
			
			dots.get(2).setX(centerX - Math.cos(a) * distance);
			dots.get(2).setY(centerY + Math.sin(a) * distance);
			
			dots.get(3).setX(centerX + Math.cos(a) * distance);
			dots.get(3).setY(centerY - Math.sin(a) * distance);
			
			//second square
			dots.get(4).setX(centerX2 + Math.sin(a) * distance);
			dots.get(4).setY(centerY2 + Math.cos(a) * distance);
			
			dots.get(5).setX(centerX2 - Math.sin(a) * distance);
			dots.get(5).setY(centerY2 - Math.cos(a) * distance);
			
			dots.get(6).setX(centerX2 - Math.cos(a) * distance);
			dots.get(6).setY(centerY2 + Math.sin(a) * distance);
			
			dots.get(7).setX(centerX2 + Math.cos(a) * distance);
			dots.get(7).setY(centerY2 - Math.sin(a) * distance);
		}
	}
	
	public void paint(Graphics2D g2d) {
		update();
		for(Line l : lines) {
			l.paint(g2d);
		}
		for(Dot d : dots) {
			d.paint(g2d);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
	
	
	public double getSpeedX() {
		return this.speedX;
	}
	public double getSpeedY() {
		return this.speedY;
	}
	public void setSpeedX(double speed) {
		this.speedX = speed;
	}
	public void setSpeedY(double speed) {
		this.speedY = speed;
	}
	public boolean getTurn() {
		return turnRight;
	}
	public void setTurn(boolean turnRight) {
		this.turnRight = turnRight;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
