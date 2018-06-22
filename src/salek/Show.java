package salek;

import javax.swing.JFrame;

public class Show {	
	
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
	
	public static void main(String[] args) {	
		
	    long startTime, Time;
	    final long miliSec = 1000L;
	    final int fps = 60;
	    final int updateTime = (int) (miliSec / fps);
		
		Panel myPanel = new Panel();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Just for fun - by Mohammad Salek, 22 June 2018");
		frame.add(myPanel);
		frame.setVisible(true);
		
		try { 
			while(true) {
				startTime = System.nanoTime();
				myPanel.collision.update();
				myPanel.repaint();
				Time = (int) Math.ceil((double) (System.nanoTime() - startTime)/1000000);
				Thread.sleep(updateTime -  Time);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
