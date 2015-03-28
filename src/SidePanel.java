import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public abstract class SidePanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;

	private static final Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 20);
	
	private static final Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);
	
	private static final Font SMALL_FONT = new Font("Tahoma", Font.BOLD, 12);
	
	private Screen screen;

	public SidePanel(Screen screen) {
		this.screen = screen;
		
		setPreferredSize(new Dimension(300, Screen.WIDTH * Screen.HEIGHT));
		setBackground(Color.BLACK);
	}
	
	private static final int STATISTICS_OFFSET = 150;

	private static final int CONTROLS_OFFSET = 320;

	private static final int MESSAGE_STRIDE = 30;

	private static final int SMALL_OFFSET = 30;

	private static final int LARGE_OFFSET = 50;
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);

		/*
		* Set the color to draw the font in to white.
		*/
		g.setColor(Color.WHITE);
		
		/*
		* Draw the game name onto the window.
		*/
		g.setFont(LARGE_FONT);
		g.drawString("Snake Game", getWidth() / 2 - g.getFontMetrics().stringWidth("Snake Game") / 2, 50);
		
		/*
		* Draw the categories onto the window.
		*/
		g.setFont(MEDIUM_FONT);
		g.drawString("Statistics", SMALL_OFFSET, STATISTICS_OFFSET);
		g.drawString("Controls", SMALL_OFFSET, CONTROLS_OFFSET);
	}
}
