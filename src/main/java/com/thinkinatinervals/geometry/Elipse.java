package com.thinkinatinervals.geometry;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Elipse {
	private double p;
	private double e;
	private int numPoints;
	private Point[] points;
	
	private static Logger logger = Logger.getLogger(Elipse.class);
	
	public Elipse (double p, double e,int numPoints){
		logger.info("Creating Elipse with p="+p+" e="+e + " numPoints="+numPoints);
		 
		setP(p);
		setE(e);
		setNumPoints(numPoints);
		points=new Point[ numPoints ];
		 
		calcPoints();
	}
	
	//to do add other Elipse info, eg a, b, foci

	
	public void calcPoints(){
		for (int i=0;i<numPoints;i++){
			Point point = new Point(p,e,360/numPoints*i);			
			points[i]=point;			
			logger.info(point);
		}		
	}

	
	public int getNumPoints() {
		return numPoints;
	}

	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	public Point[] getPoints() {
		return points;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}
	
	
}
