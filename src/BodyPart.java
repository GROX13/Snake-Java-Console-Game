import java.awt.Color;
import java.awt.Graphics;

public class BodyPart implements Part {
	/*
	 * Old Code:
	 * 
	 * int xCoor; int yCoor; int width; int height;
	 * 
	 * public BodyPart(int xCoor, int yCoor, int tileSize) { this.xCoor = xCoor;
	 * this.yCoor = yCoor; width = tileSize; height = tileSize; }
	 * 
	 * public void tick() {
	 * 
	 * }
	 * 
	 * public void draw(Graphics g) { // g.setColor(Color.BLACK); //
	 * g.fillOval(xCoor * width, yCoor * height, width, height);
	 * 
	 * // g.fillRect(xCoor * width, yCoor * height, width, height);
	 * g.setColor(Color.GREEN); g.fillOval(xCoor * width + 2, yCoor * height +
	 * 2, width - 4, height - 4); // g.fillRect(xCoor * width + 2, yCoor *
	 * height + 2, width - 4, height - // 4); // g.fillRoundRect(xCoor * width,
	 * yCoor * height, width, 20, height, 5);
	 * 
	 * }
	 * 
	 * public int getxCoor() { return xCoor; }
	 * 
	 * public void setxCoor(int xCoor) { this.xCoor = xCoor; }
	 * 
	 * public int getyCoor() { return yCoor; }
	 * 
	 * public void setyCoor(int yCoor) { this.yCoor = yCoor; }
	 */

	int x;
	int y;
	int width;
	int height;

	public BodyPart(int x, int y, int tileSize) {
		this.x = x;
		this.y = y;
		width = tileSize;
		height = tileSize;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.GREEN);
		graphics.fillOval(x * width + 2, y * height + 2, width - 4, height - 4);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void tick() {

	}

}
