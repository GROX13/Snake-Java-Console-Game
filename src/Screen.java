import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int GAME_FIELD_ROLS = 30;
	public static final int GAME_FIELD_COLS = 30;
	private Thread thread;
	private boolean running = false;
	
	private BodyPart b;
	private ArrayList<BodyPart> snake;
	
	private Apple apple;
	private ArrayList<Apple> apples;
	
	private Random r;
	
	private int xCoor = 0;
	private int yCoor = HEIGHT / 40;
	private int size = 5;
	
	private int snakeSpeed = 30000;
	private int snakeFinalSpeed = 6000;
	private int speedSstep = 500;
	
	boolean right = true;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	
	private int ticks = 0;
	
	private Key key;
	
	public Screen() {
		setFocusable(true);
		key = new Key();
		addKeyListener(key);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		r = new Random();
		
		snake = new ArrayList<BodyPart>();
		apples = new ArrayList<Apple>();
		
		start();
	}
	
	public void tick() {
		if (snake.size() == 0) {
			b = new BodyPart(xCoor, yCoor, 20);
			snake.add(b);
		}
		if (apples.size() == 0) {
			int xCoor = r.nextInt(GAME_FIELD_ROLS);
			int yCoor = r.nextInt(GAME_FIELD_COLS);
			
			apple = new Apple(xCoor, yCoor, 20);
			apples.add(apple);
		}
		
		for (int i = 0; i < apples.size(); i++) {
			if ((xCoor == apples.get(i).getxCoor()) && (yCoor == apples.get(i).getyCoor())) {
				size++;
				apples.remove(i);
				i--;
				if (snakeSpeed != snakeFinalSpeed) {
					snakeSpeed -= speedSstep;
				}
			}
		}
		
		for (int i = 0; i < snake.size(); i++) {
			if (xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
				if (i != snake.size() - 1) {
					stop();
				}
			}
		}
		
		if (xCoor < 0 || xCoor > GAME_FIELD_ROLS - 1 || yCoor < 0 || yCoor > GAME_FIELD_COLS - 1) {
			stop();
		}
		
		ticks++;
		
		if (ticks > snakeSpeed) {
			if (right) {
				xCoor++;
			}
			if (left) {
				xCoor--;
			}
			if (up) {
				yCoor--;
			}
			if (down) {
				yCoor++;
			}
			
			ticks = 0;
			
			b = new BodyPart(xCoor, yCoor, 20);
			snake.add(b);
			
			if (snake.size() > size) {
				snake.remove(0);
			}
		}
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.DARK_GRAY);
				
		for (int i = 0; i < WIDTH / 20; i++) {
			g.drawLine(i * 20, 0, i * 20, HEIGHT);
		}
		
		for (int i = 0; i < HEIGHT / 20; i++) {
			g.drawLine(0, i * 20, WIDTH, i * 20);
		}
		
		g.setColor(Color.BLACK);
		g.fillRect(WIDTH - 199, 0, WIDTH, HEIGHT);
				
		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		
		for (int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(g);
		}
	}
	
	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			tick();
			repaint();
		}
	}
	
private class Key implements KeyListener{
		
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_RIGHT && !left) {
				up = false;
				down = false;
				right = true;
			}
			if (key == KeyEvent.VK_LEFT && !right) {
				up = false;
				down = false;
				left = true;
			}
			if (key == KeyEvent.VK_UP && !down) {
				up = true;
				right = false;
				left = false;
			}
			if (key == KeyEvent.VK_DOWN && !up) {
				down = true;
				right = false;
				left = false;
			}
			if (key == KeyEvent.VK_P) {
				boolean pressOnce = true;
				if (pressOnce) {
					while (true) {
						int keyPause = e.getKeyCode();
						
						if (keyPause != KeyEvent.VK_P) {
							pressOnce = false;
							System.out.println(keyPause);
							break;
						}
					}
				}
				else {
					
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}