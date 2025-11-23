

import javax.swing.*;
// java.util.Scanner;

public class Main {
    static int boardWidth = 600;
    static int boardHeight = 750;
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Manuvo");
		frame.setSize(boardWidth,boardHeight);
		//frame.setBounds(400,10,800,800);
        frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		MainScreen mainScreen = new MainScreen();
		frame.add(mainScreen);

		//DifficultySelect difficulty = new DifficultySelect();
		//frame.add(difficulty);

		frame.setVisible(true);





	}
}

