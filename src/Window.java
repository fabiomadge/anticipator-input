import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

public class Window extends JFrame implements MouseMotionListener
{
	
	private Logic l;
	private int x, y;
	private int size;

	public Window(Logic logic){
		size = 300;

		l = logic;
		x = size / 2;
		y = size / 2;

		setTitle("anticipator-input");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(size,size + 20);
		setResizable(false);

		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2.clearRect(0, 20, size, size + 20);

		Ellipse2D.Double sphere = new Ellipse2D.Double();
		sphere.width = 14;
		sphere.height = 14;
		sphere.x = x - (sphere.width / 2);
		sphere.y = y - (sphere.height / 2);
		g2.draw(sphere);
	}

	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		double xL = ((double) x)      / size;
		double yL = ((double) y - 20) / size;

		if(xL > 1) xL = 1;
		if(yL > 1) yL = 1;

		l.update(xL, yL);

		repaint();
	}

	public void mouseMoved(MouseEvent e) {
	}

}