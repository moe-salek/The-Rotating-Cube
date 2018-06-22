package salek;

import java.util.List;
import java.util.Random;

public class Collision {
	
	private Cube cube;
	private Random random = new Random();
	private int dotNumber = 8;
	List<Dot> dots;
	double[][] dotPositions = new double[dotNumber][2];
	
	public Collision(Cube cube) {
		this.cube = cube;
		this.dots = cube.dots;
	}

	public void update() {
		updatePositions();
		boolean collided = false;
		for(int i = 0; i < dotNumber; i++) {
			if(dotPositions[i][0] < 0) {
				if(cube.getSpeedX() < 0) {
					cube.setSpeedX(cube.getSpeedX() * -1);
					collided = true;
				}
			}
			else if(dotPositions[i][0] > Show.WIDTH) {
				if(cube.getSpeedX() > 0) {
					cube.setSpeedX(cube.getSpeedX() * -1);
					collided = true;
				}
			}
				
			if(dotPositions[i][1] < 0 ) {
				if(cube.getSpeedY() < 0) {
					cube.setSpeedY(cube.getSpeedY() * -1);
					collided = true;
				}
			}
			else if(dotPositions[i][1] > Show.HEIGHT) {
				if(cube.getSpeedY() > 0) {
					cube.setSpeedY(cube.getSpeedY() * -1);
					collided = true;
				}
			}
		}
		if(collided) {
//			cube.setTurn(!cube.getTurn());
			cube.setDistance(random.nextInt(Cube.MAXCUBE) + Cube.MINCUBE);
			collided = false;
		}
	}
	
	private void updatePositions() {
		for(int i = 0; i < dotNumber; i++) {
			dotPositions[i][0] = dots.get(i).getX();
			dotPositions[i][1] = dots.get(i).getY();
		}
	}
}
