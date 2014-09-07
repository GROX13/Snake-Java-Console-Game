import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
	
	int xCoor;
	int yCoor;
	int width;
	int height;
		
	public BodyPart(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
//		g.setColor(Color.BLACK);
//		g.fillOval(xCoor * width, yCoor * height, width, height);
		
//		g.fillRect(xCoor * width, yCoor * height, width, height);
		g.setColor(Color.GREEN);
		g.fillOval(xCoor * width + 2, yCoor * height + 2, width - 4, height - 4);
//		g.fillRect(xCoor * width + 2, yCoor * height + 2, width - 4, height - 4);
//		g.fillRoundRect(xCoor * width, yCoor * height, width, 20, height, 5);
		
	}
	
	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
}
