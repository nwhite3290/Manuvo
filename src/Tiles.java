
/*
 * Tiles.java
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tiles extends JPanel {
	private int pos;
	private int YHEIGHT = 200;
	Random random = new Random();

	// Version 4
	public void drawTiles(Graphics g, boolean[] tilesCheck, int[] tilesY, boolean play) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w = 150, h = 200;
		if (!play) {
			g2.setColor(Color.BLUE.darker());
			g2.fillRect(225, 300, w, h);
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("SansSerif", Font.BOLD, 24));
			g2.drawString("Press   1\n", 249, 361);
			g2.drawString("to  START", 243, 415);
			return;
		}
		g2.setColor(Color.BLUE.darker());
		for (int i = 0; i < 4; i++) {
			if (tilesCheck[i]) {
				g2.fillRect(i * w, tilesY[i], w, h);
			}
		}
	}



/*
// Version 3
public void drawTiles(Graphics g, boolean[] tilesCheck, int[] tilesY, boolean play) {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	int tileWidth = 150;
	int tileHeight = 200;
	Color tileColor = new Color(10,10,10,220);
	Color tileHighlight = new Color(255,255,255,45);
	if (!play) {
		g2.setColor(tileColor);
		g2.fillRoundRect(225, 300, 150, 200, 30, 30);
		g2.setColor(Color.white);
		g2.setFont(new Font("SansSerif", Font.BOLD, 40));
		g2.drawString("START", 245, 415);
		return;
	}
	for(int i = 0; i < 4; i++) {
		if(tilesCheck[i]) {
			int x = i * tileWidth;
			int y = tilesY[i];
			// tile rectangle g2.setColor(tileColor);
			g2.fillRoundRect(x, y, tileWidth, tileHeight, 30, 30);
			// highlight glow g2.setColor(tileHighlight);
			g2.fillRoundRect(x+10, y+10, tileWidth-20, tileHeight-20, 30, 30);
		}
	}
}
*/

	/*
	// Version 2
	public void drawTiles (Graphics g, boolean[] tilesCheck, int[] tilesY, boolean play) {
		g.setColor(Color.BLACK);
		if(!play) {
			g.fillRect(150,350,150,200);
			g.setColor(Color.white);
			g.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,30));
			g.drawString("Start",180,460);
		}
		if(tilesCheck[0]) {
			g.fillRect(0,tilesY[0],150,YHEIGHT); // YHEIGHT = 200
		}
		if(tilesCheck[1]) {
			g.fillRect(150,tilesY[1],150,YHEIGHT);
		}
		if(tilesCheck[2]) {
			g.fillRect(300,tilesY[2],150,YHEIGHT);
		}
		if(tilesCheck[3]) {
			g.fillRect(450,tilesY[3],150,YHEIGHT);
		}
	}

 */
	public void drawFoul(Graphics g, int foulPlace, int foulY) {
		g.setColor(Color.red);
		if (foulPlace == 0) {
			g.fillRect(0, foulY, 150, YHEIGHT);
		}
		if (foulPlace == 1) {
			g.fillRect(150, foulY, 150, YHEIGHT);
		}
		if (foulPlace == 2) {
			g.fillRect(300, foulY, 150, YHEIGHT);
		}
		if (foulPlace == 3) {
			g.fillRect(450, foulY, 150, YHEIGHT);
		}
	}
}
