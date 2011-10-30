package light;

import def.block;
import def.main;

import java.awt.Color;
import java.awt.Graphics;

public class Light
{
	public Light()
	{
		
	}
	
	public void manageLight(Graphics g)
	{
		if (main.UserView.userviewX() >= 0)
		{
			
		}
		for (int a = 0; a < 24; a ++)
		{
			for (int b = 0; b < 24; b ++)
			{
				if (main.UserView.userviewX() >= 0 && main.UserView.userviewY() >= 0 && main.World.get((int) (a + main.UserView.userviewX()), (int) (b + main.UserView.userviewY())) != block.sky() && main.World.get((int) (a + main.UserView.userviewX()), (int) (b + main.UserView.userviewY())) != block.flower() && main.World.get((int) (a + main.UserView.userviewX()), (int) (b + main.UserView.userviewY())) != block.wood() && main.World.get((int) (a + main.UserView.userviewX()), (int) (b + main.UserView.userviewY())) != block.leaf())
				{
					g.setColor(new Color(0, 0, 0, 150));
					g.fillRect(a * 32 - main.Drawer.verschiebungX, b * 32 - main.Drawer.verschiebungY, 32, 32);
				}
			}
		}
	}
}