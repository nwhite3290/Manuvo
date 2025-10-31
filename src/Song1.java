
/*
 * Song1.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Song1 extends JPanel implements KeyListener, ActionListener {
	/*
	// Version 4
	public void gameInBackGround(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Pure white background
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 600, 600); // Glowing lane separators
		// Very subtle lane separators
		g2.setColor(new Color(200, 200, 200));
		g2.setStroke(new BasicStroke(2f));
		g2.drawLine(150, 0, 150, 600);
		g2.drawLine(300, 0, 300, 600);
		g2.drawLine(450, 0, 450, 600); // Hit zone at bottom
		// Hit zone (light neutral)
		g2.setColor(new Color(240, 240, 240));
		g2.fillRect(0, 450, 600, 200);
	}
	*/

	/*
	// version 3
	public void gameInBackGround(Graphics g) {
		// Smooth rendering
		Graphics2D g2 = (Graphics2D) g;
		// Gradient background
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint bg = new GradientPaint(0, 0, new Color(70,0,120), 0, 600, new Color(140,0,255));
		g2.setPaint(bg);
		g2.fillRect(0, 0, 600, 600); // Glowing lane separators
		g2.setStroke(new BasicStroke(6f));
		g2.setColor(new Color(255,255,255,90));
		g2.drawLine(150,0,150,600);
		g2.drawLine(300,0,300,600);
		g2.drawLine(450,0,450,600); // Hit zone at bottom
		g2.setPaint(new Color(0,0,0,160));
		g2.fillRect(0, 450, 600, 200);
	}
	*/


	// version 2
	public void gameInBackGround(Graphics g) {
		// Smooth rendering
		Graphics2D g2 = (Graphics2D) g;
		// Gradient background
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint bg = new GradientPaint(0, 0, new Color(70,0,120), 0, 600, new Color(140,0,255));
		g2.setPaint(bg);
		g2.fillRect(0, 0, 600, 600); // Glowing lane separators
		g2.setStroke(new BasicStroke(6f));
		g2.setColor(new Color(255,255,255,90));
		g2.drawLine(150,0,150,600);
		g2.drawLine(300,0,300,600);
		g2.drawLine(450,0,450,600); // Hit zone at bottom
		g2.setPaint(new Color(0,0,0,160));
		g2.fillRect(0, 450, 600, 200);
	}

/*
	// version 1
	public void gameInBackGround(Graphics g) {
		g.setColor(new Color(0x0000FF)); // 0x842EDC = purple
		g.fill3DRect(0, 0, 600, 600, true); // glowing lane separators
		g.setColor(new Color(0xFFFFFF));
		g.drawLine(150, 0, 150, 600);
		g.drawLine(300, 0, 300, 600);
		g.drawLine(450, 0, 450, 600); // bottom hit zone
		g.setColor(Color.BLACK);
		g.fill3DRect(0, 600, 600, 150, true);
		g.setColor(new Color(0x34000000, true)); // 0x34000000 = RED
		g.fill3DRect(0, 450, 600, 200, true);
	}
*/
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
