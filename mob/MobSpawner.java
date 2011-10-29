package mob;

public class MobSpawner 
{
	int SpawnerType;
	
	public MobSpawner(int MobSpawnerType)
	{
		SpawnerType = MobSpawnerType;
	}
	
	public void spawn()
	{
		if (SpawnerType == TYPE_ANIMALS)
		{
			spawnSheeps(2);
			spawnCows(2);
			spawnPigs(2);
		}
		
		else if (SpawnerType == TYPE_MONSTERS)
		{
			spawnCreepers(2);
			spawnZombies(2);
			spawnWolves(2);
		}
	}
	
	public double generateRandomX()
	{
		return Math.random()*1000;
	}
	
	public double generateRandomY()
	{
		return Math.random()*100;
	}
	
	
	public void spawnSheeps(int n)
	{
		while (true)
		{
			int X = (int) generateRandomX();
			int Y = (int) generateRandomY();
			
			double width = MobAttributes.getSizeinBlocks(Mob.sheep).getWidth();
			double height = MobAttributes.getSizeinBlocks(Mob.sheep).getHeight();
			
			//test if random block intersects with main.world.get(X,Y)
			//if not, then break
		}
	
	}
	public void spawnCows(int n)
	{
		while (true)
		{
			int X = (int) generateRandomX();
			int Y = (int) generateRandomY();
			
			double width = MobAttributes.getSizeinBlocks(Mob.sheep).getWidth();
			double height = MobAttributes.getSizeinBlocks(Mob.sheep).getHeight();
		}
	}
	public void spawnPigs(int n)
	{
		while (true)
		{
			int X = (int) generateRandomX();
			int Y = (int) generateRandomY();
			
			double width = MobAttributes.getSizeinBlocks(Mob.sheep).getWidth();
			double height = MobAttributes.getSizeinBlocks(Mob.sheep).getHeight();
		}
	}
	public void spawnCreepers(int n)
	{
		while (true)
		{
			int X = (int) generateRandomX();
			int Y = (int) generateRandomY();
			
			double width = MobAttributes.getSizeinBlocks(Mob.sheep).getWidth();
			double height = MobAttributes.getSizeinBlocks(Mob.sheep).getHeight();
		}
	}
	public void spawnZombies(int n)
	{
		while (true)
		{
			int X = (int) generateRandomX();
			int Y = (int) generateRandomY();
			
			double width = MobAttributes.getSizeinBlocks(Mob.sheep).getWidth();
			double height = MobAttributes.getSizeinBlocks(Mob.sheep).getHeight();
		}
	}
	public void spawnWolves(int n)
	{
		while (true)
		{
			int X = (int) generateRandomX();
			int Y = (int) generateRandomY();
			
			double width = MobAttributes.getSizeinBlocks(Mob.sheep).getWidth();
			double height = MobAttributes.getSizeinBlocks(Mob.sheep).getHeight();
		}
	}
	
	public static int TYPE_ANIMALS = 0;
	public static int TYPE_MONSTERS = 1;
}
