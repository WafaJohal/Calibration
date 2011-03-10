
public class PointPol {
	protected double radius, angle;
	public PointPol(double radius, double angle){
		this.radius = radius;
		this.angle = angle;
	}
	
	public void setPointPol(double radius, double angle){
		this.radius = radius;
		this.angle = angle;
	}
	
	public double getRadius(){return radius;}
	public void setRadius(double radius){this.radius = radius;}
	public double getAngle(){return angle;}
	public void setAngle(double angle){this.angle = angle;}
	
	public double getXCoord(){
		double x = radius + Math.cos(angle);
		return x;
	}
	
	public double getYCoord(){
		double y = radius + Math.sin(angle);
		return y;
	}
	
	public PointCart getCartesianCoord(){
		return new PointCart(this.getXCoord(),this.getYCoord());
	}
}
