import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import math.geom2d.Point2D;

import javax.imageio.ImageIO;
import javax.swing.*;
import math.geom2d.Point2D;
public class Draw extends JPanel {
	
	private static final Graphics2D Graphics2D = null;


	Point2D p = new Point2D();
	
	
	public static SimCible s;
public Draw(int x, int y){
	p.setLocation(x,y);
		s = new SimCible(p);
}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
        Graphics2D g2 = (Graphics2D)g;
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.BLUE);
		 
		for(int i = 0 ; i<20; i++){
			s.run();
			
			BufferedImage bf = null;
			try {
				bf = ImageIO.read(new File("icon/target.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g2.drawImage(bf, null, (int) s.getCible().getX() ,(int) s.getCible().getY()) ;
			g.drawLine((int)s.getCible0().getX(),(int) s.getCible0().getY(),(int) s.getCible().getX() ,(int) s.getCible().getY()) ;
			s.setNbIteration(1);
			}
		
			}
	
	public void painting(){
		this.repaint();
		this.validate();
	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		Draw panel = new Draw(200,200);
		panel.setSize(700,700);
		frame.add(panel);
		
		panel.painting();
		frame.setSize(700, 700);
		frame.setVisible(true);

		
	}
}
