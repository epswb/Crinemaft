package mob;

import java.awt.Dimension;

public class MobAttributes 
{
	
	public MobAttributes()
	{
		
	}
	
	public static Dimension getSizeinBlocks(int mobID)
	{
		if (mobID == Mob.cow)
		{
			return new Dimension(2, 2);
		}		
		else if (mobID == Mob.sheep)
		{
			return new Dimension(2, 2);
		}
		else if (mobID == Mob.pig)
		{
			return new Dimension(2, 2);
		}
		else if (mobID == Mob.wolf)
		{
			return new Dimension(2, 1);
		}
		else if (mobID == Mob.zombie)
		{
			return new Dimension(1, 2);
		}
		else if (mobID == Mob.creeper)
		{
			return new Dimension(1, 2);
		}
		else
		{
			System.out.println("Unknown mobID");
			return null;
		}

	}
}
