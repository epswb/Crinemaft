package def;
import java.awt.Image;
import javax.swing.ImageIcon;


class ImageStorer
{
	public Image player1, player2, player3, player4, manfront, manback, manarm0, manarm1,
				 manarm2, manarm3, manarm4;
	public Image[] blocks = new Image[20];
	public Image[][] playerImages = new Image[2][2];
	public Image[][][] toolImages = new Image[4]  [5]      [5];
//											  tool material position
	
	public void loadImages()
	{
		player1 = new ImageIcon("C:\\Crinemaft\\textures\\character\\001.png").getImage();
		player2 = new ImageIcon("C:\\Crinemaft\\textures\\character\\002.png").getImage();
		player3 = new ImageIcon("C:\\Crinemaft\\textures\\character\\003.png").getImage();
		player4 = new ImageIcon("C:\\Crinemaft\\textures\\character\\004.png").getImage();
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
		if (blocks[blockID] != null)
		{
			return blocks[blockID];
		}
		else
		{
			blocks[blockID] =  new ImageIcon("C:\\Crinemaft\\textures\\terrain\\" + blockID + ".png").getImage();
			return blocks[blockID];
		}
	}
	
	public Image getToolImage(int tool, int material, int pos)
	{
		if (toolImages[tool][material][pos] != null)
		{
			return toolImages[tool][material][pos];
		}
		else
		{
			toolImages[tool][material][pos] = new ImageIcon("C:\\Crinemaft\\textures\\tools\\" + tool + "\\" + material + "\\" + pos + ".png").getImage();
			return toolImages[tool][material][pos];
		}
	}
	
	
	public Image[][] playerImgs()
	{
		return playerImages;
	}
}