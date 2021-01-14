package _01_Olympic_Rings;

import java.awt.Color;
import java.awt.Graphics;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot tl = new Robot(250, 250);
		Robot tm = new Robot(650, 250);
		Robot tr = new Robot(1050, 250);
		Robot bl = new Robot(450, 450);
		Robot br = new Robot(850, 450);
	
		tl.setSpeed(100);
		tm.setSpeed(100);
		tr.setSpeed(100);
		bl.setSpeed(100);
		br.setSpeed(100);
		
		tl.setPenColor(Color.blue);
		tm.setPenColor(Color.black);
		tr.setPenColor(Color.red);
		bl.setPenColor(Color.yellow);
		br.setPenColor(Color.green);
		
		tl.setPenWidth(3);
		tm.setPenWidth(3);
		tr.setPenWidth(3);
		bl.setPenWidth(3);
		br.setPenWidth(3);
	
		tl.penDown();
		tm.penDown();
		tr.penDown();
		bl.penDown();
		br.penDown();
		
		Thread r1 = new Thread(()->tl.move(3));
		Thread r2 = new Thread(()->tm.move(3));
		Thread r3 = new Thread(()->tr.move(3));
		Thread r4 = new Thread(()->bl.move(3));
		Thread r5 = new Thread(()->br.move(3));
		
		Thread t1 = new Thread(()->tl.turn(1));
		Thread t2 = new Thread(()->tm.turn(1));
		Thread t3 = new Thread(()->tr.turn(1));
		Thread t4 = new Thread(()->bl.turn(1));
		Thread t5 = new Thread(()->br.turn(1));
		
		for(int i=0;i<360;i++) {
			r1.run();
			r2.run();
			r3.run();
			r4.run();
			r5.run();
			
			t1.run();
			t2.run();
			t3.run();
			t4.run();
			t5.run();
		}
		
		tl.penUp();
		tm.penUp();
		tr.penUp();
		bl.penUp();
		br.penUp();
		
		Thread l1 = new Thread(()->tl.move(2000));
		Thread l2 = new Thread(()->tm.move(2000));
		Thread l3 = new Thread(()->tr.move(2000));
		Thread l4 = new Thread(()->bl.move(2000));
		Thread l5 = new Thread(()->br.move(2000));
		
		l1.run();
		l2.run();
		l3.run();
		l4.run();
		l5.run();
	}
}

