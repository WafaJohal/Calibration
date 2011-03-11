
import math.geom2d.Point2D;



public class PointPol extends Point2D
 {
	protected double radius, angle;
	protected double x, y;

	public PointPol() {
		super();
	}

	public void setPointPol(double radius, double angle) {
		this.radius = radius;
		this.angle = angle;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
		x = radius + Math.cos(angle);
		y = radius + Math.sin(angle);
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
		x = radius + Math.cos(angle);
		y = radius + Math.sin(angle);
	}

	public double getX() {
		return x;
	}

	public void setX(double x){
		this.x = x;
		angle = Math.atan2(y, x);
		radius = Math.sqrt((x * x) + (y * y));
	}
	
	public double getY() {
		return y;
	}

	public void setY(double y){
		this.y = y;
		angle = Math.atan2(y, x);
		radius = Math.sqrt((x * x) + (y * y));
	}
	
	public void setLocation(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void setPolarCoord(double radius, double angle) {
		this.setRadius(radius);
		this.setAngle(angle);
		}
	
		
	
}
