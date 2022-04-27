import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class Road extends JPanel {
	
	final int LANE_HEIGHT = 120;
	final int ROAD_WIDTH = 800;
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
		// draw cars
		for (int a = 0; a < cars.size(); a++) {
			cars.get(a).paintMe(g);
		}
	}	
	
	public void step() {
		for (int a = 0; a < cars.size(); a++) {
			Vehicle v = cars.get(a);
			v.setX(v.getX() + v.getSpeed());
			if (v.getX() > ROAD_WIDTH) {
				v.setX(0);
			}
		}
	}
	
	public boolean collision(int x, int y, int width, Vehicle v) {
		for (int a = 0; a < cars.size(); a++) {
			Vehicle u = cars.get(a);
			if (y == u.getY()) { // if i'm in the same lane
				if (u.equals(v) == false) { // if i'm not checking myself
					if (v.getX() < u.getX() + u.getWidth() && // my left side is left of their right
							v.getX() + v.getWidth() > u.getX()) { // my right side is right of their right
						return true;
					}
				}
			}
		}
		return false;
	}
}