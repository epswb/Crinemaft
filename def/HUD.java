package def;
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
			g.fillRect(130 + i*20, 600, 15, 15);
			g.setColor(Color.BLACK);
			g.drawRect(130 + i*20, 600, 15, 15);
		}
	}
	
	public void drawLeiste(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(130, 620, 470, 45);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(120 + LeisteZeiger*50 + 20, 620, 45, 45);
		
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < 9; i++)
		{
			g.fillRect(125 + i*50 + 20, 625, 35, 35);
		}
		
		
	}
	
	public void drawLeisteContent(Graphics g)
	{
		g.setColor(Color.WHITE);
		Font font = new Font("Arial Black", Font.PLAIN, 20);
	    g.setFont(font);
		for (int i = 0; i < 9; i++)
		{
			g.drawImage(main.Block.getBlock(main.inv.inventory.get(i).blockID), 125 + i*50 + 25, 630, 25, 25, null);
			g.drawString(String.valueOf(main.inv.inventory.get(i).anzahl), 125 + i*50+30, 660);
			
		}
	}
	
	public void drawInventoryMode(Graphics g)
	{
//		Bildschirm verdunkeln
		g.setColor(new Color(0, 0, 0, 175));
		g.fillRect(0, 0, 750, 750);
		
//		-------------------------------------------------------------
//		inventar
		g.setColor(Color.BLACK);
		g.drawRect(125, 90, 500, 500);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(125, 90, 500, 500);
		
		g.setColor(Color.WHITE);
		g.fillRect(145, 340, 460, 230);
		
		g.setColor(Color.GRAY);
		for (int a = 0; a < 3; a++)
		{
			for (int i = 0; i < 9; i++)
			{
				g.fillRect(145 + i*50+5, 345 + a*50, 45, 45);
			}
		}
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(125, 495, 500, 15);
		
		g.setColor(Color.GRAY);
		for (int i = 0; i < 9; i++)
		{
			g.fillRect(145 + i*50+5, 515, 45, 45);
		}
		
//		-------------------------------------------------------------
//		mann zeichnen + rahmen
		g.setColor(Color.WHITE);
		g.fillRect(145, 110, 230, 200);
		
		g.setColor(Color.BLACK);
		g.fillRect(150, 115, 220, 190);
		
		g.drawImage(main.IS.manfront, 220, 125, 80, 170, null);
		
//		-------------------------------------------------------------
//		crafting view
		g.setColor(Color.WHITE);
		g.fillRect(405, 165, 105, 105);
		
		g.fillRect(550, 190, 52, 52);
		
		g.setColor(Color.GRAY);
		for (int a = 0; a < 2; a++)
		{
			for (int i = 0; i < 2; i++)
			{
				g.fillRect(405 + i*50+5, 170 + a*50, 45, 45);
			}
		}
		
		g.fillRect(553, 193, 45, 45);
		
		Polygon poly = new Polygon();
		   poly.addPoint(525,205);
		   poly.addPoint(540,215);
		   poly.addPoint(525,225);
		   poly.addPoint(525,205);
		   g.fillPolygon(poly);
		   
		g.fillRect(515, 210, 10, 10);
		
		g.setColor(Color.GRAY);
		Font font = new Font("Arial", Font.PLAIN, 20);
	    g.setFont(font);
	    
	    g.drawString("Crafting", 405, 160);
		
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
				g.drawImage(main.Block.getBlock(main.inv.inventory.get(o).blockID), 147 + a*50+5, 517, 40, 40, null);
				g.drawString(String.valueOf(main.inv.inventory.get(o).anzahl), 147 + a*50+20, 552);
			}
		}
		
		for (int o = 0; o < main.inv.inventory.size(); o++)
		{
			if (main.inv.inventory.get(o).invPos >= 9 && main.inv.inventory.get(o).invPos < 18)
			{
				int a = main.inv.inventory.get(o).invPos - 9;
				g.drawImage(main.Block.getBlock(main.inv.inventory.get(o).blockID), 147 + a*50+5, 297+50, 40, 40, null);
				g.drawString(String.valueOf(main.inv.inventory.get(o).anzahl), 147 + a*50+20, 332+50);
			}
		}
		
		for (int o = 0; o < main.inv.inventory.size(); o++)
		{
			if (main.inv.inventory.get(o).invPos >= 18 && main.inv.inventory.get(o).invPos < 27)
			{
				int a = main.inv.inventory.get(o).invPos - 18;
				g.drawImage(main.Block.getBlock(main.inv.inventory.get(o).blockID), 147 + a*50+5, 347+50, 40, 40, null);
				g.drawString(String.valueOf(main.inv.inventory.get(o).anzahl), 147 + a*50+20, 382+50);
			}
		}
		
		for (int o = 0; o < main.inv.inventory.size(); o++)
		{
			if (main.inv.inventory.get(o).invPos >= 27 && main.inv.inventory.get(o).invPos < 36)
			{
				int a = main.inv.inventory.get(o).invPos - 27;
				g.drawImage(main.Block.getBlock(main.inv.inventory.get(o).blockID), 147 + a*50+5, 397+50, 40, 40, null);
				g.drawString(String.valueOf(main.inv.inventory.get(o).anzahl), 147 + a*50+20, 432+50);
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