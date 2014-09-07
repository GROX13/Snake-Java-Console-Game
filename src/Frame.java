import javax.swing.JFrame;
import java.awt.GridLayout;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Snake Game v1.00");
		setResizable(false);
		
		init();
	}
	public void init() {
		setLayout(new GridLayout(1, 1, 0, 0));
	
		Screen s = new Screen();
		add(s);
		
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Frame();
	}
}