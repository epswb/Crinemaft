package def;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JFrame;
import light.Light;


public class main extends Applet implements Runnable
{
	
	Image bufImage;
	Graphics bufG;
	public static drawer Drawer;
	public static world World;
	public static ImageStorer IS;
	public static userview UserView;
	public static player Player;
	public static physics Physics;
	public static block Block;
	public static PressedKeys PK;
	public static MiningHandler mininghandler;
	public static HUD hud;
	public static Inventory inv;
	public static Light light;
	
	
	public JFrame frame;
	
	
	public main()
	{
		
		Drawer = new drawer();
		World = new world();
		IS = new ImageStorer();
		UserView = new userview(0, 0);
		Player = new player(352, 320);
		Physics = new physics();
		Block = new block();
		PK = new PressedKeys();
		hud = new HUD();
		mininghandler = new MiningHandler();
		inv = new Inventory();
		light = new Light();
		
		frame = new JFrame("Crinemaft 1.0.0");
		frame.setSize(750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBackground(Color.BLACK);
		this.addKeyListener(new kl());
		this.addMouseListener(new ml());
		this.addMouseMotionListener(new mml());
		this.addMouseWheelListener(new mwl());
		this.requestFocus();
		
		frame.add(this);
		
		frame.setVisible(true);
		
		IS.loadImages();
	}
	
	public void load()
	{
//		World.loadWorld("C:\\Crinemaft\\worlds\\world001.txt");
		World.loadWorld("C:\\Crinemaft\\map.txt");
		
	}

	
	public void run() 
	{
		
		while (true)
		{
			this.requestFocus();
			repaint();
			checkKeys();
			Physics.doGravity();
			mininghandler.handle();
			Physics.changes();
//			
//			---------------------------------------------------------------------
//			
			if (Physics.upperpoint == 1)
			{
				Physics.upperpoint = 2;
				Physics.bigstep = true;
			}
			else if (Physics.upperpoint == 2)
			{
				Physics.bigstep = false;
				Physics.upperpoint = 0;
			}
//			
//			-----------------------------------------------------------------------
//						
			if (Physics.walkright == true && Player.WalkingLeft == true && (Physics.turnposition*100) % 100 == 0)
			{
				
			}
			
			Physics.walkleft = Player.WalkingLeft;
			Physics.walkright = !Physics.walkleft;
			
			Physics.turnposition = Player.blockposX;
			
			try{
				Thread.sleep(40);
			}catch(Exception e){}
		}
		
	}
	
	
	public void paint(Graphics g)
	{
		Drawer.draw(g);
		hud.drawHUD(g);
		light.manageLight(g);
	}
	
	public void update (Graphics g)
	{
		int w = this.getSize().width;
        int h = this.getSize().height;
 
        if(bufImage == null){
              bufImage = this.createImage(w,h);
              bufG = bufImage.getGraphics();
        }
        
        bufG.setColor(this.getBackground());
        bufG.fillRect(0,0,w,h);
        
        bufG.setColor(this.getForeground());
        
        paint(bufG);
 
        g.drawImage(bufImage,0,0,this);
	}
	
	
	public static void main(String[] args)
	{
		main MAIN = new main();
		MAIN.load();
		Thread t = new Thread(MAIN);
		t.start();
		
	}
	
	
	public void checkKeys()
	{
		if (PK.A() == true)
		{
			
			if ((Physics.collisionleftup() == false && Physics.collisionleft() == false && Physics.collisionleftdown() == false) || Player.blockposX != Math.round(Player.blockposX))
			{
				Player.walkLeft();
			}
			
		}
		
		if (PK.D() == true)
		{
			if ((Physics.collisionrightup() == false && Physics.collisionright() == false && Physics.collisionrightdown() == false) || Player.blockposX != Math.round(Player.blockposX))
			{
				Player.walkRight();
			}
		}
		
		if (PK.SPACE() == true)
		{
				Physics.jump(2);
		}
	}
	
	
	public class kl implements KeyListener
	{

		
		public void keyPressed(KeyEvent a) 
		{
			if (a.getKeyCode() == KeyEvent.VK_A)
			{
				PK.a = true;
			}
			
			else if (a.getKeyCode() == KeyEvent.VK_D)
			{
				PK.d = true;
			}
			
			else if (a.getKeyCode() == KeyEvent.VK_SPACE)
			{
				PK.space = true;
			}
			
			if (a.getKeyCode() == KeyEvent.VK_E)
			{
				inv.inventoryMode = !inv.inventoryMode;
			}
			
			
		}

		
		public void keyReleased(KeyEvent b) 
		{
			if (b.getKeyCode() == KeyEvent.VK_A)
			{
				PK.a = false;
				
					
				
				
			}
			
			else if (b.getKeyCode() == KeyEvent.VK_D)
			{
				PK.d = false;
				
					
				
			}
			
			else if (b.getKeyCode() == KeyEvent.VK_SPACE)
			{
				PK.space = false;
				
				
			}
			
		}

		
		public void keyTyped(KeyEvent c) 
		{
			
			
		}
		
	}
	
	public class ml implements MouseListener
	{

		
		public void mouseClicked(MouseEvent a) 
		{
			
			
		}

		
		public void mouseEntered(MouseEvent b) 
		{
			
			
		}

		
		public void mouseExited(MouseEvent c) 
		{
			
			
		}

		
		public void mousePressed(MouseEvent d)
		{
			if (d.getButton() == MouseEvent.BUTTON1)
			{
				PK.leftmouse = true;
			}
			else if (d.getButton() == MouseEvent.BUTTON3)
			{
				PK.rightmouse = true;
			}
			
		}

		
		public void mouseReleased(MouseEvent e) 
		{
			if (e.getButton() == MouseEvent.BUTTON1 && inv.inventoryMode == false)
			{
				PK.leftmouse = false;
			}
			else if (e.getButton() == MouseEvent.BUTTON3 && inv.inventoryMode == false)
			{
				PK.rightmouse = false;
			}
			else if (e.getButton() == MouseEvent.BUTTON1 && inv.inventoryMode == true)
			{
				if (PK.clickedaufgenommen == false)
				{
					inv.BlockNehmen(e.getX(), e.getY());
					
				}
				else
				{
					inv.BlockAblegen(e.getX(), e.getY());
				}
			}
			
		}
		
	}
	
	public class mml implements MouseMotionListener
	{

		
		public void mouseDragged(MouseEvent a) 
		{
			PK.MouseX = a.getX();
			PK.MouseY = a.getY();
			
		}

		
		public void mouseMoved(MouseEvent b) 
		{
			PK.MouseX = b.getX();
			PK.MouseY = b.getY();
		}
		
	}
	
	public class mwl implements MouseWheelListener
	{
		public void mouseWheelMoved(MouseWheelEvent a) 
		{
			
			int w = a.getWheelRotation();
			
			hud.scrollLeiste(w);
		}
	
	}

	
	
}