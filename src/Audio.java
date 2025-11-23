
/*
 * Audio.java
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Audio class
 * - Handles the audio files
 *  - starts and stops the music
 */
public class Audio {
    // background song is song[0] " Someone you Loved"
	String[] song = {
			"Music/1.wav", // song[0] "Someone you Loved"
			"Music/2.wav", // song[1] "Memories"
			"Music/3.wav", // song[2] "Counting Stars"
			"Music/4.wav", // song[3] "Fur Elise"
			"Music/5.wav", // song[4] "Canon"
			"Music/6.wav", // song[5] "Moonlight Sonata"
            "Music/7.wav"  // song[6] "Nocturne"
	};
	// preloaded audio track
	Clip clip;
	// audio sample
	AudioInputStream audioInputStream;

	/**
	 * Audio()
	 * - constructor creates a new Audio object
	 */
	public Audio() {
	}

	/**
	 * Audio(int s)
	 * - chooses a song based on the number passed into the method
	 *  - request songs (0 - 6) or change the number above when adding more music
	 * @param s song number
	 */
	public Audio(int s) {
		// try to create a song clip
		try {
			// song file
			audioInputStream = AudioSystem.getAudioInputStream(new File(song[s]).getAbsoluteFile());
			// chosen piece of song to play
			clip = AudioSystem.getClip();
			// open the audioInputStream file as a clip
			clip.open(audioInputStream);
			// catch exception unable to read files
		} catch (Exception e) {
			// catch exception unable to read files
			System.out.println(e.getMessage());
			System.out.println("Audio/public Audio(int s)");
		}
	}

	/**
	 * playAudio()
	 * - starts playing the clip as a continuous music loop
	 */
	public void startAudio() {
		// start the music
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	/**
	 * stopAudio()
	 * - stops playing the continuous music loop clip
	 */
	public void stopAudio() {
		// stop the music
		clip.stop();
	}
}
