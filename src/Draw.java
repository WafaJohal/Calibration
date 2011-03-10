import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.*;

public class Draw extends JPanel {
	static SimCible s = new SimCible(new PointCart(500, 500));

	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.BLUE);
		
		Image img =  getToolkit().createImage("target.gif");
;
		//g.drawImage(img ,(int)s.getCible0().getXCoord(),(int) s.getCible().getYCoord(), this) ;
		Dimension d = getSize();
				        Insets i = getInsets();
		        
		  g.drawImage(img, i.left, i.top, d.width - i.left - i.right, d.height - i.top - i.bottom, this );
	}
	
	public void painting(){
		this.repaint();
		this.validate();
	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		Draw panel = new Draw();
		panel.setSize(700,700);
		frame.add(panel);
		for(int i = 0 ; i<4; i++){
		s.run();
		System.out.println("x(t-1) :  "+(int)s.getCible0().getXCoord()+" y(t-1) :  "+ (int) s.getCible0()
		.getYCoord()+" x(t) :  "+ (int) s.getCible().getXCoord()+" y(t) :  " +(int) s
		.getCible().getYCoord());
		panel.painting();
		s.setNbIteration(1);
		}
		panel.painting();
		frame.setSize(700, 700);
		frame.setVisible(true);

		
	}
}
