package sound;

import java.util.Vector;

public class SoundStorer 
{
	Vector<Sound> musicList = new Vector<Sound>();
	Sound[][] stepEffects = new Sound[4][2];
	
	public SoundStorer()
	{
		musicList.add(new Sound("C:\\Crinemaft\\sound\\music\\piano1.wav"));
		musicList.add(new Sound("C:\\Crinemaft\\sound\\music\\hal2.wav"));
		musicList.add(new Sound("C:\\Crinemaft\\sound\\music\\piano3.wav"));
		musicList.add(new Sound("C:\\Crinemaft\\sound\\music\\nuance1.wav"));
		musicList.add(new Sound("C:\\Crinemaft\\sound\\music\\hal1.wav"));
		musicList.add(new Sound("C:\\Crinemaft\\sound\\music\\piano2.wav"));
		musicList.add(new Sound("C:\\Crinemaft\\sound\\music\\nuance2.wav"));
		
	}
	
	public Sound getStepEffect(int detail, int number)
	{
		if (stepEffects[detail][number] != null)
		{
			return stepEffects[detail][number];
		}
		
		else
		{
			Sound s = new Sound("C:\\Crinemaft\\sound\\material\\" + detail + "\\" + number + ".wav");
			stepEffects[detail][number] = s;
			
			return stepEffects[detail][number];
		}
	}
	
	
}
