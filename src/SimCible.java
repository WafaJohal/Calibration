
public class SimCible {
	
	private PointCart cible;
	private double vitesse; //vitesse moyenne en m/s
	private boolean ismoving;
	private double std = 2;
	private int frequence_dacc = 1;
	private int nb_iteration = 1;
	private int isaccelerating;
	private PointCart cible0;
	
	public SimCible(PointCart init_point){
		cible = init_point;
		cible0 = cible;
		vitesse = 15;
		ismoving = false;
	}
	
	public SimCible(PointPol init_point){
		this(init_point.getCartesianCoord());
	}
	
	public void run(){
		ismoving = true;
		while(nb_iteration>0){
		moveCible();
		System.out.println("x : "+cible.getXCoord()+"\t y : "+cible.getYCoord());
		nb_iteration--;
		}
		ismoving = false;
	}
	public void stop(){ismoving = false;}
	
	public double getNextVitesse(){
		return vitesse + gaussNoise(vitesse);
	}
	public double getVitesse(){return vitesse;}
	public double gaussNoise(double v){
			if(Math.random()<0.5) isaccelerating = 1;
			else isaccelerating = -1;
		return v*isaccelerating*Math.random()*std;
	}
	public void moveCible(){
		if(ismoving){
		double direction = Math.random(); //in radian
		double distance = vitesse * frequence_dacc;
		PointCart p = new PointPol(distance,direction).getCartesianCoord();
		cible0.setPointCart(cible.getXCoord(), cible.getYCoord());
		cible.setPointCart(p.getXCoord()+cible.getXCoord(), cible.getYCoord()+p.getYCoord());
		vitesse = getNextVitesse();
	}
		}
	public PointCart getCible(){return cible;}
	public PointCart getCible0(){return cible0;}
	public void setNbIteration(int nb){this.nb_iteration = nb;}
	public static void main(String[] args) {
		SimCible s = new SimCible (new PointCart(500, 500));
		s.run();
		s.run();
	}
}
