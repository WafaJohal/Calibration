
public class SimCible {
	
	private PointCart cible;
	private double vitesse; //vitesse moyenne en m/s
	private boolean ismoving;
	private double std = 1;
	
	public SimCible(PointCart init_point){
		cible = init_point;
		vitesse = 2;
	}
	
	public SimCible(PointPol init_point){
		this(init_point.getCartesianCoord());
	}
	
	public void start(){ismoving = true;}
	public void stop(){ismoving = false;}
	
	public double getNextVitesse(){
		return vitesse + gaussNoise(vitesse);
	}
	public double getVitesse(){return vitesse;}
	public double gaussNoise(double v){
		return v + Math.random()*std;
	}
	public void moveCible(){
		
	}
}
