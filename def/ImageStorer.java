package def;
import java.awt.Image;
import javax.swing.ImageIcon;


class ImageStorer
{
	public Image player1, player2, player3, player4, sky, dirt, sand, stone, wood, leaf, flower, deepdirt, water, sandstone, gravel, coal,
				 iron, gold, diamond, lapislazuli, redstone, dungeon, lava, bedrock, manfront, manback, manarm0, manarm1, manarm2, manarm3, manarm4;
	public Image[][] playerImages = new Image[2][2];
	
	public void loadImages()
	{
		player1 = new ImageIcon("C:\\Crinemaft\\textures\\character\\001.png").getImage();
		player2 = new ImageIcon("C:\\Crinemaft\\textures\\character\\002.png").getImage();
		player3 = new ImageIcon("C:\\Crinemaft\\textures\\character\\003.png").getImage();
		player4 = new ImageIcon("C:\\Crinemaft\\textures\\character\\004.png").getImage();
		sky = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\sky.png").getImage();
		dirt = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\dirt.png").getImage();
		sand = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\sand.png").getImage();
		stone = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\stone.png").getImage();
		wood = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\wood.png").getImage();
		leaf = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\leaf.png").getImage();
		flower = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\flower.png").getImage();
		deepdirt = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\deepdirt.png").getImage();
		water = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\water.png").getImage();
		sandstone = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\sandstone.png").getImage();
		gravel = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\gravel.png").getImage();
		coal = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\coal.png").getImage();
		iron = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\iron.png").getImage();
		gold = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\gold.png").getImage();
		diamond = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\diamond.png").getImage();
		lapislazuli = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\lapislazuli.png").getImage();
		redstone = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\redstone.png").getImage();
		dungeon = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\dungeon.png").getImage();
		lava = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\lava.png").getImage();
		bedrock = new ImageIcon("C:\\Crinemaft\\textures\\terrain\\bedrock.png").getImage();
		manfront = new ImageIcon("C:\\Crinemaft\\textures\\character\\front.png").getImage();
		manback = new ImageIcon("C:\\Crinemaft\\textures\\character\\back.png").getImage();
		manarm0 = new ImageIcon("C:\\Crinemaft\\textures\\character\\arm0.png").getImage();
		manarm1 = new ImageIcon("C:\\Crinemaft\\textures\\character\\arm1.png").getImage();
		manarm2 = new ImageIcon("C:\\Crinemaft\\textures\\character\\arm2.png").getImage();
		manarm3 = new ImageIcon("C:\\Crinemaft\\textures\\character\\arm3.png").getImage();
		manarm4 = new ImageIcon("C:\\Crinemaft\\textures\\character\\arm4.png").getImage();
		
		playerImages[0][0] = player1;
		playerImages[0][1] = player2;
		playerImages[1][0] = player3;
		playerImages[1][1] = player4;
	}
	
	public Image getImage(int blockID)
	{
		if (blockID == block.sky())
		{
			return sky;
		}
		else if (blockID == block.dirt())
		{
			return dirt;
		}
		else if (blockID == block.sand())
		{
			return sand;
		}
		else if (blockID == block.stone())
		{
			return stone;
		}
		else if (blockID == block.wood())
		{
			return wood;
		}
		else if (blockID == block.leaf())
		{
			return leaf;
		}
		else if (blockID == block.flower())
		{
			return flower;
		}
		else if (blockID == block.deepdirt())
		{
			return deepdirt;
		}
		else if (blockID == block.water())
		{
			return water;
		}
		else if (blockID == block.sandstone())
		{
			return sandstone;
		}
		else if (blockID == block.gravel())
		{
			return gravel;
		}
		else if (blockID == block.coal())
		{
			return coal;
		}
		else if (blockID == block.iron())
		{
			return iron;
		}
		else if (blockID == block.gold())
		{
			return gold;
		}
		else if (blockID == block.diamond())
		{
			return diamond;
		}
		else if (blockID == block.lapislazuli())
		{
			return lapislazuli;
		}
		else if (blockID == block.redstone())
		{
			return redstone;
		}
		else if (blockID == block.dungeon())
		{
			return dungeon;
		}
		else if (blockID == block.lava())
		{
			return lava;
		}
		else if (blockID == block.bedrock())
		{
			return bedrock;
		}
		else
		{
			return null;
		}
	}
	
	
	public Image[][] playerImgs()
	{
		return playerImages;
	}
}