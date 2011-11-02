package sound;

import def.block;
import def.main;

public class SoundManager 
{
	int actualMusic;
	private SoundPlayer musicplayer, stepeffectplayer;
	
	public SoundManager(main MAIN)
	{
		actualMusic = (int) (Math.random()*7);
		musicplayer = new SoundPlayer(main.soundstorer.musicList.get(actualMusic).getSound());
	}
	
	public void manageSound()
	{
		manageMusic();
	}
	
	public void manageMusic()
	{
		
		if (musicplayer.clipIsStillRunning() == false)
		{
			actualMusic = (int) (Math.random()*7);
			musicplayer = new SoundPlayer(main.soundstorer.musicList.get(actualMusic).getSound());
			startNewMusicClip();
		}
		
	}
	
	public void playStepEffect(SoundEffect se)
	{
		stepeffectplayer = new SoundPlayer(main.soundstorer.getStepEffect(
				se.DETAIL, se.NUMBER).getSound());
		stepeffectplayer.playSound();
	}
	
	public void startNewMusicClip()
	{
		musicplayer.playSound();
		System.out.println(actualMusic);
	}
	
	public void placingBlockEffect(int blockID)
	{
		int detail = -1;
		
		if (blockID == block.dirt() || blockID == block.deepdirt())
		{
			detail = SoundEffect.SE_DETAIL_GRASS;
		}
		else if (blockID == block.wood())
		{
			detail = SoundEffect.SE_DETAIL_WOOD;
		}
		else if (blockID == block.stone())
		{
			detail = SoundEffect.SE_DETAIL_STONE;
		}
		else if (blockID == block.gravel())
		{
			detail = SoundEffect.SE_DETAIL_GRAVEL;
		}
		
		if (detail > -1)
		{
			main.soundmanager.playStepEffect(new SoundEffect(
					SoundEffect.SE_TYPE_MATERIAL, detail, (int)(Math.random()*2)));
		}
	}
}
