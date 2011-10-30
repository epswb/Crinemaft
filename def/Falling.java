package def;



class Falling implements Runnable
{
	float FallDistance;
	float i = 0;
	
	public Falling(float falldistance)
	{
		FallDistance = falldistance;
	}
	
	public void run() 
	{
		for (i = 0; i < FallDistance; i+=0.25)
		{
			main.Player.blockposY += 0.25;
			
			main.UserView.manageVerticalScrollDown();
			
			try{
				Thread.sleep(10);
			}catch(Exception e){}
		}
		main.Physics.threadstarted = false;
		main.Physics.walkingblocked = false;
		
	
	
	}
	
	
	
	
}