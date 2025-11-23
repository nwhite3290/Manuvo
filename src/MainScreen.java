


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * MainScreen class creates new MainScreen object
 * User Interface. uses all other classes:
 * - Uses all classes:
 * - create and set up menu, songs, game board and graphics
 * - run menus and game
 * - sets initial values
 * - and handles input and output
 * - extends JPanel
 * - uses KeyListener for keyboard actions
 * - uses ActionListener for button presses vs piece locations
 */
public class MainScreen extends JPanel implements KeyListener, ActionListener {
	/*
	 * create initial values and checks
	 */
	// create new game timer
	private Timer time;
	// game timer delay between milliseconds
	private int delay = 15;
	// gameplay in progress flag == false
	private boolean play = false;
	// gameplay over flag == false
	private boolean over = false;
	// create new random generator
	// used for backball[x], backball[y], tilesProduced 'x' position
	Random rand = new Random();
	/*
    // x - position of bubbles, max = 40
	private int[] backBallX = new int[40];
	// y - position of black balls, max = 40
	private int[] backBallY = new int[40];
	*/
	// check for song image flag == true
	private boolean check = true;
	// too far away to hit if better option window
	private final int MISTAKE = 50;
	// tile hit window lower limit (pixels)
	private final int bottomBond = 550;
	// used to set and set 'x' column of produced tiles
	private int x = 0;
	// used to calculate score
	private int score = 0;
	// 'Y' location fouled hit
	private int foulY = 0;
	// fouled hit location
	private int foulPlace;
	// total tiles per column
	private int totalTiles = 0;
	// key binding for game selection [loop(0-5)]
	private int move = 1;
	// song select window: up arrow: selectRectY = (-100)
	private int selectRectY=-75;
	// game play speed == Difficulty
	private int speed = 5;
	// game begin flag == false
	private  boolean go = false;
	// is a key pressed flag all 4 columns flag
	private boolean key[] = new boolean[5];
	// check any tile column for game over foul
	private boolean tilesCheck[] = new boolean[5];
	// previous tile in column clear to make a new tile flag
	private boolean checkTilesProduce[] = new boolean[5];
	// check for tile location in column
	private int tilesY[] = new int[5];
	// compliment player and increase score
	private String compliment = "";
	// complement player Font size
	private int complimentSize = 50;
	// hit foul flag == false
	private boolean foul = false;
	// start game flag == false
	private boolean startSong = false;
	// start music flag == false
	private boolean audioStatus = false;
	// start background music flag == false
	private boolean backgroundAudioStatus = false;

	// song images
	public static final BufferedImage[] songsImg = new BufferedImage[5];
	// Manuvo Image
	Image iconImage;
	/*
	 * end create initial values and flags
	 */

	// create Audio object for game
	Audio audio;
	// create background Audio for menus
	Audio backgroundAudio;
	//BufferedImage iconImage = null;
	ImageIcon backgroundStars;

	/**
	 *  MainScreen constructor
	 *  set up initial values, key press action listener,
	 *  and arrow button key binding listener
	 *  starts a game loop timer.
	 */
	public MainScreen (){
		// set initial reset values
		initialValues();
		// sets up initial keybinding for new objects
		addKeyListener(this);
		// sets action focus to new objects
		setFocusable(true);
		// add selection enable using keyboard
		setFocusTraversalKeysEnabled(false);
		// initialize game loop timer(time in ms, to new "M.S" objects)
		time = new Timer(delay,this);
		// start game loop
		time.start();
	}

	/**
	 * initialValues() method
	 * sets initial values and flags
	 */
	public void initialValues() {
		// game text for scoring
		compliment = "";
		// initial number of tiles
		totalTiles = 0;
		// initial score
		score = 0;
		// starting delay
		delay = 15;
		// gameplay not started
		play = false;
		// loss flag reset
		over = false;
		// tiles reset
		check = true;
		// no tiles in columns
		x = 0;
		// first song selected initial
		move = 1;
		// location of song selection rectangle
		selectRectY = 200;
		// game start criteria not met
		go = false;
		// no fouls
		foulY = 0;
		// no audio playing
		audioStatus = false;
		// song not in progress
		startSong = false;
		// no background music
		backgroundAudioStatus = false;
		// no fouls on board
		foul = false;
		// no song selected

		// check the keyboard action for presses
		for(int i = 0; i < 5; i++) {
			// no keys pressed
			key[i] = false;
			// no initial fouls
			tilesCheck[i] = false;
			// no tiles produced
			checkTilesProduce[i] = false;
			// used for game tile locations
			tilesY[i] = -150;
		}
		/*
		// create <= 40 floating bubbles on main screen
		for (int i = 0; i < 40; i++) {
			// random x starting location
			backBallX[i]=rand.nextInt(550);
			// random y starting location
			backBallY[i]=rand.nextInt(700);
		}
		*/
	}

	/**
	 * paint(Graphics g) method paints an object passed in
	 * @param graphics  the <code>Graphics</code> context object in which to paint
	 */
	public void paint (Graphics graphics) {
		// create new game text object for user feedback
		GameText gameText = new GameText();
		//difficulty();
		gameText.difficultyText(graphics);
		// paint backGround method found below
		backGround(graphics);
		// paint floating bubbles method found below
//		backBalls(graphics);

		// display game name on main window
		gameText.gameName(graphics);
		// display game Icon on main window
		icon(graphics);
		// draw song names on main window
		// playDate, danceMonkey, memories, countingStars, someoneYouLoved.
		drawSongImage(graphics);
		// check song images are available
		getSongImage(check);
		// reset check flag for reuse
		check=false;
		// display song names on main window
		gameText.songText(graphics);
		// difficulty display difficulty on main window
		gameText.difficultyText(graphics);
		// create song select button for available songs
		Button button = new Button();
		// song select button changes on focus
		button.drawCircle(graphics,move);
		// selection button arrow inside changes on focus
		button.drawTriangle(graphics,move);
		// create new song object for game
		Song song = new Song();
		// game not started && no background audio
		if(!go && !backgroundAudioStatus) {
			// create background audio - song[5]
			backgroundAudio = new Audio(0);
			// start playing background audio
			backgroundAudio.startAudio();
			// set background audio playing flag = true
			backgroundAudioStatus = true;
		}
		// ready to start game conditions good flag
		if(go) {
			// first stop background music
			backgroundAudio.stopAudio();
		}
		// song selection 1 = song[0]
		if(move==1) {
			// set difficulty "very easy"
			speed = 2;
			// begin playing music flag == true
			if (startSong) {
				// initialize audio 0
				audio = new Audio(0); // 1st song
				// start audio 0 track
				audio.startAudio();
				// set audio in progress flag = true
				audioStatus = true;
				// set begin playing music flag = false
				startSong = false;
			}
			// (game over == true) && (audio playing == true)
			if (over && audioStatus) {
				// stop audio 0 track
				audio.stopAudio();
				// set audio not in progress flag = false
				audioStatus = false;
			}
		}
		// song selection 2 = song[1]
		if(move==2) {
			// // MainScreen actionEvent
			// set difficulty "easy"
			speed = 3; // tile speed
			// if song begin flag == true
			if (startSong) {
				// initialize audio 1
				audio = new Audio(1); // 2nd song
				// start audio 1 track
				audio.startAudio();
				// set audio in progress flag = true
				audioStatus = true;
				// set song begin flag = false
				startSong = false;
			}
			// if game over && audio still playing
			if (over && audioStatus) {
				// stop audio track
				audio.stopAudio();
				// set audio in progress flag = false
				audioStatus = false;
			}
		}
		// song selection 3 = song[2]
		if(move==3) {
			// set difficulty == "medium"
			speed = 4;
			// if song begin flag == true
			if (startSong) {
				// initialize audio 2
				audio = new Audio(2); // 3rd song
				// start audio track
				audio.startAudio();
				// set audio in progress flag = true
				audioStatus = true;
				// song begin flag == false
				startSong = false;
			}
			// if game over and audio still playing
			if (over && audioStatus) {
				// stop audio track
				audio.stopAudio();
				// set audio in progress flag = false
				audioStatus = false;
			}
		}
		// song section 4 = song[3]
		if(move==4) {
			// difficulty == "hard"
			speed = 5;
			// if song begin flag == true
			if (startSong) {
				// initialize audio 3
				audio = new Audio(3); // 4th song
				// start audio track
				audio.startAudio();
				// set audio in progress flag = true
				audioStatus = true;
				// song begin flag == false
				startSong = false;
			}
			// if game over and audio still playing
			if (over && audioStatus) {
				// stop audio track
				audio.stopAudio();
				// set audio in progress flag = false
				audioStatus = false;
			}
		}
		// song selection 5 = song[4]
		if(move==5) {
			// difficulty = "very hard"
			speed = 6;
			// if song begin flag == true
			if (startSong) {
				// initialize audio 4
				audio = new Audio(4); // 5th song
				// start audio track
				audio.startAudio();
				// set audio in progress flag = true
				audioStatus = true;
				// song begin flag == false
				startSong = false;
			}
			if (over && audioStatus) {
				// stop audio track
				audio.stopAudio();
				// set audio in progress flag = false
				audioStatus = false;
			}
		}
		// song selection 5 = song[4]
		if(move==6) {
			// difficulty = "very hard"
			speed = 7;
			// if song begin flag == true
			if (startSong) {
				// initialize audio 4
				audio = new Audio(5); // 5th song
				// start audio track
				audio.startAudio();
				// set audio in progress flag = true
				audioStatus = true;
				// song begin flag == false
				startSong = false;
			}
			if (over && audioStatus) {
				// stop audio track
				audio.stopAudio();
				// set audio in progress flag = false
				audioStatus = false;
			}
		}
		// Main Screen actionEvent "ENTER" button pressed
		if(go) { /* [START GAME] */
			// draw gameboard
			song.gameInBackGround(graphics);
			// draw game buttons
			button.gameButton(graphics,key);
			// game not over
			if(!over) {
				// create new Tile object
				Tiles tiles = new Tiles();
				// draw new tiles, check tile position, game in progress
				tiles.drawTiles(graphics, tilesCheck, tilesY, play);
				// create new gameText object
				GameText gameText1 = new GameText();
				// user feedback: print score and compliment to screen
				gameText1.score(graphics,score,compliment,complimentSize);
			}
		}
		// tile foul: wrong key or missed tile
		if(foul) {
			// create new Tile object
			Tiles tiles = new Tiles();
			// draw fouled tile
			tiles.drawFoul(graphics, foulPlace, foulY);
		}
		// if foul resulted in game over
		if(over) {
			// create new GameText object "Game Over"
			GameText gameTextOver = new GameText();
			// user feedback display game over
			gameTextOver.gameOver(graphics, score);
			try {
				// pause game 0.5 seconds
				Thread.sleep(500);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				System.err.println(e.getMessage());
				System.out.println("MainScreen/paint(Graphics graphics)");
			}
			// reset foul flag
			foul = false;
		}
		// Disposes the used graphics and releases system resources
		graphics.dispose();
		// repaints the gameboard
		repaint();
	}

	/**
	 * backGround(Graphics g)
	 * displays MainScreen background graphics
	 * @param g any object in need of graphics rendering
	 */
	public void backGround(Graphics g) {
		Image bk = new ImageIcon("Backgrounds/songListBg600x750.png").getImage();
		g.drawImage(bk, 0, 0, 600, 718, null);
        g.draw3DRect(35,selectRectY,520,75,true);
        // set background color.BLACK
        //g.setColor(new Color(0, 0, 0, 255));
        //backgroundStars = new ImageIcon(bk.getScaledInstance(600, 750, Image.SCALE_SMOOTH));
		// fill entire background (600x750)
		//g.fillRect(0,0,600,750);
		// set song select rectangle Color.WHITE
		//g.setColor(new Color(255, 255, 255, 164));
		// draw line around selection.
		// 10px indents from L/R edges. 100px tall
		// true = rectangle appears raised above surface

	}


	/**
	 * backBalls(Graphics g)
	 * draws bubbles rising up from random x locations on main menu screen
	 * @param g rising bubbles objects to draw
	 */
	/*
    private void backBalls(Graphics g) {
		// set bubble Color.GRAY
		g.setColor(new Color(255, 255, 255, 131));
		// fill bubbles with Color.Gray
		for(int i = 0; i < 40; i++) {
			// 10 x 10 pixels in diameter
			g.fillOval(backBallX[i], backBallY[i], 10, 10);
		}
	}
    */

	/**
	 * getSongImage(boolean check)
	 * renders song images from folder onto Main Menu
	 * @param check boolean true if songs are available
	 */
	public void getSongImage(boolean check) {
		// check for song images
		if(check) {
			// try to read image files
			try {
				// copy images into buffered list to be rendered in next method
				for (int i = 0; i <= 4; i++){
					songsImg[i] = ImageIO.read(new File("Images/songLogo.png"));
				}
				// catch exception unable to read image files
			} catch (IOException e) {
				// output error message to stderr
				System.err.println(e.getMessage());
				System.out.println("MainScreen/getSongImage(boolean check)");
			}
		}
	}

	/**
	 * drawSongImage(Graphics g)
	 * draws song images to main menu
	 * @param g local buffered images used as graphics input
	 */
	public void drawSongImage(Graphics g) {
		// draws images to horizontally spaced every 100px on main menu
		int y = 210;
		for(int i = 0; i <= 4; i++) {
			//g.drawImage(songsImg[i],20,y,75,80,this);
			y += 100;
		}
	}

	/**
	 * icon(Graphics g) renders Icon onto main menu
	 * @param g icon to be rendered
	 */
	public void icon (Graphics g) {
		// check if file is accessible
		if(check)
			// try to access image

			try {
				// location of image to be displayed
				iconImage = ImageIO.read(new File("Backgrounds/Icon.jpg"));
				// catch exception unable to read files
			} catch (IOException e) {
				// output error message to stderr
				System.err.println(e.getMessage());
				System.out.println("MainScreen/icon(Graphics g)");
			}

		// draw icon (x,y,width,height,<java.awt.imageObserver(for scaling)>
		//g.drawImage(iconImage,20,10,200,190,this);
	}

	/**
	 * tilesProduced() produces tiles for the program
	 * - adds tiles as needed at random columns
	 */
	public void tilesProduce () {
		// produce another tile
		totalTiles++;
		// put the tile in a random column
		x = rand.nextInt(4);
		// check if successful
		tilesCheck[x] = true;
	}

	/**
	 * actionPerformed(ActionEvent e)
	 * - handles tile location related events
	 * - {@literal @}override - Inherited method must override
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
/*
        // for at most, 40 bubbles
		for(int i = 0; i < 40; i++) {
			// rising bubbles
			backBallY[i]-=1; // -1px every (int delay = 15ms)
			// if bubble reaches top of screen (y = 0)
			if(backBallY[i]==0) {
				// reset it at bottom of screen
				backBallY[i] = 700;
				// in a random 'x' location
				backBallX[i] = rand.nextInt(550);
			}
		}
*/
		// if tile is created in 1st column
		if(tilesCheck[0]) {
			// set the speed to match difficulty
			tilesY[0]+=speed;
		}
		// if tile is created in 2nd column
		if(tilesCheck[1]) {
			// set the speed to match difficulty
			tilesY[1]+=speed;
		}
		// if tile is created in 3rd column
		if(tilesCheck[2]) {
			// set the speed to match difficulty
			tilesY[2]+=speed;
		}
		// if tile is created in 4th column
		if(tilesCheck[3]) {
			// set the speed to match difficulty
			tilesY[3]+=speed;
		}
		// if 1st column tile location >= 80px && no more tiles have been produced
		if(tilesY[0]>=80 && !checkTilesProduce[0]) {
			// crete another tile
			tilesProduce();
			// set 1st column tile flag = true
			checkTilesProduce[0] = true;
		}
		// if 2nd column tile location >= 80px && no more tiles have been produced
		if(tilesY[1]>=80 && !checkTilesProduce[1]) {
			// crete another tile
			tilesProduce();
			// set 2nd column tile flag = true
			checkTilesProduce[1] = true;
		}
		// if 3rd column tile location >= 80px && no more tiles have been produced
		if(tilesY[2]>=80 && !checkTilesProduce[2]) {
			// crete another tile
			tilesProduce();
			// set 3rd column tile flag = true
			checkTilesProduce[2] = true;
		}// if 4th column tile location >= 80px && no more tiles have been produced
		if(tilesY[3]>=80 && !checkTilesProduce[3]) {
			// crete another tile
			tilesProduce();
			// set 4th column tile flag = true
			checkTilesProduce[3] = true;
		}
		// if 1st column tile top is past the hit window (550px)
		if(tilesY[0]>=bottomBond) {
			// set game over flag = true
			over = true;
			// set play flag = false
			play = false;
			// set stop checking for tile locations = false
			tilesCheck[0]=false;
		}
		// if 2nd column tile is past the hit window (440px)
		if(tilesY[1]>=bottomBond) {
			// set game over flag = true
			over = true;
			// set play flag = false
			play=false;
			// set stop checking for tile locations = false
			tilesCheck[1]=false;
		}
		// if 3rd column tile is past the hit window (440px)
		if(tilesY[2]>=bottomBond) {
			// set game over flag = true
			over = true;
			// set play flag = false
			play=false;
			// set stop checking for tile locations = false
			tilesCheck[2]=false;
		}
		// if 4th column tile is past the hit window (440px)
		if(tilesY[3]>=bottomBond) {
			// set game over flag = true
			over = true;
			// set play flag = false
			play = false;
			// set stop checking for tile locations = false
			tilesCheck[3]=false;
		}
	}

	/**
	 * keyTyped(KeyEvent e)
	 * - handles keyboard events
	 * - {@literal @}override - Inherited method must override
	 * @param e the event to be processed
	 */
	@Override
	public void keyTyped(KeyEvent e) { }

	/**
	 * keyPressed(KeyEvent(KeyEvent e)
	 * - handles when a key is pressed down
	 * - {@literal @}override - Inherited method must override
	 * {@see @literal KeyEvent.java} for key reference
	 * @param e the event to be processed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// if (Down) key is pressed
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			// move(songChoice) = move + 1
			move+=1;
			// select box moves down 100px to highlight next choice
			selectRectY+=75;
			// if move(songChoice) = 6; past bottom of screen passed
			if(move==7)
				// reset move back to 1
				move=1; // move at bottom assumes select box at bottom
			// if select box is past bottom of screen
			if(selectRectY==650)
				//reset to first song at y=[100-200]px
				selectRectY=200;
		}
		// if (Up) key is pressed
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			// move(songChoice) = move - 1
			move-=1;
			// select box moves up 100px to highlight previous choice
			selectRectY-=75;
			// if move(songChoice) = 0; past top of screen passed
			if(move==0) // move at top assumes select box at top
				// reset move back to 5
				move=6;
			// if select box is past top of screen
			if(selectRectY==125)
				//reset to last song at y=[500-600]px
				selectRectY=575;
		}
		/*
		 * GAME STARTS HERE, conditions met:
		 * <go=true, play=true, startSong=true> + ENTER button pressed
		 */
		// if [go] game ready flag == true && (S) key is pressed
		if(go && e.getKeyCode() == KeyEvent.VK_1) {
			// set gameplay in progress flag = true
			play = true;
			// if start music flag == false
			if(!audioStatus)
				// set start game flag = true
				startSong = true;
			// start producing tiles
			tilesProduce();
		}
		// if ENTER key is pressed
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			// start game
			go = true;
		}
		// if game over  && ENTER button pressed
		if(over && e.getKeyCode() == KeyEvent.VK_ENTER) {
			// reset game (load initial values)
			initialValues();
		}
		// if game not over && button '1' pressed
		if(e.getKeyCode() == KeyEvent.VK_1 && !over) { // *HIT*
			// complement player
			complimentSize = 80;
			// if a tile in 1st column is outside hit zone (50px)
			if(tilesY[0]<tilesY[1] - MISTAKE || tilesY[0]<tilesY[2] - MISTAKE || tilesY[0]<tilesY[3] - MISTAKE) {
				// set game over flag = true
				over = true;
				// set foul flag = true
				foul = true;
				// set 1st column foul location
				foulPlace = 0;
				// sort tiles
				foulY = sortTilesY(tilesY);
			}
			// set 1st column foul flag = true
			key[0] = true;
		}
		// if game not over && button '2' pressed
		if(e.getKeyCode() == KeyEvent.VK_2 && !over) {
			// complement player
			complimentSize = 80;
			// if a tile in 2nd column is outside hit zone (50px)
			if(tilesY[1]<tilesY[0] - MISTAKE || tilesY[1]<tilesY[2] - MISTAKE || tilesY[1]<tilesY[3] - MISTAKE) {
				// set game over flag = true
				over = true;
				// set foul flag = true
				foul = true;
				// set 2nd column foul location
				foulPlace = 1;
				// sort tiles
				foulY = sortTilesY(tilesY);
			}
			// set 2nd column foul flag = true
			key[1] = true;
		}
		// if game not over && button '3' pressed
		if(e.getKeyCode() == KeyEvent.VK_3 && !over) {
			// complement player
			complimentSize = 80;
			// if a tile in 3rd column is outside hit zone (50px)
			if(tilesY[2]<tilesY[0] - MISTAKE || tilesY[2]<tilesY[1] - MISTAKE || tilesY[2]<tilesY[3] - MISTAKE ) {
				// set game over flag = true
				over = true;
				// set foul flag = true
				foul = true;
				// set 3rd column foul location
				foulPlace = 2;
				// sort tiles
				foulY = sortTilesY(tilesY);
			}
			// set 3rd column foul flag = true
			key[2] = true;
		}
		// if game not over && button '4' pressed
		if(e.getKeyCode() == KeyEvent.VK_4 && !over) {
			// complement player
			complimentSize = 80;
			// if a tile in 4th column is outside hit zone (50px)
			if(tilesY[3]<tilesY[0] - MISTAKE || tilesY[3]<tilesY[1] - MISTAKE || tilesY[3]<tilesY[2] - MISTAKE) {
				// set game over flag = true
				over = true;
				// set foul flag = true
				foul = true;
				// set 4th column foul location
				foulPlace = 3;
				// sort tiles
				foulY = sortTilesY(tilesY);
			}
			// set 4th column foul flag = true
			key[3] = true;
		}
	}

	/**
	 * keyReleased(KeyEvent e)
	 * - handles when a key is released
	 * - {@literal @}override - Inherited method must override
	 * @param e the event to be processed
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// if key '1' is released
		if(e.getKeyCode() == KeyEvent.VK_1) {
			// compliment player
			complimentSize = 50; // **HIT**
			// 1st column flag = false
			key[0] = false;
		}
		// if key '2' is released
		if(e.getKeyCode() == KeyEvent.VK_2) {
			// compliment player
			complimentSize = 50;
			// 2nd column flag = false
			key[1] = false;
		}
		// if key '3' is released
		if(e.getKeyCode() == KeyEvent.VK_3) {
			// compliment player
			complimentSize = 50;
			// 3rd column flag = false
			key[2] = false;
		}
		// if key '4' is released
		if(e.getKeyCode() == KeyEvent.VK_4) {
			// compliment player
			complimentSize = 50;
			// 4th column flag = false
			key[3] = false;
		}
		// if key '1' is pressed && tile is inside hit zone
		if(e.getKeyCode() == KeyEvent.VK_1 && tilesCheck[0] && tilesY[0]>200) {
			// create new ScoreCalculate object
			ScoreCalculate scoreCalculate = new ScoreCalculate();
			// calculate score for correct tile
			compliment = scoreCalculate.score(tilesY[0]);
			// if perfect hit
			if(compliment.equals("Perfect"))
				// score = score + 3
				score += 3;
				// if good hit
			else if(compliment.equals("Great"))
				// score = score + 2
				score += 2;
				// else all other non-misses
			else
				// score = score + 1
				score +=1;
			// set 1st column flag = false
			key[0] = false;
			// set check for bad hits = false
			tilesCheck[0] = false;
			// set check for tile clearance column = false
			checkTilesProduce[0] = false;
			// set up to create new tile
			tilesY[0] = -150;
			// send another tile
			tilesProduce();
		}
		// if key '2' is pressed && tile is inside hit zone
		if(e.getKeyCode() == KeyEvent.VK_2 && tilesCheck[1] && tilesY[1]>200) {
			// create new ScoreCalculate object
			ScoreCalculate scoreCalculate = new ScoreCalculate();
			// calculate score for correct tile
			compliment = scoreCalculate.score(tilesY[1]);
			// if perfect hit
			if(compliment.equals("Perfect"))
				// score = score + 3
				score += 3;
				// if good hit
			else if(compliment.equals("Great"))
				// score = score + 2
				score += 2;
				// else all other non-misses
			else
				// score = score + 1
				score += 1;
			// set 2nd column flag = false
			key[1] = false;
			// set check for bad hits = false
			tilesCheck[1] = false;
			// set check for tile clearance column = false
			checkTilesProduce[1] = false;
			// set up to create new tile
			tilesY[1] = -150;
			// send another tile
			tilesProduce();
		}
		// if key '3' is pressed && tile is inside hit zone
		if(e.getKeyCode() == KeyEvent.VK_3 && tilesCheck[2] && tilesY[2]>200) {
			// create new ScoreCalculate object
			ScoreCalculate scoreCalculate = new ScoreCalculate();
			// calculate score for correct tile
			compliment = scoreCalculate.score(tilesY[2]);
			// if perfect hit
			if(compliment.equals("Perfect"))
				// score = score + 3
				score += 3;
				// if good hit
			else if(compliment.equals("Great"))
				// score = score + 2
				score += 2;
				// else all other non-misses
			else
				// score = score + 1
				score += 1;
			// set 3rd column flag = false
			key[2] = false;
			// set check for bad hits = false
			tilesCheck[2] = false;
			// set check for tile clearance column = false
			checkTilesProduce[2] = false;
			// set up to create new tile
			tilesY[2] = -150;
			// send another tile
			tilesProduce();
		}
		// if key '4' is pressed && tile is inside hit zone
		if(e.getKeyCode() == KeyEvent.VK_4 && tilesCheck[3] && tilesY[3]>200) {
			// create new ScoreCalculate object
			ScoreCalculate scoreCalculate = new ScoreCalculate();
			// calculate score for correct tile
			compliment = scoreCalculate.score(tilesY[3]);
			// if perfect hit
			if(compliment.equals("Perfect"))
				// score = score + 3
				score += 3;
				// if good hit
			else if(compliment.equals("Great"))
				// score = score + 2
				score += 2;
				// else all other non-misses
			else
				// score = score + 1
				score += 1;
			// set 4th column flag = false
			key[3] = false;
			// set check for bad hits = false
			tilesCheck[3] = false;
			// set check for tile clearance column = false
			checkTilesProduce[3] = false;
			// set up to create new tile
			tilesY[3] = -150;
			// send another tile
			tilesProduce();
		}
	}

	/**
	 * sortTilesY(int[] tilesY)
	 * takes an array of tile y positions, sorts them
	 * - then returns them into play sorted.
	 * @param tilesY integer array of tile y positions
	 * @return sorted array of y position integers
	 */
	public int sortTilesY (int[] tilesY) {
		// create an array of integers
		int[] sort = new int[4];
		// iterate through the two arrays
		for(int i = 0; i < 4; i++) {
			// store tilesY in sort
			sort[i] = tilesY[i];
		}
		// sort the sort array
		Arrays.sort(sort);
		// return the sorted array
		return sort[3];
	}

}
