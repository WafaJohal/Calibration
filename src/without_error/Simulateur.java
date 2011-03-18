package without_error;
import math.geom2d.Point2D;

/** 
 * objectif : générer des angles plausible afin de pouvoir tester la calibration
 *@author wafa 
 */

public class Simulateur  {

	
	double angle_camera;
	double angle_micros;
	
	final PointPol position_camera;/** camera est au centre*/
	
	final Point2D milieu;/** point entre m1 et m2*/
	
	Point2D position_target = new Point2D();/** position de la persone mouvante*/
	
	Point2D position_m1;/** position micro 1*/
	Point2D position_m2;
	
	int HOZ_LIM = 500;
	int VER_LIM = 500;
	Point2D c_micro;/** Point2D au milieu de m1 et m2*/
	
	
	public Simulateur(){
		//SET THE POSITIONS
		int x = (int) (((Math.random()*(-1)))*200-1);
		int y =  (int) (((Math.random()*(-1))+Math.random()+1)*200-1);
		position_target = new Point2D(x,y);
		System.out.println("position target "+position_target);
		position_camera = new PointPol();
		position_camera.setLocation(0,0);
		/*int m_x = (int) ((Math.random()+1)*2-1);
		int m_y =  (int) ((Math.random()+1)*2-1);*/
		position_m1 = new Point2D(1,1);
		/*m_x = (int) ((Math.random()+1)*2 -1);
		m_y =  (int) ((Math.random()+1)*2 -1);*/
		position_m2 = new Point2D(-1,1)/*position_camera.createPolar(position_camera,3* Math.PI/4, 1)*/;
		milieu = /*getCentre(position_m1, position_m2)*/ new Point2D(0,0);
		//SET ANGLES
		angle_camera = Math.atan2(position_target.getY(), position_target.getX());
		angle_micros = getAngle(getPointOnNorme(position_m1,position_m2), position_camera, position_target);
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Simulateur s = new Simulateur ();
		s.position_camera.setLocation(0,0);
		s.position_target.setLocation(20,200);
		double am = s.angle_micros*180/Math.PI;
		double ac = s.angle_camera*180/Math.PI;
		Point2D pnorme = s.getPointOnNorme(s.position_m1,s.position_m2);
		System.out.println("angle micros target "+am);
		System.out.println("angle camera target "+ac);
		System.out.println("difference position -- calculer par angle : "+(ac - am));
		System.out.println("angle camera micro -- vrai position : "+ Math.atan2(pnorme.getY(), pnorme.getX())*180/Math.PI);
	}
	/**
	 * Method getAngle
	 * @param Point2D a in the camera referential
	 * @param Point2D b in the camera referential
	 * @param Point2D c in the camera referential
	 * @return the angle value formed by those 3 points 
	 */
	public double getAngle(Point2D a, Point2D b, Point2D c){
		double bangle = 0 ;
		double ab = Math.sqrt(((a.getX()-b.getX())*(a.getX()-b.getX())) + ((a.getY()-b.getY())*(a.getY()-b.getY())));
		double bc = Math.sqrt(((b.getX()-c.getX())*(b.getX()-c.getX())) + ((b.getY()-c.getY())*(b.getY()-c.getY())));
		double ac = Math.sqrt(((a.getX()-c.getX())*(a.getX()-c.getX())) + ((a.getY()-c.getY())*(a.getY()-c.getY())));
		
		bangle = Math.acos(((bc*bc) + (ab*ab) - (ac*ac))/(2*bc*ab));
		
		return bangle;
	}
	
	
	public Point2D getCentre(Point2D a, Point2D b){
		return  new Point2D(0,0);
	}
	
	
	public Point2D getPointOnNorme(Point2D a, Point2D b){
		Point2D m = Point2D.midPoint(a, b);
		return m;
	}
}

/*class Vector{
	protected double x_ori, y_ori, x_arr, y_arr;
	
	public Vector(double x_ori, double y_ori, double x_arr, double y_arr){
		this.x_ori = x_ori;
		this.y_ori = y_ori;
		this.x_arr = x_arr;
		this.y_arr = y_arr;
	}
	
	
}*/