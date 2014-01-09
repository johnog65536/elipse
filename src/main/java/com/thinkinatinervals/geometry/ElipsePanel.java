package com.thinkinatinervals.geometry;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class ElipsePanel extends JPanel{
	
	private static Logger logger = Logger.getLogger(ElipsePanel.class);
	
	private int canvasHeight=0;
	private int canvasWidth=0;
	private int PAD=20;
	private Elipse elipse;
	private DrawingParams drawingParams;
	
	public ElipsePanel(int canvasWidth,int PAD){
		this.canvasWidth=canvasWidth;
		this.PAD=PAD;

		double p = 2;          // p=semi-lautus rectum = dist from an origin vertically to edge of eclipse or b*b/a
		double e = 0.5;        // e=excentricity of the elipse
		int numPoints = 360;    // numpoints of the elipse to draw
		
	    elipse = new Elipse(p,e,numPoints);
	    drawingParams = elipse.getDrawingParams();
		canvasHeight=(int) (canvasWidth*elipse.getE());
		
		logger.debug("Storing canvasHeight based on e="+elipse.getE()+" and canvasWidth="+canvasWidth+ "thus canvasHeight="+getCanvasHeight());
		logger.debug("Completed elipse generation id="+elipse);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
		for (ElipsePoint elipsePoint:elipse.getPoints()){
			int x=convToFitX(elipsePoint.getX());
			int y=convToFitY(elipsePoint.getY());
			
			logger.debug("Plotting x="+x+" y="+y);
			g2.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));
			
			if(elipsePoint.getTheta()%30==0){
				 g2.draw(new Line2D.Double(convToFitX(0), convToFitY(0), x, y));
			}
		}
		
		//add the foci
		g2.fill(new Ellipse2D.Double(convToFitX(0) - 2, convToFitY(0) - 2, 4, 4));
		g2.fill(new Ellipse2D.Double(convToFitX(drawingParams.getMinX()+drawingParams.getMaxX()) - 2, convToFitY(0) - 2, 4, 4));
				
		//add the actual centre
		g2.fill(new Ellipse2D.Double(convToFitX(drawingParams.getMinX()+drawingParams.getWidth()/2) - 2, convToFitY(0) - 2, 4, 4));
		
		
		//add the x and y axis
		g2.draw(new Line2D.Double(convToFitX(drawingParams.getMinX()), convToFitY(0), convToFitX(drawingParams.getMaxX()), convToFitY(0)));
		g2.draw(new Line2D.Double(convToFitX(drawingParams.getMinX()+drawingParams.getWidth()/2), convToFitY(drawingParams.getMinY()), convToFitX(drawingParams.getMinX()+drawingParams.getWidth()/2), convToFitY(drawingParams.getMaxY())));
		
		//logger.debug("canvasHeight="+canvasHeight+" drawingParams.getMinY()="+drawingParams.getMinY()+" drawingParams.getHeight()="+drawingParams.getHeight());
		//logger.debug("mixY="+drawingParams.getMinY()+" maxY="+drawingParams.getMaxY());
        
	}	
	
	private int convToFitX(double point){
		return (int) Math.round( (point+Math.abs(drawingParams.getMinX()))/(drawingParams.getWidth())*canvasWidth  );
	}

	private int convToFitY(double point){
		return (int) (canvasHeight - Math.round( (point+Math.abs(drawingParams.getMinY()))/(drawingParams.getHeight())*canvasHeight  ));
	}
	public int getCanvasHeight(){
		return canvasHeight;
	}

}
