
/*
 * Main.java
 */

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MainScreen mainScreen = new MainScreen();
		//GamePlay gamePlay = new GamePlay();
		frame.setBounds(400,10,600,750); // frame.setBounds(x,y,width, height);
		frame.setTitle("Manuvo");
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(mainScreen);
	}
}

