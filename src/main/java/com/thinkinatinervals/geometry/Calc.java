package com.thinkinatinervals.geometry;

import org.apache.log4j.Logger;

public class Calc {

	private static Logger logger = Logger.getLogger(Calc.class);

	public static void main(String[] args) {
		
		logger.debug("Initialising");
				
		Calc c = new Calc();
		try{
			c.go();
		} catch (Exception e){e.printStackTrace();}
		
		logger.debug("Done");
	}
	 
	public void go() throws Exception{
				
		double p = 5;          // p=semi-lautus rectum = dist from origin north to edge of eclipse or b*b/a
		double e = 0.5;        // e=excentricity of the elipse
		int numPoints = 10;    // numpoints of the elipse to draw
		
		Elipse elipse = new Elipse(p,e,numPoints);
		
		logger.debug("Completed elipse generation id="+elipse);
	} 
}
