public class PointCart{
	protected double x, y;
	public PointCart(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void setPointCart(double x, double y){
		this.setXCoord(x);
		this.setYCoord(y);
	}
	public double getXCoord(){return x;}
	public void setXCoord(double x){this.x = x;}
	public double getYCoord(){return y;}
	public void setYCoord(double y){this.y = y;}
	
	public double getPolarAngle(){
		double theta = 0.0;
		theta = Math.atan2(y, x);
		return theta;
	}
	public double getPolarRadius(){
		return Math.sqrt((x*x) + (y*y));
	}
	public PointPol getPolarCoord(){
		return new PointPol(this.getPolarRadius(),this.getPolarAngle());
	}
}