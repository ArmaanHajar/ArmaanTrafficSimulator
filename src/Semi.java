import java.awt.Color;
import java.awt.Graphics;

public class Semi extends Vehicle {
	
	public Semi(int newx, int newy) { // setters for characteristics of semi
		super(newx, newy);
		width = 100;
		height = 40;
		speed = 5;
	}
	
	public void paintMe(Graphics g) { // sets color of semi
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
}