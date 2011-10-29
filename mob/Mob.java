package mob;

public class Mob 
{
	int mobID;
	float blockposX, blockposY;
	
	
	public Mob(int MobID, float blockposx, float blockposy)
	{
		mobID = MobID;
		blockposX = blockposx;
		blockposY = blockposy;
	}
	
	
	
	public static int sheep = 0;
	public static int cow = 1;
	public static int pig = 2;
	public static int zombie = 3;
	public static int creeper = 4;
	public static int wolf = 5;
}
