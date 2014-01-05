package com.thinkinatinervals.geometry;

import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private Logger logger = Logger.getLogger(AppTest.class);
	
	public AppTest(){
		// drop down to WARN only to keep the log clean
		Logger.getRootLogger().setLevel(Level.WARN);
	}
	
	@Test
	public void testLogging(){
		logger.debug("Testing Logging");		
	}
	
	@Test
	public void createElipsePoint(){
		double p = 5;          // p=semi-lautus rectum = dist from an origin vertically to edge of eclipse or b*b/a
		double e = 0.5;        // e=excentricity of the elipse

		ElipsePoint elipsePoint = new ElipsePoint(p,e,90);
		assertNotNull("ElipsePoint was null", elipsePoint);
		
		assertEquals("Checking Radial",5.0, elipsePoint.getR(),0.01);
		assertEquals("Cheking X coordinate",3.0616E-16,elipsePoint.getX(),0.00001d);
		assertEquals("Checking Y coordinate",5.0,elipsePoint.getY(),0.001);
	}
	
    @Test
    public void createElipse() {

		double p = 5;          // p=semi-lautus rectum = dist from an origin vertically to edge of eclipse or b*b/a
		double e = 0.5;        // e=excentricity of the elipse
		int numPoints = 10;    // numpoints of the elipse to draw
		
		Elipse elipse = new Elipse(p,e,numPoints);			
		assertNotNull("Created elipse object was null", elipse);
    }
	    

}
