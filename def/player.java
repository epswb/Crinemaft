package def;


class player
{
	
	public int posX, posY, WalkState = 0;
	public boolean WalkingLeft = false;
	public int actualImg = 0;
	public float blockposX = 11, blockposY = 13;
	public int armstate = 0;
	public int leben = 10;
	public boolean armGoesUp = true;
	
	
	public player(int posx, int posy)
	{
		posX = posx;
		posY = posy;
	}
	
	public void walkRight()
	{
		if (main.Physics.bigstep == false && main.Physics.walkingblocked == false)
		{
			main.Player.WalkingLeft = false;
			
			main.Player.blockposX += 0.25;
			main.UserView.manageSideScrollRight();
			
			if (main.Player.walkstate() == 5)
			{
				if (main.Player.actualImg == 0)
				{
					main.Player.actualImg = 1;
				}
				else
				{
					main.Player.actualImg = 0;
				}
				main.Player.WalkState = 0;
			}
			else
			{
				main.Player.WalkState++;
			}
			
			if ((main.Player.blockposX % 1) == 0 && (Math.random()*5) > 4)
			{
				main.soundmanager.BlockEffect(main.World.get((int) blockposX, (int) blockposY));
			}
		}
		
		else if (main.Physics.bigstep == true && main.Physics.walkingblocked == false)
		{
			main.Player.WalkingLeft = false;
			main.Player.blockposX += 0.5;
			main.UserView.X += 0.5;
		}
	}
	
	public void walkLeft()
	{
		if (main.Physics.bigstep == false && main.Physics.walkingblocked == false)
		{
			main.Player.WalkingLeft = true;
			
			main.Player.blockposX -= 0.25;
			main.UserView.manageSideScrollLeft();
			
			if (main.Player.walkstate() == 5)
			{
				if (main.Player.actualImg == 0)
				{
					main.Player.actualImg = 1;
				}
				else
				{
					main.Player.actualImg = 0;
				}
				main.Player.WalkState = 0;
			}
			else
			{
				main.Player.WalkState++;
			}
			
			if ((main.Player.blockposX % 1) == 0 && (Math.random()*5) > 4)
			{
				main.soundmanager.BlockEffect(main.World.get((int) blockposX, (int) blockposY));
			}
		}
		
		else if (main.Physics.bigstep == true && main.Physics.walkingblocked == false)
		{
			main.Player.WalkingLeft = true;
			main.Player.blockposX -= 0.5;
			main.UserView.X -= 0.5;
		}
	}
	
	public float blockPositionX()
	{
		return blockposX;
	}
	
	public float blockPositionY()
	{
		return blockposY;
	}
	
	public int walkstate()
	{
		return WalkState;
	}
	
	public boolean walkingleft()
	{
		return WalkingLeft;
	}
	
}