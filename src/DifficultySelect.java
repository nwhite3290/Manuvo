/*
 * DifficultySelect.java
 */

import javax.swing.*;
//12: import everything related to awt.event
import java.awt.*;
import java.awt.event.*;

public class DifficultySelect {
	JFrame frame;

	// 10: Create a JLabel
	// we will be able to control the movement of this label
	JLabel[] label;
	JLabel outline = new JLabel();
	String[] difficulty = {"VeryEasy", "Easy", "Medium", "Hard", "VeryHard"};

	// 8: create Action Object instances for each action up,down,left,right
	Action upAction;
	Action downAction;
	Action leftAction;
	Action rightAction;

	// 1: create an instance of this class from caller "KeyBind bind = new KeyBind();"
	// 2: create constructor
	DifficultySelect() {

		// 13: begin by setting up the frame
		frame = new JFrame("KeyBinding");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 750);
		frame.setLayout(null);
		// 14: create JLabel
		int y = 100;
		for (int i = 0; i <= 4; i++){
			label[i] = new JLabel(difficulty[i]);
			frame.add(label[i]);
			label[i].setBounds(100,y,100,100);
			y +=100;
		}

		//outline.setBounds(100,y,100,100);


		//outline.setBounds(0,0,800,550);
		/*
		 * 20.1: instantiate the actions up,down,left,right
		 */
		// 20.2: instantiate up action
		upAction = new UpAction();
		// 20.3: instantiate down Action
		downAction = new DownAction();
		// 20.4: instantiate left Action
		leftAction = new LeftAction();
		// 20.5: instantiate right Action
		rightAction = new RightAction();
		/*
		 * 21: now set up the action performed action within each class below
		 */

		/*
		 * 26.1: map swing component "label" with events created below
		 * - start with the swing component you want to bind (label)
		 * - add the getInputMap() method
		 * - chain on the put(keystroke, object) method
		 * - put takes the keystroke and an action map key
		 * - associate using the Up Keystroke with moving the character up
		 */
		// 26.2: map label events to the actions
		//label.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up" );
		// not the KeyEvent.VK_UP, but type "UP"
		// doesn't matter what we call the actionMapKey. we are only using it once on next line
		outline.getInputMap().put(KeyStroke.getKeyStroke("UP"), "goUp");
		// 26.3: now set it to get the action map
		// put("name from above", <one of our created actions>)
		outline.getActionMap().put("goUp", upAction);
		//26.4: now do the same for down,left,and right
		// 26.5: map the down key the same way as up
		outline.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "goDown");
		outline.getActionMap().put("goDown", downAction);
		// 26.6: map the left key the same way as down
		outline.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "goLeft");
		outline.getActionMap().put("goLeft", leftAction);
		// 26.7: map the right key the same way as left
		outline.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "goRight");
		outline.getActionMap().put("goRight", rightAction);
		// Thats it!!! Try it out


		/*
		 * 27: map the keys to different keys if desired
		 * - try the 'W','A','S','D' keys
		 * - make sure single character keys are in single quotes (' ')
		 */
		// comment out above mappings and change them to these
/*
        label.getInputMap().put(KeyStroke.getKeyStroke('w'), "goUp");
        label.getActionMap().put("goUp", upAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('s'), "goDown");
        label.getActionMap().put("goDown", downAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('a'), "goLeft");
        label.getActionMap().put("goLeft", leftAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('d'), "goRight");
        label.getActionMap().put("goRight", rightAction);
*/
		// END


		// 15: set a background color
		//outline.setBackground(Color.RED);
		// 16: set bounds. size and location of label
		outline.setBounds(100, 100, 100, 100);
		// 17: set it opaque(
		outline.setOpaque(false);
		// 18: add the label to frame
		frame.add(outline);
		// 19: set frame visible. could have been done in step 13.
		frame.setVisible(true);
		/*
		 * 20: Now need to instantiate the Action events listed above.
		 * put this after step 15.
		 */


	}

	// 3: create inner class for each action (up,down,left,right) starting with UP
	public class UpAction extends AbstractAction {

		// 4: add actionPerformed method
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * 25.1: set up the actions
			 */
			// 25.2: create a new action for UP
			// can use getX,getY for the current locations
			// to move up: y should go more negative (getY() - int)
			outline.setLocation(outline.getX(), outline.getY() - 200);

		}
	}

	// 5: create separate classes for down left and right. starting with down.
	public class DownAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 25.3: now set up down,left,right the same way as up
			// to move down: y should go more positive getY() + int)
			outline.setLocation(outline.getX(), outline.getY() + 100);
		}
	}

	// 6: create left action class
	public class LeftAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 25.4: now set up left,right the same way
			// to move left: x should go more negative getX() - int)
			//outline.setLocation(outline.getX() - 10, outline.getY());

		}
	}

	// 7: create right action class
	public class RightAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 25.5: now set up right the same way
			// to move right: x should go more positive getX() + int)
			//outline.setLocation(outline.getX() + 10, outline.getY());
			/*
			 * 26: now back to constructor. Each swing component
			 * can have its own unique mapping of key events to actions
			 */

		}
	}
}
