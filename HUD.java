import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.RenderingHints;


class HUD
{
	
	int LeisteZeiger = 0;
	
	public HUD()
	{
		
	}
	
	public void drawHUD(Graphics g)
	{
		drawLeben(g);
		drawLeiste(g);
		drawLeisteContent(g);
		
		if (main.inv.inventoryMode == true)
		{
			drawInventoryMode(g);
			drawInventoryContent(g);
		}
	}
	
	public void drawLeben(Graphics g)
	{
		int life = main.Player.leben;
		
		for (int i = 0; i < life; i++)
		{
			g.setColor(Color.RED);
			g.fillRect(200 + i*20, 780, 15, 15);
			g.setColor(Color.BLACK);
			g.drawRect(200 + i*20, 780, 15, 15);
		}
	}
	
	public void drawLeiste(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(200, 800, 470, 45);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(205 + LeisteZeiger*50 + 20, 800, 45, 45);
		
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < 9; i++)
		{
			g.fillRect(210 + i*50 + 20, 805, 35, 35);
		}
		
		
	}
	
	public void drawLeisteContent(Graphics g)
	{
		g.setColor(Color.WHITE);
		Font font = new Font("Arial Black", Font.PLAIN, 20);
	    g.setFont(font);
		for (int i = 0; i < 9; i++)
		{
			g.drawImage(main.Block.getBlock(main.inv.inventory.get(i).blockID), 210 + i*50 + 25, 810, 25, 25, null);
			g.drawString(String.valueOf(main.inv.inventory.get(i).anzahl), 210 + i*50+30, 840);
			
		}
	}
	
	public void drawInventoryMode(Graphics g)
	{
//		Bildschirm verdunkeln
		g.setColor(new Color(0, 0, 0, 175));
		g.fillRect(0, 0, 900, 900);
		
//		-------------------------------------------------------------
//		inventar
		g.setColor(Color.BLACK);
		g.drawRect(200, 200, 500, 500);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(200, 200, 500, 500);
		
		g.setColor(Color.WHITE);
		g.fillRect(220, 450, 460, 230);
		
		g.setColor(Color.GRAY);
		for (int a = 0; a < 3; a++)
		{
			for (int i = 0; i < 9; i++)
			{
				g.fillRect(220 + i*50+5, 455 + a*50, 45, 45);
			}
		}
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(200, 605, 500, 15);
		
		g.setColor(Color.GRAY);
		for (int i = 0; i < 9; i++)
		{
			g.fillRect(220 + i*50+5, 625, 45, 45);
		}
		
//		-------------------------------------------------------------
//		mann zeichnen + rahmen
		g.setColor(Color.WHITE);
		g.fillRect(220, 220, 230, 200);
		
		g.setColor(Color.BLACK);
		g.fillRect(225, 225, 220, 190);
		
		g.drawImage(main.IS.manfront, 295, 235, 80, 170, null);
		
//		-------------------------------------------------------------
//		crafting view
		g.setColor(Color.WHITE);
		g.fillRect(480, 275, 105, 105);
		
		g.fillRect(625, 300, 52, 52);
		
		g.setColor(Color.GRAY);
		for (int a = 0; a < 2; a++)
		{
			for (int i = 0; i < 2; i++)
			{
				g.fillRect(480 + i*50+5, 280 + a*50, 45, 45);
			}
		}
		
		g.fillRect(628, 303, 45, 45);
		
		Polygon poly = new Polygon();
		   poly.addPoint(600,315);
		   poly.addPoint(615,325);
		   poly.addPoint(600,335);
		   poly.addPoint(600,315);
		   g.fillPolygon(poly);
		   
		g.fillRect(590, 320, 10, 10);
		
		g.setColor(Color.GRAY);
		Font font = new Font("Arial", Font.PLAIN, 20);
	    g.setFont(font);
	    
	    g.drawString("Crafting", 480, 270);
		
//		-------------------------------------------------------------
		
	}
	
	public void drawInventoryContent(Graphics g)
	{
		g.setColor(Color.WHITE);
		Font font = new Font("Arial Black", Font.PLAIN, 20);
	    g.setFont(font);
	    
		
		for (int o = 0; o < main.inv.inventory.size(); o++)
		{
			if (main.inv.inventory.get(o).invPos < 9)
			{
				int a = main.inv.inventory.get(o).invPos;
				g.drawImage(main.Block.getBlock(main.inv.inventory.get(o).blockID), 222 + a*50+5, 627, 40, 40, null);
				g.drawString(String.valueOf(main.inv.inventory.get(o).anzahl), 222 + a*50+20, 662);
			}
		}
		
		for (int o = 0; o < main.inv.inventory.size(); o++)
		{
			if (main.inv.inventory.get(o).invPos >= 9 && main.inv.inventory.get(o).invPos < 18)
			{
				int a = main.inv.inventory.get(o).invPos - 9;
				g.drawImage(main.Block.getBlock(main.inv.inventory.get(o).blockID), 222 + a*50+5, 407+50, 40, 40, null);
				g.drawString(String.valueOf(main.inv.inventory.get(o).anzahl), 222 + a*50+20, 442+50);
			}
		}
		
		for (int o = 0; o < main.inv.inventory.size(); o++)
		{
			if (main.inv.inventory.get(o).invPos >= 18 && main.inv.inventory.get(o).invPos < 27)
			{
				int a = main.inv.inventory.get(o).invPos - 18;
				g.drawImage(main.Block.getBlock(main.inv.inventory.get(o).blockID), 222 + a*50+5, 457+50, 40, 40, null);
				g.drawString(String.valueOf(main.inv.inventory.get(o).anzahl), 222 + a*50+20, 492+50);
			}
		}
		
		for (int o = 0; o < main.inv.inventory.size(); o++)
		{
			if (main.inv.inventory.get(o).invPos >= 27 && main.inv.inventory.get(o).invPos < 36)
			{
				int a = main.inv.inventory.get(o).invPos - 27;
				g.drawImage(main.Block.getBlock(main.inv.inventory.get(o).blockID), 222 + a*50+5, 507+50, 40, 40, null);
				g.drawString(String.valueOf(main.inv.inventory.get(o).anzahl), 222 + a*50+20, 542+50);
			}
		}
		
		if (main.inv.movingItem != null)
		{
			g.drawImage(main.Block.getBlock(main.inv.movingItem.blockID), main.PK.MouseX-20, main.PK.MouseY-20, 40, 40, null);
			g.drawString(String.valueOf(main.inv.movingItem.anzahl), main.PK.MouseX, main.PK.MouseY+15);
		}
		
	}
	
	public void scrollLeiste(int w)
	{
		if (w > 0)
		{
			if (LeisteZeiger == 8)
			{
				LeisteZeiger = 0;
			}
			else
			{
				LeisteZeiger++;
			}
		}
		else
		{
			if (LeisteZeiger == 0)
			{
				LeisteZeiger = 8;
			}
			else
			{
				LeisteZeiger--;
			}
		}
	}
}