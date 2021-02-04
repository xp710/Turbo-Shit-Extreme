package edu.stuy.starlorn.sound;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
	//Objects
	private AudioInputStream ais;
	private Clip clip;

	//Constructor
	public AudioPlayer(String filename, boolean loop)
		throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{
		ais = AudioSystem.getAudioInputStream(getClass().getResource(filename));
		clip = AudioSystem.getClip();
		clip.open(ais);
		if (loop)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	//Methods
	public void play(){
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void close(){
		clip.stop();
		clip.close();
	}
}