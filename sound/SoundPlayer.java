package sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer 
{
	Clip clip;
	File file;
	
	public SoundPlayer(File f)
	{
		file = f;
	}
		
	public void playSound()
	{
		try{
				
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
		        
		    clip = AudioSystem.getClip();
		        
		    clip.open(audioIn);
		    clip.start();
		
		} catch (Exception e){}
	}
		
	public boolean clipIsStillRunning()
	{
		if (clip != null)
		{
			return clip.isRunning();
		}
		return false;
	}
}
