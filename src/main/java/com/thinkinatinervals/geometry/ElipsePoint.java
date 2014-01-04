package com.thinkinatinervals.geometry;

public class ElipsePoint {
	private double theta;
	private double thetaRadians;
	private double p;
	private double e;
	private double x;
	private double y; 
	private double r;
	
	public ElipsePoint(double p,double e,double theta){
		setP(p);
		setE(e);
		setTheta(theta);
		
		reCalc();
	}
	
	public String toString(){
		return "theta="+getTheta()+" r="+getR()+ " x="+getX() +" y="+getY();
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	
	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
		this.thetaRadians=Math.toRadians(theta);
	}
	
	public void reCalc(){
		this.r=p/(1+e * Math.cos(thetaRadians)); 			
		this.x=r*Math.cos(thetaRadians);
		this.y=r*Math.sin(thetaRadians);
	}

	public double getThetaRadians() {
		return thetaRadians;
	}

	public void setThetaRadians(double thetaRadians) {
		this.thetaRadians = thetaRadians;
		this.theta=Math.toDegrees(thetaRadians);
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

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
