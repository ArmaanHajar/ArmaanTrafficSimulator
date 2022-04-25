import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Traffic implements ActionListener, Runnable {
	
	JFrame frame = new JFrame("Traffic Simulation");
	Road road = new Road();
	// South Container
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	Container south = new Container();
	// West Container
	JButton semi = new JButton ("Add Semi");
	JButton suv = new JButton ("Add SUV");
	JButton sports = new JButton ("Add Sports");
	Container west = new Container();
	
	boolean running = false;

	public Traffic() {
		frame.setSize(1000, 550);
		frame.setLayout(new BorderLayout());
		frame.add(road, BorderLayout.CENTER);
		
		south.setLayout(new GridLayout(1, 2));
		south.add(start);
		start.addActionListener(this);
		south.add(stop);
		stop.addActionListener(this);
		frame.add(south, BorderLayout.SOUTH);
		
		west.setLayout(new GridLayout(3,1));
		west.add(semi);
		semi.addActionListener(this);
		west.add(suv);
		suv.addActionListener(this);
		west.add(sports);
		sports.addActionListener(this);
		frame.add(west, BorderLayout.WEST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Semi testSemi = new Semi(10, 20);
		road.addCar(testSemi);
		SUV testSUV = new SUV(10, 170);
		road.addCar(testSUV);
		Sports testSports = new Sports(10, 320);
		road.addCar(testSports);
		frame.repaint();
	}

	public static void main(String[] args) {
		new Traffic();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
	
	}

	@Override
	public void run() {
		while (running == true) {
			road.step();
			frame.repaint();
			try {
				Thread.sleep(500);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
