

class physics
{
	
	boolean threadstarted;
	boolean walkingblocked;
	int upperpoint = 0;
	boolean bigstep = false;
	boolean jumped;
	boolean walkleft, walkright;
	float turnposition;
	
	
	public void doGravity()
	{
		
		if (main.Physics.collisiondown() == false && threadstarted == false && upperpoint == 0)
		{
			if (main.Player.walkingleft() == true && (main.Player.blockposX % 1) < 0.25)
			{
				Falling fall = new Falling(1);
				Thread t = new Thread(fall);
				t.start();
				threadstarted = true;
				walkingblocked = true;
			}
			
			else if (main.Player.walkingleft() == false && (main.Player.blockposX % 1) >= -0.25)
			{
				Falling fall = new Falling(1);
				Thread t = new Thread(fall);
				t.start();
				threadstarted = true;
				walkingblocked = true;
			}
		}
	}
	
	public void jump(int JDis)
	{
		if (collisiondown() == true && threadstarted == false && collisionup() == false && main.Block.BlockwillCollide(main.World.get((int)main.Player.blockPositionX(), (int)main.Player.blockPositionY()-5)) == false)
		{
			Jumping jump = new Jumping(JDis);
			Thread t = new Thread(jump);
			t.start();
			threadstarted = true;
			walkingblocked = true;
		}
		if (collisiondown() == true && threadstarted == false && collisionup() == false && main.Block.BlockwillCollide(main.World.get((int)main.Player.blockPositionX(), (int)main.Player.blockPositionY()-5)) == true)
		{
			Jumping jump = new Jumping(1);
			Thread t = new Thread(jump);
			t.start();
			threadstarted = true;
			walkingblocked = true;
		}
	}
	
	public void changes()
	{
		changeDungeonToSky();
		manageLiquidFlow();
		manageBlockGravity();
		manageDirtDeepDirt();
	}
	
	

	public void changeDungeonToSky()
	{
		for (int i = 0; i < 1000; i++)
		{
			 for (int o = 0; o < 100; o++)
			 {
				 if (main.World.get(i, o) == block.dungeon())
				 {
					 int skycounter = 0;
					 
					 
					 if (block.BlockwillCollide(main.World.get(i - 1, o)) == false && main.World.get(i - 1, o) != block.dungeon())
					 {
						 
						 skycounter++;
					 }
					 if (block.BlockwillCollide(main.World.get(i - 1, o)) == false && main.World.get(i - 1, o) != block.dungeon())
					 {
						 
						 skycounter++;
					 }
					 if (block.BlockwillCollide(main.World.get(i - 1, o)) == false && main.World.get(i - 1, o) != block.dungeon())
					 {
						 
						 skycounter++;
					 }
					 if (block.BlockwillCollide(main.World.get(i - 1, o)) == false && main.World.get(i - 1, o) != block.dungeon())
					 {
						 
						 skycounter++;
					 }
					 
					 if (skycounter >= 2)
					 {
						 main.World.set(i, o, block.sky());
					 }
				 }
			 }
		}
	}
	
	public void manageLiquidFlow() 
	{
		for (int i = 0; i < 1000; i++)
		{
			 for (int o = 0; o < 100; o++)
			 {
				 if (main.World.get(i, o) == block.lava() || main.World.get(i, o) == block.water())
				 {
					 if (main.World.get(i, o+1) == block.dungeon() || main.World.get(i, o+1) == block.sky())
					 {
						 main.World.set(i, o+1, main.World.get(i, o));
					 }
					 if (main.World.get(i+1, o) == block.dungeon() || main.World.get(i+1, o) == block.sky())
					 {
						 main.World.set(i+1, o, main.World.get(i, o));
					 }
					 if (main.World.get(i-1, o) == block.dungeon() || main.World.get(i-1, o) == block.sky())
					 {
						 main.World.set(i-1, o, main.World.get(i, o));
					 }
				 }
			 }
		}
		
	}
	
	public void manageBlockGravity()
	{
		for (int i = 0; i < 1000; i++)
		{
			 for (int o = 0; o < 100; o++)
			 {
				 if (main.World.get(i, o) == block.dungeon() || main.World.get(i, o) == block.sky() || main.World.get(i, o) == block.water() || main.World.get(i, o) == block.lava())
				 {
					 if (o > 0 && block.BlockGravity(main.World.get(i, o-1)))
					 {
						 main.World.set(i, o, main.World.get(i, o-1));
						 main.World.set(i, o-1, block.sky());
					 }
				 }
			 }
		}
	}
	
	public void manageDirtDeepDirt()
	{
		for (int i = 0; i < 1000; i++)
		{
			for (int o = 0; o < 100; o++)
			{
				if (main.World.get(i, o) == block.deepdirt() && block.BlockwillCollide(main.World.get(i, o - 1)) == false)
				{
					main.World.set(i, o, block.dirt());
				}
				
				else if (main.World.get(i, o) == block.dirt() && block.BlockwillCollide(main.World.get(i, o - 1)) == true)
				{
					main.World.set(i, o, block.deepdirt());
				}
			}
		}
	}
	
	public boolean collisionleft()
	{
		if (block.BlockwillCollide(main.World.get((int) (main.Player.blockposX-1 - main.Player.blockposX % 1), (int) (main.Player.blockposY-2 - main.Player.blockposY % 1))) == true)
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	public boolean collisionright()
	{
		
		if (block.BlockwillCollide(main.World.get((int) (main.Player.blockposX+1 - main.Player.blockposX % 1), (int) (main.Player.blockposY-2 - main.Player.blockposY % 1))) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean collisionup()
	{
		if (block.BlockwillCollide(main.World.get((int) (main.Player.blockposX - main.Player.blockposX % 1), (int) (main.Player.blockposY-4 - main.Player.blockposY % 1))) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean collisiondown()
	{
		if (block.BlockwillCollide(main.World.get((int) (main.Player.blockposX - main.Player.blockposX % 1), (int) (main.Player.blockposY - main.Player.blockposY % 1))) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean collisionleftdown()
	{
		if (block.BlockwillCollide(main.World.get((int) (main.Player.blockposX-1 - main.Player.blockposX % 1), (int) (main.Player.blockposY-1 - main.Player.blockposY % 1))) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean collisionleftup()
	{
		if (block.BlockwillCollide(main.World.get((int) (main.Player.blockposX-1 - main.Player.blockposX % 1), (int) (main.Player.blockposY-3 - main.Player.blockposY  % 1))) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean collisionrightdown()
	{
		if (block.BlockwillCollide(main.World.get((int) (main.Player.blockposX+1 - main.Player.blockposX % 1), (int) (main.Player.blockposY-1 - main.Player.blockposY % 1))) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean collisionrightup()
	{
		if (block.BlockwillCollide(main.World.get((int) (main.Player.blockposX+1 - main.Player.blockposX % 1), (int) (main.Player.blockposY-3 - main.Player.blockposY % 1))) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}