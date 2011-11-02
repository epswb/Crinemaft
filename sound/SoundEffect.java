package sound;

public class SoundEffect 
{
	int TYPE, DETAIL, NUMBER;
	
	public SoundEffect(int type, int detail, int number)
	{
		TYPE = type;
		DETAIL = detail;
		NUMBER = number;
	}
	
	public static final int SE_TYPE_MATERIAL = 0;
	public static final int SE_TYPE_MOB = 1;
	
	public static final int SE_DETAIL_GRASS = 0;
	public static final int SE_DETAIL_WOOD = 1;
	public static final int SE_DETAIL_STONE = 2;
	public static final int SE_DETAIL_GRAVEL = 3;
	public static final int SE_DETAIL_COW = 0;
	public static final int SE_DETAIL_SHEEP = 1;
	public static final int SE_DETAIL_PIG = 2;
	public static final int SE_DETAIL_WOLF = 3;
	public static final int SE_DETAIL_CREEPER = 4;
	public static final int SE_DETAIL_ZOMBIE = 5;
	
	public static final int SE_NUMBER_ZERO = 0;
	public static final int SE_NUMBER_ONE = 1;
	
	
}
