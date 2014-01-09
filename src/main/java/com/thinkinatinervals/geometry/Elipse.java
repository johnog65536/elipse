package com.thinkinatinervals.geometry;

import org.apache.log4j.Logger;

public class Elipse {
	private double p;
	private double e;
	private int numPoints;
	private ElipsePoint[] points;
	private DrawingParams drawingParams;
	private static Logger logger = Logger.getLogger(Elipse.class);
	
	public Elipse (double p, double e,int numPoints){
		logger.debug("Creating Elipse with p="+p+" e="+e + " numPoints="+numPoints);
		 
		setP(p);
		setE(e);
		setNumPoints(numPoints);
		
		 
		calcPoints();
		calcDims();
	}
	
	//to do add other Elipse info, eg a, b, foci

	private void calcDims(){
		drawingParams=new DrawingParams();
		
		for(ElipsePoint elipsePoint:points){
			if (elipsePoint.getX()<drawingParams.getMinX()) drawingParams.setMinX(elipsePoint.getX());
			if (elipsePoint.getY()<drawingParams.getMinY()) drawingParams.setMinY(elipsePoint.getY());
			if (elipsePoint.getX()>drawingParams.getMaxX()) drawingParams.setMaxX(elipsePoint.getX());
			if (elipsePoint.getY()>drawingParams.getMaxY()) drawingParams.setMaxY(elipsePoint.getY());
		}
		
		drawingParams.setWidth(drawingParams.getMaxX() + Math.abs(drawingParams.getMinX()));
		drawingParams.setHeight(drawingParams.getMaxY() + Math.abs(drawingParams.getMinY()));
		
		logger.debug("Width="+drawingParams.getWidth()+ " Height=" + drawingParams.getHeight());
	}
	
	private void calcPoints(){
		points=new ElipsePoint[ numPoints ];
		
		for (int i=0;i<numPoints;i++){
			ElipsePoint point = new ElipsePoint(p,e,360/numPoints*i);			
			points[i]=point;			
			logger.debug(point);
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

	public ElipsePoint[] getPoints() {
		return points;
	}

	public void setPoints(ElipsePoint[] points) {
		this.points = points;
	}

	public DrawingParams getDrawingParams() {
		return drawingParams;
	}

	public void setDrawingParams(DrawingParams drawingParams) {
		this.drawingParams = drawingParams;
	}
	
	
	
}
