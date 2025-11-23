
/*
 * Song.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Song extends JPanel implements KeyListener, ActionListener {
    public void gameInBackGround(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    // Smooth rendering
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    // Gradient background
	    // Gradient background
	    GradientPaint bg = new GradientPaint(0, 0, new Color(70,0,120), 0, 750, new Color(140,0,255));
	    g2.setPaint(bg);
	    g2.fillRect(0, 0, 600, 750);
	    // Glowing lane separators
	    g2.setStroke(new BasicStroke(6f));
	    g2.setColor(new Color(255,255,255,90));
	    g2.drawLine(150,0,150,750);
	    g2.drawLine(300,0,300,750);
	    g2.drawLine(450,0,450,750);
	    // Hit line (bottom of tile: perfect hit)
	    g2.setPaint(new Color(32, 2, 64, 255));
	    g2.fillRect(0, 550, 600, 200);
        // Hit tile when it touches button separator line
        g2.setStroke(new BasicStroke(4f));
        g2.setColor(new Color(255,255,255,60));
        g2.drawLine(0,550,600,550);
        // but no earlier than 50px above
        g2.drawLine(0,400,600,400);

		/*
		g.setColor(new Color(0x842EDC));
        g.fill3DRect(0,0,600,600,true);
        g.setColor(new Color(0xFFFFFF));
        g.drawLine(150,0,150,600);
        g.drawLine(300,0,300,600);
        g.drawLine(450,0,450,600);
        g.setColor(Color.BLACK);
        g.fill3DRect(0,600,600,150,true);
        g.setColor( new Color(0x34000000, true));
        g.fill3DRect(0,450,600,200,true);
        */

		/*
		Graphics2D g2 = (Graphics2D) g;

		// Smooth rendering
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Gradient background
		GradientPaint bg = new GradientPaint(0, 0, new Color(70,0,120),
				0, 600, new Color(140,0,255));
		g2.setPaint(bg);
		g2.fillRect(0, 0, 600, 600);

		// Glowing lane separators
		g2.setStroke(new BasicStroke(6f));
		g2.setColor(new Color(255,255,255,90));
		g2.drawLine(150,0,150,600);
		g2.drawLine(300,0,300,600);
		g2.drawLine(450,0,450,600);

		// Hit zone at bottom
		g2.setPaint(new Color(0,0,0,160));
		g2.fillRect(0, 450, 600, 200);
		 */

    }


    @Override
    public void actionPerformed(ActionEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }
}
