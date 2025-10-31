
/*
 * GameText.java
 */

import java.awt.*;

public class GameText {
	private String TITLE = "Manuvo";

	public void gameName(Graphics g) {
		g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 90));
		g.setColor(Color.GRAY); // g.setColor(new Color(0xFFFFFF00, true));
		g.drawString(TITLE, 264, 100);
		g.setColor(Color.BLUE); // g.setColor(new Color(156, 112, 248, 255));
		g.drawString(TITLE, 260, 100);
		g.setColor(new Color(0xFFFFFF00, true)); // 0xFFFFFFFF = Black
/*
        g.drawString("Tiles",264,190);
        g.setColor(new Color(156, 112, 248, 255)); // Color(156, 112, 248, 255) = Purple
        g.drawString("Tiles",260,190);
 */
	}

	public void songText(Graphics g) {
		g.setColor(new Color(114, 222, 210, 255)); // Color(156, 112, 248, 255) = Ugly Cyan_Green
		g.setFont(new Font("monospaced Bold", Font.ITALIC, 30));

		g.drawString("Someone you Loved", 180, 230);
		g.drawString("Memories", 180, 330);
		g.drawString("Play Date", 180, 430);
		g.drawString("Dance Monkey", 180, 530);
		g.drawString("Counting Stars", 180, 630);
	}

	// Guitar = G, R, Y, Bl, O
	public void difficultyText(Graphics g) {
		g.setFont(new Font("serif", Font.BOLD, 20));

		// Green
		//g.setColor(new Color(0x0FFD0FF, true)); // 0xFFD0FF00 = Pink
		g.setColor(new Color(0xCC00FF00, true)); // 0xFFD0FF00 = Purple
		g.drawString("Very Easy", 400, 280);

		g.setColor(Color.RED);
		g.drawString("Easy", 400, 380);

		g.setColor(new Color(0xFFFFFF00, true)); // 0x099202 = Green
		g.drawString("Medium", 400, 480);

		g.setColor(Color.BLUE);
		g.drawString("Hard", 400, 580);

		g.setColor(Color.ORANGE);
		g.drawString("Very Hard", 400, 680);
	}

	public void gameOver(Graphics g, int score) {
		g.setFont(new Font("serif", Font.BOLD, 50));
		g.setColor(new Color(0xFFFFFFFF, true)); // g.setColor(new Color(0xFFE600));
		g.drawString("Score: " + score, 180, 255);
		g.setColor(new Color(0xFFFFFFFF)); // g.setColor(new Color(0x800000));
		g.drawString("Game Over", 150, 325);
		g.setColor(new Color(0xFFFFFFFF)); // g.setColor(new Color(0x26FF00));
		g.drawString("Press Enter", 160, 400);
	}

	// Version 4
	public void score(Graphics g, int score, String compliment, int complimentSize) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SansSerif", Font.BOLD, 48));
		g2.drawString(String.valueOf(score), 270, 70);
		g2.setFont(new Font("SansSerif", Font.PLAIN, complimentSize));
		g2.setColor(new Color(140, 140, 140)); // soft gray
		g2.drawString(compliment, 230, 140);
	}


	/*
	// Version 3
	public void score(Graphics g,int score, String compliment, int complimentSize) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("SansSerif",Font.BOLD,50));
		g2.setColor(Color.white);
		g2.drawString(String.valueOf(score),270,70);
		g2.setFont(new Font("SansSerif",Font.BOLD,complimentSize));
		g2.setColor(new Color(255, 255, 255, 200));
		g2.drawString(compliment,230,140);
	}
	*/

/*
	// Version 2
	public void score(Graphics g,int score, String compliment, int complimentSize) {
        g.setColor(new Color(0xFFFFFF)); // 0xFFFFFF = White
        g.setFont(new Font("serif",Font.BOLD,50));
        g.drawString(String.valueOf(score),300,70);
        if(compliment.equals("Perfect"))
            g.setColor(new Color(0x630061)); // 0x630061 = Purple
        else if(compliment.equals("Great"))
            g.setColor(new Color(0x001E99)); // 0x001E99 = Blue
        else
            g.setColor(new Color(0x008787)); // 0x008787 = Cyan
        g.setFont(new Font("serif",Font.BOLD,complimentSize));
        if(complimentSize == 50)
            g.drawString(compliment,280,120);
        else
            g.drawString(compliment,230,140);

    }

 */
}
