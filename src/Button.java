
/*
 * Button.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * Button class
 * - creates buttons used in the program
 */
public class Button {
	Image[] songButtons =  new Image[6];
    Color[] gameButtonColor = {(new Color(120, 255, 120)), (new Color(255, 120, 120)), (new Color(255, 255, 0)), (new Color(120, 120, 255))};
    Color[] gameButtonPressedColor = {(new Color(32, 120, 32)), (new Color(120, 32, 32)), (new Color(120, 120, 32)), (new Color(32, 32, 120))};

	/**
	 * drawCircle(Graphics g, int move)
	 * - draws the circles for the song selection menu
	 * @param g graphics object passed in from caller
	 * @param move key binding for game selection [loop(0-5)]
	 */
    public void drawCircle(Graphics g, int move) {
		int y = 215;
	    for (int i = 0; i <= 5; i++) {
			songButtons[i] = new ImageIcon("Buttons/select" + i + ".png").getImage();
		    g.drawImage(songButtons[i], 500, y, 40, 40, null);
			y += 75;
	    }
	}


    /**
     * drawTriangle(graphics g, int move)
     * - draws triangles inside the song select buttons
     * @param g the graphics object passed in by the caller
     * @param move song selection passed in by the caller
     */
    public void drawTriangle(Graphics g, int move) {
		int x = 515;
		int y = 227;

		g.setColor(Color.BLACK);
		for (int i = 0; i <= 5; i++) {
			g.fillPolygon(new int[]{x, x, x + 15}, new int[]{y, y + 16, y + 8}, 3);
			y += 75;
		}
    }

    /**
     * gameButton(Graphics g, boolean[] key)
     * - draws the game buttons pressed during gameplay
     * @param g the graphics object passed in by the caller
     * @param key button pressed
     */
    public void gameButton(Graphics g, boolean[] key) {
		int[] x = {40, 190, 340, 490};
		int y = 620;
		int size = 60;

	    // lane 1 (left lane) button key[0]
	    g.setColor(gameButtonPressedColor[0]);
	    g.fillOval(x[0],y,size,size);
	    g.setColor(key[0] ? gameButtonPressedColor[0] : gameButtonColor[0]);
	    g.fillOval(x[0] + 4,y + 4,52,52);
	    g.setColor(Color.black);
	    g.setFont(new Font("SansSerif",Font.BOLD,34));
	    g.drawString("1", x[0] + 20, y + 44);
		// lane 2 (middle left) button key[1]
	    g.setColor(gameButtonPressedColor[1]);
	    g.fillOval(x[1],y,size,size);
	    g.setColor(key[1] ? gameButtonPressedColor[1] : gameButtonColor[1]);
	    g.fillOval(x[1] + 4,y + 4,52,52);
	    g.setColor(Color.black);
	    g.setFont(new Font("SansSerif",Font.BOLD,34));
	    g.drawString("2", x[1] + 20, y + 44);
		// lane 3 (middle right) button key[2]
	    g.setColor(gameButtonPressedColor[2]);
	    g.fillOval(x[2],y,size,size);
	    g.setColor(key[2] ? gameButtonPressedColor[2] : gameButtonColor[2]);
	    g.fillOval(x[2] + 4,y + 4,52,52);
	    g.setColor(Color.black);
	    g.setFont(new Font("SansSerif",Font.BOLD,34));
	    g.drawString("3", x[2] + 20, y + 44);
		// lane 4 (right) button key[3]
	    g.setColor(gameButtonPressedColor[3]);
	    g.fillOval(x[3],y,size,size);
	    g.setColor(key[3] ? gameButtonPressedColor[3] : gameButtonColor[3]);
	    g.fillOval(x[3] + 4,y + 4,52,52);
	    g.setColor(Color.black);
	    g.setFont(new Font("SansSerif",Font.BOLD,34));
	    g.drawString("4", x[3] + 20, y + 44);
    }
}
