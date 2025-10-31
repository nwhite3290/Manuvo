
/*
 * Audio.java
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio {
	String[] song = {"Music/1.wav", "Music/2.wav", "Music/3.wav", "Music/4.wav",  "Music/5.wav", "Music/background.wav",};
	Clip clip;
	AudioInputStream audioInputStream;

	public Audio() {
	}

	public Audio(int s) {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(song[s]).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playAudio() {
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stopAudio() {
		clip.stop();
	}
}
