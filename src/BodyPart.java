
import java.awt.Color;
import java.awt.Graphics;

public class BodyPart implements Part {
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
