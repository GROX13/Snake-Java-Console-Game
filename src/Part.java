
import java.awt.Graphics;

public interface Part {

	public void draw(Graphics graphics);

	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);

	public void tick();

}
