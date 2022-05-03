import java.awt.Graphics;

public class Vehicle { // setters for cars	
	int x;
	int y;
	int width = 0;
	int height = 0;
	int speed = 0;
	
	public Vehicle(int newx, int newy) { // sets parent for x and y of vehicle
		y = newy;
		x = newx;
	}
	
	public void paintMe(Graphics g) {
		
	}
	
	public int getX() { // gets x value of car
		return x;
	}
	
	public void setX(int newx) { // sets x value of car
		x = newx;
	}

	public int getSpeed() { // gets speed of car
		return speed;
	}
	
	public int getY() { // gets y value of car
		return y;
	}
	
	public void setY(int newy) { // sets y value of car
		y = newy;
	}
	
	public int getWidth() { // gets width of car
		return width;
	}

}