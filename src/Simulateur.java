
public class Simulateur {

	/** objectif : générer des angles plausible afin de pouvoir tester la calibration*/
	double angle_camera;
	double angle_micros;
	/** camera est au centre*/
	final PointPol position_camera;
	/** distance entre le centre (0,0) camera et le milieu du segt m1-m2 : c la mediane*/
	final double mediane = 30;
	/** position de la persone mouvante*/
	PointPol position_target = new PointPol();
	/** position micro 1*/
	PointPol position_m1;
	PointPol position_m2;
	/** PointPol au milieu de m1 et m2*/
	PointPol c_micro;
	
	
	public Simulateur(double x_target, double y_target){
	/*	//SET THE POSITIONS
		*/position_camera = new PointPol();
		/*position_m1 = new PointPol(mediane,(mediane/Math.cos(Math.PI/4)) * Math.sin(Math.PI/4));
		position_m2 = new PointPol(mediane,(mediane/Math.cos(3*Math.PI/4)) * Math.sin(3*Math.PI/4));
		*/this.position_target.setLocation(x_target, y_target);
		/*c_micro = new PointPol(/**TODO0,0);
		//SET ANGLES
		angle_camera = position_target.getPolarAngle();
		angle_micros = getAngle(position_target, position_m1, position_m2);
	*/}
	/**
	 * @param args
	 *//*
	public static void main(String[] args) {
		Simulateur s = new Simulateur (500, 500);
	}
	/**
	 * Method getAngle
	 * @param PointPol a in the camera referential
	 * @param PointPol b in the camera referential
	 * @param PointPol c in the camera referential
	 * @return the angle value formed by those 3 points 
	 */
	public double getAngle(PointPol a, PointPol b, PointPol c){
		double angle = 0 ;
		/**TODO*/
		return angle;
	}
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