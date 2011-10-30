package def;

import java.awt.Color;
import java.awt.Graphics;


public class drawer
{
	
	block Block;
	public int verschiebungX;
	public int verschiebungY;
	public drawer()
	{
		Block = new block();
	}
	
	public void draw(Graphics g)
	{
		int[][] world = main.World.getWorld();
		int userviewX = (int) main.UserView.userviewX();
		int userviewY = (int) main.UserView.userviewY();
		verschiebungX = (int) ((main.UserView.userviewX() - Math.round(main.UserView.userviewX())) * 32);
		verschiebungY = (int) ((main.UserView.userviewY() - Math.round(main.UserView.userviewY())) * 32);
		
		
		
		if (verschiebungY < 0)
		{
			verschiebungY += 32;
		}
		
		if (main.Player.blockposX <= 11)
		{
			if (verschiebungX <= 0)
			{
				verschiebungX += 32;
			}
			
			verschiebungX -= 32;
		}
		
		else
		{
			if (verschiebungX < 0)
			{
				verschiebungX += 32;
			}
		}
		
		for (int i = 0; i < 24; i++)
		{
			for (int o = 0; o < 24; o++)
			{
				g.drawImage(Block.getBlock(block.sky()), (i)*32 - verschiebungX, (o)*32 - verschiebungY, 32, 32, null);
			}
		}
		
		for (int i = -1; i < 24; i++)
		{
			for (int o = -1; o < 24; o++)
			{
				if (o+userviewY < 0)
				{
					g.drawImage(Block.getBlock(block.sky()), main.World.getCoordinates(i, o).X - verschiebungX, main.World.getCoordinates(i, o).Y - verschiebungY, 32, 32, null);
				}
				
				else if (o+userviewY > 99)
				{
					g.drawImage(Block.getBlock(block.bedrock()), main.World.getCoordinates(i, o).X - verschiebungX, main.World.getCoordinates(i, o).Y - verschiebungY, 32, 32, null);
				}
				
				else
				{
					if (i+userviewX < 0)
					{
						g.drawImage(Block.getBlock(block.bedrock()), main.World.getCoordinates(i, o).X - verschiebungX, main.World.getCoordinates(i, o).Y - verschiebungY, 32, 32, null);
					}
					
					else if (i+userviewX > 999)
					{
						g.drawImage(Block.getBlock(block.bedrock()), main.World.getCoordinates(i, o).X - verschiebungX, main.World.getCoordinates(i, o).Y - verschiebungY, 32, 32, null);
					}
					
					else
					{
						g.drawImage(Block.getBlock(world[i+userviewX][o+userviewY]), main.World.getCoordinates(i, o).X - verschiebungX, main.World.getCoordinates(i, o).Y - verschiebungY, 32, 32, null);
					}
					
				}
			}
		}
		
		for (int i = 0; i < 24; i++)
		{
			for (int o = 0; o < 24; o++)
			{
				if (userviewX + i >= 0 && userviewY + o >= 0 && userviewX + i <= 999 && userviewY + o <= 99 && main.World.get(i + userviewX, o + userviewY) != block.sky() && main.World.get(i + userviewX, o + userviewY) != block.dungeon() && main.World.get(i + userviewX, o + userviewY) != block.flower())
				{
					if (userviewX + i >= 1 && (main.World.get(i + userviewX - 1, o + userviewY) == block.sky() || main.World.get(i + userviewX - 1, o + userviewY) == block.dungeon() || main.World.get(i + userviewX - 1, o + userviewY) == block.flower()))
					{
						g.drawLine(i * 32 - verschiebungX, o * 32 - verschiebungY, i * 32 - verschiebungX, (o + 1) * 32 - verschiebungY);
					}
					
					if (userviewX + i <= 999 && (main.World.get(i + userviewX + 1, o + userviewY) == block.sky() || main.World.get(i + userviewX + 1, o + userviewY) == block.dungeon() || main.World.get(i + userviewX + 1, o + userviewY) == block.flower()))
					{
						g.drawLine((i + 1) * 32 - verschiebungX, o * 32 - verschiebungY, (i + 1) * 32 - verschiebungX, (o + 1) * 32 - verschiebungY);
					}
					
					if (userviewY + o >= 1 && (main.World.get(i + userviewX, o + userviewY - 1) == block.sky() || main.World.get(i + userviewX, o + userviewY - 1) == block.dungeon() || main.World.get(i + userviewX, o + userviewY - 1) == block.flower()))
					{
						g.drawLine(i * 32 - verschiebungX, o * 32 - verschiebungY, (i + 1) * 32 - verschiebungX, o * 32 - verschiebungY);
					}
					
					if (userviewY + o <= 99 && (main.World.get(i + userviewX, o + userviewY + 1) == block.sky() || main.World.get(i + userviewX, o + userviewY + 1) == block.dungeon() || main.World.get(i + userviewX, o + userviewY + 1) == block.flower()))
					{
						g.drawLine(i * 32 - verschiebungX, (o + 1) * 32 - verschiebungY, (i + 1) * 32 - verschiebungX, (o + 1) * 32 - verschiebungY);
					}
				}
				
			}
			
		}
		
		if (main.Player.walkingleft() == false)
		{
			if (main.Player.actualImg == 0)
			{
				g.drawImage(main.IS.playerImages[0][main.Player.actualImg], main.Player.posX, main.Player.posY, 32, 96, null);
				drawManArm(main.Player.walkingleft(), main.Player.actualImg, g);
			}
			else if (main.Player.actualImg == 1)
			{
				g.drawImage(main.IS.playerImages[0][main.Player.actualImg], main.Player.posX, main.Player.posY, 45, 96, null);
				drawManArm(main.Player.walkingleft(), main.Player.actualImg, g);
			}
			
			
		}
		else
		{
			if (main.Player.actualImg == 0)
			{
				g.drawImage(main.IS.playerImages[1][main.Player.actualImg], main.Player.posX, main.Player.posY, 32, 96, null);
				drawManArm(main.Player.walkingleft(), main.Player.actualImg, g);
			}
			else if (main.Player.actualImg == 1)
			{
				g.drawImage(main.IS.playerImages[1][main.Player.actualImg], main.Player.posX-15, main.Player.posY, 45, 96, null);
				drawManArm(main.Player.walkingleft(), main.Player.actualImg, g);
			}
			
		}
		
		g.setColor(Color.BLACK);
		
		
	}
	
	public void drawManArm(boolean manWalkingLeft, int actImg, Graphics g)
	{
		if (manWalkingLeft == false)
		{
			if (main.Player.armstate == 0)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm0, main.Player.posX+10, main.Player.posY+30, 13, 30, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm0, main.Player.posX+8, main.Player.posY+30, 13, 30, null);
				}
			}
			else if (main.Player.armstate == 1)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm1, main.Player.posX+11, main.Player.posY+30, 27, 38, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm1, main.Player.posX+9, main.Player.posY+30, 27, 38, null);
				}
			}
			else if (main.Player.armstate == 2)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm2, main.Player.posX+12, main.Player.posY+30, 36, 36, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm2, main.Player.posX+10, main.Player.posY+30, 36, 36, null);
				}
			}
			else if (main.Player.armstate == 3)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm3, main.Player.posX+13, main.Player.posY+30, 38, 27, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm3, main.Player.posX+11, main.Player.posY+30, 38, 27, null);
				}
			}
			else if (main.Player.armstate == 4)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm4, main.Player.posX+14, main.Player.posY+30, 35, 18, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm4, main.Player.posX+12, main.Player.posY+30, 35, 18, null);
				}
			}
		}
		else
		{
			if (main.Player.armstate == 0)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm0, main.Player.posX+22, main.Player.posY+35, -13, 30, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm0, main.Player.posX+24, main.Player.posY+35, -13, 30, null);
				}
			}
			else if (main.Player.armstate == 1)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm1, main.Player.posX+22, main.Player.posY+35, -27, 38, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm1, main.Player.posX+24, main.Player.posY+35, -27, 38, null);
				}
			}
			else if (main.Player.armstate == 2)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm2, main.Player.posX+22, main.Player.posY+35, -36, 36, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm2, main.Player.posX+24, main.Player.posY+35, -36, 36, null);
				}
			}
			else if (main.Player.armstate == 3)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm3, main.Player.posX+22, main.Player.posY+35, -38, 27, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm3, main.Player.posX+24, main.Player.posY+35, -38, 27, null);
				}
			}
			else if (main.Player.armstate == 4)
			{
				if (actImg == 0)
				{
					g.drawImage(main.IS.manarm4, main.Player.posX+22, main.Player.posY+35, -35, 18, null);
				}
				else if (actImg == 1)
				{
					g.drawImage(main.IS.manarm4, main.Player.posX+24, main.Player.posY+35, -35, 18, null);
				}
			}
		}
		
	}

}
