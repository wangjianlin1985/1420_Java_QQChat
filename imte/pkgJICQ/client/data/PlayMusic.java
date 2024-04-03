package pkgJICQ.client.data;

import com.sun.media.sound.*;
import java.io.*;

public class PlayMusic {
	String path = System.getProperty("user.dir");

	static FileInputStream ff;

	public PlayMusic() {

	}

	public void play(String url) {
		JavaSoundAudioClip player;
		try {
			ff = new FileInputStream(path + "\\music\\" + url);
			player = new JavaSoundAudioClip(ff);
			player.play();
			ff.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void gofolder() {
		play("folder.wav");
	}

	public void goline() {
		play("online.wav");
	}

	public void gomsg() {
		play("msg.wav");
	}

	public void gosystem() {
		play("system.wav");
	}

	public static void main(String[] args) {
		PlayMusic pl = new PlayMusic();
		pl.gomsg();
	}
}