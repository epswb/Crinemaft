package def;
import java.util.Vector;

class Inventory
{
	public Vector<Item> inventory = new Vector<Item>();
	public boolean inventoryMode = false;
	public Item movingItem;
	
	public Inventory()
	{
		Item i1 = new Item(7, 64, 0);
		Item i2 = new Item(3, 54, 1);
		Item i3 = new Item(2, 32, 2);
		Item i4 = new Item(10, 11, 3);
		Item i5 = new Item(9, 42, 4);
		Item i6 = new Item(11, 12, 5);
		Item i7 = new Item(14, 21, 6);
		Item i8 = new Item(8, 9, 7);
		Item i9 = new Item(18, 23, 8);
		
		inventory.add(i1);
		inventory.add(i2);
		inventory.add(i3);
		inventory.add(i4);
		inventory.add(i5);
		inventory.add(i6);
		inventory.add(i7);
		inventory.add(i8);
		inventory.add(i9);
		
		Item i10 = new Item(13, 34, 9);
		inventory.add(i10);
		Item i11 = new Item(14, 34, 10);
		inventory.add(i11);
		Item i12 = new Item(15, 34, 11);
		inventory.add(i12);
		Item i13 = new Item(16, 34, 12);
		inventory.add(i13);
		Item i14 = new Item(13, 34, 13);
		inventory.add(i14);
		Item i15 = new Item(14, 34, 14);
		inventory.add(i15);
		Item i16 = new Item(15, 34, 15);
		inventory.add(i16);
		Item i17 = new Item(16, 34, 19);
		inventory.add(i17);
		Item i18 = new Item(13, 34, 20);
		inventory.add(i18);
		Item i19 = new Item(14, 34, 30);
		inventory.add(i19);
		Item i20 = new Item(15, 34, 21);
		inventory.add(i20);
		Item i21 = new Item(16, 34, 22);
		inventory.add(i21);
		Item i22 = new Item(13, 34, 24);
		inventory.add(i22);
		Item i23 = new Item(14, 34, 29);
		inventory.add(i23);
		Item i24 = new Item(15, 34, 34);
		inventory.add(i24);
		Item i25 = new Item(16, 34, 35);
		inventory.add(i25);
		
	}
	
	public int ausgewählterBlock()
	{
		return inventory.get(main.hud.LeisteZeiger).blockID;
	}
	
	public void addToInventory(Item item)
	{
		inventory.add(item);
	}
	
	public void removeFromInventory(Item item)
	{
		inventory.remove(item);
	}
	
	public void BlockNehmen(int x, int y)
	{
		x -= 222;
		y -= 457;
		
		x = (x / 50) - (x % 1);
		y = (y / 50) - (y % 1);
		
		
		for (int i = 0; i < main.inv.inventory.size(); i++)
		{
			if (main.inv.inventory.get(i).invPos == x+y*9+9)
			{
				movingItem = new Item(main.inv.inventory.get(i).blockID, main.inv.inventory.get(i).anzahl, main.inv.inventory.get(i).invPos);
				main.inv.inventory.remove(i);
				main.PK.clickedaufgenommen = true;
			}
		}
	}
	
	public void BlockAblegen(int x, int y)
	{
		x -= 222;
		y -= 457;
		
		x = (x / 50) - (x % 1);
		y = (y / 50) - (y % 1);
		
		boolean geändert = false;
		
		a:for (int i = 0; i < main.inv.inventory.size(); i++)
		{
			if (movingItem != null && main.inv.inventory.get(i).invPos == x+y*9+9)
			{
				main.PK.clickedaufgenommen = true;
				Item übergang = new Item(main.inv.inventory.get(i).blockID, main.inv.inventory.get(i).anzahl, main.inv.inventory.get(i).invPos);
				main.inv.inventory.remove(i);
				movingItem.invPos = x+y*9+9;
				Item newItem = new Item(movingItem.blockID, movingItem.anzahl, movingItem.invPos);
				main.inv.inventory.add(newItem);
				movingItem = new Item(übergang.blockID, übergang.anzahl, übergang.invPos);
				geändert = true;
				break a;
			}
			
		}
		
		if (geändert == false)
		{
			a:for (int i = 0; i < main.inv.inventory.size(); i++)
			{
				if (movingItem != null && main.inv.inventory.get(i).invPos != x+y*9+9)
				{
					main.inv.movingItem.invPos = x+y*9+9;
					main.inv.inventory.add(movingItem);
					movingItem = null;
					main.PK.clickedaufgenommen = false;
				}
				
			}
		}
	}
}