


class userview
{
	float X = 0, Y = 0;
	
	public userview(int x, int y)
	{
		X = x;
		Y = y;
	}
	
	public float userviewX()
	{
		return X;
	}
	
	public float userviewY()
	{
		return Y;
	}
	
	public void manageSideScrollRight()
	{
		this.X += 0.25;
	}
	
	public void manageSideScrollLeft()
	{
		this.X -= 0.25;
	}
	
	public void manageVerticalScrollUp()
	{
		this.Y -= 0.25;
	}
	
	public void manageVerticalScrollDown()
	{
		this.Y += 0.25;
	}
}