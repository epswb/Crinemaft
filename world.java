import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class world
{
	
	int[][] world = new int[1008][108];
	
	
	public void loadWorld(String path)
	{
		File file = new File(path);
		Scanner s;
		try {
		
			s = new Scanner(file);
		
		
			int INT, count = 0, count2 = 0;
		
			while (s.hasNext())
			{
				INT  = Integer.parseInt(s.next());
			
				if (INT == 0)
				{
					count ++;
				
					count2 = 0;
				}
				else
				{
					world[count2][count] = INT;
				
					count2 ++;
				}
			}
		
		
		} catch (FileNotFoundException e) {e.printStackTrace();}
	}
	
	
	public int[][] getWorld()
	{
		return world;
	}
	
	public int get(int a, int b)
	{
		return world[a][b];
	}
	
	public void set(int x, int y, int blockID)
	{
		world[x][y] = blockID;
	}
	
	public Coordinates getCoordinates(int a, int b)
	{
		int x = a * 32;
		int y = b * 32;
		
		Coordinates c = new Coordinates(x, y);
		
		return(c);
	}
	
}