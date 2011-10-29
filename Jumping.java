


class Jumping implements Runnable
{
	float JumpDistance;
	float i = 0;
	
	public Jumping(float jdistance)
	{
		JumpDistance = jdistance;
	}
	
	public void run() 
	{
		if (main.Player.blockposY > 0)
		{
			
			
			for (i = 0; i < JumpDistance; i+=0.25)
			{
				main.Player.blockposY -= 0.25;
				
				main.UserView.manageVerticalScrollUp();
				
				try{
					Thread.sleep(10);
				}catch(Exception e){}
			}
			main.Physics.threadstarted = false;
			main.Physics.walkingblocked = false;
			main.Physics.upperpoint = 1;
			
			if (main.Player.blockposY < 89.25 && JumpDistance == 2)
			{
				main.UserView.manageVerticalScrollUp();
				main.UserView.Y+=0.25;
			}
		}
	}
	
}