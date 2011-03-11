import math.geom2d.Point2D;
import math.geom2d.Vector2D;
public class Simulateur {

	/** objectif : générer des angles plausible afin de pouvoir tester la calibration*/
	double angle_camera;
	double angle_micros;
	/** camera est au centre*/
	final PointPol position_camera;
	/** distance entre le centre (0,0) camera et le milieu du segt m1-m2 : c la mediane*/
	final double mediane = 30;
	/** position de la persone mouvante*/
	Point2D position_target = new Point2D();
	/** position micro 1*/
	Point2D position_m1;
	Point2D position_m2;
	/** Point2D au milieu de m1 et m2*/
	Point2D c_micro;
	
	
	public Simulateur(double x_target, double y_target){
		//SET THE POSITIONS
		position_camera = new PointPol();
		position_camera.setLocation(300, 300);
		position_m1 = new Point2D(mediane,(mediane/Math.cos(Math.PI/4)) * Math.sin(Math.PI/4));
		position_m2 = new Point2D(mediane,(mediane/Math.cos(3*Math.PI/4)) * Math.sin(3*Math.PI/4));
		this.position_target.setLocation(x_target, y_target);
		c_micro = new PointPol();
		c_micro = Point2D.midPoint(position_m1, position_m2);
		//SET ANGLES
		angle_camera = Math.atan2(position_target.getY(), position_target.getX());
		angle_micros = this.getAngle(position_target, position_m1, position_m2);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Simulateur s = new Simulateur (500, 500);
		s.position_camera.setLocation(0,0);
		s.position_m1.setLocation(10,0);
		s.position_m2.setLocation(0,10);
		System.out.println(""+s.getAngle(s.position_target, s.position_m1, s.position_m2)*180/Math.PI);
		//System.out.println(""+s.gridRD(s.position_target, s.position_m1, s.position_m2));
	}
	/**
	 * Method getAngle
	 * @param PointPol a in the camera referential
	 * @param PointPol b in the camera referential
	 * @param PointPol c in the camera referential
	 * @return the angle value formed by those 3 points 
	 */
	public double getAngle(Point2D a, Point2D b, Point2D c){
		double angle = 0 ;
		/**TODO*/
		double ab = Math.sqrt(((a.getX()-b.getX())*(a.getX()-b.getX())) + ((a.getY()-b.getY())*(a.getY()-b.getY())));
		double bc = Math.sqrt(((b.getX()-c.getX())*(b.getX()-c.getX())) + ((b.getY()-c.getY())*(b.getY()-c.getY())));
		double ac = Math.sqrt(((a.getX()-c.getX())*(a.getX()-c.getX())) + ((a.getY()-c.getY())*(a.getY()-c.getY())));
		
		angle = Math.acos(((bc*bc) - (ab*ab) + ac*ac)/((-2)*ac*ab));
		
		return angle;
	}
	
	/*public double gridRD(Point2D a,Point2D b,Point2D c){
		double result = 0.0;

		// calculating the 3 distances

		double ab = a.distance(b);

		double bc = b.distance(c);

		double ac = a.distance(c);

		double cosB = Math.pow(ac, 2) - Math.pow(ab, 2) - Math.pow(bc, 2);

		cosB /= (2 * ab * bc);

		result = (Math.acos(cosB) * 180 / Math.PI);

		return result;
		}*/
	public double distance(PointPol a, PointPol b){
		double distance = 0;
		/**TODO*/
		return distance;
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