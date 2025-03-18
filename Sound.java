package main;

import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax. sound.sampled.Clip;
import javax.sound.sampled.LineEvent.Type;
import javax. sound.sampled.*;

public class Sound {
	
	Clip musicClip;
	URL url[] = new URL[10];

	public Sound() {
		url[0] = getClass().getResource("/delete line.wav");
		url[1] = getClass().getResource("/gameover.wav");
		url[2] = getClass().getResource("/rotation.wav");
		url[3] = getClass().getResource("/touch floor.wav");
	}
	public void play(int i, boolean music) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(url[i]);
		Clip clip = AudioSystem.getClip();
		
		if(music) {
			 musicClip = clip;
		}
		clip.open(ais);
		clip.addLineListener(new LineListener() {
			public void update(LineEvent event) {
				if(event.getType() == Type.STOP) {
					clip.close();
				}
			}
		});
		ais.close();
		clip.start();
		}
		catch(Exception e) {
			
		}
	}
	public void loop() {
		musicClip.loop(Clip.LOOP_CONTINUOUSLY);
	
	}
	public void stop() {
		musicClip.stop();
		musicClip.close();
	}
}
