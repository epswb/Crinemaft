package mob;

import java.util.Vector;

public class MobManager 
{
	MobSpawner animalspawner;
	MobSpawner monsterspawner;
	Vector<Mob> moblist = new Vector<Mob>();
	
	public MobManager()
	{
		animalspawner = new MobSpawner(MobSpawner.TYPE_ANIMALS);
		monsterspawner = new MobSpawner(MobSpawner.TYPE_MONSTERS);
	}
	
	public void spawnAnimals()
	{
		animalspawner.spawn();
	}
	
	public void spawnMonsters()
	{
		monsterspawner.spawn();
	}
}
