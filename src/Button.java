

/*
 * Button.java
 */

/*
 * WHITE = 0x000000, rgba: (255,255,255,0/1), (0,0,0,0), or
 * BLACK = 0xFFFFFF, rgba: (0,0,0,1)
 * RED = = 0xFF0000, rgba: (255,0,0,0.00-1.00)
 * GREEN = 0x00FF00
 * BLUE = 0x0000FF
 * LIME_GREEN =
 * HOT_PINK = 0xFF00FF
 * PURPLE = 0x800080
 */


import java.awt.*;

public class Button {
	int x = 0;
	int y = 0;
	boolean keyPressed = false;

	public void drawCircle(Graphics g, int move) {
		if (move != 1) {
			g.setColor(Color.BLACK); // // g.setColor(new Color(0xFFFFFF));
			g.fillOval(504, 234, 41, 41);
			g.setColor((Color.GREEN)); // g.setColor((Color.green));
			g.fillOval(500, 230, 40, 40);
		}
		if (move == 1) {
			g.setColor(Color.DARK_GRAY); // g.setColor((Color.red));
			g.fillOval(504, 234, 40, 40);
		}
		if (move != 2) {
			g.setColor(Color.BLACK); // g.setColor(new Color(0xFFFFFF));
			g.fillOval(504, 334, 41, 41);
			g.setColor(Color.RED); // g.setColor((Color.green));
			g.fillOval(500, 330, 40, 40);
		}
		if (move == 2) {
			g.setColor(Color.DARK_GRAY); // g.setColor((Color.red));
			g.fillOval(504, 334, 40, 40);
		}
		if (move != 3) {
			g.setColor(Color.BLACK); // g.setColor(new Color(0xFFFFFF))
			g.fillOval(504, 434, 41, 41);
			g.setColor(Color.YELLOW); // g.setColor((Color.green));
			g.fillOval(500, 430, 40, 40);
		}
		if (move == 3) {
			g.setColor(Color.DARK_GRAY); // g.setColor((Color.red));
			g.fillOval(504, 434, 40, 40);
		}
		if (move != 4) {
			g.setColor(Color.BLACK); // g.setColor(new Color(0xFFFFFF));
			g.fillOval(504, 534, 41, 41);
			g.setColor(Color.BLUE); // g.setColor((Color.green));
			g.fillOval(500, 530, 40, 40);
		}
		if (move == 4) {
			g.setColor(Color.DARK_GRAY); // g.setColor((Color.red));
			g.fillOval(504, 534, 40, 40);
		}
		if (move != 5) {
			g.setColor(Color.BLACK); // g.setColor(new Color(0xFFFFFF));
			g.fillOval(504, 634, 41, 41);
			g.setColor(Color.ORANGE); // g.setColor((Color.green));
			g.fillOval(500, 630, 40, 40);
		}
		if (move == 5) {
			g.setColor(Color.DARK_GRAY); // g.setColor((Color.red));
			g.fillOval(504, 634, 40, 40);
		}
	}

	public void drawTriangle(Graphics g, int move) {
		//g.setColor(Color.WHITE); // g.setColor(new Color(0xFFFFFFFF, true));
		//g.fillPolygon(new int[]{513,513,533}, new int[]{242,262,252},3);
		g.setColor(Color.blue);
		if (move == 1) {
			g.setColor(Color.WHITE);
			g.fillPolygon(new int[] {514, 514, 534}, new int[] {245, 265, 255}, 3);
		}
		if (move != 1) {
			g.setColor(Color.BLACK);
			g.fillPolygon(new int[] {510, 510, 530}, new int[] {241, 261, 251}, 3);
		}
		if (move == 2) {
			g.setColor(Color.WHITE);
			g.fillPolygon(new int[] {514, 514, 534}, new int[] {345, 365, 355}, 3);
		}
		if (move != 2) {
			g.setColor(Color.BLACK);
			g.fillPolygon(new int[] {510, 510, 530}, new int[] {341, 361, 351}, 3);
		}
		if (move == 3) {
			g.setColor(Color.WHITE);
			g.fillPolygon(new int[] {514, 514, 534}, new int[] {445, 465, 455}, 3);
		}
		if (move != 3) {
			g.setColor(Color.BLACK);
			g.fillPolygon(new int[] {510, 510, 530}, new int[] {441, 461, 451}, 3);
		}
		if (move == 4) {
			g.setColor(Color.WHITE);
			g.fillPolygon(new int[] {514, 514, 534}, new int[] {545, 565, 555}, 3);
		}
		if (move != 4) {
			g.setColor(Color.BLACK);
			g.fillPolygon(new int[] {510, 510, 530}, new int[] {541, 561, 551}, 3);
		}
		if (move == 5) {
			g.setColor(Color.WHITE);
			g.fillPolygon(new int[] {514, 514, 534}, new int[] {645, 665, 655}, 3);
		}
		if (move != 5) {
			g.setColor(Color.BLACK);
			g.fillPolygon(new int[] {510, 510, 530}, new int[] {641, 661, 651}, 3);
		}
	}

	// Version 4
	public void gameButton(Graphics g, boolean[] key) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		String[] letters = {"1", "2", "3", "4"};
		String[] buttonColors = {"GREEN", "Color.RED", "Color.YELLOW", "Color.BLUE"};
		Color[] colors = {Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE};
		Color[] darkColors = {Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE};
		int[] x = {45, 195, 345, 495};
		int y = 625;
		for (int i = 0; i < 4; i++) {
			g2.setColor(key[i] ? colors[i].darker() : colors[i]);
			g2.fillOval(x[i], y, 60, 60);
			g2.setColor(Color.BLACK);
			g2.setFont(new Font("SansSerif", Font.BOLD, 32));
			g2.drawString(letters[i], x[i] + 20, y + 42);
		}
	}





	/*
	// Version 3
	public void gameButton(Graphics g, boolean[] key) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		String[] letters = {"A","S","J","K"};
		int[] x = {45,195,345,495};
		int y = 625;
		for(int i=0;i<4;i++) {
			g2.setColor(key[i] ? new Color(40,40,40) : new Color(220,220,220));
			g2.fillOval(x[i], y, 60, 60);
			g2.setColor(Color.BLACK);
			g2.setFont(new Font("SansSerif",Font.BOLD,32));
			g2.drawString(letters[i], x[i]+20, y+42);
		}
	}
*/

/*
	// Version 2
	public void gameButton (Graphics g, boolean[] key) {
	    String[] letters = {"A","S","J","K"};
	    int[] x = {45,195,345,495};
	    int y = 625;

    }

		g.setFont(new Font("monospaced",Font.BOLD,50));
        if(!key[0]) {
            g.setColor(new Color(0x000000)); // 0xFFFFFFF = RED
            g.fillOval(45, 625, 60, 60);
            g.setColor((Color.green));
            g.fillOval(40, 620, 60, 60);
            g.setColor(Color.GREEN);
            g.drawString("1",57,665);
        }
        if(key[0]) {
            g.setColor((Color.red));
            g.fillOval(45, 625, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("1",62,670);
        }
        if(!key[1]) {
            g.setColor(new Color(0xFFFFFF)); // 0xFFFFFFF = RED
            g.fillOval(195, 625, 60, 60);
            g.setColor((Color.green));
            g.fillOval(190, 620, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("2",207,665);
        }
        if(key[1]) {
            g.setColor((Color.red));
            g.fillOval(195, 625, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("2",212,670);
        }
        if(!key[2]) {
            g.setColor(new Color(0xFFFFFF)); // 0xFFFFFFF = RED
            g.fillOval(345, 625, 60, 60);
            g.setColor((Color.green));
            g.fillOval(340, 620, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("3",357,665);
        }
        if(key[2]) {
            g.setColor((Color.red));
            g.fillOval(345, 625, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("3",362,670);
        }
        if(!key[3]) {
            g.setColor(new Color(0xFFFFFF)); // 0xFFFFFFF = RED
            g.fillOval(495, 625, 60, 60);
            g.setColor((Color.green));
            g.fillOval(490, 620, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("4",507,665);
        }
        if(key[3]) {
            g.setColor((Color.red));
            g.fillOval(495, 625, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("4",512,670);
        }
    }
 */

}
