
/*
 * GameText.java
 */

import java.awt.*;

/**
 * GameText
 * - class creates the text used in the game
 */
public class GameText {
    public void gameName(Graphics g) {
	    g.setColor(new Color(107, 98, 55, 255));
	    g.setFont(new Font("Garamond Bold",Font.BOLD,50));
        //g.drawString("Manuvo",400,100);
    }
    public void songText(Graphics g) {
	    g.setColor(new Color(107, 98, 55, 255));
	    g.setFont(new Font("Garamond Bold",Font.BOLD,32));
	    //g.setFont(new Font("Gill Sans Bold",Font.BOLD,48));
        
        // background song is song[0] " Someone you Loved"
	    g.drawString("Someone you Loved",40,250);
	    g.drawString("Memories",40, 325);
	    g.drawString("Counting Stars",40,400);
	    g.drawString("Fur Elise",40,475);
	    g.drawString("Canon",40,550);
	    g.drawString("Moonlight Sonata",40,625);

    }
    public void difficultyText(Graphics g) {
        g.setFont(new Font("serif",Font.BOLD,20));

        g.setColor(new Color(0xFFD0FF00, true));
        //g.drawString("Very Easy",400,280);

        g.setColor(Color.CYAN);
        //g.drawString("Easy",400,380);

        g.setColor(new Color(0x099202));
        //g.drawString("Medium",400,480);

        g.setColor(Color.blue);
        //g.drawString("Hard",400,580);

        g.setColor(Color.red);
        //g.drawString("Very Hard",400,680);
    }
    public void gameOver(Graphics g, int score) {
        g.setFont(new Font("serif",Font.BOLD,50));
        g.setColor(new Color(0xFFE600));
        g.drawString("Score: "+score,180,255);
        g.setColor(new Color(0x800000));
        g.drawString("Game Over",150,325);
        g.setColor(new Color(0x26FF00));
        g.drawString("Press Enter",160,400);
    }
	/*
	public void score(Graphics g,int score, String compliment, int complimentSize) { Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("SansSerif",Font.BOLD,50));
		g2.setColor(Color.white);
		g2.drawString(String.valueOf(score),270,70);
		g2.setFont(new Font("SansSerif",Font.BOLD,complimentSize));
		g2.setColor(new Color(255, 255, 255, 200));
		g2.drawString(compliment,230,140);
	}
	*/
	public void score(Graphics g,int score, String compliment, int complimentSize) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SansSerif", Font.BOLD, 48));
		g2.drawString(String.valueOf(score), 270, 70);

		g2.setFont(new Font("SansSerif", Font.PLAIN, complimentSize));
		g2.setColor(new Color(140, 140, 140)); // soft gray
		g2.drawString(compliment, 230, 140);
	}
}
