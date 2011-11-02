package sound;

import java.io.File;

import javax.sound.sampled.Clip;

public class Sound 
{
	File sound;
	static Clip clip;
	
	public Sound(String path)
	{
		sound = new File(path);
	}
	
	public File getSound()
	{
		return sound;
	}
}
