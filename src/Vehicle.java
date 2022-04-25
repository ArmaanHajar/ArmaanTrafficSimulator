import java.awt.Graphics;

public class Vehicle {
	
	int x;
	int y;
	int width = 0;
	int height = 0;
	int speed = 0;
	
	public Vehicle(int newx, int newy) {
		y = newy;
		x = newx;
	}
	
	public void paintMe(Graphics g) {
		
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int newx) {
		x = newx;
	}

	public int getSpeed() {
		return speed;
	}
}