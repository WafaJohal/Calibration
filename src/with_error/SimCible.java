package without_error;
import math.geom2d.Point2D;


public class SimCible {
	
	private Point2D cible; // cible a instant t
	private Point2D cible0; //cible a t-1
	private Point2D tmp ; 
	private double vitesse; //vitesse moyenne en m/s
	private boolean ismoving;
	private double std = 5;//standard deviation : confiance sur la variation de la vitesse
	private int frequence_dacq = 1; // fréquence d'acquisition, ici 1 seconde
	private int nb_iteration = 1;// nombre de pas, nombre de capture de donnée, beans
	private int isaccelerating;
	
	// taille de la pièce où se déplace la cible
	private final int height_room = 700;
	private final int width_room = 700;
	//direction de la cible de 0 à 2PI randomalizer
	private double direction;
	//distance calculé à partir de la vitesse et de la fréquence
	private double distance;
	private double dx, dy;
	
	/**
	 * Constructeur qui prend le point de départ de la cible à t0
	 * @param init_point
	 */
	public SimCible(Point2D init_point){
		cible = init_point;
		cible0 = cible;
		vitesse = 50;
		ismoving = false;
	}
	
	
	/**
	 * void qui lance les itérations de movement de la cible
	 */
	public void run(){
		ismoving = true;
		while(nb_iteration>0){
		moveCible();
		System.out.println("x : "+cible.getX()+"\t y : "+cible.getY());
		nb_iteration--;
		}
		ismoving = false;
	}
	
	/**
	 * arrete le mouvement de la cible
	 */
	public void stop(){ismoving = false;}
	
	/**
	 * Method qui génère la vitesse suivante en ajoutant du bruit gaussien à la précédante
	 * @return vitesse
	 */
	public double getNextVitesse(){
		return gaussNoise(vitesse, std);
	}
	/**
	 * @return the current vitesse
	 */
	public double getVitesse(){return vitesse;}
	
	/**
	 * 
	 * @param v : mean variable
	 * @param std : standard deviation
	 * @return la vitesse avec du bruit
	 */
	public double gaussNoise(double v, double std){
			if(Math.random()<0.5) isaccelerating = 1;
			else isaccelerating = -1;
		return v+Math.random()*std*isaccelerating;
	}
	/**
	 * bouge la cible
	 */
	public void moveCible(){
		if(ismoving){
			//générate new coordonée
		direction = Math.random()*2*Math.PI; //in radian
		distance = vitesse * frequence_dacq;
		dx = Math.cos(direction)*distance;
		dy = Math.sin(direction)*distance;
		
		//save old position
		cible0.setLocation(cible);
		//apply new position
		tmp = cible.translate(dx, dy);
			
		if((tmp.getX()< 0)||(tmp.getX()>= width_room)){
			dx = (-1)*dx;
			System.out.println("out on X");
		}
		if((tmp.getY()< 0)||(tmp.getY()>= height_room)){
			dy = (-1)*dy;
			System.out.println("out on Y");
		}
		cible = cible.translate(dx, dy);
		vitesse = getNextVitesse();
	}
		}
	
	
	public Point2D getCible(){return cible;}
	public Point2D getCible0(){return cible0;}
	public void setNbIteration(int nb){this.nb_iteration = nb;}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		Point2D p = new Point2D();
		p.setLocation(500, 500);
		SimCible s = new SimCible (p);
		s.run();
		s.setNbIteration(2);
		s.run();
	}
}
