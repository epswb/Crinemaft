package def;
import java.awt.Image;


public class block
{
	
	public Image getBlock(int blockID)
	{
		if (blockID == block.sky())
		{
			return main.IS.getImage(block.sky());
		}
		else if (blockID == block.dirt())
		{
			return main.IS.getImage(block.dirt());
		}
		else if (blockID == block.sand())
		{
			return main.IS.getImage(block.sand());
		}
		else if (blockID == block.stone())
		{
			return main.IS.getImage(block.stone());
		}
		else if (blockID == block.wood())
		{
			return main.IS.getImage(block.wood());
		}
		else if (blockID == block.leaf())
		{
			return main.IS.getImage(block.leaf());
		}
		else if (blockID == block.flower())
		{
			return main.IS.getImage(block.flower());
		}
		else if (blockID == block.deepdirt())
		{
			return main.IS.getImage(block.deepdirt());
		}
		else if (blockID == block.water())
		{
			return main.IS.getImage(block.water());
		}
		else if (blockID == block.sandstone())
		{
			return main.IS.getImage(block.sandstone());
		}
		else if (blockID == block.gravel())
		{
			return main.IS.getImage(block.gravel());
		}
		else if (blockID == block.coal())
		{
			return main.IS.getImage(block.coal());
		}
		else if (blockID == block.iron())
		{
			return main.IS.getImage(block.iron());
		}
		else if (blockID == block.gold())
		{
			return main.IS.getImage(block.gold());
		}
		else if (blockID == block.diamond())
		{
			return main.IS.getImage(block.diamond());
		}
		else if (blockID == block.lapislazuli())
		{
			return main.IS.getImage(block.lapislazuli());
		}
		else if (blockID == block.redstone())
		{
			return main.IS.getImage(block.redstone());
		}
		else if (blockID == block.dungeon())
		{
			return main.IS.getImage(block.dungeon());
		}
		else if (blockID == block.lava())
		{
			return main.IS.getImage(block.lava());
		}
		else if (blockID == block.bedrock())
		{
			return main.IS.getImage(block.bedrock());
		}
		else
		{
			return null;
		}
		
		
	}
	
	public final static int sky()
	{
		return 0;
	}
	public final static int dirt()
	{
		return 1;
	}
	public final static int sand()
	{
		return 2;
	}
	public final static int stone()
	{
		return 3;
	}
	public final static int wood()
	{
		return 4;
	}
	public final static int leaf()
	{
		return 5;
	}
	public final static int flower()
	{
		return 6;
	}
	public final static int deepdirt()
	{
		return 7;
	}
	public final static int water()
	{
		return 8;
	}
	public final static int sandstone()
	{
		return 9;
	}
	public final static int gravel()
	{
		return 10;
	}
	public final static int coal()
	{
		return 11;
	}
	public final static int iron()
	{
		return 12;
	}
	public final static int gold()
	{
		return 13;
	}
	public final static int diamond()
	{
		return 14;
	}
	public final static int lapislazuli()
	{
		return 15;
	}
	public final static int redstone()
	{
		return 16;
	}
	public final static int dungeon()
	{
		return 17;
	}
	public final static int lava()
	{
		return 18;
	}
	public final static int bedrock()
	{
		return 19;
	}
	
	
	public static boolean BlockwillCollide(int blockID)
	{
		if (blockID == 0)
		{
			return false;
		}
		if (blockID == 1)
		{
			return true;
		}
		if (blockID == 2)
		{
			return true;
		}
		if (blockID == 3)
		{
			return true;
		}
		if (blockID == 4)
		{
			return false;
		}
		if (blockID == 5)
		{
			return false;
		}
		if (blockID == 6)
		{
			return false;
		}
		if (blockID == 7)
		{
			return true;
		}
		if (blockID == 8)
		{
			return false;
		}
		if (blockID == 9)
		{
			return true;
		}
		if (blockID == 10)
		{
			return true;
		}
		if (blockID == 11)
		{
			return true;
		}
		if (blockID == 12)
		{
			return true;
		}
		if (blockID == 13)
		{
			return true;
		}
		if (blockID == 14)
		{
			return true;
		}
		if (blockID == 15)
		{
			return true;
		}
		if (blockID == 16)
		{
			return true;
		}
		if (blockID == 17)
		{
			return false;
		}
		if (blockID == 18)
		{
			return false;
		}
		if (blockID == 19)
		{
			return true;
		}
		else
		{
			System.out.println("UNKNOWN BLOCKID!");
			return false;
			
		}
	}
	
	public static boolean BlockGravity(int blockID)
	{
		if (blockID == 0)
		{
			return false;
		}
		if (blockID == 1)
		{
			return false;
		}
		if (blockID == 2)
		{
			return true;
		}
		if (blockID == 3)
		{
			return false;
		}
		if (blockID == 4)
		{
			return false;
		}
		if (blockID == 5)
		{
			return false;
		}
		if (blockID == 6)
		{
			return false;
		}
		if (blockID == 7)
		{
			return false;
		}
		if (blockID == 8)
		{
			return false;
		}
		if (blockID == 9)
		{
			return false;
		}
		if (blockID == 10)
		{
			return true;
		}
		if (blockID == 11)
		{
			return false;
		}
		if (blockID == 12)
		{
			return false;
		}
		if (blockID == 13)
		{
			return false;
		}
		if (blockID == 14)
		{
			return false;
		}
		if (blockID == 15)
		{
			return false;
		}
		if (blockID == 16)
		{
			return false;
		}
		if (blockID == 17)
		{
			return false;
		}
		if (blockID == 18)
		{
			return false;
		}
		if (blockID == 19)
		{
			return false;
		}
		else
		{
			System.out.println("UNKNOWN BLOCKID!");
			return false;
			
		}
	}
	
	public static boolean BlockLiquid(int blockID)
	{
		if (blockID == 0)
		{
			return false;
		}
		if (blockID == 1)
		{
			return false;
		}
		if (blockID == 2)
		{
			return false;
		}
		if (blockID == 3)
		{
			return false;
		}
		if (blockID == 4)
		{
			return false;
		}
		if (blockID == 5)
		{
			return false;
		}
		if (blockID == 6)
		{
			return false;
		}
		if (blockID == 7)
		{
			return false;
		}
		if (blockID == 8)
		{
			return true;
		}
		if (blockID == 9)
		{
			return false;
		}
		if (blockID == 10)
		{
			return false;
		}
		if (blockID == 11)
		{
			return false;
		}
		if (blockID == 12)
		{
			return false;
		}
		if (blockID == 13)
		{
			return false;
		}
		if (blockID == 14)
		{
			return false;
		}
		if (blockID == 15)
		{
			return false;
		}
		if (blockID == 16)
		{
			return false;
		}
		if (blockID == 17)
		{
			return false;
		}
		if (blockID == 18)
		{
			return true;
		}
		if (blockID == 19)
		{
			return false;
		}
		else
		{
			System.out.println("UNKNOWN BLOCKID!");
			return false;
			
		}
	}
}