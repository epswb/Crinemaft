


class Mining
{
	int BX, BY, AbbauDauer, i = 0;
	boolean destroy;
	
	public Mining(int blockX, int blockY, int abbaudauer)
	{
		BX = blockX;
		BY = blockY;
		AbbauDauer = abbaudauer;
		destroy = false;
	}
	
	public void nextStep() 
	{
		if (i == AbbauDauer)
		{
			if (destroy == false)
			{
				main.mininghandler.abbauen(BX, BY);
				main.mininghandler.miningAlready = false;
				
			}
			
			
		}
		
		else
		{
			i += 10;
		}
		
	}
	
	public boolean stimmtNochAlles(int x, int y)
	{
		if (x == BX && y == BY)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}