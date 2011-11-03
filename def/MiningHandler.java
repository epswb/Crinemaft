package def;

import sound.SoundEffect;


class MiningHandler
{
	int WorkingBlockX, PlayerPosX, WorkingBlockY, PlayerPosY;
	Mining m;
	Thread t;
	boolean miningAlready = false;
	
	public void handle()
	{
		
		if (main.PK.LeftMouse() == true && main.inv.inventoryMode == false)
		{
			handleLM();
		}
		else if (main.PK.RightMouse() == true && main.inv.inventoryMode == false)
		{
			handleRM();
		}
		
//		else if (main.PK.LeftMouse() == true && main.inv.inventoryMode == true)
//		{
//			
//		}
//		
//		else if (main.PK.RightMouse() == true && main.inv.inventoryMode == true)
//		{
//			
//		}
		
		handleMining();
	}
	
	public void handleLM()
	{
		WorkingBlockX = (int) (main.PK.MouseX / 32 + main.UserView.X);
		PlayerPosX = (int) (main.Player.posX / 32 + main.UserView.X);
		WorkingBlockY = (int) (main.PK.MouseY / 32 + main.UserView.Y);
		PlayerPosY = (int) (main.Player.posY / 32 + main.UserView.Y);
		
		if (block.BlockwillCollide(main.World.get(WorkingBlockX, WorkingBlockY)) == true && main.World.get(WorkingBlockX, WorkingBlockY) != 20)
		{
			int differenzX = PlayerPosX - WorkingBlockX;
			int differenzY = PlayerPosY - WorkingBlockY;
			
			differenzX = Math.abs(differenzX);
			differenzY = Math.abs(differenzY);
			
			if (differenzX <= 3 && differenzY <= 3 && miningAlready == false)
			{
				m = new Mining(WorkingBlockX, WorkingBlockY, 100);
				miningAlready = true;
			}
		}
	}
	
	public void handleRM()
	{
		WorkingBlockX = (int) (main.PK.MouseX / 32 + main.UserView.X);
		PlayerPosX = (int) (main.Player.posX / 32 + main.UserView.X);
		WorkingBlockY = (int) (main.PK.MouseY / 32 + main.UserView.Y);
		PlayerPosY = (int) (main.Player.posY / 32 + main.UserView.Y);
		
		if (main.World.get(WorkingBlockX, WorkingBlockY) == block.sky() || main.World.get(WorkingBlockX, WorkingBlockY) == block.dungeon() || main.World.get(WorkingBlockX, WorkingBlockY) == block.water() || main.World.get(WorkingBlockX, WorkingBlockY) == block.lava())
		{
			if (block.BlockwillCollide(main.World.get(WorkingBlockX + 1, WorkingBlockY)) || block.BlockwillCollide(main.World.get(WorkingBlockX - 1, WorkingBlockY)) || block.BlockwillCollide(main.World.get(WorkingBlockX, WorkingBlockY + 1)) || block.BlockwillCollide(main.World.get(WorkingBlockX, WorkingBlockY - 1)))
			{
				if (main.Player.blockPositionX() == Math.round(main.Player.blockPositionX()))
				{
//					if ((WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 1) || (WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 2) || (WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 3))
					{
						if (WorkingBlockX - main.Player.blockposX <= 3 && WorkingBlockX - main.Player.blockposX >= -3 && WorkingBlockY - main.Player.blockposY <= 0 && WorkingBlockY - main.Player.blockposY >= -4)
						{
							main.World.set(WorkingBlockX, WorkingBlockY, main.inv.ausgewählterBlock());
							main.inv.inventory.get(main.hud.LeisteZeiger).anzahl--;
							main.soundmanager.BlockEffect(main.inv.ausgewählterBlock());
						}
					}
				}
				
				else if (main.Player.blockPositionX() > Math.round(main.Player.blockPositionX()))
				{
//					if ((WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 1) || (WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 2) || (WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 3) || (WorkingBlockX != main.Player.blockPositionX() + 1 && WorkingBlockY != main.Player.blockPositionY() - 1) || (WorkingBlockX != main.Player.blockPositionX() + 1 && WorkingBlockY != main.Player.blockPositionY() - 2) || (WorkingBlockX != main.Player.blockPositionX() + 1 && WorkingBlockY != main.Player.blockPositionY() - 3))
					{
						if (WorkingBlockX - main.Player.blockposX <= 3 && WorkingBlockX - main.Player.blockposX >= -3 && WorkingBlockY - main.Player.blockposY <= 0 && WorkingBlockY - main.Player.blockposY >= -4)
						{
							main.World.set(WorkingBlockX, WorkingBlockY, main.inv.ausgewählterBlock());
							main.inv.inventory.get(main.hud.LeisteZeiger).anzahl--;
							main.soundmanager.BlockEffect(main.inv.ausgewählterBlock());
						}
					}
				}
				
				else if (main.Player.blockPositionX() < Math.round(main.Player.blockPositionX()))
				{
//					if ((WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 1) || (WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 2) || (WorkingBlockX != main.Player.blockPositionX() && WorkingBlockY != main.Player.blockPositionY() - 3) || (WorkingBlockX != main.Player.blockPositionX() - 1 && WorkingBlockY != main.Player.blockPositionY() - 1) || (WorkingBlockX != main.Player.blockPositionX() - 1 && WorkingBlockY != main.Player.blockPositionY() - 2) || (WorkingBlockX != main.Player.blockPositionX() - 1 && WorkingBlockY != main.Player.blockPositionY() - 3))
					{
						if (WorkingBlockX - main.Player.blockposX <= 3 && WorkingBlockX - main.Player.blockposX >= -3 && WorkingBlockY - main.Player.blockposY <= 0 && WorkingBlockY - main.Player.blockposY >= -4)
						{
							main.World.set(WorkingBlockX, WorkingBlockY, main.inv.ausgewählterBlock());
							main.inv.inventory.get(main.hud.LeisteZeiger).anzahl--;
							main.soundmanager.BlockEffect(main.inv.ausgewählterBlock());
						}
					}
				}
			}
		}
	}
	

	public void handleMining()
	{
		if (miningAlready == true)
		{
			if (m.stimmtNochAlles((int) (main.PK.MouseX / 32 + main.UserView.X), (int) (main.PK.MouseY / 32 + main.UserView.Y)) == false && main.PK.leftmouse == false)
			{
				m.destroy = true;
			}
			
			else if (m.stimmtNochAlles((int) (main.PK.MouseX / 32 + main.UserView.X), (int) (main.PK.MouseY / 32 + main.UserView.Y)) == true && main.PK.leftmouse == true)
			{
				m.nextStep();
				
				if (main.Player.armstate == 4)
				{
					main.Player.armGoesUp = false;
				}
				else if (main.Player.armstate == 0)
				{
					main.Player.armGoesUp = true;
				}
				
				if (main.Player.armGoesUp == false)
				{
					main.Player.armstate--;
				}
				else
				{
					main.Player.armstate++;
				}
			}
			
			else
			{
				m.destroy = true;
			}
		}
		
		if (miningAlready == true)
		{
			if (m.destroy == true)
			{
				m = null;
				miningAlready = false;
			}
		}
	}
	
	public void abbauen(int bx, int by)
	{
		if (main.World.get(bx, by-1) == block.flower())
		{
			main.World.set(bx, by-1, block.sky());
		}
		
		int detail = -1;
		int bID = main.World.get(bx, by);
		
		if (bID == block.dirt() || bID == block.deepdirt())
		{
			detail = SoundEffect.SE_DETAIL_GRASS;
		}
		else if (bID == block.wood())
		{
			detail = SoundEffect.SE_DETAIL_WOOD;
		}
		else if (bID == block.stone())
		{
			detail = SoundEffect.SE_DETAIL_STONE;
		}
		else if (bID == block.gravel())
		{
			detail = SoundEffect.SE_DETAIL_GRAVEL;
		}
		
		if (detail > -1)
		{
			main.soundmanager.playStepEffect(new SoundEffect(
					SoundEffect.SE_TYPE_MATERIAL, detail, (int)(Math.random()*2)));
		}
				
		main.World.set(bx, by, block.dungeon());
		
		
	}
}











