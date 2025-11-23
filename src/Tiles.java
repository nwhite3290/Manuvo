
/*
 * Tiles.java
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Tiles class
 * - extends JPanel
 * - Draws tiles on gameboard
 */
public class Tiles extends JPanel {
	/**
	 * drawTiles(Graphics g, boolean[] tilesCheck, int[] tilesY, boolean play)
	 * - draws the tiles on the gameboard
	 * @param g graphics object passed into the function
	 * @param tilesCheck checks the column for a tile
	 * @param tilesY starting `y` position of the tile
	 * @param play current state of the program
	 */
	public void drawTiles(Graphics g, boolean[] tilesCheck, int[] tilesY, boolean play) {
		// render Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		// set antialiasing ON
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // set color of tiles
        Color[] highlight = {(new Color(120, 255, 120)), (new Color(255, 120, 120)), (new Color(255, 255, 0)), (new Color(120, 120, 255))};
        Color[] tileColor = {(new Color(32, 120, 32)), (new Color(120, 32, 32)), (new Color(120, 120, 32)), (new Color(32, 32, 120))};
		// set height and width of tiles
		int tileWidth = 150;
		int tileHeight = 200;
		// if gameplay is not in progress
		if(!play) {
            // tile rectangle
            g2.setColor(tileColor[0]);
            g2.fillRoundRect(1, 350, tileWidth - 2, tileHeight, 30, 30);
            // highlight glow
            g2.setColor(highlight[0]);
            g2.fillRoundRect(1 + 11, 350 + 10, tileWidth - 22, tileHeight - 20, 30, 30);
            // set color to dark gray
			g2.setColor(Color.DARK_GRAY);
            // set new font
			g2.setFont(new Font("SansSerif", Font.BOLD, 40));
            // draw the word "Start" in the middle of the tile
			g2.drawString("START", 15, 450);
			return;
		}
        // if there is room in the [ith] column
		for(int i = 0; i < 4; i++) {
            if (tilesCheck[i]) {
                int x = i * tileWidth;
                int y = tilesY[i];
                // tile rectangle
                g2.setColor(tileColor[i]);
                g2.fillRoundRect(x + 1, y, tileWidth - 2, tileHeight, 30, 30);
                // highlight glow
                g2.setColor(highlight[i]);
                g2.fillRoundRect(x + 11, y + 10, tileWidth - 22, tileHeight - 20, 30, 30);
            }
        }



	}

	public void drawFoul(Graphics g, int foulPlace, int foulY) {
		g.setColor(Color.red);
		if(foulPlace == 0) {
			g.fillRect(0,foulY,150,200);
		}
		if(foulPlace == 1) {
			g.fillRect(150,foulY,150,200);
		}
		if(foulPlace == 2) {
			g.fillRect(300,foulY,150,200);
		}
		if(foulPlace == 3) {
			g.fillRect(450,foulY,150,200);
		}
	}
}
