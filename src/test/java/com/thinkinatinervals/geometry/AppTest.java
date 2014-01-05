package com.thinkinatinervals.geometry;

import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 * @author johnog65536
 */
public class AppTest {
	
	private Logger logger = Logger.getLogger(AppTest.class);
	
	/** default constructor, just sets the root logging level to WARN
	 * @author johnog65536
	 */
	public AppTest(){
		// drop down to WARN only to keep the log clean
		Logger.getRootLogger().setLevel(Level.WARN);
	}
	
	/** this method checks the logging API is setup properly
	 * @author johnog65536
	 */
	@Test public void testLogging(){
		logger.debug("Testing Logging");		
	}
	
	/** This methods checks an ElipsePoint can be created properly
	 * @author johnog65536
	 */
	@Test public void createElipsePoint(){
		double p = 5;          // p=semi-lautus rectum = dist from an origin vertically to edge of eclipse or b*b/a
		double e = 0.5;        // e=excentricity of the elipse

		ElipsePoint elipsePoint = new ElipsePoint(p,e,90);
		assertNotNull("ElipsePoint was null", elipsePoint);
		
		assertEquals("Checking Radial",5.0, elipsePoint.getR(),0.01);
		assertEquals("Cheking X coordinate",3.0616E-16,elipsePoint.getX(),0.00001d);
		assertEquals("Checking Y coordinate",5.0,elipsePoint.getY(),0.001);
	}
	
    /** This method check the elipse can be created properly
     * @author johnog65536
     */
	 @Test public void createElipse() {

		double p = 5;          // p=semi-lautus rectum = dist from an origin vertically to edge of eclipse or b*b/a
		double e = 0.5;        // e=excentricity of the elipse
		int numPoints = 10;    // numpoints of the elipse to draw
		
		// check elipse can be created
		Elipse elipse = new Elipse(p,e,numPoints);			
		assertNotNull("Created elipse object was null", elipse);
		
		// check the points are all there & arent null
		ElipsePoint[] elipsePoints=elipse.getPoints();
		for (int i=0;i<numPoints;i++){
			assertNotNull("Checking elipse point "+i,elipsePoints[i]);
		}
    }
	
	 /** this method invokes the go method on the Calc class and checks no exceptions are returned
	  * go is called from Calc's main method as sole operation, other than handling potential exceptions
	  * @author johnog65536
	  */
	 @Test public void testCalc() throws Exception{
		 Calc c = new Calc();
		 c.go();
	 }
}
