package _02_Advanced_Robot_Race;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot[] rob = new Robot[5];
		for(int i=0;i<5;i++) {
			rob[i] = new Robot(i*250+250, 700);
			rob[i].setSpeed(5);
			rob[i].setRandomPenColor();
			rob[i].penDown();
		}
		
		Robot start = new Robot(0, 700);
		start.setSpeed(10);
		start.turn(90);
		start.setPenColor(Color.blue);
		start.setPenWidth(3);
		start.penDown();
		start.move(2000);
		
		Robot finish = new Robot(0, 100);
		finish.setSpeed(10);
		finish.turn(90);
		finish.setPenColor(Color.red);
		finish.setPenWidth(3);
		finish.penDown();
		finish.move(2000);
		
		Thread[] thr = new Thread[5];
		Random rand = new Random();
		int[] rands = new int[5];
		while(rob[0].getY()>=100&&rob[1].getY()>=100&&rob[2].getY()>=100&&rob[3].getY()>=100&&rob[4].getY()>=100) {
			for(int i=0;i<5;i++) {
				rands[i] = rand.nextInt(60)+10;
				int temp = i;
				thr[i] = new Thread(()->rob[temp].move(rands[temp]));
				thr[i].run();
				if(rob[i].getY()<=100) {
					for(int j=0;j<5;j++) {
						int t = j;
						thr[j] = new Thread(()->rob[t].move(0));
						thr[j].run();
					}
					rob[i].sparkle();
					JOptionPane.showMessageDialog(null, "Robot "+i+" has won!");
				}
			}
		}
	}
}
