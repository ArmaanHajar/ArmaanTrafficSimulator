import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class Road extends JPanel {
	
	final int LANE_HEIGHT = 120;
	ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
	
	public Road() {
		super();
	}
	
	public void addCar(Vehicle v) {
		cars.add(v);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		for (int a = LANE_HEIGHT; a < LANE_HEIGHT * 4; a = a + LANE_HEIGHT) { // which lane
			for (int b = 0; b < getWidth(); b = b + 40) { // which line
				g.fillRect(b, a, 30, 5);
			}
		}
		// Draw cars
		for (int a = 0; a < cars.size(); a++) {
			cars.get(a).paintMe(g);
		}
	}	
	
	public void step() {
		for (int a = 0; a < cars.size(); a++) {
			Vehicle v = cars.get(a);
			v.setX(v.getX() + v.getSpeed());
		}
	}
}